package com.github.log;

import android.util.Log;

/***
 *   created by android on 2019/8/26
 */
public class LG {
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

    public static void setLength(int length){
        printLength=length;
    }
    public static void e(String tag,String msg){
        if(msg==null){
            new NullPointerException("msg can not null,java.lang.NullPointerException: println needs a message");
        }
        if(msg.length()<=printLength){
            Log.e(tag,TOP_BORDER);
            Log.e(tag,HORIZONTAL_LINE+msg);
            Log.e(tag,BOTTOM_BORDER);
        }else if(true){
            byte[] bytes = msg.getBytes();
            int byteLength = bytes.length;
            Log.e(tag,TOP_BORDER);
            for (int i = 0; i < byteLength; i+=printLength) {
                int count = Math.min(byteLength - i, printLength);
                Log.e(tag,HORIZONTAL_LINE+new String(bytes,i,count));
            }
            Log.e(tag,BOTTOM_BORDER);
        }
    }
}
