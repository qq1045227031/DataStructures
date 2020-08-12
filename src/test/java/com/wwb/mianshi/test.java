package com.wwb.mianshi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class test {
    public static void main(String[] args) {
//        System.out.println(Long.toHexString(0x100000000L+0xcafebabe));
//        int i = 1;
//        System.out.println(isOdd1(i));
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(3,2,1,4));
        list= list.stream().filter(i->i>1)
                .map(i->i*10).sorted().collect(Collectors.toList());
        System.out.println(list);

    }
    public static boolean isOdd1(int i){
        return i%2==1;
    }

}
