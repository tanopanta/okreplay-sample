package sample;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkreplaySample {
    public Response Get() {
        OkHttpClient client = new OkHttpClient.Builder().build();
        Request request = new Request.Builder().url("https://httpbin.org/get").build();

        Response response = null;
        try {
            response = client.newCall(request).execute();
        } catch (IOException e) {
            // TODO: handle exception
        }

        return response;
    }
}
