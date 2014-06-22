package com.wade.framework.service.menu.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wade.framework.dao.menu.IMenuDao;
import com.wade.framework.entity.MenuEntity;
import com.wade.framework.service.menu.IMenuService;
import com.wade.framework.base.PageInfo;
import com.wade.framework.base.PaginationResult;

@Service("menuService")
public class MenuServiceImpl implements IMenuService {

    @Autowired
    IMenuDao menuDao;
    
    @Override
    public int insert(MenuEntity menu) {
        int id=menuDao.insert("menu.insertMenu", menu);
        return id;
    }

    @Override
    public int update(MenuEntity menu) {
        return menuDao.update("menu.updateMenu", menu);
    }

    @Override
    public int delete(MenuEntity menu) {
        return menuDao.delete("menu.deleteMenu", menu);
    }

    @Override
    public MenuEntity queryObjectById(MenuEntity menu) {
        return menuDao.queryObjectById("menu.queryMenuById", menu);
    }

    @Override
    public List<MenuEntity> queryList(Object param) {
        return menuDao.queryList("menu.queryMenu", param);
    }

    @Override
    public PaginationResult<MenuEntity> queryListByPage(MenuEntity param, PageInfo pageinfo) {
       return menuDao.queryListByPage("menu.queryMenusByPage", param, pageinfo);
    }
    
}