package lab11_ miniproject;

import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDate;

/** Plain-Java self-check **/
public class LibraryTest {
    private static int failures = 0;

    private static void check(String name, boolean ok) {
        System.out.println((ok ? "PASS  " : "FAIL  ") + name);
        if (!ok) failures++;
    }

    public static void main(String[] args) throws Exception {
        Library lib = new Library();
        lib.addItem(new Book("B1", "Clean Code", "Robert Martin"));
        lib.addItem(new Book("B2", "Effective Java", "Joshua Bloch"));
        lib.addItem(new Book("B3", "Java Concurrency", "Brian Goetz"));
        lib.addItem(new Dvd("D1", "The Matrix", 136));
        lib.registerMember(new Member("M1", "Tariro"));
        lib.registerMember(new Member("M2", "Farai"));

        LocalDate day = LocalDate.of(2026, 1, 1);

        // polymorphism: different loan periods
        check("Book loan = 14 days", lib.findItem("B1").loanPeriodDays() == 14);
        check("Dvd loan = 7 days",   lib.findItem("D1").loanPeriodDays() == 7);

        // borrow ok
        lib.borrow("M1", "B1", day);
        check("Item becomes unavailable", !lib.findItem("B1").isAvailable());

        // already on loan
        try { lib.borrow("M2", "B1", day); check("ItemNotAvailableException thrown", false); }
        catch (ItemNotAvailableException e) { check("ItemNotAvailableException thrown", true); }

        // limit of 3
        lib.borrow("M1", "B2", day);
        lib.borrow("M1", "B3", day);
        try { lib.borrow("M1", "D1", day); check("MemberLimitExceededException thrown", false); }
        catch (MemberLimitExceededException e) { check("MemberLimitExceededException thrown", true); }

        // unknown ids
        try { lib.borrow("NOPE", "B1", day); check("Unknown member rejected", false); }
        catch (IllegalArgumentException e) { check("Unknown member rejected", true); }

        // overdue (book due Jan 15)
        check("Not overdue on Jan 10", lib.overdueLoans(LocalDate.of(2026, 1, 10)).isEmpty());
        check("3 overdue on Feb 1",   lib.overdueLoans(LocalDate.of(2026, 2, 1)).size() == 3);

        // search (streams)
        check("Search 'java' finds 2", lib.searchByTitle("java").size() == 2);

        // return
        lib.giveBack("B1");
        check("Returned item available again", lib.findItem("B1").isAvailable());

        // persistence round trip
        Path tmp = Files.createTempDirectory("librarytest");
        LibraryStorage storage = new LibraryStorage(tmp.toString());
        storage.save(lib);
        Library reloaded = storage.load();
        check("Reload keeps items",   reloaded.getItems().size() == 4);
        check("Reload keeps members", reloaded.getMembers().size() == 2);
        check("Reload keeps loans",   reloaded.getLoans().size() == 2);
        check("Reload keeps availability", !reloaded.findItem("B2").isAvailable()
                && reloaded.findItem("B1").isAvailable());

        System.out.println(failures == 0 ? "\nAll tests passed." : "\n" + failures + " test(s) failed.");
        if (failures > 0) System.exit(1);
    }
}

