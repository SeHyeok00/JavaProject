import java.util.ArrayList;
import java.util.List;

public class LogManager {
    private List<String> logs = new ArrayList<>();

    public void addLog(String log) {
        logs.add(log);
    }

    public void printLogs() {
        System.out.println("\n==== 📋 기록 목록 📋 ====");
        if (logs.isEmpty()) {
            System.out.println("기록이 없습니다.");
        } else {
            for (String log : logs) {
                System.out.println(log.replace(" 지금 물 한 잔 마실 시간이에요!", ""));
            }
        }
    }
}
