package com.felix.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Permute{
    static void permute(List<Integer> arr, int k){
        for(int i = k; i < arr.size(); i++){
            Collections.swap(arr, i, k);
            permute(arr, k+1);
            Collections.swap(arr, k, i);
        }
        if (k == arr.size() -1){
            System.out.println(Arrays.toString(arr.toArray()));
        }
    }
    public static void main(String[] args){
        Permute.permute(Arrays.asList(3,4,6,2,1), 0);
    }
}
