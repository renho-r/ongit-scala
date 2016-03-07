package com.renho.akka.java.actors;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;
import com.renho.akka.java.messages.Result;

/**
 * Created by renho on 2016/3/7.
 */
public class MasterActor extends UntypedActor {

    private ActorRef aggregateActor = getContext().actorOf(Props.create(AggregateActor.class), "aggregate");
    private ActorRef reduceActor = getContext().actorOf(Props.create(ReduceActor.class, aggregateActor), "reduce");
    private ActorRef mapActor = getContext().actorOf(Props.create(MapActor.class, reduceActor), "map");

    @Override
    public void onReceive(Object message) throws Exception {
            if(message instanceof String) {
                mapActor.tell(message, this.getSelf());
            } else if(message instanceof Result) {
                aggregateActor.tell(message, this.getSelf());
            } else {
                unhandled(message);
            }
    }
}
