package com.saifi369.androidrestfulapi.utils;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HttpHelper {

    public static String downloadUrl(RequsetPackage requsetPackage) throws Exception {

        InputStream inputStream=null;

        String address=requsetPackage.getEndPoint();
        String encodedParams=requsetPackage.getEncodedParams();

        //checking for parameters to send in GET request
        //GET request paremeters are sent in url
        if(requsetPackage.getMethod().equals("GET") &&
                encodedParams.length()>0){
            address= String.format("%s?%s",address,encodedParams);
        }

        //GET request with okhttp

        OkHttpClient client=new OkHttpClient();

        Request.Builder builder=new Request.Builder()
                .url(address);

        Request request=builder.build();

        Response response=client.newCall(request).execute();

        if(response.isSuccessful()){
            return response.body().string();
        }
        else{
            throw new Exception("Error: Got response code: "+response.code());
        }

        //used for making connections with httpurl connections
//        try {
//            URL url = new URL(address);
//            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//
//            connection.setReadTimeout(15000);
//            connection.setConnectTimeout(10000);
//            connection.setDoInput(true);
//            connection.setRequestMethod(requsetPackage.getMethod());
//
//            //checking for parameters to send in POST request
//            //POST request paremeters are sent in request body
//            if(requsetPackage.getMethod().equals("POST") &&
//                    encodedParams.length()>0){
//                OutputStreamWriter writer=new OutputStreamWriter(connection.getOutputStream());
//                writer.write(requsetPackage.getEncodedParams());
//                writer.flush();
//                writer.close();
//            }
//
//
//            connection.connect();
//
//            int responseCode = connection.getResponseCode();
//            if (responseCode != 200) {
//                throw new Exception("Error: Got response code: " + responseCode);
//            }
//
//            inputStream = connection.getInputStream();
//
//            return readStream(inputStream);
//        }
//        finally {
//            if (inputStream != null) {
//                inputStream.close();
//            }
//        }
    }
    //only used for connections with httpurl connection
    //not nedded for okhttp
    private static String readStream(InputStream stream) throws IOException {

        byte[] buffer = new byte[1024];
        ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
        BufferedOutputStream out = null;
        try {
            int length = 0;
            out = new BufferedOutputStream(byteArray);
            while ((length = stream.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }
            out.flush();
            return byteArray.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (out != null) {
                out.close();
            }
        }

    }

}
