package com.itk16.bk.pc.apptoanlop1.model;

import com.itk16.bk.pc.apptoanlop1.R;


import java.util.ArrayList;

public class ListItemImage {
    private ArrayList<ItemImage> mArrImages;

    public ArrayList<ItemImage> getmArrImages() {
        return mArrImages;
    }

    public void setmArrImages(ArrayList<ItemImage> mArrAnh) {
        this.mArrImages = mArrAnh;
    }

    public ListItemImage() {
       data();
    }

    public void data()
    {
        mArrImages= new ArrayList<>();
        mArrImages.add(new ItemImage(R.drawable.quadau, "quả dâu" ));
        mArrImages.add(new ItemImage(R.drawable.quatao, "qua tao"));

    }

}
