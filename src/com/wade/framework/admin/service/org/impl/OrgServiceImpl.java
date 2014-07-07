package com.wade.framework.admin.service.org.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wade.framework.admin.dao.org.IOrgDao;
import com.wade.framework.admin.entity.OrgEntity;
import com.wade.framework.admin.service.org.IOrgService;
import com.wade.framework.base.PageInfo;
import com.wade.framework.base.PaginationResult;
import com.wade.framework.base.entity.TreeEntity;

@Service("orgService")
public class OrgServiceImpl implements IOrgService {

    @Autowired
    IOrgDao orgDao;
    
    @Override
    public int insert(OrgEntity org) {
    	org.setDeleteMark("0");
        int id=orgDao.insert("org.insertOrg", org);
        return id;
    }

    @Override
    public int update(OrgEntity org) {
        return orgDao.update("org.updateOrg", org);
    }

    @Override
    public int delete(OrgEntity org) {
        return orgDao.delete("org.deleteOrg", org);
    }

    @Override
    public OrgEntity queryObjectById(OrgEntity org) {
        return orgDao.queryObjectById("org.queryOrgById", org.getOrgId());
    }

    @Override
    public List<OrgEntity> queryList(Object param) {
        return orgDao.queryList("org.queryOrg", param);
    }

    @Override
    public PaginationResult<OrgEntity> queryListByPage(OrgEntity param, PageInfo pageinfo) {
       return orgDao.queryListByPage("org.queryOrgsByPage", param, pageinfo);
    }

    @Override
    public List<TreeEntity> initOrgTree(Long parentId) {
        OrgEntity entity = new OrgEntity();
        if(null != parentId){
            entity.setParentId(parentId);
        }
        return orgDao.queryList("org.queryOrgTree", entity);
    }

    @Override
    public Boolean isCodeExists(String code, Long orgId) {
        OrgEntity entity = new OrgEntity();
        entity.setOrgCode(code);
        entity.setOrgId(orgId);
        return orgDao.getCount("org.queryCountByCode", entity)>0;
    }
    
    
    
}
