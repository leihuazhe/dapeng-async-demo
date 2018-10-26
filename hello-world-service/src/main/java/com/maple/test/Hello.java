package com.maple.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href=mailto:leihuazhe@gmail.com>maple</a>
 * @since 2018-10-17 2:52 PM
 */
public class Hello {

    public static void main(String[] args) {
        List<String> valueList = new ArrayList<>();
        valueList.add("maple");
        valueList.add("maple2");
        valueList.add("maple3");


        String s = valueList.toString();

        System.out.println(s);
    }
}
