package com.wade.framework.admin.service.func.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wade.framework.admin.dao.func.IFuncDao;
import com.wade.framework.admin.entity.FuncEntity;
import com.wade.framework.admin.service.func.IFuncService;
import com.wade.framework.base.PageInfo;
import com.wade.framework.base.PaginationResult;

@Service("funcService")
public class FuncServiceImpl implements IFuncService {

    @Autowired
    IFuncDao funcDao;
    
    @Override
    public int insert(FuncEntity func) {
    	func.setDeleteMark("0");
        int id=funcDao.insert("func.insertFunc", func);
        return id;
    }

    @Override
    public int update(FuncEntity func) {
        return funcDao.update("func.updateFunc", func);
    }

    @Override
    public int delete(FuncEntity func) {
        return funcDao.delete("func.deleteFunc", func);
    }

    @Override
    public FuncEntity queryObjectById(Long id) {
        return funcDao.queryObjectById("func.queryFuncById", id);
    }

    @Override
    public List<FuncEntity> queryList(Object param) {
        return funcDao.queryList("func.queryFuncs", param);
    }

    @Override
    public PaginationResult<FuncEntity> queryListByPage(FuncEntity param, PageInfo pageinfo) {
       return funcDao.queryListByPage("func.queryFuncsByPage", param, pageinfo);
    }
    
}
