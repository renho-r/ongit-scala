package com.renho.akka.java.messages;

import java.util.HashMap;

/**
 * Created by renho on 2016/3/7.
 */
public class ReduceData {

    private HashMap<String, Integer> reduceDataList;

    public HashMap<String, Integer> getReduceDataList() {
        return this.reduceDataList;
    }

    public ReduceData(HashMap<String, Integer> reduceDataList) {
        this.reduceDataList = reduceDataList;
    }

}
