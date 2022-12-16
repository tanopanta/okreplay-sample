package sample;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkreplaySample {
    public static void main(String[] args) {
        OkHttpClient client = new OkHttpClient.Builder()
            .build();
        Request request = new Request.Builder()
            .url("https://httpbin.org/get")
            .build();
        
        try {
            Response response =  client.newCall(request).execute();
            System.out.println(response.body().string());
        } catch (IOException e) {
            // TODO: handle exception
        }
    }
}