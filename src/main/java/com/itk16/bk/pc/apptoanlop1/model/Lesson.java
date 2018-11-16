package com.itk16.bk.pc.apptoanlop1.model;

public class Lesson {
    private String mNameLesson;
    private boolean mLock;
    private int mContent;
    private int mNumberStar ;
    public Lesson(String NameLesson, boolean Lock, int Content, int NumberStar) {
        this.mNameLesson = NameLesson;
        this.mLock = Lock;
        this.mContent = Content;
        this.mNumberStar = NumberStar;
    }

    public String getmNameLesson() {
        return mNameLesson;
    }
    public void setmNameLesson(String mTenbaihoc) {
        this.mNameLesson = mTenbaihoc;
    }
    public boolean getmLock() {

        return mLock;
    }

    public void setmLock(boolean mLock) {
        this.mLock = mLock;
    }

    public int getmContent() {

        return mContent;
    }

    public void setmContent(int Content) {

        this.mContent = Content;
    }

    public int getmNumberStar() {

        return mNumberStar;
    }

    public void setmNumberStar(int NumberStar) {

        this.mNumberStar = NumberStar;
    }


}
