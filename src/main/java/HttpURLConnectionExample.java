

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpURLConnectionExample {

    private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.143 Safari/537.36";

    public void post(String url, String body) throws Exception {
        String result = null;

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", USER_AGENT);
        con.setRequestProperty("Content-Type", "application/xml");

        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(body);
        wr.flush();
        wr.close();

        int responseCode = con.getResponseCode();
        System.out.println("'POST' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        System.out.println("Response Body : ");
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine+"\n");
        }
        in.close();

        result = response.toString();
        if (result.equals(body+"\n"))
            System.out.println("TRUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUU");
        System.out.println(result);

    }

    public void get(String url) throws Exception {
        String result = null;

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        con.setRequestMethod("GET");


        int responseCode = con.getResponseCode();
        System.out.println("'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        System.out.println("Response Body : ");
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine+"\n");
        }
        in.close();

        result = response.toString();
        System.out.println(result);
    }

    public static void main(String[] args) {
        try {
            HttpURLConnectionExample example = new HttpURLConnectionExample();
//            String getUrl = "http://httpbin.org/get";
//
//            System.out.println("HttpURLConnection Examples:");
//            System.out.println();
//            example.get("http://google.com");
//            System.out.println();
//
//            String postUrl = "http://httpbin.org/post";
            String message = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                    "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
                    "  <soap:Body>\n" +
                    "    <GetCursOnDate xmlns=\"http://web.cbr.ru/\">\n" +
                    "      <On_date>2017-01-30</On_date>\n" +
                    "    </GetCursOnDate>\n" +
                    "  </soap:Body>\n" +
                    "</soap:Envelope>";
            example.post("http://localhost:8888/currency", message);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}