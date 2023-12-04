import java.util.ArrayList;
import java.util.Scanner;

class Candidate {
    public static ArrayList<String> serialNumbers = new ArrayList<>();
    public static ArrayList<Integer> voteList = new ArrayList<>();
    public static ArrayList<String> candidateNames = new ArrayList<>();

    public void setCandidates(Scanner scanner) {
        int numberOfCandidates = inputNumberOfCandidates(scanner);
        inputCandidateInfo(scanner, numberOfCandidates);
    }

    private int inputNumberOfCandidates(Scanner scanner) {
        System.out.print("How Many Candidate To Input: ");
        return scanner.nextInt();
    }

    private void inputCandidateInfo(Scanner scanner, int numberOfCandidates) {
        int i = 1;
        scanner.nextLine(); // consume newline
        while (numberOfCandidates != 0) {
            System.out.print("Enter Serial for Candidate " + i + " : ");
            String serial = scanner.nextLine();
            System.out.print("Enter Name For Candidate " + i + " : ");
            String name = scanner.nextLine();
            serialNumbers.add(serial);
            candidateNames.add(name);
            voteList.add(0);
            i++;
            numberOfCandidates--;
        }
    }

    public void viewCandidates() {
        if (serialNumbers.isEmpty()) {
            System.out.println("No Candidate Is Selected");
            return;
        }
        for (int i = 0; i < serialNumbers.size(); i++) {
            System.out.print("Candidate Serial: " + serialNumbers.get(i));
            System.out.println("  Candidate Name: " + candidateNames.get(i));
        }
    }

    public void viewVote() {
        if (voteList.isEmpty()) {
            System.out.println("No Candidate Is Selected");
            return;
        }
        for (int i = 0; i < voteList.size(); i++) {
            System.out.print("Serial: " + serialNumbers.get(i) + " Name: " + candidateNames.get(i) + " Total Vote: ");
            System.out.println(voteList.get(i));
        }
    }

    public void countVote(String serial, Scanner scanner){
        int index= serialNumbers.indexOf(serial);
        System.out.println("You Want To Vote "+ candidateNames.get(index));
        System.out.print("If YES Press 1: ");
        String choice =scanner.nextLine();
        if(!choice.equals("1")){
            return;
        }
        int value = voteList.get(index);
        value+=1;
        voteList.set(index,value);
    }

    public void removeCandidate() {
        if (serialNumbers.isEmpty()) {
            System.out.println("No Candidate Is Selected");
            return;
        }
        System.out.print("Enter The Serial No Of The Candidate: ");
        Scanner scanner = new Scanner(System.in);
        String serial1 = scanner.nextLine();
        if (serialNumbers.contains(serial1)) {
            int index = serialNumbers.indexOf(serial1);
            serialNumbers.remove(serial1);
            voteList.remove(index);
            System.out.println("Removed Candidate " + candidateNames.get(index));
            candidateNames.remove(index);
        }
    }

}
