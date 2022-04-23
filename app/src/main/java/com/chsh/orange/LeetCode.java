package com.chsh.orange;

public class LeetCode {


    public int maxSum(int[] arr){
        if(arr.length==1){
            return arr[0];
        }else if(arr.length==2){
            return Math.max(arr[0],arr[1]);
        }
            int first = arr[0];
            int second = Math.max(arr[0],arr[1]);
            for (int i = 2; i < arr.length; i++) {
                int temp = second;
                second = Math.max(first + arr[i], second);
                first = temp;
            }
            return second;
    }

}
