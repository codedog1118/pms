package com.ujiuye.compare.service;

import com.ujiuye.compare.bean.BenchMarking;

import java.util.List;

public interface BenchMarkingService {
    void saveInfo(BenchMarking benchMarking);

    List<BenchMarking> getAmountList(Integer year);
}
