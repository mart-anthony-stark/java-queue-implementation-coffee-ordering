import java.util.*;

public class Main {
    static Deque<Customer> customers = new ArrayDeque<Customer>();
    static Queue<Customer> orderHistory = new ArrayDeque<Customer>();
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        // WELCOME SCREEN
        System.out.println("\t\t  ___   __   ____  ____  ____        __     __   __ _   ___ \r\n" +
                "\t\t / __) / _\\ (  __)(  __)(  __) ___  (  )   (  ) (  ( \\ / __)\r\n" +
                "\t\t( (__ /    \\ ) _)  ) _)  ) _) (___) / (_/\\  )(  /    /( (_ \\\r\n" +
                "\t\t \\___)\\_/\\_/(__)  (__)  (____)      \\____/ (__) \\_)__) \\___/");
        System.out.println("\t\t  ___   __   ____  ____  ____  ____        ____  _  _   __   ____ \r\n" +
                "\t\t / __) /  \\ (  __)(  __)(  __)(  __)      / ___)/ )( \\ /  \\ (  _ \\\r\n" +
                "\t\t( (__ (  O ) ) _)  ) _)  ) _)  ) _)       \\___ \\) __ ((  O ) ) __/\r\n" +
                "\t\t \\___) \\__/ (__)  (__)  (____)(____)      (____/\\_)(_/ \\__/ (__)  ");
        System.out.println("                                         \r\n" +
                "\t\t\t              @@ @&  @                  \r\n" +
                "\t\t\t               .@  @  @.                \r\n" +
                "\t\t\t              @@ %@  @/                 \r\n" +
                "\t\t\t             @  @  /@                   \r\n" +
                "\t\t\t              @  @. @@                  \r\n" +
                "\t\t\t    @@@@@@@@@@@@@@@@@@@@@@@@@@@         \r\n" +
                "\t\t\t    @@                       @@@@@@@@@@ \r\n" +
                "\t\t\t    @@                       @@      /@.\r\n" +
                "\t\t\t     @(                     @@#      @@ \r\n" +
                "\t\t\t     @@                    *@@@     @@  \r\n" +
                "\t\t\t      /@@                 @@   @@@@/    \r\n" +
                "\t\t\t &@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@#      \r\n" +
                "\t\t\t   %@@.                     #@@*        \r\n" +
                "\t\t\t       (@@@@@@@@@@@@@@@@@@@,            ");

