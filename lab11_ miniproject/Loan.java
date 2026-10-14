;


import java.time.LocalDate;

/** One borrowing event: who has which item and when it is due. */
public class Loan {
    private final Member member;
    private final LibraryItem item;
    private final LocalDate borrowedOn;
    private final LocalDate dueDate;

    public Loan(Member member, LibraryItem item, LocalDate borrowedOn) {
        this.member = member;
        this.item = item;
        this.borrowedOn = borrowedOn;
        this.dueDate = borrowedOn.plusDays(item.loanPeriodDays());   // polymorphic call
    }

    /** Used when reloading from CSV where the due date is already known. */
    public Loan(Member member, LibraryItem item, LocalDate borrowedOn, LocalDate dueDate) {
        this.member = member;
        this.item = item;
        this.borrowedOn = borrowedOn;
        this.dueDate = dueDate;
    }

    public Member getMember()       { return member; }
    public LibraryItem getItem()    { return item; }
    public LocalDate getBorrowedOn() { return borrowedOn; }
    public LocalDate getDueDate()   { return dueDate; }

    public boolean isOverdue(LocalDate today) { return today.isAfter(dueDate); }

    @Override
    public String toString() {
        return item.getTitle() + " -> " + member.getName() + " (due " + dueDate + ")";
    }
}

