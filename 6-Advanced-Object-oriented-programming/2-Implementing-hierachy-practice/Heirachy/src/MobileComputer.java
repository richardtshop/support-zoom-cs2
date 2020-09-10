public class MobileComputer extends Computer {
  private int _batteryLifeHours;
  private int _batteryRemainingPercentage;
  private int _weight;

  public void setWeight(int weight) {
    _weight = weight;
  }

  public void setBatteryLifeHours(int batteryLife) {
    _batteryLifeHours = batteryLife;
  }

  public void setBatteryRemainingPercentage(int batteryRemaining) {
    _batteryRemainingPercentage = batteryRemaining;
  }

  public int getBatteryLifeHours() {
    return _batteryLifeHours;
  }

  public int getBatteryRemainingPercentage() {
    return _batteryRemainingPercentage;
  }

  public int getWeight() {
    return _weight;
  }

  public void rechargeBattery() {
    setBatteryRemainingPercentage(100);
  }

  public int getRemainingBatteryLifeHours() {
    int percentage = this.getBatteryRemainingPercentage();
    int batteryLife = this.getBatteryLifeHours();
    return (percentage * batteryLife) / 100;
  }

  public boolean isHeavy(int weight) {
    int currWeight = this.getWeight();
    if (currWeight > weight) {
      return true;
    }
    return false;
  }
}
