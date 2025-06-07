import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class WaterDrinkReminder {
    static Scanner sc = new Scanner(System.in);
    static int startHour = 1;   // 알람 시작 시간
    static double endHour = 13;    // 알람 종료 시간
    static double intervalMinutes = 0.1; // 알림 간격

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
                    System.out.println("잘못된 입력입니다.");
            }
            System.out.println();
        }
    }

    static void printMainMenu() {
        System.out.println("💦물 마시기 프로그램!!💦");
        System.out.println("1. 프로그램 시작");
        System.out.println("2. 기록 보기");
        System.out.println("3. 설정");
        System.out.print("선택: ");
    }

    static int getChoice() {
        try {
            return Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    static void startProgram() {
        System.out.println();
        System.out.println("=== 💦 물 마시기를 시작합니다 💦 ===");
        System.out.println("설정된 시간: " + startHour + "시 ~ " + endHour + "시 ");
        System.out.println("알림 간격: " + intervalMinutes + "분");

        Calendar now = Calendar.getInstance();
        int currentHour = now.get(Calendar.HOUR_OF_DAY);

        if (currentHour < startHour) {
            System.out.println("현재 시간(" + currentHour + "시)은 알림 시간이 아닙니다.");
            return;
        }

        System.out.println("🔔🔔 알림이 시작되었습니다! 🔔🔔");

        while (true) {
            Calendar current = Calendar.getInstance();
            int hour = current.get(Calendar.HOUR_OF_DAY);

            if (hour < startHour || hour >= endHour) {
                System.out.println("‼️ 알림 시간이 끝났습니다. 알림을 종료합니다. ‼️");
                break;
            }

            String time = String.format("%tF %tT", current, current);
            String message = "[" + time + "]  지금 물 한 잔 마실 시간이에요!";
            System.out.println();
            System.out.println(message);

            System.out.print("물을 마셨나요? (1: 예, 2: 아니요, 0: 중단): ");
            int input = getChoice();

            if (input == 0) {
                System.out.println("알림을 중단합니다.");
                break;
            } else if (input == 1) {
                logs.add(message + " 마셨습니다!");
                System.out.println("기록되었습니다.");
            } else if (input == 2) {
                logs.add(message + " 마시지 않았습니다.");
                System.out.println("기록되었습니다.");
            } else {
                System.out.println("올바른 숫자를 입력하세요.");
                continue;
            }

            try {
                Thread.sleep((long) (intervalMinutes * 60 * 1000)); // 분 → 밀리초
            } catch (InterruptedException e) {
                System.out.println(" 알림이 중단되었습니다.");
                break;
            }
        }
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
        while (true) {
            System.out.println();
            System.out.println("==== 설정 메뉴 ====");
            System.out.println("1. 시간 설정");
            System.out.println("2. 알림 간격 설정");
            System.out.println("3. 뒤로 가기");
            System.out.print("선택: ");

            int settingChoice = getChoice();

            switch (settingChoice) {
                case 1:
                    setTimeRange();
                    break;
                case 2:
                    setInterval();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("잘못된 입력입니다.");
                    break;
            }
        }
    }

    static void setTimeRange() {
        System.out.println();
        System.out.print("시작 시간 (0~23): ");
        int start = getChoice();
        if (start < 0 || start > 23) {
            System.out.println("잘못된 입력입니다. 0~23 사이의 숫자를 입력하세요.");
            return;
        }

        System.out.print("종료 시간 (0~23): ");
        int end = getChoice();
        if (end < 0 || end > 23) {
            System.out.println("잘못된 입력입니다. 0~23 사이의 숫자를 입력하세요.");
            return;
        }

        startHour = start;
        endHour = end;
        System.out.println("시간 설정이 완료되었습니다.");
    }

    static void setInterval() {
        System.out.print("알림 간격 (분): ");
        int interval = getChoice();
        if (interval <= 0) {
            System.out.println("잘못된 입력입니다. 양수를 입력하세요.");
            return;
        }

        intervalMinutes = interval;
        System.out.println("간격 설정이 완료되었습니다.");
    }
}


