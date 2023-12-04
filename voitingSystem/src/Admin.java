import java.util.Scanner;

public class Admin {
    private final ValidateAdmin validateAdmin = new ValidateAdmin();
    private final Candidate candidate = new Candidate();
    static String winner = "No Winner Selected";

    private final Scanner scanner = new Scanner(System.in);

    public void login() {
        if (validateAdmin.validateAdminCredentials(scanner)) {
            manageAdminActions();
        }
    }

    private void manageAdminActions() {
        while (true) {
            displayAdminMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    candidate.setCandidates(scanner);
                    pressAnyKeyToContinue();
                    break;
                case 2:
                    candidate.viewCandidates();
                    pressAnyKeyToContinue();
                    break;
                case 3:
                    candidate.removeCandidate();
                    pressAnyKeyToContinue();
                    break;
                case 4:
                    candidate.viewVote();
                    pressAnyKeyToContinue();
                    break;
                case 5:
                    setWinner();
                    pressAnyKeyToContinue();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid Input");
            }
        }
    }

    private void displayAdminMenu() {
        System.out.println("-------------------------");
        System.out.println("1. Set Candidate");
        System.out.println("2. View Candidate");
        System.out.println("3. Remove Candidate");
        System.out.println("4. View All Vote");
        System.out.println("5. Declare Winner");
        System.out.println("6. Logout");
        System.out.println("-------------------------");
        System.out.print("Enter Your Choice: ");
    }

    private void pressAnyKeyToContinue() {
        System.out.print("Press Any Key And Enter: ");
        scanner.next();
    }

    private void setWinner() {
        if (candidate.serialNumbers.isEmpty()) {
            System.out.println("No Candidate Is Selected");
            return;
        }
        System.out.print("Enter The Serial of The Winner: ");
        String serial1 = scanner.nextLine();
        if (candidate.serialNumbers.contains(serial1)) {
            int index = candidate.serialNumbers.indexOf(serial1);
            System.out.println("The Selected Winner Is: " + candidate.candidateNames.get(index));
            winner = candidate.candidateNames.get(index);
        }
    }

    public void printWinner() {
        System.out.println(winner);
    }
}