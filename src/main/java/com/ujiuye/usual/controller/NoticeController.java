package com.ujiuye.usual.controller;

import com.github.pagehelper.PageInfo;
import com.ujiuye.common.ResultEntity;
import com.ujiuye.common.StringUtils;
import com.ujiuye.usual.bean.Notice;
import com.ujiuye.usual.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    @RequestMapping(value = "/jsonList",method = RequestMethod.GET)
    @ResponseBody
    public ResultEntity getJsonList(HttpServletRequest request, @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum){
        Map<String,Object> parameterMap = WebUtils.getParametersStartingWith(request,"search_");

        String queryStr = StringUtils.parseparameterMapToString(parameterMap);
        String requestURI = request.getRequestURI();

        PageInfo<Notice> page = noticeService.jsonList(pageNum,parameterMap);

        return ResultEntity.success().put("page",page).put("queryStr",queryStr).put("requestURI",requestURI);
    }

   /* @RequestMapping(value = "jsonList",method = RequestMethod.GET)
    @ResponseBody
    public ResultEntity jsonList(){
        List<Notice> list = noticeService.jsonList();
        return ResultEntity.success().put("list",list);
    }*/


    @RequestMapping(value = "saveInfo",method = RequestMethod.POST)
    @ResponseBody
    public ResultEntity saveInfo(Notice notice){

        noticeService.saveInfo(notice);

        return ResultEntity.success();
    }
}
