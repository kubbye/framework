package com.wade.framework.admin.service.syslog;

import java.util.List;

import com.wade.framework.admin.entity.SyslogEntity;
import com.wade.framework.base.PageInfo;
import com.wade.framework.base.PaginationResult;

/**
 * <p>ClassName: ISyslogService</p>
 * <p>Description: 系统日志Service接口</p>
 * <p>Author: weih</p>
 * <p>Date: 2014-07-07</p>
 */
public interface ISyslogService {
    /**
     * <p>Description: 插入系统日志</p>
     * @param syslog 系统日志对象
     * @return
     */
    int insert(SyslogEntity syslog);
    
    /**
     * <p>Description: 更新系统日志</p>
     * @param syslog 系统日志对象
     * @return
     */
    int update(SyslogEntity syslog);
    
    /**
     * <p>Description: 删除系统日志</p>
     * @param syslog 系统日志对象
     * @return
     */
    int delete(SyslogEntity syslog);
    
    /**
     * <p>Description: 根据系统日志id查询系统日志记录</p>
     * @param syslog 系统日志对象
     * @return 系统日志对象
     */
    SyslogEntity queryObjectById(SyslogEntity syslog);
    
    /**
     * <p>Description: 查询系统日志记录列表</p>
     * @param param 系统日志对象
     * @return 系统日志记录列表
     */
    List<SyslogEntity> queryList(Object param);
    
    /**
     * <p>Description: 分页查询系统日志记录列表</p>
     * @param param 系统日志对象
     * @param pageinfo 分页对象
     * @return 分页记录
     */
    PaginationResult<SyslogEntity> queryListByPage(SyslogEntity param, PageInfo pageinfo);
}
