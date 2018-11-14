package com.saifi369.androidrestfulapi;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.saifi369.androidrestfulapi.network.MyIntentService;
import com.saifi369.androidrestfulapi.utils.NetworkHelper;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MyTag";
    private TextView mLog;
    private boolean isNetworkOk;

    public static final String JSON_URL="https://localhost/pakinfo/json/itemsfeed.php";

    private BroadcastReceiver mReceiver=new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String data=intent.getStringExtra(MyIntentService.SERVICE_PAYLOAD);
            logOutput(data);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        isNetworkOk=NetworkHelper.isNetworkAvailable(this);

        logOutput("Network : "+isNetworkOk);

    }

    public void runCode(View view) {

        Intent intent=new Intent(MainActivity.this,MyIntentService.class);
        startService(intent);

    }

    private void logOutput(String data){
        Log.d(TAG, "logOutput: "+data);
        mLog.setText(data+"\n");
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
