package com.avj.algos;

import java.util.*;

public class BracketMatch {

    public boolean isValid(String s) {
        Map<Character, Character> vmap = new HashMap<>();
        Stack<Character> stack = new Stack<>();
        vmap.put('(', ')');
        vmap.put('[', ']');
        vmap.put('{', '}');
        char[] arr = s.toCharArray();
        boolean allmatch = true;
        if (arr.length % 2 != 0) {
            return false;
        }
        for (int i = 0; i < arr.length; i++) {
            if (i > arr.length || i + 1 > arr.length) {
                break;
            }
            char selem;
            char present = arr[i];
            if (present == '(' || present == '{' || present == '[') {
                stack.push(present);
            } else if (present == ')' || present == '}' || present == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                selem = stack.pop();
                if (vmap.get(selem) == null || vmap.get(selem) != present) {
                    return false;
                }
            } else {
                return false;
            }
        }
        if(!stack.isEmpty()) { allmatch =false;}
        return allmatch;
    }

    public static void main(String[] args) {
        String str = "((";
        BracketMatch bm = new BracketMatch();
        boolean allmatch = bm.isValid(str);
        System.out.println("All brackets match: " + allmatch);


    }

}
