package com.luster.fistIdeaItem;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

import java.util.HashSet;
import java.util.Random;

/**
 * 布隆 过滤器
 */
public class BloomFilterTest {

    static int sizeOfNumberSet = Integer.MAX_VALUE >> 4;

    static Random generator = new Random();

    public static void main(String[] args){

        int error = 0;
        HashSet<Integer> hashSet = new HashSet<Integer>();
        BloomFilter<Integer> filter = BloomFilter.create(Funnels.integerFunnel(), sizeOfNumberSet);

        for(int i = 0; i < sizeOfNumberSet; i++) {
            int number = generator.nextInt();
            if(filter.mightContain(number) != hashSet.contains(number)) {
                error++;
            }
            filter.put(number);
            hashSet.add(number);
        }

        System.out.println("Error count: " + error + ", error rate = " + String.format("%f", (float)error/(float)sizeOfNumberSet));
    }
}
