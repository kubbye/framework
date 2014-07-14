package com.wade.framework.admin.service.syslog.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wade.framework.admin.dao.syslog.ISyslogDao;
import com.wade.framework.admin.entity.SyslogEntity;
import com.wade.framework.admin.service.syslog.ISyslogService;
import com.wade.framework.base.PageInfo;
import com.wade.framework.base.PaginationResult;

@Service("syslogService")
public class SyslogServiceImpl implements ISyslogService {

    @Autowired
    ISyslogDao syslogDao;
    
    @Override
    public int insert(SyslogEntity syslog) {
    	syslog.setDeleteMark("0");
        int id=syslogDao.insert("syslog.insertSyslog", syslog);
        return id;
    }

    @Override
    public int update(SyslogEntity syslog) {
        return syslogDao.update("syslog.updateSyslog", syslog);
    }

    @Override
    public int delete(SyslogEntity syslog) {
        return syslogDao.delete("syslog.deleteSyslog", syslog);
    }

    @Override
    public SyslogEntity queryObjectById(SyslogEntity syslog) {
        return syslogDao.queryObjectById("syslog.querySyslogById", syslog.getId());
    }

    @Override
    public List<SyslogEntity> queryList(Object param) {
        return syslogDao.queryList("syslog.querySyslog", param);
    }

    @Override
    public PaginationResult<SyslogEntity> queryListByPage(SyslogEntity param, PageInfo pageinfo) {
       return syslogDao.queryListByPage("syslog.querySyslogsByPage", param, pageinfo);
    }
    
}
