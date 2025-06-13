import java.util.Calendar;
import java.util.Scanner;

public class ReminderService {
    private Settings settings;
    private LogManager logManager;
    private Scanner scanner;

    public ReminderService(Settings settings, LogManager logManager, Scanner scanner) {
        this.settings = settings;
        this.logManager = logManager;
        this.scanner = scanner;
    }

    public void start() {
        System.out.println("\n=== 💧 물 마시기를 시작합니다. 💧 ===");
        System.out.println("설정된 시간: " + settings.getStartHour() + "시 ~ " + settings.getEndHour() + "시");
        System.out.println("알림 간격: " + settings.getIntervalMinutes() + "분");

        int currentHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        if (currentHour < settings.getStartHour() || currentHour >= settings.getEndHour()) {
            System.out.println("‼️ 현재 시간(" + currentHour + "시)은 알림 시간이 아닙니다. ‼️");
            return;
        }

        System.out.println("🔔 알림이 시작되었습니다! 🔔");

        while (true) {
            Calendar current = Calendar.getInstance();
            int hour = current.get(Calendar.HOUR_OF_DAY);
            if (hour < settings.getStartHour() || hour >= settings.getEndHour()) {
                System.out.println("‼️ 알림 시간이 끝났습니다. 알림을 종료합니다. ‼️");
                break;
            }

            String time = String.format("%tF %tT", current, current);
            String message = "[" + time + "]  💦 지금 물 한 잔 마실 시간이에요!";
            System.out.println("\n" + message);
            System.out.print("물을 마셨나요? (1: 예, 2: 아니요, 0: 중단): ");

            int input = getInput();
            if (input == 0) {
                System.out.println("🛑 알림을 중단합니다.");
                break;
            } else if (input == 1) {
                logManager.addLog(message + " 마셨습니다! ⭕");
                System.out.println("✅ 기록되었습니다.");
            } else if (input == 2) {
                logManager.addLog(message + " 마시지 않았습니다. ❌");
                System.out.println("✅ 기록되었습니다.");
            } else {
                System.out.println("올바른 숫자를 입력하세요.");
                continue;
            }

            try {
                Thread.sleep(settings.getIntervalMinutes() * 60 * 1000L);
            } catch (InterruptedException e) {
                System.out.println("알림이 중단되었습니다.");
                break;
            }
        }
    }

    private int getInput() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
