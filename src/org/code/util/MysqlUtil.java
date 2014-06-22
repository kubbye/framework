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
    
    private List<Field> getFieldList(){
        String driveName = PropertyUtil.getValue("mysql.driverClassName");
        String url = PropertyUtil.getValue("mysql.url");
        String userName = PropertyUtil.getValue("mysql.username");
        String pwd = PropertyUtil.getValue("mysql.password");
        String tableName= PropertyUtil.getValue("table.name");
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Field> list = new ArrayList<Field>();
        try {
            Class.forName(driveName);
            conn=DriverManager.getConnection(url,userName,pwd);
            pst=conn.prepareStatement("SELECT column_name,data_type,column_comment,is_nullable,column_key FROM information_schema.columns WHERE table_name=? ORDER BY ordinal_position");
            pst.setString(1, tableName);
            rs = pst.executeQuery();
            Field field = null;
            while(rs.next()){
                field = new Field();
                field.setName(StringUtil.columnName(rs.getString("column_name").toLowerCase()));
                field.setColumnName(rs.getString("column_name").toUpperCase());
                field.setType(StringUtil.mysqlDatatype(rs.getString("data_type").toLowerCase()));
                field.setUpperName(StringUtil.upperFirst(field.getName()));
                field.setComment(rs.getString("column_comment"));
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
    public static void main(String[] args) {
        MysqlUtil.getInstance().getFieldList();
    }
}
