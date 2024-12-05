public class Main {
    public static void main(String[] args) {
        Battery battery = new Battery();
        BatteryLevelDisplay batteryDisplay = new BatteryLevelDisplay(battery);
        LowBatteryWarning lowBatteryWarning = new LowBatteryWarning(battery);
        battery.setDisplay(batteryDisplay);
        battery.setWarning(lowBatteryWarning);
        battery.consume(20);
        battery.consume(50);
        battery.consume(10);
    }
}
