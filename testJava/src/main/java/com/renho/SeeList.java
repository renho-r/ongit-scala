package com.renho;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by renho on 2016/1/28.
 */
public class SeeList {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        for(int i=0; i<1*10000; i++) {
            list.add(i + "");
        }
        System.out.println(list.size());
    }

}
