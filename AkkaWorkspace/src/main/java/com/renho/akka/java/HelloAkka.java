package com.renho.akka.java;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import com.renho.akka.java.actors.MasterActor;
import com.renho.akka.java.messages.Result;

/**
 * Created by renho on 2016/3/7.
 */
public class HelloAkka {
    public static void main(String[] args) throws InterruptedException {
        ActorSystem as = ActorSystem.create("HelloAkka");
        ActorRef master = as.actorOf(Props.create(MasterActor.class), "master");
        master.tell("hello renho", null);
        master.tell("renho renho renho import com.renho.akka.java.actors.MasterActor;", null);
        master.tell("renho ActorRef master = = as.actorOf(Props.create(MasterActor.class), \"master\");", null);
        Thread.sleep(500);
        master.tell(new Result(), null);

        as.terminate();
    }
}
