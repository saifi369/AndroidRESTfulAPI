package com.saifi369.androidrestfulapi.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.saifi369.androidrestfulapi.model.CityItem;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CacheImageManager {

    public static Bitmap getImage(Context context, CityItem cityItem){

        String fileName=context.getCacheDir()+"/"+cityItem.getImage();

        File file=new File(fileName);

        Bitmap bitmap=null;

        try {
            bitmap=BitmapFactory.decodeStream(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return bitmap;
    }

    public static void putImage(Context context,CityItem cityItem,Bitmap bitmap){

        String fileName=context.getCacheDir()+"/"+cityItem.getImage();

        File file=new File(fileName);

        FileOutputStream outputStream=null;

        try {
            outputStream=new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG,50,outputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }






    }


}
