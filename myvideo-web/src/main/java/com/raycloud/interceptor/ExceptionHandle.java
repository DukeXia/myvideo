package com.raycloud.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.raycloud.constant.ResponseResultConstant;
import com.raycloud.exception.InvalidSessionException;
import com.raycloud.exception.ServiceException;
import com.raycloud.response.Response;
import com.raycloud.util.BooleanStatusResponse;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ConnectException;

/**
 * Created by linjunjie(490456661@qq.com) on 2016/3/1.
 */
public class ExceptionHandle {
    private static Logger logger = Logger.getLogger(ExceptionHandle.class);
    //处理异常
    public static void handle(HttpServletRequest req,HttpServletResponse resp,Exception e){
        Response response = new Response();
        PrintWriter out = null;
        resp.setContentType( "text/html;charset=UTF-8" );
        boolean status = false;
        response.setData(new BooleanStatusResponse(status));
        if(e instanceof NullPointerException){
            response.setMessage("空指针异常");
            response.setResult("901");
        }else if(e instanceof ServiceException){
            ServiceException serviceException = ((ServiceException) e);
            if(serviceException.getCode() == 902){
                response.setMessage(serviceException.getMessage());
            }else {
                response.setMessage(ResponseResultConstant.resultString.get(serviceException.getCode()));
            }
            response.setResult(serviceException.getCode()+"");
        }else if(e instanceof InvalidSessionException){
            response.setMessage("用户会话失效，请重新登陆!");
            response.setResult(ResponseResultConstant.INVALID_SESSION+"");
        }else if(e instanceof ConnectException){
            response.setMessage("数据库连接失败");
            response.setResult(ResponseResultConstant.CODE_SERVICE_DB_ERROR+"");
        }else{
            //不处理
            response.setMessage(e.getMessage());
            response.setResult("900");
        }
        //记录日志
        logger.error(e.getMessage(),e);
        e.printStackTrace();
        try {
            out = resp.getWriter();
            out.write(JSONObject.toJSONString(response));
        } catch (IOException e1) {
            logger.error(e1.getMessage(),e1);
        }finally{
            IOUtils.closeQuietly(out);
        }
    }

}
