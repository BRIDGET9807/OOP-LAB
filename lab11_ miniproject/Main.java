package lab11_ miniproject;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

/** Console menu for the Library Management System. */
public class Main {
    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        LibraryStorage storage = new LibraryStorage("data");
        Library lib = storage.load();                     // reload previous run
        System.out.println("Loaded " + lib.getItems().size() + " items, "
                + lib.getMembers().size() + " members, " + lib.getLoans().size() + " loans.");

        boolean running = true;
        while (running) {
            printMenu();
            String choice = in.nextLine().trim();
            try {
                switch (choice) {
                    case "1" -> addItem(lib);
                    case "2" -> registerMember(lib);
                    case "3" -> borrow(lib);
                    case "4" -> giveBack(lib);
                    case "5" -> listOverdue(lib);
                    case "6" -> search(lib);
                    case "7" -> lib.getItems().forEach(System.out::println);
                    case "8" -> lib.getMembers().forEach(System.out::println);
                    case "0" -> running = false;
                    default  -> System.out.println("Unknown option.");
                }
            } catch (ItemNotAvailableException | MemberLimitExceededException e) {
                System.out.println("Cannot borrow: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        storage.save(lib);                                // persist on exit
        System.out.println("Data saved. Goodbye!");
    }

    private static void printMenu() {
        System.out.println("""

                ===== LIBRARY MENU =====
                1) Add item        5) List overdue
                2) Register member 6) Search by title
                3) Borrow          7) List all items
                4) Return          8) List members
                0) Save and exit""");
        System.out.print("Choice: ");
    }

    private static String ask(String prompt) {
        System.out.print(prompt + ": ");
        return in.nextLine();
    }

    private static void addItem(Library lib) {
        String type = ask("Type (book/dvd)").trim().toLowerCase();
        String id = ask("Id");
        String title = ask("Title");
        if (type.equals("book")) {
            lib.addItem(new Book(id, title, ask("Author")));
        } else if (type.equals("dvd")) {
            int minutes;
            try {
                minutes = Integer.parseInt(ask("Running time (minutes)").trim());
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Minutes must be a number");
            }
            lib.addItem(new Dvd(id, title, minutes));
        } else {
            throw new IllegalArgumentException("Type must be 'book' or 'dvd'");
        }
        System.out.println("Item added.");
    }

    private static void registerMember(Library lib) {
        lib.registerMember(new Member(ask("Member id"), ask("Name")));
        System.out.println("Member registered.");
    }

    private static void borrow(Library lib) throws ItemNotAvailableException, MemberLimitExceededException {
        Loan loan = lib.borrow(ask("Member id"), ask("Item id"));
        System.out.println("Borrowed. " + loan);
    }

    private static void giveBack(Library lib) {
        lib.giveBack(ask("Item id"));
        System.out.println("Item returned.");
    }

    private static void listOverdue(Library lib) {
        List<Loan> overdue = lib.overdueLoans(LocalDate.now());
        if (overdue.isEmpty()) System.out.println("No overdue items.");
        else overdue.forEach(System.out::println);
    }

    private static void search(Library lib) {
        List<LibraryItem> found = lib.searchByTitle(ask("Search text"));
        if (found.isEmpty()) System.out.println("No matches.");
        else found.forEach(System.out::println);
    }
}

