package sample;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkreplaySample {
    private OkHttpClient client;

    public OkreplaySample() {
        this.client = new OkHttpClient.Builder().build();
    }

    public OkreplaySample(OkHttpClient client) {
        this.client = client;
    }

    public Response Get() {
        Request request = new Request.Builder().url("https://httpbin.org/get").build();

        Response response = null;
        try {
            response = this.client.newCall(request).execute();
        } catch (IOException e) {
            // TODO: handle exception
        }

        return response;
    }
}
