package com.ujiuye.compare.controller;

import com.ujiuye.compare.bean.BenchMarking;
import com.ujiuye.compare.service.BenchMarkingService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping("/benchmarking")
@Controller
public class BenchMarkingController {
    @Autowired
    private BenchMarkingService benchMarkingService;

    @RequestMapping("/list/{year}")
    @ResponseBody
    public List<BenchMarking> getAmountList(@PathVariable("year") Integer year){
        return benchMarkingService.getAmountList(year);
    }

    @RequestMapping(value = "/saveInfo",method = RequestMethod.POST)
    public String saveInfo(BenchMarking benchMarking){
        benchMarkingService.saveInfo(benchMarking);
        return "redirect:/indexvalue-base.jsp";
    }
}
