package clothes;

public class Watch extends Accessories {
  private String _type;
  private int _batteryRemaining;

  public Watch(String name, String color, String material, boolean isClean, String bodyLocation, String type,
      int batteryRemaining) {
    super(name, color, material, isClean, bodyLocation);
    _type = type;
    if (batteryRemaining > 100) {
      _batteryRemaining = 100;
    } else if (batteryRemaining < 0) {
      _batteryRemaining = 0;
    } else {
      _batteryRemaining = batteryRemaining;
    }
  }

  // getters
  public String getType() {
    return _type;
  }

  public int getBatteryRemaining() {
    return _batteryRemaining;
  }

  // setters
  public void setBatteryRemaining(int batteryRemaining) {
    _batteryRemaining = batteryRemaining;
  }

  // other methods
  public void rechargeBattery() {
    setBatteryRemaining(100);
  }
  // compatibility methods
}
