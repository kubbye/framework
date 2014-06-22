package org.code.util;

public class StringUtil {
    /**
     * <p>Description: 首字母大写</p>
     * @param s 源字符串
     * @return 结果字符串
     */
    public static String upperFirst(String s){
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
    public static String lowerFirst(String s){
        if(null==s){
            return null;
        }
        if(s.trim().length()==0){
            return s;
        }
        s=s.substring(0,1).toLowerCase()+s.substring(1);
        return s;
    }
    
    /**
     * <p>Description: 得到列的属性名称</p>
     * @param s 列名称
     * @return
     */
    public static String columnName(String s){
        if(null==s){
            return null;
        }
        if(s.trim().length()==0){
            return s;
        }
        String [] arr = s.split("_");
        String res="";
        for(String str : arr){
            res = res + upperFirst(str);
        }
        return lowerFirst(res);
    }
    
    public static String mysqlDatatype(String jdbctype){
        String datatype="";
        if("varchar".equals(jdbctype) || "char".equals(jdbctype) || "text".equals(jdbctype)){
            datatype = "String";
        }
        if("int".equals(jdbctype) || "tinyint".equals(jdbctype)){
            datatype = "Integer";
        }
        
        if("bigint".equals(jdbctype)){
            datatype = "Long";
        }
        if("datetime".equals(jdbctype) || "timestamp".equals(jdbctype)){
            datatype = "Date";
        }
        
        return datatype;
    }
}
