package com.zh.dao;


import com.zh.domain.ToolsType;

import java.util.List;

public interface ToolsTypeDao {

    int insertToolsType(ToolsType toolsType);


    List<ToolsType> findToolsTypeAll();
}
