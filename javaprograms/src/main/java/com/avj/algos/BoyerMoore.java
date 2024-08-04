package com.avj.algos;

public class BoyerMoore {


    public static void main(String[] args) {

        Integer[] nums = {1,2,3,3,2,3,4,5,3,3,3};

        int number = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                number = nums[i];
                count = 1;
            } else if (nums[i] == number) {
                count++;
            } else {
                count--;
            }
            System.out.println("i = "+i+ " nums["+i+"]: "+ nums[i]+" number: "+number+ " count: "+count);
        }

        int counter = 0;
        for (int num : nums) {
            if (num == number) counter++;
        }

        int halflen = nums.length / 2;
        System.out.println("len/2 : " + halflen);
        if (counter > halflen) {
            System.out.println("Largest votes for " + number + " count: " + counter);
        } else {
            System.out.println("No largest vote, number: " + number);
        }

    }
}
