package com.zh.service.impl;

import com.zh.dao.ToolsTypeDao;
import com.zh.domain.ToolsType;
import com.zh.service.ToolsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToolsTypeServiceImpl implements ToolsTypeService {

    @Autowired
    ToolsTypeDao toolsTypeDao;

    @Override
    public List<ToolsType> getToolsTypeAll() {
        return toolsTypeDao.findToolsTypeAll();
    }
}
