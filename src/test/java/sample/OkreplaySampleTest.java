package sample;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

import okhttp3.Response;

public class OkreplaySampleTest {
    @Test
    public void testGet() {
        OkreplaySample sut = new OkreplaySample();

        Response res = sut.Get();

        assertNotNull(res);
        assertTrue(res.isSuccessful());
        assertEquals(res.code(), 200);
    }
}
