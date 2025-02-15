package org.leurning.spark;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import java.util.ArrayList;
import java.util.List;

public class Map {
    public static void main(String[] args) {

        List<Integer> inputData = new ArrayList<>();
        inputData.add(35);
        inputData.add(12);
        inputData.add(90);
        inputData.add(20);

        Logger.getLogger("org.apache").setLevel(Level.WARN);

        SparkConf conf = new SparkConf().setAppName("startingSpark").setMaster("local[*]");
        JavaSparkContext sc = new JavaSparkContext(conf);

        JavaRDD<Integer> myRdd = sc.parallelize(inputData);

        Integer result = myRdd.reduce((value1, value2) -> value1 + value2);

        JavaRDD<Double> sqrtRdd = myRdd.map(value -> Math.sqrt(value));
        sqrtRdd.foreach(value -> System.out.println(value));

        System.out.println(result);

        // how many elements in sqrtRDD
        //using just map and reduce
        System.out.println("how many elements in sqrtRDD ?" + sqrtRdd.count());
        JavaRDD<Long> singleIntegerRdd = sqrtRdd.map(value -> 1L);
        Long count  = singleIntegerRdd.reduce((value1, value2) -> value1 + value2);
        sc.close();


    }
}
