
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class FifthEditionAPI {

    public static void callDnd5eAPI() {

        try {

            URL url = new URL("http://www.dnd5eapi.co/api/spells/1/?format=json");
            HttpURLConnection openConnection = (HttpURLConnection) url.openConnection();
            openConnection.setRequestMethod("GET");
            openConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");

            if (openConnection.getResponseCode() != 200) {
                throw new RuntimeException("HTTP : " + openConnection.getResponseCode());
            }

            BufferedReader httpResponse = new BufferedReader(new InputStreamReader(
                    (openConnection.getInputStream())));

            String httpResponseString;
            StringBuffer response = new StringBuffer();

            System.out.println("Output from Server .... \n");

            while ((httpResponseString = httpResponse.readLine()) != null) {
                response.append(httpResponseString);
            }
            httpResponse.close();

            System.out.println(response.toString());
            JSONObject myResponse = new JSONObject(response.toString());
            System.out.println("index: " + myResponse.getString("index"));
            System.out.println("name: " + myResponse.getString("name"));
            System.out.println("school: " + myResponse.getJSONObject("school").get("name"));
            openConnection.disconnect();

        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

}