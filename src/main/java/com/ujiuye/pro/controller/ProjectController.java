package com.ujiuye.pro.controller;

import com.sun.tracing.dtrace.ModuleAttributes;
import com.ujiuye.pro.bean.Project;
import com.ujiuye.pro.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/pro")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @RequestMapping(value = "/withAnalyseJsonList",method = RequestMethod.GET)
    @ResponseBody
    public List<Project> getProjectWithAnalyseJsonList(){
        return projectService.getProjectWithAnalyseJsonList();
    }


    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ModelAndView getProjectList(Integer cid,String keyword,Integer orderby){
        ModelAndView mv = new ModelAndView("project-base");
        List<Project> list = projectService.getProjectList(cid,keyword,orderby);

        mv.addObject("list",list);

        return mv;
    }



    @RequestMapping(value = "/detail/{pid}",method = RequestMethod.GET)
    public String detail(@PathVariable("pid") Integer pid , Map<String,Object> map){
        Project project = projectService.getProjectDetail(pid);
        map.put("project",project);
        return "project-base-look";
    }

    //
    @RequestMapping(value = "/jsonList",method = RequestMethod.GET)
    @ResponseBody
    public List<Project> getProjectJsonList(){
        return projectService.getProjectJsonList();
    }

   /* @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ModelAndView showProList(){
        List<Project> list = projectService.showProList();
        ModelAndView mv = new ModelAndView("project-base");
        mv.addObject("list",list);
        return  mv;
    }*/


    @RequestMapping(value = "/saveInfo",method = RequestMethod.POST)
    public String saveInfo(Project project){
        projectService.saveInfo(project);
        return "redirect:/pro/list";
    }

}
