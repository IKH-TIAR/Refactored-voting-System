import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Admin admin = new Admin();
        User user = new User();
        while (true) {
            displayMainMenu();
            int userChoice = scanner.nextInt();
            switch (userChoice) {
                case 1:
                    admin.login();
                    break;
                case 2:
                    user.userMenu();
                    break;
                case 3:
                    admin.printWinner();
                    pressAnyKeyToContinue(scanner);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid Input");
            }
        }
    }

    private static void displayMainMenu() {
        System.out.println("---------------------");
        System.out.println("1. Admin");
        System.out.println("2. User");
        System.out.println("3. See Winner");
        System.out.println("4. Exit");
        System.out.println("----------------------");
        System.out.print("Enter Your Choice: ");
    }

    private static void pressAnyKeyToContinue(Scanner scanner) {
        System.out.print("Press Any Key And Enter: ");
        scanner.next();
    }
}