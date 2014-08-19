package com.wipro.wess.ods.utils;

import java.nio.charset.Charset;

import com.google.common.io.BaseEncoding;

public class OmUtil {

    public static String encode(String str) {
        return BaseEncoding.base32().encode(str.getBytes(Charset.forName("UTF-8")));
    }

    public static String decode(String str) {
        return new String(BaseEncoding.base32().decode(str), Charset.forName("UTF-8"));
    }

}
