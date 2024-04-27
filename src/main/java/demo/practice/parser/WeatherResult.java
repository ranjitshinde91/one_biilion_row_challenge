package demo.practice.parser;

public class WeatherResult {
  private double min;
  private double max;
  private double total;
  private double entryCount;

  public WeatherResult(double temperature) {
    this.min = temperature;
    this.max = temperature;
    this.total = temperature;
    this.entryCount = 1;
  }

  public void updateWithNewEntry(double temperature) {
    if (this.min > temperature) {
      this.min = temperature;
    }
    if (this.max < temperature) {
      this.max = temperature;
    }
    this.total = this.total + temperature;
    entryCount = entryCount + 1;
  }

  public double getMin() {
    return min;
  }

  public double getMax() {
    return max;
  }

  public double getMean() {
    return this.total / this.entryCount;
  }
}
