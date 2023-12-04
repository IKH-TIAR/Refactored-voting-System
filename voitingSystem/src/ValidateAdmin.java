import java.util.Scanner;

class ValidateAdmin {
   AdminCredentials adminCredentials = new AdminCredentials();
    public boolean validateAdminCredentials(Scanner scanner) {
        adminCredentials.setUsername("admin");
        adminCredentials.setPassword("admin pass");
        System.out.print("Enter Username: ");
        String enteredUsername = scanner.nextLine();
        if (enteredUsername.equals(adminCredentials.getUsername())) {
            System.out.print("Enter Password: ");
            String enteredPassword = scanner.nextLine();
            return enteredPassword.equals(adminCredentials.getPassword());
        }
        return false;
    }
}
