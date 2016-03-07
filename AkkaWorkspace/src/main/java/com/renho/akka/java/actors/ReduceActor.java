package com.renho.akka.java.actors;

import akka.actor.ActorRef;
import akka.actor.UntypedActor;
import com.renho.akka.java.messages.MapData;
import com.renho.akka.java.messages.ReduceData;
import com.renho.akka.java.messages.WordCount;

import java.util.HashMap;
import java.util.List;

/**
 * Created by renho on 2016/3/7.
 */
public class ReduceActor extends UntypedActor {

    private ActorRef aggregateActor;

    public ReduceActor(ActorRef aggregateActor) {
        this.aggregateActor = aggregateActor;
    }

    @Override
    public void onReceive(Object message) throws Exception {

        if(message instanceof MapData) {
            MapData md = (MapData) message;
            ReduceData rd = reduce(md.getDataList());
            aggregateActor.tell(rd, this.getSelf());
        } else {
            unhandled(message);
        }

    }

    private ReduceData reduce(List<WordCount> dataList) {
        HashMap<String, Integer> reduceMap = new HashMap<String, Integer>();
        for(WordCount wc:dataList) {
            if(reduceMap.containsKey(wc.getWord())) {
                int count = reduceMap.get(wc.getWord());
                reduceMap.put(wc.getWord(), count+1);
            } else {
                reduceMap.put(wc.getWord(), 1);
            }
        }
        return new ReduceData(reduceMap);
    }
}
