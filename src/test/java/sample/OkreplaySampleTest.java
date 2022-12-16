package sample;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okreplay.OkReplayConfig;
import okreplay.OkReplayInterceptor;
import okreplay.Recorder;
import okreplay.TapeMode;

public class OkreplaySampleTest {
    @Test
    public void testGet() {
        OkReplayConfig configuration = new OkReplayConfig.Builder().defaultMode(TapeMode.READ_WRITE)
                .interceptor(new OkReplayInterceptor()).build();

        OkHttpClient client =
                new OkHttpClient.Builder().addInterceptor(configuration.interceptor()).build();
        OkreplaySample sut = new OkreplaySample(client);

        Recorder rec = new Recorder(configuration);
        rec.start("test");

        Response res = sut.Get();
        assertNotNull(res);
        assertTrue(res.isSuccessful());
        assertEquals(res.code(), 200);

        rec.stop();
    }
}
