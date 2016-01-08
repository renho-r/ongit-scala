package com.renho;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.Function2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by renho on 2016/1/8.
 */
public class MyJavaSparkPi {

    public static void main(String[] args) {
        args = new String[]{"10"};
        SparkConf conf = new SparkConf();
        conf.setAppName("MyJavaSparkPi");
        conf.setMaster("spark://master:7077");
        JavaSparkContext jsc = new JavaSparkContext(conf);
        jsc.addJar("file:///d:sparkData/lib/spark-wordcount-in-java-win.jar");
        int slices = (args.length == 1) ? Integer.parseInt(args[0]) : 2;
        int n = 100000 * slices;
        List<Integer> l = new ArrayList<Integer>(n);
        for (int i = 0; i < n; i++) {
            l.add(i);
        }
        JavaRDD<Integer> dataSet = jsc.parallelize(l);

        int count = dataSet.map(new Function<Integer, Integer>() {
            @Override
            public Integer call(Integer integer) throws Exception {
                double x = Math.random() * 2 - 1;
                double y = Math.random() * 2 - 1;
                return (x * x + y * y < 1) ? 1 : 0;
            }
        }).reduce(new Function2<Integer, Integer, Integer>() {
            @Override
            public Integer call(Integer integer, Integer integer2) throws Exception {
                return integer + integer2;
            }
        });

        System.out.println("Pi is" + 4.0 * count / n);
        jsc.stop();
    }

}
