public class TestingComputers {
  public static void main(String[] args) {

    // Testing Computer class
    Computer computer = new Computer();
    computer.setOS("DOS");
    computer.setMemoryGB(2);
    computer.setStorageGB(4);
    computer.setPower(false);

    System.out.println(computer.getPowered()); // false
    computer.togglePower();
    System.out.println(computer.getPowered()); // true

    // computer.setBatteryLifeHours(3); // error

    // Testing Desktop computer class
    Desktop desktop = new Desktop();
    desktop.setOS("Windows");
    desktop.setMemoryGB(16);
    desktop.setStorageGB(2056);
    desktop.setPower(true);
    desktop.setFormFactor("Mini-ATX");
    desktop.setWaterCooled(false);

    System.out.println("Memory: " + desktop.getMemoryGB() + "GB"); // 16
    System.out.println("Storage: " + desktop.getStoragGB() + "GB"); // 2056
    desktop.addMemory(16);
    desktop.addStorage(2056);
    System.out.println("Memory: " + desktop.getMemoryGB() + "GB"); // 32
    System.out.println("Storage: " + desktop.getStoragGB() + "GB"); // 4112
    System.out.println("------------------------");

    // Testing MobileComputer class
    MobileComputer mobile = new MobileComputer();
    mobile.setOS("Linux");
    mobile.setMemoryGB(16);
    mobile.setStorageGB(1028);
    mobile.setBatteryLifeHours(2);
    mobile.setBatteryRemainingPercentage(50);
    mobile.setPower(false);
    mobile.setWeight(1000);

    System.out.println(mobile.isHeavy(2000)); // false
    mobile.togglePower();
    System.out.println(mobile.getPowered()); // true
    System.out.println("Battery remaining: " + mobile.getRemainingBatteryLifeHours() + " hours"); // 1 hours
    System.out.println(mobile.isHeavy(2000)); // false
    System.out.println("------------------------");

    // Testing Laptop class
    Laptop laptop = new Laptop();
    laptop.setOS("ChromeOS");
    laptop.setMemoryGB(16);
    laptop.setStorageGB(256);
    laptop.setBatteryLifeHours(12);
    laptop.setBatteryRemainingPercentage(70);
    laptop.setPower(true);
    laptop.setWeight(3000);
    laptop.setScreenOn(true);
    laptop.setkeyboardLayout("Dvorak");

    System.out.println(laptop.getkeyboardLayout()); // Dvorak
    System.out.println(laptop.isHeavy(2500)); // true
    System.out.println("Battery remaining: " + laptop.getRemainingBatteryLifeHours() + " hours"); // 8 hours
    laptop.rechargeBattery();
    System.out.println("Battery remaining: " + laptop.getRemainingBatteryLifeHours() + " hours"); // 12 hours
    System.out.println(laptop.getScreenOn()); // true
    laptop.toggleScreen();
    System.out.println(laptop.getScreenOn()); // false
    System.out.println("------------------------");

    // Testing phone class
    SmartPhone phone = new SmartPhone();
    phone.setOS("Android");
    phone.setMemoryGB(8);
    phone.setStorageGB(128);
    phone.setBatteryLifeHours(12);
    phone.setBatteryRemainingPercentage(90);
    phone.setPhoneNumber(6131111111L);
    phone.setPower(true);

    phone.printNumber();
    System.out.println("Phone is on: " + phone.getPowered());
    phone.togglePower();
    System.out.println("Phone is on: " + phone.getPowered());
    System.out.println("Battery remaining: " + phone.getRemainingBatteryLifeHours() + " hours");
    phone.rechargeBattery();
    System.out.println("Battery remaining: " + phone.getRemainingBatteryLifeHours() + " hours");
    System.out.println("------------------------");
  }
}
