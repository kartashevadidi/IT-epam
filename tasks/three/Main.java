package by.epam.tr.tasks.three;

import by.epam.tr.tasks.three.models.Airline;
import by.epam.tr.tasks.three.models.AirplaneType;
import by.epam.tr.tasks.two.models.Cover;

import java.sql.Time;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        AirlinesDataAccess airlinesDataAccess = new AirlinesDataAccess();

        Set<Integer> days = new HashSet<>();
        days.add(1);
        days.add(2);
        days.add(3);
        days.add(4);
        days.add(6);
        days.add(7);

        airlinesDataAccess.addAirline(new Airline("1", "123", AirplaneType.BOEING, new Time(12, 34, 2), days));
        airlinesDataAccess.addAirline(new Airline("2", "123", AirplaneType.BOEING, new Time(14, 34, 2), days));
        airlinesDataAccess.addAirline(new Airline("3", "123", AirplaneType.BOEING, new Time(15, 34, 2), days));
        airlinesDataAccess.addAirline(new Airline("4", "123", AirplaneType.BOEING, new Time(16, 34, 2), days));
        airlinesDataAccess.addAirline(new Airline("5", "123", AirplaneType.BOEING, new Time(17, 34, 2), days));
        airlinesDataAccess.addAirline(new Airline("6", "123", AirplaneType.BOEING, new Time(18, 34, 2), days));

        while (true) {
            printMenu();
            int userOption = userOptionInput(scanner);

            switch (userOption) {
                case 1:
                    addAirline(scanner, airlinesDataAccess);
                    break;
                case 2:
                    getAirlinesByDestination(scanner, airlinesDataAccess);
                    break;
                case 3:
                    getAirlinesByDay(scanner, airlinesDataAccess);
                    break;
                case 4:
                    getAirlinesByDayTime(scanner, airlinesDataAccess);
                    break;
                case 5:
                    getAirlines(airlinesDataAccess);
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

    private static void getAirlinesByDayTime(Scanner scanner, AirlinesDataAccess airlinesDataAccess) {
        scanner.nextLine();
        System.out.print("Enter day: ");
        while (!scanner.hasNextInt()) {
            scanner.nextLine();
            System.out.println("Invalid value. Please try again");
        }
        int day = scanner.nextInt();
        System.out.print("Enter time (hh:MM:ss): ");
        Time time = validateTime(scanner);
        List<Airline> airlines = airlinesDataAccess.getAirlinesByDayTime(day, time);
        if (airlines.size() == 0) {
            System.out.println("there is no data to show");
        } else {
            airlines.forEach(System.out::println);
        }
    }

    private static void getAirlinesByDay(Scanner scanner, AirlinesDataAccess airlinesDataAccess) {
        scanner.nextLine();
        System.out.print("Enter day of the week (from 1 to 7): ");
        while (!scanner.hasNextInt()) {
            scanner.nextLine();
            System.out.println("Invalid value. Please try again");
        }
        int day = scanner.nextInt();
        List<Airline> airlines = airlinesDataAccess.getAirlinesByDay(day);
        if (airlines.size() == 0) {
            System.out.println("There is no data to show");
        } else {
            airlines.forEach(System.out::println);
        }
    }

    private static void getAirlinesByDestination(Scanner scanner, AirlinesDataAccess airlinesDataAccess) {
        scanner.nextLine();
        System.out.print("Enter destination: ");
        List<Airline> airlines = airlinesDataAccess.getAirlinesByDestination(scanner.nextLine());
        if (airlines.size() == 0) {
            System.out.println("There is no data to show");
        } else {
            airlines.forEach(System.out::println);
        }
    }

    private static void addAirline(Scanner scanner, AirlinesDataAccess airlinesDataAccess) {
        scanner.nextLine();
        Airline airline = new Airline();

        System.out.print("Enter destination: ");
        airline.setDestination(scanner.nextLine());

        System.out.print("Enter flightNumber: ");
        airline.setFlightNumber(scanner.nextLine());

        System.out.print("Enter airplane type (1 - BOEING, 2 - AIRBUS): ");
        airline.setPlaneType(validateAirplaneType(scanner));

        System.out.print("Enter time (hh:MM:ss): ");
        airline.setTime(validateTime(scanner));

        System.out.print("Enter days from 1 to 7 (if more than 1 enter separated by commas): ");
        airline.setDays(validateDays(scanner));

        airlinesDataAccess.addAirline(airline);

        System.out.println("Airline successfully added");

    }

    private static Set<Integer> validateDays(Scanner scanner) {
        boolean isValid = false;
        Set<Integer> days = null;
        while (!isValid) {
            String[] inputDays = scanner.nextLine().split(",");
            Integer[] daysArray = new Integer[inputDays.length];
            for (int i = 0; i < daysArray.length; i++) {
                daysArray[i] = Integer.parseInt(inputDays[i].trim());
            }
            List<Integer> listDays = Arrays.asList(daysArray);
            days = new HashSet<>(listDays);
            isValid = true;
            for (int d : days) {
                if (d <= 0 || d > 7) {
                    System.out.println("Invalid days value");
                    isValid = false;
                    break;
                }
            }
        }
        return days;
    }

    private static Time validateTime(Scanner scanner) {
        scanner.nextLine();
        boolean isValid = false;
        Time time = null;
        while (!isValid) {
            String[] inputTime = scanner.nextLine().split(":");
            if (inputTime.length != 3) {
                System.out.println("Invalid time format. Please try again");
            } else {
                try {
                    time = new Time(Integer.parseInt(inputTime[0]), Integer.parseInt(inputTime[1]), Integer.parseInt(inputTime[2]));
                    isValid = true;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid time format (to big value). Please try again");
                }
            }
        }
        return time;
    }

    private static AirplaneType validateAirplaneType(Scanner scanner) {
        boolean isValid = false;
        AirplaneType airplaneType = null;
        while (!isValid) {
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid Airplane type. Please try again");
                scanner.nextLine();
            }
            airplaneType = AirplaneType.getByCode(scanner.nextInt());
            if (airplaneType == null) {
                System.out.println("Invalid Airplane type. Please try again");
            } else {
                isValid = true;
            }
        }
        return airplaneType;
    }

    private static void printMenu() {
        System.out.println("============== Menu ==============");
        System.out.println("Press 1 to add Airline\n" +
                "Press 2 to get list of Airlines by destination\n" +
                "Press 3 to get list of Airlines by day of the week\n" +
                "Press 4 to get list of Airlines for a given day of the week and time of departure\n" +
                "Press 5 to get all Airlines\n" +
                "Press 0 to exit");
    }

    private static int userOptionInput(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            scanner.nextLine();
            System.out.println("Please, choose valid option");
        }
        return scanner.nextInt();
    }

    public static void getAirlines(AirlinesDataAccess airlinesDataAccess) {
        if (airlinesDataAccess.getAirlines().size() == 0) {
            System.out.println("There is no data to show.");
        } else {
            airlinesDataAccess.getAirlines().forEach(System.out::println);
        }
    }

}
