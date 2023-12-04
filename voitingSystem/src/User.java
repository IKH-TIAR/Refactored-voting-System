import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class User{
    private final Scanner scanner = new Scanner(System.in);
    private final HashMap<String, String> registerInfo = new HashMap<>();
    private final ArrayList<String> notVoted = new ArrayList<>();
    private final Candidate candidate = new Candidate();

    public void userMenu() {
        while (true) {
            displayUserMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 1) {
                registerUser();
                pressAnyKeyToContinue();
            } else if (choice == 2) {
                userLogin();
            } else if (choice == 3) {
                return;
            } else System.out.println("Invalid Input");
        }
    }

    private void displayUserMenu() {
        System.out.println("----------------------");
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("3. Main Menu");
        System.out.println("-----------------------");
        System.out.print("Enter Your Choice: ");
    }

    private void pressAnyKeyToContinue() {
        System.out.print("Press Any Key And Enter: ");
        scanner.next();
    }

    public void registerUser() {
        System.out.print("Enter Username: ");
        String username = scanner.nextLine();
        if (registerInfo.containsKey(username)) {
            System.out.println("Username Is Already Taken");
            return;
        }
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();
        registerInfo.put(username, password);
        System.out.println("Registration Complete");
        System.out.println("Login To Vote");
        notVoted.add(username);
    }

    public void userLogin() {
        System.out.print("Enter Username: ");
        String username = scanner.nextLine();
        if (registerInfo.containsKey(username)) {
            System.out.print("Enter Password: ");
            String password = scanner.nextLine();
            if (registerInfo.get(username).equals(password)) {
                userMainMenu(username);
            } else System.out.println("Wrong Password");
        } else System.out.println("Wrong Username");
    }

    public void userMainMenu(String username) {
        while (true) {
            displayUserMainMenu();
            int choice = scanner.nextInt();
            if (choice == 1) {
                candidate.viewCandidates();
                pressAnyKeyToContinue();
            } else if (choice == 2) {
                vote(username);
                pressAnyKeyToContinue();
            } else if (choice == 3) return;
            else System.out.println("Invalid Input");
        }
    }

    private void displayUserMainMenu() {
        System.out.println("-----------------------");
        System.out.println("1. View Candidate");
        System.out.println("2. Vote");
        System.out.println("3. Logout");
        System.out.println("------------------------");
        System.out.print("Enter Your Choice: ");
    }

    public void vote(String username) {
        if (Candidate.serialNumbers.isEmpty()) {
            System.out.println("No Candidate Is Selected");
            return;
        }
        scanner.nextLine();
        if (!notVoted.contains(username)) {
            System.out.println("You Already Voted");
            return;
        }
        System.out.print("Enter the Serial No: ");
        String serial = scanner.nextLine();
        candidate.countVote(serial,scanner);
        System.out.println("Vote Complete");
        notVoted.set(notVoted.indexOf(username), "0");
    }
}