package Spells;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Dictionary {
    public static void getAllSpells() {
        try {
            URL url = new URL("http://www.dnd5eapi.co/api/spells/");
            HttpURLConnection openConnection = (HttpURLConnection) url.openConnection();
            openConnection.setRequestMethod("GET");
            openConnection.setRequestProperty("User-Agent", "Mozilla/5.0");

            if (openConnection.getResponseCode() != 200){
                throw new RuntimeException("Response code: " + openConnection.getResponseCode());
            }

            BufferedReader responseReader = new BufferedReader(new InputStreamReader(openConnection.getInputStream()));
            String strResponse;
            StringBuffer response = new StringBuffer();

            while((strResponse = responseReader.readLine()) != null) {
                response.append(strResponse);
            }
            responseReader.close();
            openConnection.disconnect();

            System.out.println(response.toString());
            JSONObject json = new JSONObject(response.toString());

            System.out.println("count: " + json.getString("count"));
            System.out.println("Spell #4: " + json.getJSONArray("results").getJSONObject(3).getString("name"));

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
