package com.github.log;

/***
 *   created by android on 2019/8/26
 */
public class LGBuilder {
    private int printLength = 3000;
    private String TAG = "TAG";
    private int methodCount = 2;
    private boolean showThreadInfo = true;

    public int getPrintLength() {
        return printLength;
    }

    public LGBuilder setPrintLength(int printLength) {
        this.printLength = printLength;
        return this;
    }

    public String getTAG() {
        return TAG;
    }

    public LGBuilder setTAG(String TAG) {
        this.TAG = TAG;
        return this;
    }


    public int getMethodCount() {
        return methodCount;
    }

    public LGBuilder setMethodCount(int methodCount) {
        this.methodCount = methodCount;
        return this;
    }

    public boolean isShowThreadInfo() {
        return showThreadInfo;
    }

    public LGBuilder setShowThreadInfo(boolean showThreadInfo) {
        this.showThreadInfo = showThreadInfo;
        return this;
    }
}
