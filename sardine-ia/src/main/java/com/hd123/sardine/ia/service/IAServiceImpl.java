package com.hd123.sardine.ia.service;

import com.google.common.base.Preconditions;
import com.hd123.sardine.common.model.RestfulResponse;
import com.hd123.sardine.ia.api.IARequest;
import com.hd123.sardine.ia.api.IAService;
import com.hd123.sardine.ia.controller.client.TccClient;
import org.springframework.beans.factory.annotation.Autowired;

public class IAServiceImpl implements IAService{

    @Autowired
    private TccClient tccClient;

    @Override
    public RestfulResponse<String> save(IARequest request) {
        Preconditions.checkNotNull(request);

        //TODO 根据userId查询用户

        //TODO 调用远程方法，保存库存Participant表

        //TODO 查看ParticipantLink
        //*********************************
        //** IAParticipant保存
        //**
        //**
        //*********************************


        return null;
    }

    @Override
    public RestfulResponse<String> confirm(IARequest request) {
        //***********************************
        //**TODO 根据ID查询IAParticipant
        //***
        //***
        //************************************
        return null;
    }
}
