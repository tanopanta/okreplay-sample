package sample;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okreplay.ComposedMatchRule;
import okreplay.MatchRules;
import okreplay.OkReplayConfig;
import okreplay.OkReplayInterceptor;
import okreplay.Recorder;
import okreplay.TapeMode;

public class OkreplaySampleTest {
    private Recorder rec;
    private OkHttpClient testClient;

    @BeforeEach
    public void setupRecoder(TestInfo testInfo) {
        OkReplayInterceptor okreplayInterceptor = new OkReplayInterceptor();
        OkReplayConfig configuration = new OkReplayConfig.Builder().defaultMode(TapeMode.READ_WRITE)
                .defaultMatchRule(
                        ComposedMatchRule.of(MatchRules.method, MatchRules.uri, MatchRules.body))
                .interceptor(okreplayInterceptor).build();

        this.testClient = new OkHttpClient.Builder().addInterceptor(okreplayInterceptor).build();

        this.rec = new Recorder(configuration);
        this.rec.start(testInfo.getDisplayName());
    }

    @AfterEach
    public void tearDownRecoder(TestInfo testInfo) {
        this.rec.stop();
    }

    @Test
    public void testGet() {
        OkreplaySample sut = new OkreplaySample(this.testClient);

        Response res = sut.Get();
        assertNotNull(res);
        assertTrue(res.isSuccessful());
        assertEquals(200, res.code());
    }
}
