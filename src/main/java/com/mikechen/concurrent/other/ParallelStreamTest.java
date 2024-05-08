package com.mikechen.concurrent.other;

import java.util.Arrays;
import java.util.List;

/**
 * ParallelStream详解
 *
 * @author  mikechen
 */
public class ParallelStreamTest {

    public static void main(String[] args){
        List<Integer> numberList = Arrays.asList(1,2,3,4,5,6,7,8,9);
        numberList.parallelStream().forEach(System.out::println);
    }
}

