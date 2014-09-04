package com.wade.framework.admin.service.dict;

import java.util.List;

import com.wade.framework.admin.entity.DictEntity;
import com.wade.framework.base.PageInfo;
import com.wade.framework.base.PaginationResult;

/**
 * <p>ClassName: IDictService</p>
 * <p>Description: 数据字典Service接口</p>
 * <p>Author: weih</p>
 * <p>Date: 2014-09-04</p>
 */
public interface IDictService {
    /**
     * <p>Description: 插入数据字典</p>
     * @param dict 数据字典对象
     * @return
     */
    int insert(DictEntity dict);
    
    /**
     * <p>Description: 更新数据字典</p>
     * @param dict 数据字典对象
     * @return
     */
    int update(DictEntity dict);
    
    /**
     * <p>Description: 删除数据字典</p>
     * @param dict 数据字典对象
     * @return
     */
    int delete(DictEntity dict);
    
    /**
     * <p>Description: 根据数据字典id查询数据字典记录</p>
     * @param dict 数据字典对象
     * @return 数据字典对象
     */
    DictEntity queryObjectById(Long id);
    
    /**
     * <p>Description: 查询数据字典记录列表</p>
     * @param param 数据字典对象
     * @return 数据字典记录列表
     */
    List<DictEntity> queryList(Object param);
    
    /**
     * <p>Description: 分页查询数据字典记录列表</p>
     * @param param 数据字典对象
     * @param pageinfo 分页对象
     * @return 分页记录
     */
    PaginationResult<DictEntity> queryListByPage(DictEntity param, PageInfo pageinfo);
}
