package com.hd123.sardine.common.exception;

import com.hd123.sardine.common.RestStatus;
import com.hd123.sardine.common.model.ErrorEntity;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Optional;

import static com.google.common.base.Preconditions.checkNotNull;

public class ExceptionUtils {

    public static void buildRestStatusException(RestStatus status, Object... details){
        checkNotNull(status);
        checkNotNull(status.code());

        final ErrorEntity entity = new ErrorEntity(status);
        if (details.length > 0) {
          //TODO  Optional.of(details).ifPresent(entity::setDetails);
        }
        checkNotNull(entity);
        String errorCode = String.valueOf(status.code());
        final RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes != null) {
            ((ServletRequestAttributes) requestAttributes).getRequest().setAttribute(errorCode, entity);
        }
        throw new RestStatusException(errorCode);
    }
}