        while (true) {
            try {
                queueMethods();
            } catch (Exception e) {
                System.out.println("Invalid input! Something went wrong");

            }

            System.out.println("\t\t-------------------------------------------------\n\n");
        }
    }

    // METHOD FOR MANIPULATING CUSTOMER QUEUE
    static void queueMethods() {
        System.out.println("\t\t---------------------------------------------------");
        System.out.println("\t\t|                                                  |");
        System.out.println("\t\t|                                                  |");
        System.out.println("\t\t|  [1]  Add a Customer                             |");
        System.out.println("\t\t|                                                  |");
        System.out.println("\t\t|  [2]  Serve an Order                             |");
        System.out.println("\t\t|                                                  |");
        System.out.println("\t\t|  [3]  Remove a Customer                          |");
        System.out.println("\t\t|                                                  |");
        System.out.println("\t\t|  [4]  View Order History                         |");
        System.out.println("\t\t---------------------------------------------------");

        System.out.print("Enter operation: ");
        int choice = Integer.parseInt(scan.nextLine());

        switch (choice) {
            case 1:
                // INSERT CUSTOMER TO QUEUE
                System.out.print("Enter customer name: ");
                String name = scan.nextLine();
                Customer c = new Customer(name);
                customers.offerLast(c);
                System.out.println("\n\n");
                break;
            case 2:
                // COFFEE MENU()
                if (customers.size() != 0) {
                    coffeeMenu();
                } else {
                    System.out.println("\n\t\tCustomers queue is empty! Please enter customers names first\n\n");
                }
                break;
            case 3:
                // REMOVE CUSTOMER TO QUEUE
                if (customers.size() != 0) {
                    System.out.print("Enter customer name: ");
                    String customerName = scan.nextLine();
                    boolean exist = false;
                    for (Customer x : customers) {
                        if (x.getName().equalsIgnoreCase(customerName)) {
                            customers.remove(x);
                            exist = true;
                            System.out.println("Removed " + x.getName().toUpperCase() + " at the customers' queue");
                            break;
                        }
                    }
                    if (!exist)
                        System.out.println(customerName + " is not in the customers' queue");
                    System.out.println("\n\n");
                } else {
                    System.out.println("\n\t\tCustomers queue is empty! Please enter customers' names first\n\n");
                }
                break;
            case 4:
                // ORDER HISTORY
                if (!orderHistory.isEmpty())
                    showHistory();
                else
                    System.out.println("\n\t\tOrder History is Empty\n\n\n");
                break;
            default:
                System.out.println("Invalid input");
        }
        // ITERATE OVER QUEUE AND DISPLAY CUSTOMERS QUEUE
        System.out.println("\t\tCustomers in queue:");
        if (customers.size() == 0)
            System.out.println("\t\t\t\tEmpty");
        int i = 1;
        for (Customer x : customers) {
            System.out.println("\t\t" + i + ". " + x.getName());
            i++;
        }
    }

    // COFFEE MENU METHOD
    static void coffeeMenu() {
        try {
            boolean success = true;
            System.out.println("\t\t\t             MENU     \n" +
                    "\t\t\t[1]  Coffee Barako   ---------------- $15            \r\n" +
                    "\t\t\t[2]  Nescafe Black  ----------------- $25            \r\n" +
                    "\t\t\t[3]  Expresso Patronum  ------------- $55            \r\n" +
                    "\t\t\t[4]  Nimbus Coffee  ----------------- $20            \r\n" +
                    "\t\t\t[5]  Butter Brew  ------------------- $45            \r\n");
            Customer currentCustomer = customers.peekFirst();
            System.out.println("\t\tGood day! Sir/Ma'am " + currentCustomer.getName());
            System.out.print("Enter order: ");
            int order = Integer.parseInt(scan.nextLine());
            switch (order) {
                case 1:
                    currentCustomer.setOrder("Coffee Barako - $15    ");
                    currentCustomer.setPrice(15f);
                    break;
                case 2:
                    currentCustomer.setOrder("Nescafe Black - $25    ");
                    currentCustomer.setPrice(25f);
                    break;
                case 3:
                    currentCustomer.setOrder("Expresso Patronum - $55");
                    currentCustomer.setPrice(55f);
                    break;
                case 4:
                    currentCustomer.setOrder("Nimbus Coffee - $20    ");
                    currentCustomer.setPrice(20f);
                    break;
                case 5:
                    currentCustomer.setOrder("Butter Brew - $45      ");
                    currentCustomer.setPrice(45f);
                    break;
                default:
                    success = false;
                    break;
            }
            if (success) {
                System.out.println("Order: " + currentCustomer.getOrder());
                System.out.print("Enter payment: ");
                currentCustomer.setPayment(Float.parseFloat(scan.nextLine()));
                if (currentCustomer.getPayment() < currentCustomer.getPrice()) {
                    System.out.println("The amount you entered is insufficient");
                    coffeeMenu();
                } else {
                    currentCustomer.setChange((currentCustomer.getPayment() - currentCustomer.getPrice()));
                    System.out.println("\nYour change is $" + currentCustomer.getChange());
                    System.out.println("Please come again. Thank you!\n\n");
                    orderHistory.add(currentCustomer);
                    customers.pollFirst();
                }
            } else {
                System.out.println("Invalid input, please select from the menu");
                coffeeMenu();
            }
        } catch (Exception e) {
            System.out.println("Invalid input, please select from the menu");
            coffeeMenu();
        }
    }

    static void showHistory() {
        System.out.println("\n\t\t---------------------------------------------------");
        System.out.println("\t\t|                                                  |");
        System.out.println("\t\t|                   Order History                  |");
        System.out.println("\t\t|                                                  |");
        System.out.println("\t\t---------------------------------------------------\n");
        System.out.println("\t\tNo.    Name  |         Order           	 | Payment |");
        System.out.println("\t\t---------------------------------------------------\n");
        int i = 1;
        for (Customer x : orderHistory) {
            System.out.println(
                    "\t\t(" + i + ") " + x.getName() + "  \t" + x.getOrder() + "  \t" + x.getPayment() + "   ");
            i++;
        }
        System.out.println("\t\t---------------------------------------------------\n");
        System.out.println("\n\n");
    }
}

class Customer {
    private String name, order;
    private float price, payment, change;

    Customer(String name) {
        this.name = name;
    }

    String getOrder() {
        return this.order;
    }

    void setOrder(String order) {
        this.order = order;
    }

    String getName() {
        return this.name;
    }

    void setName(String name) {
        this.name = name;
    }

    float getPayment() {
        return this.payment;
    }

    void setPayment(float payment) {
        this.payment = payment;
    }

    float getPrice() {
        return this.price;
    }

    void setPrice(float price) {
        this.price = price;
    }

    float getChange() {
        return this.change;
    }

    void setChange(float change) {
        this.change = change;
    }
}