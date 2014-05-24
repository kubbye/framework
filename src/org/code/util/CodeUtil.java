package org.code.util;

import java.io.IOException;
import java.io.StringWriter;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class CodeUtil {
    private static String key;
    private static String upperKey;
    public static void main(String[] args) throws Exception {
        Configuration cfg=getCfg();
        Template template =cfg.getTemplate("dao.html");
        StringWriter sw=new StringWriter();
        
        Map data = new  HashMap();  
        data.put("packageName" ,  "edu" ); //包名   
        
        template.process(data, sw);
        System.out.println(sw.toString());
        
        
        
    }
    public static void makeAll(Template template,Properties props){
        makeEntity();
        makeDao();
        makeService();
        makeController();
        makeSqlMap();
        makeJs();
        makePage();
    }
   
    
    public static Configuration getCfg(){
        Configuration cfg=new Configuration();
        cfg.setClassForTemplateLoading(CodeUtil.class, "/org/code/template");
        return cfg;
    }
    
    /**
     * <p>Description: 生成dao相关类</p>
     */
    public static void makeDao(){
        
    }
    /**
     * <p>Description: 生成service相关类</p>
     */
    public static void makeService(){
        
    }
    /**
     * <p>Description: </p>
     */
    public static void makeController(){
        
    }
    public static void makeSqlMap(){
        
    }
    public static void makeEntity(){
        
    }
    public static void makePage(){
        
    }
    public static void makeJs(){
        
    }
    /**
     * <p>Description: 首字母大写</p>
     * @param s 源字符串
     * @return 结果字符串
     */
    private static String upperFirst(String s){
        if(null==s){
            return null;
        }
        if(s.trim().length()==0){
            return s;
        }
        s=s.substring(0,1).toUpperCase()+s.substring(1);
        return s;
    }
    /**
     * <p>Description: 首字母小写</p>
     * @param s 源字符串
     * @return 结果字符串
     */
    private static String lowerFirst(String s){
        if(null==s){
            return null;
        }
        if(s.trim().length()==0){
            return s;
        }
        s=s.substring(0,1).toLowerCase()+s.substring(1);
        return s;
    }
}
