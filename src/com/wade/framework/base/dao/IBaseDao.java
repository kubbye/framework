package com.wade.framework.base.dao;

import java.util.List;

import com.wade.framework.base.PageInfo;

public interface IBaseDao {
    int insert(String sqlId, Object param);
    int update(String sqlId, Object param);
    int delete(String sqlId, Object param);
    <T> T queryObjectById(String sqlId, Object param);
    <T> List<T> queryList(String sqlId, Object param);
    <T> List<T> queryListByPage(String sqlId, Object param, PageInfo pageinfo);
}
