package com.saifi369.androidrestfulapi.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.saifi369.androidrestfulapi.R;
import com.saifi369.androidrestfulapi.model.CityItem;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class MyDataAdapter extends RecyclerView.Adapter<MyDataAdapter.MyViewHolder> {

    public static final String TAG = "MyTag";
    private List<CityItem> mDataList;
    private Context context;
    private Map<String,Bitmap> mBitmaps =new HashMap<>();
    Random random=new Random();


    public MyDataAdapter(Context context, List<CityItem> mDataList) {
        this.context=context;
        this.mDataList=mDataList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(context).inflate(R.layout.list_item_layout,parent,false);

        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        CityItem cityDataItem=mDataList.get(position);
        Log.d(TAG, "onBindViewHolder: Name: "+cityDataItem.getCityname()+" : "+cityDataItem.getImage());

        holder.textView.setText(cityDataItem.getCityname());

        if(mBitmaps.containsKey(cityDataItem.getCityname())){
            holder.imageView.setImageBitmap(mBitmaps.get(cityDataItem.getCityname()));
        }else {
            MyImageTask task=new MyImageTask();
            task.setViewHolder(holder);
            task.execute(cityDataItem);
        }


//        InputStream inputStream=null;
//        try{
//            inputStream = context.getAssets().open(cityDataItem.getImage());
//            Bitmap bitmap= BitmapFactory.decodeStream(inputStream);
//            holder.imageView.setImageBitmap(bitmap);
//            Log.d(TAG, "getView: Image Downloaded: "+cityDataItem.getImage());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        finally {
//            if (inputStream != null) {
//                try {
//                    inputStream.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    public  static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView textView;
        ImageView imageView;

        public MyViewHolder(View itemView) {
            super(itemView);

            textView=itemView.findViewById(R.id.textView);
            imageView=itemView.findViewById(R.id.imageView);
        }
    }

    class MyImageTask extends AsyncTask<CityItem,Void,Bitmap>{

        private static final String PHOTO_BASE_URL=
                "http://10.0.2.2/pakinfo/images/";
        private CityItem mCityItem;
        private MyViewHolder mViewHolder;

        public void setViewHolder(MyViewHolder myViewHolder){
            this.mViewHolder=myViewHolder;
        }

        @Override
        protected Bitmap doInBackground(CityItem... cityItems) {
            Bitmap bitmap = null;
            mCityItem=cityItems[0];

            String imageurl=PHOTO_BASE_URL+mCityItem.getImage();

            InputStream inputStream=null;

            try {
                URL imageUrl=new URL(imageurl);
                inputStream = (InputStream) imageUrl.getContent();
                bitmap=BitmapFactory.decodeStream(inputStream);

            } catch (Exception e) {
                e.printStackTrace();
            }
            finally {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            int sleepTime=random.nextInt(400);
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Log.d(TAG, "doInBackground: Image downloaded: "+imageurl);

            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            mViewHolder.imageView.setImageBitmap(bitmap);
            mBitmaps.put(mCityItem.getCityname(),bitmap);
        }
    }
}
