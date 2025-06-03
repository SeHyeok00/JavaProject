import java.util.*;

public class WaterDrinkReminder {
    static Scanner sc = new Scanner(System.in);
    static String reminderTime = "09:00";      // 기본 알림 시간
    static int reminderInterval = 60;          // 기본 알림 간격 (분 단위)
    static List<String> logs = new ArrayList();

    public static void main(String[] args) {
        while (true) {
            printMainMenu();
            int choice = getChoice();

            switch (choice) {
                case 1:
                    startProgram();
                case 2:
                    viewLogs();
                case 3:
                    openSettings();
                default:
                    System.out.println("다시 입력하세요.");
            }
            System.out.println();
        }
    }

    static void printMainMenu() {
        System.out.println("물 마시기 프로그램!!💦");
        System.out.println("1. 프로그램 시작");
        System.out.println("2. 기록 보기");
        System.out.println("3. 설정");
        System.out.print("선택: ");
    }

    static int getChoice() {
        try {
            return Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    static void startProgram() {
        System.out.println("물 마시기를 시작합니다!");
        System.out.println("설정된 시간: " );
        System.out.println("알림 간격: " );
    }

    static void viewLogs() {
        System.out.println("==== 기록 목록 ====");
        if (logs.isEmpty()) {
            System.out.println("기록이 없습니다.");
        } else {
            for (String log : logs) {
                System.out.println(log);
            }
        }
    }

    static void openSettings() {
        System.out.println("==== 설정 메뉴 ====");
        System.out.println("1. 시간 설정");
        System.out.println("2. 알림 간격 설정");
        System.out.print("선택: ");

        int settingChoice = getChoice();

        switch (settingChoice) {
            case 1 -> System.out.println("시간을 설정합니다.");
            case 2 -> System.out.println("알림 간격을 설정합니다. ");
            default -> System.out.println("올바른 번호를 입력하세요.");
        }
    }
}

