package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class Progression {
    private static int missingNumber;
    public static void main(String[] args) {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");

        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        System.out.println("Hello, " + name + "!");
        System.out.println("What number is missing in the progression?");

        int correctAnswers = 0;
        final int roundsToWin = 3;
        Random random = new Random();
        while (correctAnswers < roundsToWin) {
            int number = random.nextInt(100) + 1;
            int step = random.nextInt(10) + 1;

            int[] progression = generateProgression(number, step);
            System.out.print("Question: ");
            for (int i : progression) {
                if (i == 0) {
                    System.out.print(".. ");

                } else {
                    System.out.print(i + " ");
                }
            }

            System.out.println();
            System.out.print("Your answer: ");
            int userAnswer = scanner.nextInt();

            if (userAnswer == getMissingNum(progression)) {
                System.out.println("Correct!");
                correctAnswers++;
            } else {
                System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '"
                        + getMissingNum(progression) + "'.");
                System.out.println("Let's try again, " + name + "!");
                break;

            }
        }
        if (correctAnswers == roundsToWin) {
            System.out.println("Congratulations, " + name + "!");
        }
    }

    private static int[] generateProgression(int number, int step) {
        int[] progression = new int[10];
        Random random = new Random();
        int randomInt = random.nextInt(10);

        for (int i = 0; i < progression.length; i++) {
            if (i == randomInt) {
                missingNumber = number;
                number += step;
            } else {
                progression[i] = number;
                number += step;
            }
        }
        return progression;
    }

    private static int getMissingNum(int[] progression) {
        return missingNumber;
    }
}
