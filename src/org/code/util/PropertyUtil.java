package org.code.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

public class PropertyUtil {
    private static Properties props;
    
    /**
     * <p>Description: 得到属性的值</p>
     * @param key
     * @return
     */
    public static String getValue(String key){
        if(null == props){
            props = getProps();
        }
        if(null == props.get(key) || "".equals(props.get(key))){
            return "";
        }
        String val = props.get(key).toString();
        try {
            val = new String(val.getBytes("iso-8859-1"),"utf-8");
        } catch (UnsupportedEncodingException e) {
        }
        return val;
    } 
    
    
    /**
     * <p>Description: 得到属性</p>
     */
    private static Properties getProps(){
        String path;
        path = CodeUtil.class.getClass().getResource("/org/code/util").getPath();
        Properties props = new Properties();
        try {
            props.load(new FileInputStream(new File(path+"/setting.properties")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return props;
    }
    
    public static void main(String[] args) {
        System.out.println(getValue("ZhKey"));
    }
}
