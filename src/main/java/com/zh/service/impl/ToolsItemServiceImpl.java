package com.zh.service.impl;

import com.github.pagehelper.PageInfo;
import com.zh.dao.ToolsItemDao;
import com.zh.domain.ToolsItem;
import com.zh.service.ToolsItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class ToolsItemServiceImpl implements ToolsItemService {

    @Autowired
    ToolsItemDao toolsItemDao;

    @Override
    public int insertToolsItem(ToolsItem toolsItem) {
        return toolsItemDao.insertToolsItem(toolsItem);
    }

    @Override
    public PageInfo<ToolsItem> getToolsItem(int toolsTypeId) {
        HashMap<String, Object> map = new HashMap<>();
        // 类型ID
        map.put("toolsTypeId", toolsTypeId);

        List<ToolsItem> list = toolsItemDao.findToolsItemByCondition(map);

        PageInfo<ToolsItem> pageInfo = new PageInfo<>(list, 4);

        return pageInfo;
    }

    @Override
    public PageInfo<ToolsItem> getToolsItemAll() {

        List<ToolsItem> list = toolsItemDao.findToolsItemAll();

        PageInfo<ToolsItem> pageInfo = new PageInfo<>(list, 4);

        return pageInfo;
    }
}
