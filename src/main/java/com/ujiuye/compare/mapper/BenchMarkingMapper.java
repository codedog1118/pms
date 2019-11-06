package com.ujiuye.compare.mapper;

import com.ujiuye.compare.bean.BenchMarking;

import java.util.List;

public interface BenchMarkingMapper {
    void saveInfo(BenchMarking benchMarking);

    List<BenchMarking> getAmountList(Integer year);
}
