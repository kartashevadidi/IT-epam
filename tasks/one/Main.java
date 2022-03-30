package by.epam.tr.tasks.one;

import by.epam.tr.tasks.one.models.Customer;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomersDataAccess customersDataAccess = new CustomersDataAccess();
        customersDataAccess.addCustomer(new Customer("Test 1", "Test 1", "Test 1", "Test address 1", "1111 1111 1111 1111", "1234"));
        customersDataAccess.addCustomer(new Customer("Test 2", "Test 2", "Test 2", "Test address 2", "2222 2222 2222 2222", "5678"));
        customersDataAccess.addCustomer(new Customer("Test 3", "Test 3", "Test 3", "Test address 3", "3333 3333 3333 3333", "1345"));
        customersDataAccess.addCustomer(new Customer("Test 4", "Test 4", "Test 4", "Test address 4", "4444 4444 4444 4444", "5654"));
        customersDataAccess.addCustomer(new Customer("Test 5", "Test 5", "Test 5", "Test address 5", "4444 5555 6666 7777", "5654"));
        customersDataAccess.addCustomer(new Customer("Test 6", "Test 6", "Test 6", "Test address 6", "1122 3344 5566 7788", "5654"));

        while (true) {
            printMenu();
            int userOption = userOptionInput(scanner);

            switch (userOption) {
                case 1:
                    addCustomer(customersDataAccess, scanner);
                    System.out.println();
                    break;
                case 2:
                    getCustomersSortedByName(customersDataAccess);
                    break;
                case 3:
                    getCustomersInCardInterval(customersDataAccess, scanner).forEach(System.out::println);
                    break;
                case 4:
                    getCustomers(customersDataAccess);
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please, chose valid options from menu");
                    break;
            }
            System.out.println("\n\n");
        }

    }

    private static void printMenu() {
        System.out.println("============== Menu ==============");
        System.out.println("Press 1 to add new Customer object\n" +
                "Press 2 to get Customers sorted by name\n" +
                "Press 3 to get Customers in card number interval\n" +
                "Press 4 to get Customers list\n" +
                "Press 0 to exit");
    }

    private static int userOptionInput(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            scanner.nextLine();
            System.out.println("Please, choose valid option");
        }
        return scanner.nextInt();
    }

    private static void getCustomers(CustomersDataAccess customersDataAccess) {
        if (customersDataAccess.getCustomers().size() == 0) {
            System.out.println("There is no data to show.");
        } else {
            customersDataAccess.getCustomers().forEach(System.out::println);
        }
    }

    private static void getCustomersSortedByName(CustomersDataAccess customersDataAccess) {
        if (customersDataAccess.getCustomers().size() == 0) {
            System.out.println("There is no data to show.");
        } else {
            customersDataAccess.getSortedByName().forEach(System.out::println);
        }
    }

    private static void addCustomer(CustomersDataAccess customersDataAccess, Scanner scanner) {
        scanner.nextLine();
        Customer customer = new Customer();

        System.out.print("Enter surname: ");
        customer.setSurname(scanner.nextLine());

        System.out.print("Enter name: ");
        customer.setName(scanner.nextLine());

        System.out.print("Enter patronymic: ");
        customer.setPatronymic(scanner.nextLine());

        System.out.print("Enter address: ");
        customer.setAddress(scanner.nextLine());

        cardNumberValidation(scanner);

        System.out.print("Enter bank account number: ");
        customer.setBankAccountNumber(scanner.nextLine());

        customersDataAccess.addCustomer(customer);

        System.out.print("Customer successfully added");
    }

    private static String cardNumberValidation(Scanner scanner) {
        boolean isValid = false;
        String cardNumber = null;
        while (!isValid) {
            System.out.print("Enter card number (XXXX XXXX XXXX XXXX): ");
            cardNumber = scanner.nextLine();
            List<String> splitted = Arrays.asList(cardNumber.split(" "));
            if (splitted.size() != 4) {
                System.out.println("Invalid card number format. Please try again");
            } else if (!splitted.stream().allMatch(s -> s.length() == 4)) {
                System.out.println("Invalid card number format. Please try again");
            } else {
                isValid = true;
            }
        }
        return cardNumber;
    }

    private static List<Customer> getCustomersInCardInterval(CustomersDataAccess customersDataAccess, Scanner scanner) {
        scanner.nextLine();
        System.out.print("Enter interval value FROM (XXXX XXXX XXXX XXXX): ");
        String from = scanner.nextLine();

        System.out.print("Enter interval value TO (XXXX XXXX XXXX XXXX): ");
        String to = scanner.nextLine();

        return customersDataAccess.getCustomersInCardInterval(from, to);
    }

}
