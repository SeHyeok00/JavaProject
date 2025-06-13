import java.util.Scanner;

public class SettingManager {
    private Settings settings;
    private Scanner scanner;

    public SettingManager(Settings settings, Scanner scanner) {
        this.settings = settings;
        this.scanner = scanner;
    }

    public void runSettingsMenu() {
        while (true) {
            System.out.println("\n==== 🧭 설정 메뉴 🧭 ====");
            System.out.println("1. 시간 설정");
            System.out.println("2. 알림 간격 설정");
            System.out.println("3. 뒤로 가기");
            System.out.print("선택: ");

            int choice = getChoice();
            switch (choice) {
                case 1: setTimeRange();
                break;
                case 2: setInterval();
                break;
                case 3: return;
                default:
                    System.out.println("🛑 잘못된 입력입니다.");
                    break;
            }
        }
    }

    private void setTimeRange() {
        System.out.println();
        System.out.print("🕰️ 시작 시간 (0~23): ");
        int start = getChoice();
        if (!settings.setStartHour(start)) {
            System.out.println("🛑 잘못된 입력입니다. 0~23 사이의 숫자를 입력하세요.");
            return;
        }

        System.out.print("🕰️ 종료 시간 (0~23): ");
        int end = getChoice();
        if (!settings.setEndHour(end)) {
            System.out.println("🛑 잘못된 입력입니다. 0~23 사이의 숫자를 입력하세요.");
            return;
        }
        System.out.println("✅ 시간 설정이 완료되었습니다.");
    }

    private void setInterval() {
        System.out.println();
        System.out.print("⏰ 알림 간격(1~120분): ");
        int interval = getChoice();

        if (settings.setIntervalMinutes(interval)) {
            System.out.println("✅ 알림 간격 설정이 완료되었습니다.");
        } else {
            System.out.println("🛑 잘못된 입력입니다. 1~120 사이의 숫자를 입력하세요.");
        }
    }

    private int getChoice() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
