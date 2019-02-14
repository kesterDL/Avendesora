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
            json = callURL("http://www.dnd5eapi.co/api/spells/");
//            System.out.println(json.toString());

        return json;
    }

    public static JSONObject getSpecificSpell(final String spellName) throws JSONException{
        JSONArray spellArray = getAllSpells().getJSONArray("results");
        Integer numOfSpells = getAllSpells().getInt("count");
        Boolean spellFound = false;
        int iteration = 0;

        while(!spellFound && iteration < numOfSpells) {
            if(spellArray.getJSONObject(iteration).getString("name").contains(spellName)) {
                spellFound = true;
            } else {
                iteration++;
            }
        }
        if(spellFound) {
//            getSpellDescription(spellArray.getJSONObject(iteration));
            return spellArray.getJSONObject(iteration);
        } else {
            System.out.println("** " + spellName + " was not found in the spell book **");
            return null;
        }
    }


    public static String getSpellDescription(JSONObject spell) throws JSONException {
        JSONObject spellJSON = callURL(spell.getString("url"));
        return spellJSON.getJSONArray("desc").getString(0);
    }
}
