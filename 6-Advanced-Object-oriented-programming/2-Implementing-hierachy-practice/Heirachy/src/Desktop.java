public class Desktop extends Computer {
  private String _formFactor;
  private boolean _waterCooled;

  public String getFormFactor() {
    return _formFactor;
  }

  public boolean getWaterCooled() {
    return _waterCooled;
  }

  public void setFormFactor(String formFactor) {
    _formFactor = formFactor;
  }

  public void setWaterCooled(boolean waterCooled) {
    _waterCooled = waterCooled;
  }

  public void addMemory(int memoryUpgradeGB) {
    this.setMemoryGB(memoryUpgradeGB + getMemoryGB());

  }

  public void addStorage(int storageUpgradeGB) {
    this.setStorageGB(storageUpgradeGB + getStoragGB());
  }
}
