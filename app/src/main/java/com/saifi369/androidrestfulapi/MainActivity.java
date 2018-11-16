package com.saifi369.androidrestfulapi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.saifi369.androidrestfulapi.model.CityItem;
import com.saifi369.androidrestfulapi.network.MyIntentService;
import com.saifi369.androidrestfulapi.utils.NetworkHelper;
import com.saifi369.androidrestfulapi.utils.RequsetPackage;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MyTag";
    private TextView mLog;
    private boolean isNetworkOk;

    //10.0.2.2 is used to refer to local machine's localhost
    //using localhost or 127.0.0.1 refers to emulator's localhost
    public static final String JSON_URL="http://10.0.2.2/pakinfo/json/itemsfeed.php";
    public static final String WEB_URL="https://jsonplaceholder.typicode.com/posts/1";

    private BroadcastReceiver mReceiver=new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            if(intent.hasExtra(MyIntentService.SERVICE_PAYLOAD)){
                CityItem[] cityItems= (CityItem[])
                        intent.getParcelableArrayExtra(MyIntentService.SERVICE_PAYLOAD);

                for (CityItem item:cityItems){
                    logOutput(item.getCityname()+"\n");
                }
            }
            else if(intent.hasExtra(MyIntentService.SERVICE_EXPECTION)){
                String message=intent.getStringExtra(MyIntentService.SERVICE_EXPECTION);

                Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
                logOutput(message);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        isNetworkOk=NetworkHelper.isNetworkAvailable(this);

        mLog.setText("Network : "+isNetworkOk+"\n");

    }

    public void runCode(View view) {
        
        if(isNetworkOk){

            RequsetPackage requsetPackage=new RequsetPackage();
            requsetPackage.setEndPoint(JSON_URL);
            requsetPackage.setMethod("POST");
            requsetPackage.setParams("id","3");
            requsetPackage.setParams("province","Punjab");

            Intent intent=new Intent(MainActivity.this,MyIntentService.class);
            intent.putExtra(MyIntentService.SERVICE_REQUEST_PACKAGE,requsetPackage);
            startService(intent);
        }else
            Toast.makeText(this, "Network not available...", Toast.LENGTH_SHORT).show();
    }

    private void logOutput(String data){
        Log.d(TAG, "logOutput: "+data);
        mLog.append(data+"\n");
    }

    private void initViews() {
        mLog=findViewById(R.id.textView);
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
}
