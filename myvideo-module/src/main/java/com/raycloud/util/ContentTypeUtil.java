package com.raycloud.util;

/**
 * Created by linjunjie(490456661@qq.com) on 2016/5/13.
 */
public class ContentTypeUtil {

    /**
     * 获得扩展名
     * @return
     */
    public static String getExtension(String contentType){
        if("image/png".equals(contentType)){
            return ".png";
        }else if("image/jpeg".equals(contentType)){
            return ".jpg";
        }else if("image/gif".equals(contentType)){
            return ".gif";
        }
        return "";
    }
}
