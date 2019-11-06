package com.ujiuye.pro.service;

import com.ujiuye.pro.bean.Project;
import com.ujiuye.pro.bean.ProjectExample;
import com.ujiuye.pro.mapper.ProjectMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService{

    @Resource
    private ProjectMapper projectMapper;

    public void saveInfo(Project project) {
        projectMapper.insert(project);

    }

    public List<Project> showProList() {
        List<Project> projects = projectMapper.selectByExample(new ProjectExample());
        return projects;
    }

    public Project getProjectDetail(Integer pid) {
        Project project = projectMapper.selectByPrimaryKey(pid);
        return project;
    }

    public List<Project> getProjectJsonList() {
        ProjectExample example = new ProjectExample();
        List<Project> projects = projectMapper.selectByExample(example);
        return projects;
    }

    public List<Project> getProjectList(Integer cid, String keyword, Integer orderby) {
        return projectMapper.getProjectListWithSearch(cid,keyword,orderby);
    }

    public List<Project> getProjectWithAnalyseJsonList() {
        return projectMapper.getProjectWithAnalyseJsonList();
    }
}
