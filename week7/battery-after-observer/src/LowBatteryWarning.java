public class LowBatteryWarning implements Observer {
    private Battery battery;

    public LowBatteryWarning(Battery battery) {
        this.battery = battery;
    }

    public void update() {
        int level = battery.getLevel();
        if (level < 30)
            System.out.println("Warning : " + level);
    }
}
