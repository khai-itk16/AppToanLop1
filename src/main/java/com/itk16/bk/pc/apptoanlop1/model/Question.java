package com.itk16.bk.pc.apptoanlop1.model;

import java.util.ArrayList;

public class Question {
    private String mQuestion;
    private ArrayList<Response> mResponses;


    public Question(String h, String da1, boolean d1, String da2, boolean d2, String da3, boolean d3, String da4, boolean d4) {
        this.mQuestion = h;
        mResponses= new ArrayList<>();
        mResponses.add(new Response(da1,d1));
        mResponses.add(new Response(da3,d3));
        mResponses.add(new Response(da2,d2));
        mResponses.add(new Response(da4,d4));

    }

    public String getQuestion() {
        return mQuestion;
    }

    public void setmQuestion(String h) {
        this.mQuestion = h;
    }

    public ArrayList<Response> getmResponses() {
        return mResponses;
    }

    public void setmResponses(ArrayList<Response> d) {
        this.mResponses = d;
    }
}
