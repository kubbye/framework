package org.code.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MysqlUtil {
    static MysqlUtil util;
    static List<Field> list;
    private MysqlUtil(){
        
    }
    
    public static MysqlUtil getInstance(){
        if(null == util){
            init();
            util = new MysqlUtil();
        }
        return util;
    }
    private static void init(){
        list = null;
    }
    public  List<Field> getTableField(){
        if(null == list){
            list =getFieldList();
        }
        return list;
    }
    
    /**
     * <p>Description: </p>
     * @return
     */
    private List<Field> getFieldList(){
        String driveName = PropertyUtil.getValue("mysql.driverClassName");
        String url = PropertyUtil.getValue("mysql.url");
        String userName = PropertyUtil.getValue("mysql.username");
        String pwd = PropertyUtil.getValue("mysql.password");
        String tableName= PropertyUtil.getValue("table.name");
        String schema= PropertyUtil.getValue("schema.name");
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Field> list = new ArrayList<Field>();
        try {
            Class.forName(driveName);
            conn=DriverManager.getConnection(url,userName,pwd);
            pst = conn
                    .prepareStatement("SELECT column_name,data_type,character_maximum_length,column_comment,is_nullable,column_key FROM information_schema.columns WHERE table_name=?  AND TABLE_SCHEMA=? ORDER BY ordinal_position");
            pst.setString(1, tableName);
            pst.setString(2, schema);
            rs = pst.executeQuery();
            Field field = null;
            while(rs.next()){
                field = new Field();
                field.setName(StringUtil.columnName(rs.getString("column_name").toLowerCase()));
                field.setColumnName(rs.getString("column_name").toUpperCase());
                field.setType(getDatatype(rs.getString("data_type").toLowerCase()));
                field.setUpperName(StringUtil.upperFirst(field.getName()));
                field.setComment(rs.getString("column_comment"));
                if(null != rs.getString("character_maximum_length") && !"".equals(rs.getString("character_maximum_length"))){
                    field.setLength(Integer.valueOf(rs.getString("character_maximum_length")));
                }
                if(rs.getString("is_nullable").toUpperCase().equals("NO")){
                    field.setNullable(false);
                }
                if(null != rs.getString("column_key") && !"".equals(rs.getString("column_key"))){
                    field.setPriKey(true);
                }
                list.add(field);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
                pst.close();
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
    
    /**
     * <p>Description: 得到主键</p>
     * @param list table的列列表
     * @return
     */
    public static Field getPrimaryKey(List<Field> list){
        Field pk=null;
        for(Field field : list){
            if(field.getPriKey()){
                pk=field;
                break;
            }
        }
        return pk;
    }
    
    /**
     * <p>Description: 得到java数据类型</p>
     * @param jdbctype
     * @return
     */
    public static String getDatatype(String jdbctype){
        String datatype="";
        if("varchar".equalsIgnoreCase(jdbctype) || "char".equalsIgnoreCase(jdbctype) || "text".equalsIgnoreCase(jdbctype)){
            datatype = "String";
        }
        if("int".equalsIgnoreCase(jdbctype) || "tinyint".equalsIgnoreCase(jdbctype)){
            datatype = "Integer";
        }
        
        if("bigint".equalsIgnoreCase(jdbctype)){
            datatype = "Long";
        }
        if("double".equalsIgnoreCase(jdbctype) || "float".equalsIgnoreCase(jdbctype)){
            datatype = "Double";
        }
        if("datetime".equalsIgnoreCase(jdbctype) || "timestamp".equalsIgnoreCase(jdbctype)){
            datatype = "Date";
        }
        
        return datatype;
    }
    
    /*数据类型*/
    public static String getFullType(String type){
        String fullType="java.lang.String";
        if ("String".equals(type)) {
            fullType="java.lang.String";
        } else if ("Long".equals(type)) {
            fullType="java.lang.Long";
        } else if ("Integer".equals(type)) {
            fullType="java.lang.Integer";
        } else if ("Double".equals(type)) {
            fullType="java.lang.Double";
        }
        return fullType;
    }
    public static void main(String[] args) {
        MysqlUtil.getInstance().getFieldList();
    }
}
