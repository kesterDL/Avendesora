import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class FifthEditionAPI {

    // http://localhost:8080/RESTfulExample/json/product/get
    public static void callDnd5eAPI() {

        try {

            URL url = new URL("http://www.dnd5eapi.co/api/skills/");
            HttpURLConnection openConnection = (HttpURLConnection) url.openConnection();
            openConnection.setRequestMethod("GET");
            openConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");

            if (openConnection.getResponseCode() != 200) {
                throw new RuntimeException("HTTP : " + openConnection.getResponseCode());
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    (openConnection.getInputStream())));

            String output;
            System.out.println("Output from Server .... \n");
            while ((output = reader.readLine()) != null) {
                System.out.println(output);
            }

            openConnection.disconnect();

        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }

    }

}