package _04_California_Weather;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

/*
 * All weather data from December 7, 2020.
 */
public class Utilities {
    private final static String caliWeatherFilename = "california_cities_weather.txt";
    
    public static HashMap<String, WeatherData> getWeatherData() {
        HashMap<String, WeatherData> weatherData = new HashMap<>();
        HashMap<String, Integer> duplicateLocations = new HashMap<>();
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(caliWeatherFilename));
            
            String line = br.readLine();
            while(line != null){
                
                // Format of each file entry is:
                // <city name>, <weather summary>, <temperature degrees F>
                String[] datum = line.split(", ");
                
                if( datum.length > 2 ) {
                    StringBuilder cityName = new StringBuilder( datum[0] );
                    String weatherSummary = datum[1];
                    double temperatureF = Double.parseDouble( datum[2] );
                
                    // Add a separate entry for duplicate city names because
                    // large cities have multiple recordings
                    if( weatherData.containsKey(cityName.toString()) ) {
                        if( duplicateLocations.containsKey(cityName.toString()) ){
                            Integer duplicateNum = duplicateLocations.get(cityName.toString());
                        
                            // Update number at the end, e.g. Orange1, Orange2, ...
                            duplicateNum++;
                            duplicateLocations.put(cityName.toString(), duplicateNum);
                        
                            // Only do this AFTER updating the duplicate num suffix
                            cityName.append( duplicateNum );
                        } else {
                            duplicateLocations.put(cityName.toString(), 1);
                            cityName.append(1);
                        }
                    }
                    
                    weatherData.put(cityName.toString(), new WeatherData(weatherSummary, temperatureF));
                }
                
                // Read next entry
                line = br.readLine();
            }
            
            br.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        return weatherData;
    }
}
