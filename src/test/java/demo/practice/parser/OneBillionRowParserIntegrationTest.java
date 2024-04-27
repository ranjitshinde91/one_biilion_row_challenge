package demo.practice.parser;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OneBillionRowParserIntegrationTest {
  private String basePath =
      "/Users/ranjitshinde/Desktop/workshop/one_biilion_row_challenge/src/test/resources/";

  @Test
  void shouldReturnReportForMeasurement1() {
    var oneBillionRowParser = new OneBillionRowParser(basePath + "measurements-1.txt");

    var report = oneBillionRowParser.parse();

    assertEquals(1, report.size());
    WeatherResult kunming = report.get("Kunming");
    assertEquals(19.8, kunming.getMin());
    assertEquals(19.8, kunming.getMean());
    assertEquals(19.8, kunming.getMax());
  }

  @Test
  void shouldReturnReportForMeasurement2() {
    var oneBillionRowParser = new OneBillionRowParser(basePath + "measurements-2.txt");

    var report = oneBillionRowParser.parse();

    assertEquals(9, report.size());
    WeatherResult istanbul = report.get("Istanbul");
    assertEquals(6.2, istanbul.getMin());
    assertEquals(14.6, istanbul.getMean());
    assertEquals(23.0, istanbul.getMax());
  }

  @Test
  void shouldReturnReportForMeasurement3() {
    var oneBillionRowParser = new OneBillionRowParser(basePath + "measurements-3.txt");

    var report = oneBillionRowParser.parse();

    assertEquals(2, report.size());
    WeatherResult kunming = report.get("Bosaso");
    assertEquals(-15.0, kunming.getMin());
    assertEquals(1.25, kunming.getMean());
    assertEquals(20.0, kunming.getMax());

    WeatherResult petropavlovsk = report.get("Petropavlovsk-Kamchatsky");
    assertEquals(-9.5, petropavlovsk.getMin());
    assertEquals(0.0, petropavlovsk.getMean());
    assertEquals(9.5, petropavlovsk.getMax());
  }

  @Test
  void shouldReturnReport2() {
    var oneBillionRowParser = new OneBillionRowParser(basePath + "measurements-boundaries.txt");

    var report = oneBillionRowParser.parse();

    assertEquals(2, report.size());
    WeatherResult kunming = report.get("Bosaso");
    assertEquals(-99.9, kunming.getMin());
    assertEquals(-99.9, kunming.getMean());
    assertEquals(-99.9, kunming.getMax());

    WeatherResult petropavlovsk = report.get("Petropavlovsk-Kamchatsky");
    assertEquals(99.9, petropavlovsk.getMin());
    assertEquals(99.9, petropavlovsk.getMean());
    assertEquals(99.9, petropavlovsk.getMax());
  }
}
