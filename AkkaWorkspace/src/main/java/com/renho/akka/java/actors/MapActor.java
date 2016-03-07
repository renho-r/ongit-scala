package com.renho.akka.java.actors;

import akka.actor.ActorRef;
import akka.actor.UntypedActor;
import com.renho.akka.java.messages.MapData;
import com.renho.akka.java.messages.WordCount;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by renho on 2016/3/7.
 */
public class MapActor extends UntypedActor {

    private ActorRef reduceActor;
    private final String[] STOP_WORDS = {"a", "is"};
    private final List<String> STOP_WORDS_LIST = Arrays.asList(STOP_WORDS);

    public MapActor(ActorRef reduceActor) {
        this.reduceActor = reduceActor;
    }

    @Override
    public void onReceive(Object message) throws Exception {
        if(message instanceof  String) {
            String work = (String) message;
            MapData md = evaluateExpression(work);
            reduceActor.tell(md, this.getSelf());
        } else {
            unhandled(message);
        }
    }

    private MapData evaluateExpression(String line) {
        List<WordCount> dataList = new ArrayList<WordCount>();
        StringTokenizer st = new StringTokenizer(line);
        while(st.hasMoreTokens()) {
            String word = st.nextToken().toLowerCase();
            if(!STOP_WORDS_LIST.contains(word)) {
                dataList.add(new WordCount(word, 1));
            }
        }
        return new MapData(dataList);
    }
}
