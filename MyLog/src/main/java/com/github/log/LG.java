package com.github.log;

import android.util.Log;

/***
 *   created by android on 2019/8/26
 */
public class LG {
    private static String TAG="TAG";
    private static int printLength=3000;
    private static final char TOP_LEFT_CORNER = '┌';
    private static final char BOTTOM_LEFT_CORNER = '└';
    private static final char MIDDLE_CORNER = '├';
    private static final char HORIZONTAL_LINE = '│';
    private static final String DOUBLE_DIVIDER = "────────────────────────────────────────────────────────";
    private static final String SINGLE_DIVIDER = "┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄";
    private static final String TOP_BORDER = TOP_LEFT_CORNER + DOUBLE_DIVIDER + DOUBLE_DIVIDER;
    private static final String BOTTOM_BORDER = BOTTOM_LEFT_CORNER + DOUBLE_DIVIDER + DOUBLE_DIVIDER;
    private static final String MIDDLE_BORDER = MIDDLE_CORNER + SINGLE_DIVIDER + SINGLE_DIVIDER;

    public static void setTAG(String tag){
        TAG=tag;
    }
    public static void setLength(int length){
        printLength=length;
    }
    public static void i(){
    }
    /************************** w **************************/
    public static void w(String msg){
        w(TAG,msg);
    }
    public static void w(String tag,String msg){
        print(tag, msg, new LogInter() {
            @Override
            public void log(String tag, String msg) {
                logW(tag,msg);
            }
        });
    }
    /************************** wtf **************************/
    public static void wtf(String msg){
        wtf(TAG,msg);
    }
    public static void wtf(String tag,String msg){
        print(tag, msg, new LogInter() {
            @Override
            public void log(String tag, String msg) {
                logWTF(tag,msg);
            }
        });
    }
    /************************** v **************************/
    public static void v(String msg){
        v(TAG,msg);
    }
    public static void v(String tag,String msg){
        print(tag, msg, new LogInter() {
            @Override
            public void log(String tag, String msg) {
                logV(tag,msg);
            }
        });
    }
    /************************** d **************************/
    public static void d(String msg){
        d(TAG,msg);
    }
    public static void d(String tag,String msg){
        print(tag, msg, new LogInter() {
            @Override
            public void log(String tag, String msg) {
                logD(tag,msg);
            }
        });
    }
    /************************** i **************************/
    public static void i(String msg){
        i(TAG,msg);
    }
    public static void i(String tag,String msg){
        print(tag, msg, new LogInter() {
            @Override
            public void log(String tag, String msg) {
                logI(tag,msg);
            }
        });
    }
    /************************** e **************************/
    public static void e(String msg){
        e(TAG,msg);
    }
    public static void e(String tag,String msg){
        print(tag, msg, new LogInter() {
            @Override
            public void log(String tag, String msg) {
                logE(tag,msg);
            }
        });
    }


    private static void print(String tag,String msg,LogInter logInter){
        if(msg==null){
            new NullPointerException("msg can not null,java.lang.NullPointerException: println needs a message");
        }
        if(logInter==null){
            return;
        }
        if(msg.length()<=printLength){
            logInter.log(tag,TOP_BORDER);
            logInter.log(tag,HORIZONTAL_LINE+msg);
            logInter.log(tag,BOTTOM_BORDER);
            /*logE(tag,TOP_BORDER);
            logE(tag,HORIZONTAL_LINE+msg);
            logE(tag,BOTTOM_BORDER);*/
        }else if(true){
            byte[] bytes = msg.getBytes();
            int byteLength = bytes.length;
//            logE(tag,TOP_BORDER);
            logInter.log(tag,TOP_BORDER);
            for (int i = 0; i < byteLength; i+=printLength) {
                int count = Math.min(byteLength - i, printLength);
//                logE(tag,HORIZONTAL_LINE+new String(bytes,i,count));
                logInter.log(tag,HORIZONTAL_LINE+new String(bytes,i,count));
            }
//            logE(tag,BOTTOM_BORDER);
            logInter.log(tag,BOTTOM_BORDER);
        }
    }
    private static void logE(String tag,String msg){
        Log.e(tag,msg);
    }
    private static void logI(String tag,String msg){
        Log.i(tag,msg);
    }
    private static void logD(String tag,String msg){
        Log.d(tag,msg);
    }
    private static void logV(String tag,String msg){
        Log.v(tag,msg);
    }
    private static void logWTF(String tag,String msg){
        Log.wtf(tag,msg);
    }
    private static void logW(String tag,String msg){
        Log.w(tag,msg);
    }
}
