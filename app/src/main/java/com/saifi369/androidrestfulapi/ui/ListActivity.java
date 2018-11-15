package com.saifi369.androidrestfulapi.ui;

import android.app.LoaderManager;
import android.content.AsyncTaskLoader;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.Loader;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.saifi369.androidrestfulapi.R;
import com.saifi369.androidrestfulapi.adapters.MyDataAdapter;
import com.saifi369.androidrestfulapi.model.CityItem;
import com.saifi369.androidrestfulapi.network.MyIntentService;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static com.saifi369.androidrestfulapi.MainActivity.JSON_URL;

public class ListActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Map<String,Bitmap>> {

    public static final String TAG = "mytag";
    private List<CityItem> mDataList;
    private RecyclerView mRecyclerView;
//    private CityDataSource mDataSource;
    private MyDataAdapter mDataAdapter;

    private BroadcastReceiver mReceiver=new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            if(intent.hasExtra(MyIntentService.SERVICE_PAYLOAD)){
                CityItem[] cityItems= (CityItem[])
                        intent.getParcelableArrayExtra(MyIntentService.SERVICE_PAYLOAD);

                mDataList=Arrays.asList(cityItems);
                Toast.makeText(context, mDataList.size()+" Items downloaded", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "onReceive: called");
            }
            else if(intent.hasExtra(MyIntentService.SERVICE_EXPECTION)){
                String message=intent.getStringExtra(MyIntentService.SERVICE_EXPECTION);

                Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

//        mDataList= SampleDataProvider.cityDataItemList;
        mRecyclerView=findViewById(R.id.list_city);

//        mDataSource=new CityDataSource(this);
//        mDataSource.open();

        LinearLayoutManager manager=new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(manager);

        Intent intent=new Intent(ListActivity.this,MyIntentService.class);
        intent.setData(Uri.parse(JSON_URL));
        startService(intent);

//        showRecyclerData(null);
//        mDataSource.seedDatabase();
        Log.d(TAG, "onCreate: ");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.app_bar_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.show_all:
            {
                showRecyclerData(null);
                break;
            }
            case R.id.show_balochistan:
            {
                showRecyclerData("Balochistan");
                break;
            }
            case R.id.show_kpk:
            {
                showRecyclerData("KPK");
                break;
            }
            case R.id.show_punjab:
            {
                showRecyclerData("Punjab");
                break;
            }
            case R.id.show_sindh:
            {
                showRecyclerData("Sindh");
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }


    private void showRecyclerData(String prov) {
//        mDataList=mDataSource.getAllItems(prov);
        mDataAdapter =new MyDataAdapter(mDataList,this);
        mRecyclerView.setAdapter(mDataAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();

        LocalBroadcastManager.getInstance(this)
                .registerReceiver(mReceiver,new IntentFilter(MyIntentService.SERVICE_MESSAGE));
    }

    @Override
    protected void onStop() {
        super.onStop();

        LocalBroadcastManager.getInstance(this)
                .unregisterReceiver(mReceiver);
    }

    @Override
    public Loader<Map<String, Bitmap>> onCreateLoader(int id, Bundle args) {

        return new MyImageTask(this,mDataList);
    }

    @Override
    public void onLoadFinished(Loader<Map<String, Bitmap>> loader, Map<String, Bitmap> data) {
        displayData(data);
    }

    @Override
    public void onLoaderReset(Loader<Map<String, Bitmap>> loader) {

    }

    private void displayData(Map<String, Bitmap> data) {
        mDataAdapter = new MyDataAdapter(this,mDataList,data);
    }
    private static class MyImageTask extends AsyncTaskLoader<Map<String, Bitmap>> {


        private static String IMAGE_BASE_URL="https://localhost/pakinfo/images/";
        private List<CityItem> mImageItems;
        private Map<String,Bitmap> mImages;
        public MyImageTask(Context context, List<CityItem> cityItems) {
            super(context);
            this.mImageItems=cityItems;
        }

        @Override
        public Map<String, Bitmap> loadInBackground() {

            for (CityItem item:mImageItems){

                IMAGE_BASE_URL+=item.getImage();
                InputStream inputStream = null;

                try {
                    URL url=new URL(IMAGE_BASE_URL);
                    inputStream= (InputStream) url.getContent();
                    Bitmap bitmap=BitmapFactory.decodeStream(inputStream);
                    mImages.put(item.getCityname(),bitmap);

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
            }
            return mImages;
        }
    }

}
