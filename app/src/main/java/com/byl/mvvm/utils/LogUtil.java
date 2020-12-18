package com.byl.mvvm.utils;

import android.util.Log;


import com.byl.mvvm.BuildConfig;

import java.util.Arrays;
import java.util.List;

/**
 * Created by hf on 2016/4/1.
 */

public class LogUtil {

    private static boolean DEBUG_V = BuildConfig.DEBUG;
    private static boolean DEBUG_D = BuildConfig.DEBUG;
    private static boolean DEBUG_I = BuildConfig.DEBUG;
    private static boolean DEBUG_W = BuildConfig.DEBUG;
    private static boolean DEBUG_E = BuildConfig.DEBUG;

    //todo Log-上线前记得关闭Log
//    private static boolean DEBUG_V = true;
//    private static boolean DEBUG_D = true;
//    private static boolean DEBUG_I = true;
//    private static boolean DEBUG_W = true;
//    private static boolean DEBUG_E = true;
    private static String mTag = "ylyk_tag";

    public static void v(String msg) {
        if (DEBUG_V) {
            int max_str_length = 2001 - mTag.length();
            while (msg.length() > max_str_length) {
                Log.v(mTag, msg.substring(0, max_str_length));
                msg = msg.substring(max_str_length);
            }
            Log.v(mTag, msg);
        }
    }

    public static void d(String msg) {
        if (DEBUG_D) {
            int max_str_length = 2001 - mTag.length();
            while (msg.length() > max_str_length) {
                Log.d(mTag, msg.substring(0, max_str_length));
                msg = msg.substring(max_str_length);
            }
            Log.d(mTag, msg);
        }
    }

    public static void i(String msg) {
        if (DEBUG_I) {
            int max_str_length = 2001 - mTag.length();
            while (msg.length() > max_str_length) {
                Log.i(mTag, msg.substring(0, max_str_length));
                msg = msg.substring(max_str_length);
            }
            Log.i(mTag, msg);
        }
    }

    public static void w(String msg) {
        if (DEBUG_W) {
            int max_str_length = 2001 - mTag.length();
            while (msg.length() > max_str_length) {
                Log.w(mTag, msg.substring(0, max_str_length));
                msg = msg.substring(max_str_length);
            }
            Log.w(mTag, msg);
        }
    }


    public static void v(Object... msg) {
        if (DEBUG_V) {
            v(getStringBuilder(msg));
        }
    }


    public static void d(Object... msg) {
        if (DEBUG_D) {
            d(getStringBuilder(msg));
        }
    }

    public static void i(Object... msg) {
        if (DEBUG_I) {
            i(getStringBuilder(msg));
        }
    }

    public static void w(Object... msg) {
        if (DEBUG_W) {
            w(getStringBuilder(msg));
        }
    }

    public static void e(Object... msg) {
        if (DEBUG_E) {
            e(getStringBuilder(msg));
        }
    }
    private static void e(String msg) {
        //信息太长,分段打印
        if (DEBUG_E) {
            int max_str_length = 2001 - mTag.length();
            while (msg.length() > max_str_length) {
                Log.e(mTag, msg.substring(0, max_str_length));
                msg = msg.substring(max_str_length);
            }
            Log.e(mTag, msg);
        }
    }


    private static String getStringBuilder(Object[] msg) {
        List<Object> strings = Arrays.asList(msg);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < strings.size(); i++) {
            if (i > 0) {
                stringBuilder.append("========>");
            }

            stringBuilder.append(strings.get(i));
        }

        return stringBuilder.toString();
    }

}
