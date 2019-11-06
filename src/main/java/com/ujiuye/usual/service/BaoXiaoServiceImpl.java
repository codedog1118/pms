package com.ujiuye.usual.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ujiuye.common.StringUtils;
import com.ujiuye.usual.bean.BaoXiao;
import com.ujiuye.usual.bean.BaoXiaoExample;
import com.ujiuye.usual.mapper.BaoXiaoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BaoXiaoServiceImpl implements BaoXiaoService {
    @Autowired
    private BaoXiaoMapper baoXiaoMapper;

    public void saveInfo(BaoXiao baoXiao) {

        String bxid = UUID.randomUUID().toString().replaceAll("-","");

        baoXiao.setBxid(bxid);
        baoXiao.setBxstatus(0);
        baoXiaoMapper.insert(baoXiao);
    }

    public PageInfo<BaoXiao> getMyBaoXiaoList(Integer eid, Integer pageNum,Map<String,Object> parameterMap) {
        BaoXiaoExample example = new BaoXiaoExample();
        BaoXiaoExample.Criteria criteria = example.createCriteria();
        criteria.andEmpFkEqualTo(eid);

        Map<String,String> mybatisMap = StringUtils.parseParameterMapToBatisMap(parameterMap);
        String status = mybatisMap.get("status");
        String keyword = mybatisMap.get("keyword");
        if(status != null && status != ""){
            criteria.andBxstatusEqualTo(Integer.parseInt(status));
        }
        if(keyword != null && keyword != ""){
            criteria.andBxremarkLike(keyword);
        }

        PageHelper.startPage(pageNum,3);
        List<BaoXiao> baoXiaos = baoXiaoMapper.selectByExample(example);
        PageInfo<BaoXiao> page = new PageInfo<BaoXiao>(baoXiaos,5);
        return page;
    }


}
