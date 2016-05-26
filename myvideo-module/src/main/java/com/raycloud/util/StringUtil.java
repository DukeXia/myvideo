package com.raycloud.util;

/**
 * Created by linjunjie(490456661@qq.com) on 2016/2/2.
 */
public class StringUtil {

    public static boolean isEmpty(String ... arg){
        return !isNotEmpty(arg);
    }

    public static boolean isNotEmpty(String ... arg){
        for(int i=0;i<arg.length;i++){
            if(arg[i]==null||(arg[i]!=null&&"".equals(arg[i].trim()))){
                return false;
            }
        }
        return true;
    }

    public static boolean isNotNull(String ... arg){
        for(int i=0;i<arg.length;i++){
            if(arg[i] == null){
                return false;
            }
        }
        return true;
    }

    public static boolean isNull(String ...arg){
        return !isNotNull(arg);
    }

    /**
     * 过滤掉html
     * @param content
     * @return
     */
    public static String htmlFilter(String content){
        content = content.replaceAll("<script.*/>","");
        content = content.replaceAll("<script","&ltscript");
        content = content.replaceAll("</script>","&ltscript&gt");
        return content;
    }

    public static void main(String []args){
        String content = "wewr<script src='co' type='text/javascript' />cc<script ></script>";
        content =  content.replaceAll("<script.*/>","");
        content = content.replaceAll("<script","&ltscript");
        content = content.replaceAll("</script>","&ltscript&gt");
        System.out.println(content);
    }

}
