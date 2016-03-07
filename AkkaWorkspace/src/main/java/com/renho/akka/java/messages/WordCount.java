package com.renho.akka.java.messages;

/**
 * Created by renho on 2016/3/7.
 */
public class WordCount {

    private String word;
    private Integer count;

    public WordCount(String word, Integer count) {
        this.word = word;
        this.count = count;
    }

    public String getWord() {
        return this.word;
    }

    public Integer getCount() {
        return  count;
    }
}
