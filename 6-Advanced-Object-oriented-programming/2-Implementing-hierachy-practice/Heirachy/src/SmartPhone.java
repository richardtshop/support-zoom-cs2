public class SmartPhone extends MobileComputer {
  private long _phoneNumber;

  public long getPhoneNumber() {
    return _phoneNumber;
  }

  public void setPhoneNumber(long phoneNumber) {
    _phoneNumber = phoneNumber;
  }

  public void printNumber() {
    System.out.println(getPhoneNumber());
  }
}