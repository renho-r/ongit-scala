package com.renho.akka.java.withfuture;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.pattern.Patterns;
import akka.util.Timeout;
import scala.concurrent.Await;
import scala.concurrent.Future;
import scala.concurrent.duration.Duration;

/**
 * Created by renho on 2016/3/8.
 */
public class ActorWithFuture {

    public static class Worker extends UntypedActor {

        private final LoggingAdapter log = Logging.getLogger(getContext().system(), this);

        @Override
        public void onReceive(Object message) throws Exception {
            if(message instanceof String) {
                Thread.sleep(3000);
                System.out.println(Thread.currentThread().getName() + " is going to work!!!");
                System.out.println("The content of the received message is : " + message);
                this.getSender().tell("Power comes from LOVE !", this.getSelf());
                System.out.println("The sender's path=" + this.getSender().path());
                getContext().stop(this.getSelf());
                log.info("|||{} has stoped", this.getSelf().path());
            }
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("The name of current thread is : " + Thread.currentThread().getName());
        ActorSystem system = ActorSystem.create("System");
        ActorRef worker = system.actorOf(Props.create(Worker.class), "WorkActor");
        Timeout timeout = new Timeout(Duration.create(5, "seconds"));
        Future<Object> future = Patterns.ask(worker, "For free, for everyone, forever, for love!", timeout);
        String result = (String)Await.result(future, timeout.duration());
        System.out.println(result);
    }
}
