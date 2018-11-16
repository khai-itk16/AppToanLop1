package com.itk16.bk.pc.apptoanlop1.model;

import java.util.ArrayList;

public class ListQuestions {
    private ArrayList<Question> mListQuestions;

    public ArrayList<Question> getmListQuestions() {
        return mListQuestions;
    }

    public void setmListQuestions(ArrayList<Question> Lq) {
        this.mListQuestions = Lq;
    }

    public ListQuestions(int chuong) {
        switch (chuong)
        {
            case 1:
                chuong1();
                break;
            case 2:
                chuong2();
                break;
            case 3:
                chuong3();
                break;
            case 4:
                chuong4();
                break;
            case 5:
                chuong5();
                break;

        }
    }
    public void chuong1()
    {
        this.mListQuestions= new ArrayList<>();
        mListQuestions.add(new Question("2 + 2 = ? ","4",true,"4",
                false,"3",false,"2",false));
        mListQuestions.add(new Question("2 + 4 = ?","7",false,"7",
                false,"5",false,"6",true));
        mListQuestions.add(new Question("9 - 3 = ?","7",false,"9",
                false,"6",true,"10",false));
        mListQuestions.add(new Question("2 + 5 = ?","8",false,"5",
                false,"7",true,"6",false));
        mListQuestions.add(new Question("4 + 5 = ?","8",false,"9",
                true,"10",false,"8",false));
        mListQuestions.add(new Question("10 - 5 = ?","5",true,"8",
                false,"9",false,"7",false));
        mListQuestions.add(new Question("1 + 5 = ?","5",false,"4",
                false,"3",false,"6",true));
        mListQuestions.add(new Question("7 - 2 = ?","8",false,"7",
                false,"5",true,"6",false));
        mListQuestions.add(new Question("3 + 4 = ?","8",false,"7",
                true,"6",false,"5",false));
        mListQuestions.add(new Question("2 + 3 = ?","6",false,"4",
                false,"3",false,"5",true));
        mListQuestions.add(new Question("10 - 6 = ?","5",false,"8",
                false,"4",true,"7",false));
        mListQuestions.add(new Question("8 - 1 = ?","7",true,"9",
                false,"8",false,"10",false));
        mListQuestions.add(new Question("4 + 1 = ?","5",true,"3",
                false,"2",false,"4",false));
        mListQuestions.add(new Question("2 + 8 = ?","6",false,"8",
                false,"7",false,"10",true));
        mListQuestions.add(new Question("6 - 2 = ?","5",false,"6",
                false,"4",true,"7",false));
    }
    public void chuong2()
    {
        mListQuestions= new ArrayList<>();
        mListQuestions.add(new Question("12 + 2 = ? ","14",true,"8",
                false,"13",false,"10",false));
        mListQuestions.add(new Question("12 - 5 = ?","12",false,"15",
                false,"17",false,"7",true));
        mListQuestions.add(new Question("3 + 15 = ?","17",false,"19",
                false,"18",true,"20",false));
        mListQuestions.add(new Question("2 + 14 = ?","10",false,"15",
                false,"16",true,"19",false));
        mListQuestions.add(new Question("14 - 6 = ?","14",false,"8",
                true,"20",false,"10",false));
        mListQuestions.add(new Question("15 + 5 = ?","20",true,"18",
                false,"19",false,"17",false));
        mListQuestions.add(new Question("11 + 5 = ?","15",false,"14",
                false,"13",false,"16",true));
        mListQuestions.add(new Question("2 + 17 = ?","18",false,"17",
                false,"19",true,"16",false));
        mListQuestions.add(new Question("13 - 4 = ?","17",false,"9",
                true,"16",false,"10",false));
        mListQuestions.add(new Question("12 + 3 = ?","16",false,"14",
                false,"13",false,"15",true));
        mListQuestions.add(new Question("4 + 9 = ?","14",false,"8",
                false,"13",true,"7",false));
        mListQuestions.add(new Question("17 - 3 = ?","14",true,"9",
                false,"18",false,"17",false));
        mListQuestions.add(new Question("4 + 11 = ?","15",true,"13",
                false,"12",false,"14",false));
        mListQuestions.add(new Question("13 - 11 = ?","3",false,"5",
                false,"12",false,"2",true));
        mListQuestions.add(new Question("19 - 12 = ?","16",false,"6",
                false,"7",true,"17",false));
    }
    public void chuong3()
    {
        mListQuestions= new ArrayList<>();
        mListQuestions.add(new Question("10 + 15 = ? ","25",true,"26",
                false,"20",false,"35",false));
        mListQuestions.add(new Question("47 - 27 = ?","21",false,"18",
                false,"19",false,"20",true));
        mListQuestions.add(new Question("37 - 9 = ?","26",false,"30",
                false,"28",true,"29",false));
        mListQuestions.add(new Question("3 + 10 = ?","14",false,"11",
                false,"13",true,"15",false));
        mListQuestions.add(new Question("28 - 13 = ?","16",false,"15",
                true,"13",false,"14",false));
        mListQuestions.add(new Question("19 + 6 = ?","25",true,"26",
                false,"24",false,"27",false));
        mListQuestions.add(new Question("48 - 44 = ?","6",false,"5",
                false,"3",false,"4",true));
        mListQuestions.add(new Question("5 + 12 = ?","15",false,"18",
                false,"17",true,"14",false));
        mListQuestions.add(new Question("11 - 1 = ?","12",false,"10",
                true,"9",false,"8",false));
        mListQuestions.add(new Question("32 - 8 = ?","25",false,"26",
                false,"27",false,"24",true));
        mListQuestions.add(new Question("13 + 24 = ?","35",false,"38",
                false,"34",true,"37",false));
        mListQuestions.add(new Question("35 - 14 = ?","21",true,"20",
                true,"23",false,"19",false));
        mListQuestions.add(new Question("38 - 6 = ?","32",true,"33",
                false,"34",false,"31",false));
        mListQuestions.add(new Question("24 + 9 = ?","35",false,"34",
                false,"32",false,"33",true));
        mListQuestions.add(new Question("16 + 2 = ?","19",false,"17",
                false,"18",true,"16",false));
    }

    public void chuong4()
    {
        mListQuestions= new ArrayList<>();

    }
    public void chuong5()
    {
        mListQuestions= new ArrayList<>();

    }

}
