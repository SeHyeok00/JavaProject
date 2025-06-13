import java.util.Scanner;

public class ConsoleUI {
    private ReminderService reminderService;
    private LogManager logManager;
    private SettingManager settingManager;
    private Scanner scanner;

    public ConsoleUI(ReminderService reminderService, LogManager logManager, SettingManager settingsManager, Scanner scanner) {
        this.reminderService = reminderService;
        this.logManager = logManager;
        this.settingManager = settingsManager;
        this.scanner = scanner;
    }

    public void run() {
        while (true) {
            printMainMenu();
            int choice = getChoice();

            switch (choice) {
                case 1:
                    reminderService.start();
                    break;
                case 2:
                    logManager.printLogs();
                    break;
                case 3:
                    settingManager.runSettingsMenu();
                    break;
                default:
                    System.out.println("🛑 잘못된 입력입니다.");
            }
        }
    }

    private void printMainMenu() {
        System.out.println("\n💦💦💦 물 마시기 프로그램!! 💦💦💦");
        System.out.println("1. 프로그램 시작");
        System.out.println("2. 기록 목록");
        System.out.println("3. 설정");
        System.out.print("선택: ");
    }

    private int getChoice() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
