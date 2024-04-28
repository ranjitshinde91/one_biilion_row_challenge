package demo.practice;

import demo.practice.parser.OneBillionRowParser;
import demo.practice.parser.WeatherResult;

import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {

    while (true) {
      System.out.println(" Enter file name: ");
      Scanner sc = new Scanner(System.in);
      String fileName = sc.next();
      if (fileName.equals("exit")) {
        break;
      }
      parseFile(fileName);
    }
    System.out.println("application stopped");
  }

  private static void parseFile(String fileName) {
    var start = System.currentTimeMillis();
    OneBillionRowParser oneBillionRowParser = new OneBillionRowParser(fileName);
    Map<String, WeatherResult> parse = oneBillionRowParser.parse();
    var end = System.currentTimeMillis();
    System.out.println("Time taken in millis: " + (end - start));
  }
}
