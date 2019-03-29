package com.taurin190;

import com.taurin190.entity.WorkEntity;

import java.util.ArrayList;
import java.util.List;

public class BaseTest {
    protected List<WorkEntity> getTestWorkEntityList() {
        List<WorkEntity> testWorkEntityList = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            WorkEntity entity =
                    WorkEntity.builder()
                            .id(i)
                            .name("work:" + i)
                            .imgUrl("http://hogehoge.com/" + i)
                            .summary("このようなもの作りました。")
                            .publishedDate("2019/01/01")
                            .url("http://taurin190.com")
                            .build();
            testWorkEntityList.add(entity);
        }
        return testWorkEntityList;
    }
}
