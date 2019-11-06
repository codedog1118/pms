package com.ujiuye.pro.service;

import com.ujiuye.pro.bean.Project;

import java.util.List;

public interface ProjectService {
    void saveInfo(Project project);

    List<Project> showProList();

    Project getProjectDetail(Integer pid);

    List<Project> getProjectJsonList();

    List<Project> getProjectList(Integer cid, String keyword, Integer orderby);

    List<Project> getProjectWithAnalyseJsonList();
}
