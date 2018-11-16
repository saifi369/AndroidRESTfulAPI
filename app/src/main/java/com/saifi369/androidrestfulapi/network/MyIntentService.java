package com.saifi369.androidrestfulapi.network;

import android.app.IntentService;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;

import com.google.gson.Gson;
import com.saifi369.androidrestfulapi.model.CityItem;
import com.saifi369.androidrestfulapi.utils.HttpHelper;
import com.saifi369.androidrestfulapi.utils.RequsetPackage;


public class MyIntentService extends IntentService {

    public static final String SERVICE_PAYLOAD = "SERVICE_PAYLOAD";
    public static final String SERVICE_MESSAGE = "SERVICE_MESSAGE";
    public static final String SERVICE_EXPECTION = "SERVICE_EXPECTION";
    public static final String SERVICE_REQUEST_PACKAGE = "SERVICE_REQUEST_PACKAGE";

    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        RequsetPackage requsetPackage=
                (RequsetPackage) intent.getParcelableExtra(SERVICE_REQUEST_PACKAGE);


        String data;
        try {
            data = HttpHelper.downloadUrl(requsetPackage);
        } catch (Exception e) {
            e.printStackTrace();
            sendMessageToUI(e);
            return;
        }

        Gson gson=new Gson();
        CityItem[] cityItems=gson.fromJson(data,CityItem[].class);

        sendMessageToUI( cityItems);

    }

    private void sendMessageToUI(Exception e) {
        Intent intent=new Intent(SERVICE_MESSAGE);
        intent.putExtra(SERVICE_EXPECTION,e.getMessage());

        LocalBroadcastManager.getInstance(this)
                .sendBroadcast(intent);
    }

    private void sendMessageToUI(CityItem[] data) {
        Intent intent=new Intent(SERVICE_MESSAGE);
        intent.putExtra(SERVICE_PAYLOAD,data);

        LocalBroadcastManager.getInstance(this)
                .sendBroadcast(intent);
    }
}
