

import java.util.Scanner;

public class Main {
    private static Player player1;
    private static Player player2;
    private static Player mainPlayer;
    private static boolean endgame = true;
    private static final int second = 1000;
    private static final int heart = 15 * second;
    private static final int head = 8 * second;
    private static final int belly = 5 * second;
    private static int spread = 300;
    private static long msSeconds;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Score score = CheckScore.getScore("C:\\Users\\mongr\\Desktop\\JavaLabs\\My6SemLabsAndKurs\\source\\Duel\\some.dat");

        System.out.println("Это игра \"Дуэль\"\n");

        score.printScore();

        System.out.println("\nВыберите сложность\n");
        System.out.println("Легкая: введите 1");
        System.out.println("Средняя: введите 2");
        System.out.println("Сложная: введите 3");

        int check = scanner.nextInt();
        scanner.nextLine();

        switch (check) {
            case 1 -> {
                spread = 300;
                System.out.println("Выбрана лёгкая сложность\n");
            }
            case 2 -> {
                spread = 200;
                System.out.println("Выбрана средняя сложность\n");
            }
            case 3 -> {
                spread = 100;
                System.out.println("Выбрана сложная сложность\n");
            }
            default -> System.out.println("Неизвестный оператор. Выбрана сложность по умолчанию.\n");
        }

        System.out.println("1 игрок введите имя");
        player1 = new Player(scanner.nextLine());

        System.out.println("2 игрок введите имя");
        player2 = new Player(scanner.nextLine());

        mainPlayer = player1;
        System.out.println("\nК барьеру");

        while (true) {
            long startTime = System.currentTimeMillis();

            scanner.nextLine();
            msSeconds = System.currentTimeMillis() - startTime;
            hitCheck();
            System.out.println(mainPlayer.getPlayerName() + ": " + msSeconds / second);

            if (!endgame) {
                mainPlayer.setScore((int) msSeconds / second);
                score.addScore(mainPlayer);
                CheckScore.saveScore(score);
                break;
            }
            System.out.println("Мимо!\n");
            changePlayer();
        }

        System.out.println("Игра окончена. " + mainPlayer.getPlayerName() + " победил с " + msSeconds / second + " очками.");
        scanner.close();
    }

    private static void changePlayer() {
        if (mainPlayer == player1) {
            mainPlayer = player2;
        } else {
            mainPlayer = player1;
        }
    }

    private static void hitCheck() {
        if (msSeconds >= heart - spread && msSeconds <= heart + spread) {
            msSeconds = heart;
            endgame = false;
        } else if (msSeconds >= head - spread && msSeconds <= head + spread) {
            msSeconds = head;
            endgame = false;
        } else if (msSeconds >= belly - spread && msSeconds <= belly + spread) {
            msSeconds = belly;
            endgame = false;
        }
    }
}
