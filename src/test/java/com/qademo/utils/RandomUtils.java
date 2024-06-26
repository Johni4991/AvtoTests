package com.qademo.utils;

import java.security.SecureRandom;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {

    public static void main(String[] args) {
        System.out.println(randomInt(10, 100));
        System.out.println(randomString(10));
        System.out.println(randomEmail());

        String[] names = {"a", "b", "c", "d", "e"};
        System.out.println(randomItem(names));
    }

    public static int randomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static String randomString(int len) {
        String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String CD = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder(len);
        for(int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }
    public static String randomEmail() {
        return randomString(7)+"@mail.ru";
    }
    public static String randomItem(String[] values) {
        int index = randomInt(0, values.length - 1);
        return values[index];
    }

}
