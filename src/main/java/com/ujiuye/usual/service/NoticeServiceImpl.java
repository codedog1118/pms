package com.ujiuye.usual.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ujiuye.common.StringUtils;
import com.ujiuye.usual.bean.NoticeExample;
import com.ujiuye.usual.bean.Notice;
import com.ujiuye.usual.mapper.NoticeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class NoticeServiceImpl implements NoticeService{

    @Autowired
    private NoticeMapper noticeMapper;

    public void saveInfo(Notice notice) {
        notice.setNdate(new Date());
        noticeMapper.insert(notice);
    }

    public PageInfo<Notice> jsonList(Integer pageNum, Map<String, Object> parameterMap) {
       /* NoticeExample example = new NoticeExample();
        return noticeMapper.selectByExample(example);*/

        NoticeExample example = new NoticeExample();
        NoticeExample.Criteria criteria = example.createCriteria();

        Map<String,String> mybatisMap = StringUtils.parseParameterMapToBatisMap(parameterMap);

        PageHelper.startPage(pageNum,3);
        List<Notice> notices = noticeMapper.selectByExample(example);
        PageInfo<Notice> page = new PageInfo<Notice>(notices,5);
        return  page;
    }
}
