import java.util.Scanner;

public class WaterDrinkReminder {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        for (; ; ) {
            printMainMenu();
            int choice = getChoice();

            switch (choice) {
                case 1:
                    System.out.println("프로그램 시작");
                case 2:
                    System.out.println("기록 확인");
                case 3:
                    System.out.println("설정");
                default:
                    System.out.println("다시 입력하세요.");
            }
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
}

