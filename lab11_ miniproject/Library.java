package lab11_ miniproject;

import java.time.LocalDate;
import java.util.*;


public class Library {
    private final Map<String, LibraryItem> items = new HashMap<>();
    private final Map<String, Member> members = new HashMap<>();
    private final List<Loan> loans = new ArrayList<>();

    // ---------- adding things ----------
    public void addItem(LibraryItem item) {
        if (items.containsKey(item.getId()))
            throw new IllegalArgumentException("Item id already exists: " + item.getId());
        items.put(item.getId(), item);
    }

    public void registerMember(Member member) {
        if (members.containsKey(member.getId()))
            throw new IllegalArgumentException("Member id already exists: " + member.getId());
        members.put(member.getId(), member);
    }

    // ---------- borrow / return ----------
    public Loan borrow(String memberId, String itemId, LocalDate today)
            throws ItemNotAvailableException, MemberLimitExceededException {
        Member member = members.get(memberId);
        if (member == null) throw new IllegalArgumentException("No such member: " + memberId);
        LibraryItem item = items.get(itemId);
        if (item == null) throw new IllegalArgumentException("No such item: " + itemId);

        if (!member.canBorrow()) {
            throw new MemberLimitExceededException(member.getName() + " already has "
                    + Member.MAX_LOANS + " loans");
        }
        item.borrow(member);                       // throws if already on loan
        Loan loan = new Loan(member, item, today);
        loans.add(loan);
        member.addLoan(loan);
        return loan;
    }

    public Loan borrow(String memberId, String itemId)
            throws ItemNotAvailableException, MemberLimitExceededException {
        return borrow(memberId, itemId, LocalDate.now());
    }

    public void giveBack(String itemId) {
        Loan loan = loans.stream()
                .filter(l -> l.getItem().getId().equals(itemId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Item is not on loan: " + itemId));
        loan.getItem().giveBack();
        loan.getMember().removeLoan(loan);
        loans.remove(loan);
    }

    // ---------- queries (streams) ----------
    public List<LibraryItem> searchByTitle(String text) {
        return items.values().stream()
                .filter(i -> i.getTitle().toLowerCase().contains(text.toLowerCase()))
                .sorted(Comparator.comparing(LibraryItem::getTitle))
                .toList();
    }

    public List<Loan> overdueLoans(LocalDate today) {
        return loans.stream()
                .filter(l -> l.isOverdue(today))
                .sorted(Comparator.comparing(Loan::getDueDate))
                .toList();
    }

    // ---------- read-only views used by the menu and the storage class ----------
    public Collection<LibraryItem> getItems()   { return Collections.unmodifiableCollection(items.values()); }
    public Collection<Member> getMembers()      { return Collections.unmodifiableCollection(members.values()); }
    public List<Loan> getLoans()                { return Collections.unmodifiableList(loans); }
    public LibraryItem findItem(String id)      { return items.get(id); }
    public Member findMember(String id)         { return members.get(id); }

    /** Used only when reloading from disk (the item is already marked unavailable). */
    void restoreLoan(Loan loan) {
        loans.add(loan);
        loan.getMember().addLoan(loan);
        loan.getItem().setAvailable(false);
    }
}

    

