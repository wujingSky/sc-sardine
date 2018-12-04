package com.hd123.sardine.tcc.service;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.hd123.sardine.common.exception.ExceptionUtils;
import com.hd123.sardine.tcc.api.*;
import com.hd123.sardine.tcc.exception.TccConfirmException;
import com.hd123.sardine.tcc.exception.TccReserveExpireException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.OffsetDateTime;
import java.util.List;

@Service
public class TccServiceImpl implements TccService{
    private static final Logger LOGGER = LoggerFactory.getLogger(TccServiceImpl.class);

    private final RestTemplate restTemplate;
    private static final HttpEntity<?> REQUEST_ENTITY;

    static {
        final HttpHeaders header = new HttpHeaders();
        header.setAccept(ImmutableList.of(MediaType.APPLICATION_JSON_UTF8));
        header.setContentType(MediaType.APPLICATION_JSON_UTF8);
        REQUEST_ENTITY = new HttpEntity<>(header);
    }

    @Autowired
    public TccServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public void confirm(TccRequest request) throws Exception {
        Preconditions.checkNotNull(request);
        List<TccParticipant> tccParticipants = request.getItems();

        int success = 0;
        int fail = 0;
        for(TccParticipant participant : tccParticipants){
            participant.setExecuteTime(OffsetDateTime.now());
            ResponseEntity<String> response = restTemplate.exchange(participant.getUri(),HttpMethod.PUT, REQUEST_ENTITY, String.class);
            if(response.getStatusCode() == HttpStatus.NO_CONTENT){
                participant.setStatus(TccStatus.CONFIRMED);
                success++;
            }else if(response.getStatusCode() == HttpStatus.NOT_FOUND){
                participant.setStatus(TccStatus.TIMEOUT);
                participant.setErrorResponse(response);
                fail++;
            }else{
                ExceptionUtils.buildRestStatusException(TccStatusCode.SERVER_UNKNOWN_ERROR,response);
            }
        }

        if(success > 0 && fail > 0){
            throw new TccConfirmException("All Reservation were cancelled or timeout",new TccErrorResponse(tccParticipants));
        }else if(fail == tccParticipants.size()){
            throw new TccReserveExpireException("All timeout");
        }
    }

    @Override
    public void cancel(TccRequest request)  {
        Preconditions.checkNotNull(request);
        Preconditions.checkNotNull(request.getItems());

        List<TccParticipant> participantList = request.getItems();

        try {
            for (TccParticipant participant : participantList) {
                restTemplate.exchange(participant.getUri(), HttpMethod.DELETE, null, String.class);
            }
        }catch (Exception e){
            LOGGER.debug("unexpected error:{}",e.toString());
        }

    }
}
