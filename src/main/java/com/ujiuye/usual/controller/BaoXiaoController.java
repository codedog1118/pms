package com.ujiuye.usual.controller;

import com.github.pagehelper.PageInfo;
import com.ujiuye.common.StringUtils;
import com.ujiuye.sys.bean.Employee;
import com.ujiuye.usual.bean.BaoXiao;
import com.ujiuye.usual.service.BaoXiaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.Set;

@RequestMapping("/bx")
@Controller
public class BaoXiaoController {
    @Autowired
    private BaoXiaoService baoXiaoService;

    @RequestMapping(value = "/myList",method = RequestMethod.GET)
    public ModelAndView getMyBaoXiaoList(HttpServletRequest request,HttpSession session, @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum){
        Map<String,Object> parameterMap = WebUtils.getParametersStartingWith(request,"search_");

        String queryStr = StringUtils.parseparameterMapToString(parameterMap);

        Employee loginUser = (Employee) session.getAttribute("loginUser");

        String requestURI = request.getRequestURI();

        Integer eid = loginUser.getEid();
        PageInfo<BaoXiao> page = baoXiaoService.getMyBaoXiaoList(eid,pageNum,parameterMap);
        ModelAndView mv = new ModelAndView("mybaoxiao-base");
        mv.addObject("page",page);
        mv.addObject("queryStr",queryStr);
        mv.addObject("requestURI",requestURI);
        return mv;
    }



    @RequestMapping(value = "/saveInfo",method = RequestMethod.POST)
    public String saveInfo(BaoXiao baoXiao, HttpSession session){
        Employee loginUser = (Employee) session.getAttribute("loginUser");
        baoXiao.setEmpFk(loginUser.getEid());
        baoXiaoService.saveInfo(baoXiao);
        return "redirect:/mybaoxiao-base.jsp";
    }

}
