package com.wade.framework.admin.service.org.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wade.framework.admin.dao.org.IOrgDao;
import com.wade.framework.admin.entity.OrgEntity;
import com.wade.framework.admin.service.org.IOrgService;
import com.wade.framework.base.Constants;
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
        int id = orgDao.insert("org.insertOrg", org);
        // 计算机构路径并插入数据库
        String path = calcPath(org);
        org.setOrgPath(path);
        orgDao.update("org.updateOrgPath", org);

        return id;
    }

    @Override
    public int update(OrgEntity org) {
        return orgDao.update("org.updateOrg", org);
    }

    @Override
    public int delete(OrgEntity org) {
        //删除机构下的角色和岗位授权
        orgDao.delete("org.deleteAuthByOrg", org.getOrgId());
        //删除机构下的用户与角色和岗位
        orgDao.delete("role.deleteRoleByOrg", org);
        orgDao.delete("post.deletePostByOrg", org);
        //删除机构下的用户
        orgDao.delete("user.deleteUserByOrg", org);
        //删除机构
        return orgDao.delete("org.deleteOrg", org);
    }

    @Override
    public OrgEntity queryObjectById(Long orgId) {
        return orgDao.queryObjectById("org.queryOrgById", orgId);
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
        if (null != parentId) {
            entity.setParentId(parentId);
        }
        return orgDao.queryList("org.queryOrgTree", entity);
    }

    @Override
    public Boolean isCodeExists(String code, Long orgId) {
        OrgEntity entity = new OrgEntity();
        entity.setOrgCode(code);
        entity.setOrgId(orgId);
        return orgDao.getCount("org.queryCountByCode", entity) > 0;
    }
    
    /**
     * 功能描述: 计算机构路径<br>
     *  
     *
     * @param org
     * @return
     */
    private String calcPath(OrgEntity org) {
        String path = "";
        if (Constants.ORG_ROOT.equals(org.getParentId())) {
            path = org.getOrgId() + Constants.PATH_SEPRATOR;
        } else {
            OrgEntity parent = queryObjectById(org.getParentId());
            if (parent.getOrgPath().endsWith(Constants.PATH_SEPRATOR)) {
                path = parent.getOrgPath() + org.getOrgId();
            } else {
                path = parent.getOrgPath() + Constants.PATH_SEPRATOR + org.getOrgId();
            }
        }
        return path;
    }
    
    
}
