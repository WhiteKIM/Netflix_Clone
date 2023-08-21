package helpme.Netflix.Controller.Api;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.RuntimeJsonMappingException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/**
 * @ TheMovieDB API 호출부
 * @ 각 장르에 맞춰서 아래의 URL을 호출해주세요.
 * @ TheMovieDB API를 호출하는 함수는 모두 이쪽에 구현해주세요.
 */
public class TheMovieDBApiCall {
    private static String apiKey = "";//TODO : 절대 깃허브 푸시에 API키를 포함하지 마세요~
    private static Map<String, String> requestMap = Map.of(
            "fetchNowPlaying" , "movie/now_playing",
            "fetchNetflixOriginals" , "/discover/tv?with_network=213",
            "fetchTrending" , "/trending/all/week",
            "fetchTopRated" , "/movie/top_rated",
            "fetchActionMovies" , "/discover/movie?with=genres=28",
            "fetchComedyMovies" , "/discover/movie?with=genres=35",
            "fetchHorrorMovies" , "/discover/movie?with=genres=27",
            "fetchRomanceMovies" , "/discover/movie?with=genres=10749",
            "fetchDocumentaries" , "/discover/movie?with=genres=99"
    );
     public JsonNode getMovieJson() {
         try {
             URL url = new URL("https://api.themoviedb.org/3/authentication");
             HttpURLConnection conn = (HttpURLConnection) url.openConnection();
             conn.setRequestMethod("GET");
             conn.setRequestProperty("accept", "application/json");
             conn.setRequestProperty("Authorization", "Bearer "+apiKey);
             conn.setDoOutput(true);

             // 서버로부터 데이터 읽어오기
             BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
             StringBuilder sb = new StringBuilder();
             String line = null;

             while((line = br.readLine()) != null) { // 읽을 수 있을 때 까지 반복
                 sb.append(line);
             }
             ObjectMapper objectMapper = new ObjectMapper();
             return objectMapper.readTree(sb.toString());
         } catch(Exception e) {
             e.printStackTrace();
             throw new RuntimeJsonMappingException("데이터가 없습니다");
         }
     }

    public JsonNode getGenreMovieJson(String key) {
        try {
            URL url = new URL("https://api.themoviedb.org/3"+requestMap.get(key));
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("accept", "application/json");
            conn.setRequestProperty("Authorization", "Bearer "+apiKey);
            conn.setDoOutput(true);

            // 서버로부터 데이터 읽어오기
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line = null;

            while((line = br.readLine()) != null) { // 읽을 수 있을 때 까지 반복
                sb.append(line);
            }
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readTree(sb.toString());
        } catch(Exception e) {
            e.printStackTrace();
            throw new RuntimeJsonMappingException("데이터가 없습니다");
        }
    }

    public JsonNode getSpecifyMovieJson(String movieId) {
        try {
            URL url = new URL("https://api.themoviedb.org/3/movie/"+movieId+"?append_to_response=videos");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("accept", "application/json");
            conn.setRequestProperty("Authorization", "Bearer "+apiKey);
            conn.setDoOutput(true);

            // 서버로부터 데이터 읽어오기
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line = null;

            while((line = br.readLine()) != null) { // 읽을 수 있을 때 까지 반복
                sb.append(line);
            }
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readTree(sb.toString());
        } catch(Exception e) {
            e.printStackTrace();
            throw new RuntimeJsonMappingException("데이터가 없습니다");
        }
    }
}
