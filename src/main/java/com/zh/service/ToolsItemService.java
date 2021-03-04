package com.zh.service;

import com.github.pagehelper.PageInfo;
import com.zh.domain.ToolsItem;

public interface ToolsItemService {
    int insertToolsItem(ToolsItem toolsItem);

    PageInfo<ToolsItem> getToolsItem(int toolsTypeId);

    PageInfo<ToolsItem> getToolsItemAll();
}
