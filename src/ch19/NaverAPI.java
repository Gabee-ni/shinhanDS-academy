package ch19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

public class NaverAPI {
	
	public static void main(String[] args) throws IOException {
        String clientId = "_t8atCb8s3bQS0dSCcH1"; //애플리케이션 클라이언트 아이디
        String clientSecret = "8ANkCdODGK"; //애플리케이션 클라이언트 시크릿


        String text = null;
        try {
        	//검색어 인코딩 
            text = URLEncoder.encode("김가빈", "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("검색어 인코딩 실패",e);
        }

        //해당 주소에 쿼리로 검색어를 넣어서 요청 
        String apiURL = "https://openapi.naver.com/v1/search/blog?query=" + text;    // JSON 결과
        //String apiURL = "https://openapi.naver.com/v1/search/blog.xml?query="+ text; // XML 결과


        //Map 타입의 요청 헤더에 API 아이디와 비밀번호를 담음.
        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("X-Naver-Client-Id", clientId);
        requestHeaders.put("X-Naver-Client-Secret", clientSecret);

        //쿼리가 담긴 주소와 요청 헤더를 get 방식으로 보냈을 때의 응답 바디 내용을 담음. 
        String responseBody = get(apiURL,requestHeaders);
        //바디 내용 출력 
//        System.out.println(responseBody);
        
        
        //응답 결과 파싱 -> 블로그 제목, 링크 출력 
        JSONObject root = new JSONObject(responseBody);
        JSONArray items = root.getJSONArray("items");
//        System.out.println(items);
//        System.out.println(items.length());
        
        //향상된 for문 ver
        for(Object item : items) {
        	JSONObject i = (JSONObject) item;
        	System.out.println("title : "+i.getString("title"));
        	System.out.println("link : "+i.getString("link"));
        	System.out.println();
        }
        
//        for(int i=0; i<items.length();i++) {
//        	JSONObject item = items.getJSONObject(i);
//        	System.out.println("title : "+item.getString("title"));
//        	System.out.println("link : "+item.getString("link"));
////        	System.out.println("bloggername : "+item.getString("bloggername"));
////        	System.out.println("bloggerlink : "+item.getString("bloggerlink"));
////        	System.out.println("description : "+item.getString("description"));
////        	System.out.println("postdate : "+item.getString("postdate"));
//        	System.out.println();
//        }
        
        
    }


	//get 요청
    private static String get(String apiUrl, Map<String, String> requestHeaders){
        //해당 주소로 connect메서드 실행 후 httpURLConnection 객체 얻음. 
    	HttpURLConnection con = connect(apiUrl);
        try {
        	//요청헤더의 entry셋(key-value쌍)을 헤더의 키와 벨루로 나눠서 요청 속성에 담음.  
            con.setRequestMethod("GET");
            for(Map.Entry<String, String> header :requestHeaders.entrySet()) {
                con.setRequestProperty(header.getKey(), header.getValue());
            }

            //응답코드를 받았을 때 정상이면(200)
            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 호출
            	//바디의 내용 읽어 온 것을 반환
                return readBody(con.getInputStream());
            } else { // 오류 발생
                return readBody(con.getErrorStream());
            }
        } catch (IOException e) {
            throw new RuntimeException("API 요청과 응답 실패", e);
        } finally {
            con.disconnect();
        }
    }


    private static HttpURLConnection connect(String apiUrl){
        try {
        	//url 객체를 생서해서 
            URL url = new URL(apiUrl);
            //openConnection-> urlConnection으로 반환-> 강제형변환해서 httpURLconnection객체에 담음
            return (HttpURLConnection)url.openConnection();
        } catch (MalformedURLException e) {
            throw new RuntimeException("API URL이 잘못되었습니다. : " + apiUrl, e);
        } catch (IOException e) {
            throw new RuntimeException("연결이 실패했습니다. : " + apiUrl, e);
        }
    }


    private static String readBody(InputStream body){
    	//body를 읽어와서 
        InputStreamReader streamReader = new InputStreamReader(body);

        //보조스트림 리더를 활용. 성능 향상을 위해 스트링 빌더 활용 
        try (BufferedReader lineReader = new BufferedReader(streamReader)) {
            StringBuilder responseBody = new StringBuilder();

            //데이터가 있으면 응답 바디에 해당 데이터를 담음
            String line;
            while ((line = lineReader.readLine()) != null) {
                responseBody.append(line);
            }

            //바디 반환
            return responseBody.toString();
        } catch (IOException e) {
            throw new RuntimeException("API 응답을 읽는 데 실패했습니다.", e);
        }
    }
}
