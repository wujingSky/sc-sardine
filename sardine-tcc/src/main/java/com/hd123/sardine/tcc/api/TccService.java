package com.hd123.sardine.tcc.api;

public interface TccService {
    /***
     *
     * @param request
     */
    public void confirm(TccRequest request) throws Exception;

    /***
     *
     * @param request
     */
    public void cancel(TccRequest request);
}
