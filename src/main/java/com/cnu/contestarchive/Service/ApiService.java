package com.cnu.contestarchive.Service;

import com.cnu.contestarchive.Domain.MajorBaseUrl;
import com.cnu.contestarchive.Domain.ValueIn;
import com.cnu.contestarchive.Domain.ValueOut;
import com.cnu.contestarchive.Domain.BoardInfo;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ApiService {
    @Value("${key.API_KEY}")
    private String apiKey;

    public String baseUrlReturn(String major) {
        MajorBaseUrl majorBaseUrl = new MajorBaseUrl();
        Map<String, Object> baseUrlMap = majorBaseUrl.getMajorBaseUrl();
        String baseUrl = (String)baseUrlMap.get(major);
        return baseUrl;
    }

    /*
    boardNO 반환하는 서비스
     */
    public int[] boardNoReturn(String major) {
        BoardInfo boardInfo = new BoardInfo();
        Map<String, Object> boardMap = boardInfo.getBoard_info();
        int[] boardNoArray = (int[]) boardMap.get(major);
        return boardNoArray;
    }

    /*
     result json 반환할 서비스
     */

    public ValueOut apiReturn(String major, int[] boardNo, String baseUrl) throws IOException {
        ValueIn[] intern = new ValueIn[10];
        ValueIn[] contest = new ValueIn[10];
        ValueIn[] seminar = new ValueIn[10];


        for (int index = 0; index < boardNo.length; index++) {

            String cms_board = "https://api.cnu.ac.kr/svc/offcam/pub/homepageboardContents?AUTH_KEY=";
            String board_no = Integer.toString(boardNo[index]);
            URL url = new URL(cms_board + apiKey + "&P_board_no=" + board_no);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            // GET 방식인지, POST 방식인지
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setRequestProperty("Accept", "application/json");

            BufferedReader rd;
            StringBuffer result = new StringBuffer();
            if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
                rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            } else {
                rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
            }
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line + "\n");
            }
            rd.close();
            conn.disconnect();

            // 전체 데이터를 json 으로 parsing
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = null;
            try {
                jsonObject = (JSONObject) parser.parse(result.toString());
            } catch (ParseException e) {
                System.out.println(e.getMessage());
            }

            // RESULT 데이터만 뽑아내기 위함
            JSONArray resultJson = null;
            try {
                resultJson = (JSONArray) parser.parse(jsonObject.get("RESULT").toString());
            } catch (ParseException e) {
                System.out.println(e.getMessage());
            }

            int result_i = 0;
            int i = 0;
            int j = 0;
            int k = 0;
            while (!(i == 10 && j == 10 && k == 10)) {
                JSONObject oneResult = null;
                try {
                    oneResult = (JSONObject) parser.parse(resultJson.get(result_i).toString());
                } catch (ParseException e) {
                    System.out.println(e.getMessage());
                }
                String title = oneResult.get("article_title").toString();
                String content = oneResult.get("article_text").toString();
                /*
                이미지 추출 과정
                 */
                StringBuilder img = new StringBuilder();
                String imgPattern = "<img src=\\\"(.*?)\\\">";
                Pattern pattern = Pattern.compile(imgPattern);
                Matcher matcher = pattern.matcher(content);
                while (matcher.find()) {
                    img.append(matcher.group());
                }
                if (containsKeyword(title) == 1 || containsKeyword(content) == 1) {
                    if (i != 10) {
                        ValueIn internValueIn = new ValueIn(title, content, img.toString(), baseUrl);
                        intern[i++] = internValueIn;
                    }
                } else if (containsKeyword(title) == 2 || containsKeyword(content) == 2) {
                    if (j != 10) {
                        ValueIn contestValueIn = new ValueIn(title, content, img.toString(), baseUrl);
                        contest[j++] = contestValueIn;
                    }
                } else if (containsKeyword(title) == 3 || containsKeyword(content) == 3) {
                    if (k != 10) {
                        ValueIn seminarValueIn = new ValueIn(title, content, img.toString(), baseUrl);
                        seminar[k++] = seminarValueIn;
                    }
                }
                result_i++;
                if (result_i == 50)
                    break;
            }
        }

        return new ValueOut(intern, contest, seminar);


    }

    public int containsKeyword(String content) {
        String intern = "인턴십|아르바이트|설명회|공채|접수|모집|공고|지원자격|지원방법|채용공고|채용|연봉|근무|신입사원|해외 인턴십";
        String contest = "공모전|대회|아이디어";
        String seminar = "세미나|강연|특강";
        if (Pattern.compile(intern).matcher(content).find()) {
            return 1;
        } else if (Pattern.compile(contest).matcher(content).find()) {
            return 2;
        } else if (Pattern.compile(seminar).matcher(content).find()) {
            return 3;
        }
        return -1;
    }
}

