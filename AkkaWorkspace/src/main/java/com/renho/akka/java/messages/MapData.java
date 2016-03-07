package com.renho.akka.java.messages;

import java.util.List;

/**
 * Created by renho on 2016/3/7.
 */
public class MapData {

    private List<WordCount> dataList;

    public MapData(List<WordCount> dataList) {
        this.dataList = dataList;
    }

    public List<WordCount> getDataList() {
        return this.dataList;
    }
}
