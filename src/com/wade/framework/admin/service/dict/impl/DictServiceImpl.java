package com.wade.framework.admin.service.dict.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wade.framework.admin.dao.dict.IDictDao;
import com.wade.framework.admin.entity.DictEntity;
import com.wade.framework.admin.service.dict.IDictService;
import com.wade.framework.base.PageInfo;
import com.wade.framework.base.PaginationResult;

@Service("dictService")
public class DictServiceImpl implements IDictService {

    @Autowired
    IDictDao dictDao;
    
    @Override
    public int insert(DictEntity dict) {
    	dict.setDeleteMark("0");
        int id=dictDao.insert("dict.insertDict", dict);
        return id;
    }

    @Override
    public int update(DictEntity dict) {
        return dictDao.update("dict.updateDict", dict);
    }

    @Override
    public int delete(DictEntity dict) {
        return dictDao.delete("dict.deleteDict", dict);
    }

    @Override
    public DictEntity queryObjectById(Long id) {
        return dictDao.queryObjectById("dict.queryDictById", id);
    }

    @Override
    public List<DictEntity> queryList(Object param) {
        return dictDao.queryList("dict.queryDicts", param);
    }

    @Override
    public PaginationResult<DictEntity> queryListByPage(DictEntity param, PageInfo pageinfo) {
       return dictDao.queryListByPage("dict.queryDictsByPage", param, pageinfo);
    }
    
}
