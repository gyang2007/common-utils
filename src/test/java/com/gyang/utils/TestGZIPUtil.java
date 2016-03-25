package com.gyang.utils;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * Created by gyang on 16-3-25.
 */
public class TestGZIPUtil {

    @Test
    public void testCompress() throws UnsupportedEncodingException {
        String originalStr = "sadfasghasiod asod g3 94u 0asjg -2340gu -0wjg9jw349gu ]3-40i sdg";
        byte[] originalBytes = originalStr.getBytes("UTF-8");
        byte[] bytes = GZIPUtil.compress(originalBytes);
        System.out.println(originalBytes.length);
        System.out.println(bytes.length);
        System.out.println(Arrays.toString(originalBytes));
        System.out.println(Arrays.toString(bytes));
    }
}
