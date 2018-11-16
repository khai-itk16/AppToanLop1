package com.itk16.bk.pc.apptoanlop1.Databases;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class DatabaseManager extends AppCompatActivity {
    String DATABASE_NAME = "dbCauHoi.sqlite";
    String DATABASE_PATH_SUFFIX = "/databases/";
    SQLiteDatabase database = null;
    String TAG  = "tag";

    public DatabaseManager(){
        processCopy();
    }

    private void processCopy() {
        try {
            File dbFile = getDatabasePath(DATABASE_NAME);
            if(!dbFile.exists()){
                copyDatabaseFromAsset();
            }
            Log.d(TAG,"thanh cong");
        } catch (Exception ex){
            Log.e("loi","That bai " + ex.toString());
        }

    }

    private  String getDatabasePath(){
        return  getApplicationInfo().dataDir+DATABASE_PATH_SUFFIX+DATABASE_NAME;
    }

    private void copyDatabaseFromAsset() {
        try{
            InputStream myInput = getAssets().open(DATABASE_NAME);
            String outFileName = getDatabasePath();
            File f = new File(getApplicationInfo().dataDir+DATABASE_PATH_SUFFIX);
            if(!f.exists()){
                f.mkdir();
            }
            OutputStream myOutput  = new FileOutputStream(outFileName);
            byte []buffer  = new byte[1024];
            int length;
            while ((length = myInput.read(buffer)) > 0){
                myOutput.write(buffer,0,length);
            }
            myOutput.flush();
            myOutput.close();
            myInput.close();
        }
        catch (Exception ex){
            Log.e("Loi", ex.toString());
        }
    }
}
