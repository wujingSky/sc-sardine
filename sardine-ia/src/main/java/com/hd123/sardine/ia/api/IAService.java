package com.hd123.sardine.ia.api;

import com.hd123.sardine.common.model.RestfulResponse;

public interface IAService {

    RestfulResponse<String> save(IARequest request);

    RestfulResponse<String> confirm(IARequest request);
}
