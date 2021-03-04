package com.zh.dao;


import com.zh.domain.ToolsItem;

import java.util.HashMap;
import java.util.List;

public interface ToolsItemDao {

    int insertToolsItem(ToolsItem toolsItem);

    List<ToolsItem> findToolsItemAll();

    List<ToolsItem> findToolsItemByCondition(HashMap<String, Object> map);
}
