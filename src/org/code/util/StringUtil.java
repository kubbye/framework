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
    public static String columnName(String column){
        if(null==column){
            return null;
        }
        if(column.trim().length()==0){
            return column;
        }
        String res=commonColumn(column);
        if("".equals(res)){
            String [] arr = column.split("_");
            for(String str : arr){
                res = res + upperFirst(str);
            }
        }
        return lowerFirst(res);
    }
    
    public static String commonColumn(String column){
        String name="";
        if("CREATE_BY".equalsIgnoreCase(column)){
            name="createUser";
        }
        if("UPDATE_BY".equalsIgnoreCase(column)){
            name="updateUser";
        }
        if("CREATE_TIME".equalsIgnoreCase(column)){
            name="createTime";
        }
        if("UPDATE_TIME".equalsIgnoreCase(column)){
            name="updateTime";
        }
        if("DELETE_MARK".equalsIgnoreCase(column)){
            name="deleteMark";
        }
        return name;
    }
    
}
