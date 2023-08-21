package helpme.Netflix;

import com.fasterxml.jackson.databind.JsonNode;
import helpme.Netflix.Controller.Api.TheMovieDBApiCall;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * 테스트코드입니다.
 */
@Component
public class InitProc {
    private static String[] keys = {
            "fetchNowPlaying",
            "fetchNetflixOriginals",
            "fetchTrending",
            "fetchTopRated",
            "fetchActionMovies",
            "fetchComedyMovies",
            "fetchHorrorMovies",
            "fetchRomanceMovies",
            "fetchDocumentaries"
    };
    @PostConstruct
    private void init() {
        // API를 호출해서 모든 데이터를 받아온다.
        ArrayList<JsonNode> jsonNodes = new ArrayList<>();
        TheMovieDBApiCall movieDBApiCall = new TheMovieDBApiCall();
        for(String key : keys) {
            jsonNodes.add(movieDBApiCall.getGenreMovieJson(key));
        }
        System.out.println("장르별 영화 정보를 받아온다");
        for(JsonNode node : jsonNodes) {
            System.out.println(node.toString());
        }
        System.out.println("=======================================");
        System.out.println("특정 영화 정보 가져오기");
        JsonNode specifyNode = movieDBApiCall.getSpecifyMovieJson("976573");
        System.out.println(specifyNode.toString());
    }
}
