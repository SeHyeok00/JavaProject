import java.util.Scanner;

public class WaterDrinkReminder {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        for (; ; ) {
            printMainMenu();
            String input = sc.nextLine();
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

        return 0;
    }
}

