package com.raycloud.service;

import com.raycloud.exception.ServiceException;
import org.apache.http.client.HttpClient;

/**
 * 爬取、装载cookie 等功能
 * Created by linjunjie on 2015/12/6 (linjunjie@raycloud.com).
 */
public interface ParseService {

    /**
     * 为HttpClient装载cookie
     * @param cookie
     * @throws ServiceException
     */
    public void wiredCookieForClient(String cookie) throws ServiceException;

    /**
     * 模拟浏览器行为
     * @throws ServiceException
     */
    public void simulateClient(HttpClient httpClient) throws ServiceException;

    /**
     * get请求一个页面,并返回数据
     * @param url
     * @throws ServiceException
     */
    public void doGetRequired(String url) throws ServiceException;


}
