public class Main {
    public static void main(String[] args) {
        Battery battery = new Battery();
        BatteryLevelDisplay display = new BatteryLevelDisplay(battery);
        LowBatteryWarning warning = new LowBatteryWarning(battery);

        battery.attach(display);
        battery.attach(warning);

        battery.consume(30);
        battery.consume(50);
        battery.consume(10);
    }
}
