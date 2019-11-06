package com.ujiuye.compare.service;

import com.ujiuye.compare.bean.BenchMarking;
import com.ujiuye.compare.mapper.BenchMarkingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BenchMarkingServiceImpl implements BenchMarkingService {

    @Autowired
    private BenchMarkingMapper benchMarkingMapper;

    public void saveInfo(BenchMarking benchMarking) {
        benchMarkingMapper.saveInfo(benchMarking);
    }

    public List<BenchMarking> getAmountList(Integer year) {
        return benchMarkingMapper.getAmountList(year);
    }
}
