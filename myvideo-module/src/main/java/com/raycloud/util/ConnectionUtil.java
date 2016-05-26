package com.raycloud.util;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpConnection;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by linjunjie(490456661@qq.com) on 2016/3/22.
 */
public class ConnectionUtil {

    private static Logger logger = Logger.getLogger(ConnectionUtil.class);
    private static String host = "";
    private static int port = 3306;
    private static int socketTimeout = 20000;
    public static void doGet(String urlAddress){
        InputStream is = null;
        OutputStream os = null;
        HttpURLConnection httpConnection = null;
        try {
            URL url = new URL(urlAddress);
            httpConnection = (HttpURLConnection)url.openConnection();
            httpConnection.setRequestProperty("Accept-Charset","UTF-8");
            httpConnection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
            is = httpConnection.getInputStream();
            byte [] b = new byte[1024*1024*8];
            int len = -1;
            os = new FileOutputStream(new File("D://22.html"));
            while((len = is.read(b))!=-1){
                os.write(b,0,len);
            }
        }catch(Exception e){
            e.printStackTrace();
            logger.error(e.getMessage(),e);
        }finally {
            IOUtils.closeQuietly(is);
            IOUtils.closeQuietly(os);
            if(httpConnection!=null)
                 httpConnection.disconnect();
        }
    }


    public static void main(String[] args){
        doGet("http://www.baidu.com");
    }
}
