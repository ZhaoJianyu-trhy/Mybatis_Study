package com.zjy.utils;

import org.junit.Test;

import java.util.UUID;

public class IDUtils {

    public static final String getID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    @Test
    public void test1() {
        System.out.println(getID());
    }

}
