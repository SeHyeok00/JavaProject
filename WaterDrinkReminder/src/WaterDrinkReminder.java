import java.util.*;

public class WaterDrinkReminder {
    static Scanner sc = new Scanner(System.in);
    static int startHour = 9;   // 알람 시작 시간
    static int endHour = 21;    // 알람 종료 시간
    static int intervalMinutes = 60; // 알림 간격

    static List<String> logs = new ArrayList();

    public static void main(String[] args) {
        while (true) {
            printMainMenu();
            int choice = getChoice();

            switch (choice) {
                case 1:
                    startProgram();
                    break;
                case 2:
                    viewLogs();
                    break;
                case 3:
                    openSettings();
                    break;
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
        System.out.println("3. 뒤로 가기");
        System.out.print("선택: ");

        int settingChoice = getChoice();

        switch (settingChoice) {
            case 1:
                setTimeRange();
            case 2:
                setInterval();
            case 3:
                return;
            default:
                System.out.println("잘못된 입력입니다.");
        }
    }

    static void setTimeRange() {
        System.out.print("시작 시간 (0~23): ");
        startHour = getChoice();
        System.out.print("종료 시간 (0~23): ");
        endHour = getChoice();
        System.out.println("시간 설정이 완료되었습니다.");
    }

    static void setInterval() {
        System.out.print("알림 간격 (분): ");
        intervalMinutes = getChoice();
        System.out.println("간격 설정이 완료되었습니다.");
    }
}


