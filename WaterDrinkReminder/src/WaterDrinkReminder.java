import java.util.Scanner;

public class WaterDrinkReminder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Settings settings = new Settings();
        LogManager logManager = new LogManager();
        ReminderService reminderService = new ReminderService(settings, logManager, scanner);
        SettingManager settingsManager = new SettingManager(settings, scanner);

        ConsoleUI ui = new ConsoleUI(reminderService, logManager, settingsManager, scanner);
        ui.run();
    }
}








