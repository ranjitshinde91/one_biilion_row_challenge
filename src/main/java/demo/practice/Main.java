package demo.practice;

import demo.practice.parser.OneBillionRowParser;
import demo.practice.parser.WeatherResult;

import java.util.Map;

public class Main {
  public static void main(String[] args) {
    var start = System.currentTimeMillis();
    OneBillionRowParser oneBillionRowParser = new OneBillionRowParser(args[0]);
    Map<String, WeatherResult> parse = oneBillionRowParser.parse();
    var end = System.currentTimeMillis();
    System.out.println("Time taken in millis: " + (end - start));
  }
}
