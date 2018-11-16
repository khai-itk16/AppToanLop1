package com.itk16.bk.pc.apptoanlop1.model;

public class Response {
    private String mResponse;
    private boolean mIsTrue;

    public Response(String r, boolean it) {
        this.mResponse = r;
        this.mIsTrue = it;
    }

    public String getmResponse() {
        return mResponse;
    }

    public void setmResponse(String r) {
        this.mResponse = r;
    }

    public boolean isT() {
        return mIsTrue;
    }

    public void setT(boolean t) {
        this.mIsTrue = t;
    }
}
