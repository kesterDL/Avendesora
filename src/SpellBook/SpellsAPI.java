package SpellBook;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class SpellsAPI {

    public static JSONObject callURL(String urlString) {
        try {
            URL url = new URL(urlString);
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

            return new JSONObject(response.toString());

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return new JSONObject();
    }

    public static JSONObject getAllSpells() {
        JSONObject json = new JSONObject();
        try {
            json = callURL("http://www.dnd5eapi.co/api/spells/");
            System.out.println(json.toString());

            System.out.println("count: " + json.getString("count"));
            System.out.println("Spell #4: " + json.getJSONArray("results").getJSONObject(3).getString("name"));
            return json;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return json;
    }

    public static JSONObject getSpecificSpell(final String spellName) throws JSONException{
        JSONArray spellArray = getAllSpells().getJSONArray("results");
        Integer numOfSpells = getAllSpells().getInt("count");
        Boolean spellFound = false;
        int iteration = 0;

        while(!spellFound && iteration <= numOfSpells) {
            if(spellArray.getJSONObject(iteration).getString("name").contains(spellName)) {
                spellFound = true;
            } else {
                iteration++;
            }
        }
        if(spellFound) {
//            System.out.println("Spell found at index: " + iteration);
//            System.out.println(spellArray.getJSONObject(iteration).getString("name"));
            return spellArray.getJSONObject(iteration);
        } else {
            System.out.println("NO SPELL FOUND");
            return null;
        }
    }

}
