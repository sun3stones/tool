package com.lei.tool.test;

import org.apache.commons.codec.digest.DigestUtils;

public class Test {
    public static void main(String[] args) {
        System.out.println(DigestUtils.md5Hex("123456"));
    }
}
