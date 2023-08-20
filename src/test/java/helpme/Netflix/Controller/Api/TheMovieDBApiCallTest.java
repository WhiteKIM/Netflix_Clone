package helpme.Netflix.Controller.Api;

import com.fasterxml.jackson.databind.JsonNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TheMovieDBApiCallTest {
    @Test
    void getMovieJson() {
        TheMovieDBApiCall call = new TheMovieDBApiCall();

        JsonNode json = call.getMovieJson();

        System.out.println(json);
    }
}