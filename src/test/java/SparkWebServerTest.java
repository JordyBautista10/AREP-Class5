import org.escuelaing.SparkWebServer;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SparkWebServerTest {

    static SparkWebServer server ;

    @Test
    public void pageTestHtml(){
        assertEquals(SparkWebServer.page().substring(0,6), "<html>");
    }

    @Test
    public void palindromeTrueCase(){
        assertTrue(SparkWebServer.palindromo("arenera"));
    }

    @Test
    public void portGetCorrect(){
        assertEquals(SparkWebServer.getPort(), 4567);
    }
}
