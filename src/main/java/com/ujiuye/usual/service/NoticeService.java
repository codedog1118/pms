package com.ujiuye.usual.service;

import com.github.pagehelper.PageInfo;
import com.ujiuye.usual.bean.Notice;

import java.util.List;
import java.util.Map;

public interface NoticeService {
    void saveInfo(Notice notice);

    PageInfo<Notice> jsonList(Integer pageNum, Map<String, Object> parameterMap);
}
