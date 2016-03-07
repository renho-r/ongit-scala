package com.renho.akka.java.actors;

import akka.actor.UntypedActor;
import com.renho.akka.java.messages.ReduceData;
import com.renho.akka.java.messages.Result;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by renho on 2016/3/7.
 */
public class AggregateActor extends UntypedActor {

    private Map<String, Integer> finalReduceMap = new HashMap<String, Integer>();

    @Override
    public void onReceive(Object message) throws Exception {
        if(message instanceof ReduceData) {
            ReduceData rd = (ReduceData) message;
            aggregateInMemoryReduce(rd.getReduceDataList());
        } else if(message instanceof Result) {
            System.out.println(finalReduceMap);
        } else {
            unhandled(message);
        }
    }

    private void aggregateInMemoryReduce(HashMap<String, Integer> reduceDataList) {
        Integer count = null;
        for(String key: reduceDataList.keySet()) {
            if(finalReduceMap.containsKey(key)) {
                count = finalReduceMap.get(key);
                finalReduceMap.put(key, count + reduceDataList.get(key));
            } else {
                finalReduceMap.put(key, reduceDataList.get(key));
            }
        }
    }
}
