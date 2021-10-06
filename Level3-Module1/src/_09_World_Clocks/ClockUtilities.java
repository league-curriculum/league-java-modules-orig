package _09_World_Clocks;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.TimeZone;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;
import javax.swing.JOptionPane;

import com.google.gson.Gson;

public class ClockUtilities {
    public static String CITIES_TO_LAT_LON_FILE = "city_list.json";
    public static String apiKey = "ZCBUZFXAIL6T";
    Long lastApiRequestTimeMs = null;

    private HashMap<String, Coordinate> cityCoordinates = null;

    public ClockUtilities() {
        cityCoordinates = new HashMap<>();
        ReadCitiesFile();
    }

    /*
     * Use this method to get time information (Calendar object) for a city The
     * input requestedCity must be in the format "city, country" Example:
     * "San Diego, US"
     */
    public TimeZone getTimeZoneFromCityName(String requestedCity) {
        TimeZone timeZoneObj = null;

        if (!requestedCity.contains(",")) {
            JOptionPane.showMessageDialog(null,
                    "ERROR: Input must be in the format city, country [" + requestedCity + "]");
            return null;
        }

        Coordinate coordinates = getCoordinateFromCityName(requestedCity);

        if (coordinates == null) {
            JOptionPane.showMessageDialog(null, "ERROR: Unable to find " + requestedCity);
        } else {
            System.out.println("Getting time zone for " + requestedCity);
            String timeZoneString = getTimeZoneFromCoordinates(coordinates);
            timeZoneObj = TimeZone.getTimeZone(timeZoneString);
        }

        return timeZoneObj;
    }

    private void ReadCitiesFile() {
        // Read from city_list.json to get a city to lat/lon map
        try {
            Gson gson = new Gson();
            JsonReader r = Json.createReader(new FileReader(CITIES_TO_LAT_LON_FILE));
            JsonArray arr = r.readArray();

            for (JsonValue obj : arr) {
                CityData city = gson.fromJson(obj.toString(), CityData.class);

                String cityNameAndCountry = city.getName() + ", " + city.getCountry();
                cityCoordinates.put(cityNameAndCountry, city.getCoordinate());

                cityCoordinates.put(city.getName(), city.getCoordinate());
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    private String getTimeZoneFromCoordinates(Coordinate coordinates) {
        String timeZone = null;

        // API restrictions, max 1 request per second
        if( lastApiRequestTimeMs != null && ( System.currentTimeMillis() - lastApiRequestTimeMs < 1000 ) ) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        lastApiRequestTimeMs = System.currentTimeMillis();
        
        // Sample
        // http://api.timezonedb.com/v2.1/get-time-zone?key=YOUR_API_KEY&format=json&by=position&lat=40.689247&lng=-74.044502

        String addr = "http://api.timezonedb.com/v2.1/get-time-zone?";
        addr += "key=" + apiKey;
        addr += "&format=json";
        addr += "&by=position";
        addr += "&lat=" + coordinates.getLat();
        addr += "&lng=" + coordinates.getLon();

        URL url;
        try {
            Gson gson = new Gson();
            url = new URL(addr);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            JsonReader repoReader = Json.createReader(con.getInputStream());
            JsonObject userJSON = ((JsonObject) repoReader.read());
            con.disconnect();

            ClockData clockData = gson.fromJson(userJSON.toString(), ClockData.class);
            timeZone = clockData.getZoneName();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return timeZone;
    }

    private Coordinate getCoordinateFromCityName(String requestedCity) {
        Coordinate coordinate = null;

        String[] cityInfo = requestedCity.split(",");
        String city = cityInfo[0].trim();
        String country = cityInfo[1].trim();
        String requestedCityFormatted = city + ", " + country;

        for (String fullCityName : cityCoordinates.keySet()) {
            if (fullCityName.equalsIgnoreCase(requestedCityFormatted)) {
                coordinate = cityCoordinates.get(fullCityName);
                break;
            }
        }

        return coordinate;
    }
}
