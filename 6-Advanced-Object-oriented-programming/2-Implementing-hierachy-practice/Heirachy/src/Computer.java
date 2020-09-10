public class Computer {
  public String _OS;
  private int _memoryGB;
  private int _storageGB;
  private boolean _powered;

  public String getOS() {
    return _OS;
  }

  public int getMemoryGB() {
    return _memoryGB;
  }

  public int getStoragGB() {
    return _storageGB;
  }

  public boolean getPowered() {
    return _powered;
  }

  public void setOS(String OS) {
    _OS = OS;
  }

  public void setMemoryGB(int memory) {
    _memoryGB = memory;
  }

  public void setStorageGB(int storage) {
    _storageGB = storage;
  }

  public void setPower(boolean power) {
    _powered = power;
  }

  public void togglePower() {
    boolean powered = this.getPowered();
    setPower(!powered);
  }
}
