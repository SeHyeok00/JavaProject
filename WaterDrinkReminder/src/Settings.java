public class Settings {
    private int startHour = 0;
    private int endHour = 0;
    private int intervalMinutes = 0;

    public int getStartHour() { return startHour; }
    public int getEndHour() { return endHour; }
    public int getIntervalMinutes() { return intervalMinutes; }

    public boolean setStartHour(int hour) {
        if (hour >= 0 && hour <= 23) {
            startHour = hour;
            return true;
        }
        return false;
    }

    public boolean setEndHour(int hour) {
        if (hour >= 0 && hour <= 23) {
            endHour = hour;
            return true;
        }
        return false;
    }

    public boolean setIntervalMinutes(int minutes) {
        if (minutes > 0 && minutes <= 120) {
            intervalMinutes = minutes;
            return true;
        }
        return false;
    }
}
