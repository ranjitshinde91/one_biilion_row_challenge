package demo.practice.parser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class OneBillionRowParser {
  public static final String DELIMITER = ";";
  private final Map<String, WeatherResult> temperatureByWeatherStation;
  private final String fileName;

  public OneBillionRowParser(String fileName) {
    this.fileName = fileName;
    this.temperatureByWeatherStation = new HashMap<>();
  }

  public Map<String, WeatherResult> parse() {
    try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
      for (String line; (line = br.readLine()) != null; ) {
        String[] split = line.split(DELIMITER);
        String stationName = split[0];
        if (!temperatureByWeatherStation.containsKey(stationName)) {
          temperatureByWeatherStation.put(
              stationName, new WeatherResult(Double.parseDouble(split[1])));
        } else {
          temperatureByWeatherStation
              .get(stationName)
              .updateWithNewEntry(Double.parseDouble(split[1]));
        }
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    return temperatureByWeatherStation;
  }
}
