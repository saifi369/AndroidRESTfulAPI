package com.saifi369.androidrestfulapi.utils;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpHelper {

    public static String downloadUrl(RequsetPackage requsetPackage) throws Exception {

        InputStream inputStream=null;

        String address=requsetPackage.getEndPoint();
        String encodedParams=requsetPackage.getEncodedParams();

        if(requsetPackage.getMethod().equals("GET") &&
                encodedParams.length()>0){
            address= String.format("%s?%s",address,encodedParams);
        }


        try {
            URL url = new URL(address);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setReadTimeout(15000);
            connection.setConnectTimeout(10000);
            connection.setDoInput(true);
            connection.setRequestMethod(requsetPackage.getMethod());

            connection.connect();

            int responseCode = connection.getResponseCode();
            if (responseCode != 200) {
                throw new Exception("Error: Got response code: " + responseCode);
            }

            inputStream = connection.getInputStream();

            return readStream(inputStream);
        }
        finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

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
