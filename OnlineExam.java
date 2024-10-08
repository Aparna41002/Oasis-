import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class OnlineExam {
    private static Scanner scanner = new Scanner(System.in);
    private static String username;
    private static String password;
    private static String correctAnswer;
    private static int timeRemaining;
    private static Timer timer;

    public static void main(String[] args) {
        setup();
        login();
    }

    private static void setup() {
        System.out.println("=== Setup ===");
        System.out.print("Create a username: ");
        username = scanner.nextLine();
        System.out.print("Create a password: ");
        password = scanner.nextLine();
        System.out.print("Enter the correct answer for the sample question 'What is 2 + 2?': ");
        correctAnswer = scanner.nextLine();
    }

    private static void login() {
        System.out.println("\n=== Login ===");
        System.out.print("Enter username: ");
        String inputUsername = scanner.nextLine();
        System.out.print("Enter password: ");
        String inputPassword = scanner.nextLine();

        if (inputUsername.equals(username) && inputPassword.equals(password)) {
            System.out.println("Login successful!");
            updateProfile();
        } else {
            System.out.println("Invalid login credentials.");
        }
    }

    private static void updateProfile() {
        System.out.println("\n=== Update Profile ===");
        System.out.print("Enter new username (leave blank to keep the same): ");
        String newUsername = scanner.nextLine();
        System.out.print("Enter new password (leave blank to keep the same): ");
        String newPassword = scanner.nextLine();

        if (!newUsername.isEmpty()) {
            username = newUsername;
        }
        if (!newPassword.isEmpty()) {
            password = newPassword;
        }

        System.out.println("Profile updated successfully!");
        startExamination();
    }

    private static void startExamination() {
        System.out.println("\n=== Examination ===");
        System.out.print("Enter the exam duration in seconds: ");
        timeRemaining = scanner.nextInt();
        scanner.nextLine();  // Consume the newline

        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                timeRemaining--;
                System.out.println("Time remaining: " + timeRemaining + " seconds");
                if (timeRemaining <= 0) {
                    submitExam();
                }
            }
        }, 1000, 1000);

        System.out.println("Question: What is 2 + 2?");
        System.out.println("1) 1");
        System.out.println("2) 2");
        System.out.println("3) 3");
        System.out.println("4) 4");

        System.out.print("Enter your answer (1-4): ");
        String selectedAnswer = scanner.nextLine();

        submitExam(selectedAnswer);
    }

    private static void submitExam() {
        timer.cancel();
        System.out.println("\nTime is up! Exam auto-submitted.");
        checkAnswer("");
    }

    private static void submitExam(String selectedAnswer) {
        timer.cancel();
        System.out.println("\nExam Submitted!");
        checkAnswer(selectedAnswer);
    }

    private static void checkAnswer(String selectedAnswer) {
        if (selectedAnswer.equals(correctAnswer)) {
            System.out.println("Your answer is correct!");
        } else {
            System.out.println("Your answer is incorrect.");
        }
        logout();
    }

    private static void logout() {
        System.out.println("\n=== Logout ===");
        System.out.println("You have been logged out.");
}
}

