package com.ujiuye.usual.service;

import com.github.pagehelper.PageInfo;
import com.ujiuye.usual.bean.BaoXiao;

import java.util.Map;

public interface BaoXiaoService {
    void saveInfo(BaoXiao baoXiao);

    PageInfo<BaoXiao> getMyBaoXiaoList(Integer eid, Integer pageNum, Map<String,Object> parameterMap);
}
