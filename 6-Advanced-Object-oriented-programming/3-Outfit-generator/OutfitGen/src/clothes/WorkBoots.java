package clothes;

public class WorkBoots extends Boots {
  private boolean _protection;
  private String _toeCapMaterial;

  public WorkBoots(String name, String color, String material, boolean isClean, String fastening, boolean fastened,
      int height, boolean protection, String toeCapMaterial) {
    super(name, color, material, isClean, fastening, fastened, height);
    _protection = protection;
    _toeCapMaterial = toeCapMaterial;
  }

  // getters
  public boolean getProtection() {
    return _protection;
  }

  public String getToeCapMaterial() {
    return _toeCapMaterial;
  }

  // setters
  public void setProtection(boolean protection) {
    _protection = protection;
  }

  public void setToeCapMaterial(String toeCapMaterial) {
    _toeCapMaterial = toeCapMaterial;
  }

  // other methods
  public void stomp() {
    System.out.println("CLANG! CLANG! CLANG!");
  }
  // compatibility methods
}
