public class Laptop extends MobileComputer {
  private boolean _touchscreen;
  private String _keyboardLayout;
  private boolean _screenOn;

  public boolean getTouchscreen() {
    return _touchscreen;
  }

  public String getkeyboardLayout() {
    return _keyboardLayout;
  }

  public boolean getScreenOn() {
    return _screenOn;
  }

  public void setTouchscreen(boolean touchscreen) {
    _touchscreen = touchscreen;
  }

  public void setkeyboardLayout(String keyboardLayout) {
    _keyboardLayout = keyboardLayout;
  }

  public void setScreenOn(boolean screenState) {
    _screenOn = screenState;
  }

  public void toggleScreen() {
    this.setScreenOn(!this.getScreenOn());
  }
}
