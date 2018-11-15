package com.saifi369.androidrestfulapi.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.saifi369.androidrestfulapi.R;
import com.saifi369.androidrestfulapi.model.CityDataItem;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyListAdapter extends BaseAdapter {

    public static final String CITY_KEY = "city_key";
    private Context mContext;
    private List<CityDataItem> cityDataItems;
    private LayoutInflater mInflater;

    public MyListAdapter(Context context, List<CityDataItem> cityDataItems) {
        this.mContext=context;
        this.cityDataItems=cityDataItems;
        mInflater=LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return cityDataItems.size();
    }

    @Override
    public Object getItem(int position) {
        return cityDataItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView=mInflater.inflate(R.layout.list_item_layout,parent,false);
        }

        TextView textView=convertView.findViewById(R.id.textView);
        ImageView imageView=convertView.findViewById(R.id.imageView);
        Log.d("meratag", "getView: findViewById");

        CityDataItem cityDataItem=cityDataItems.get(position);

        textView.setText(cityDataItem.getCityName());

        InputStream inputStream=null;
        try{
            inputStream = mContext.getAssets().open(cityDataItem.getImage());
            Bitmap bitmap= BitmapFactory.decodeStream(inputStream);
            imageView.setImageBitmap(bitmap);
            Log.d("meratag", "getView: Image Downloaded: "+cityDataItem.getImage());
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (inputStream == null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


        return convertView;
    }
}
