package lab11_ miniproject;

    
public abstract class LibraryItem implements Borrowable {
    private final String id;
    private final String title;
    private boolean available = true;

    protected LibraryItem(String id, String title) {
        if (id == null || id.isBlank())       throw new IllegalArgumentException("id required");
        if (title == null || title.isBlank()) throw new IllegalArgumentException("title required");
        this.id = id.trim();
        this.title = title.trim();
    }

    /** Each subclass decides its own loan period (polymorphism). */
    public abstract int loanPeriodDays();

    /** Short type name used in CSV files and listings, e.g. "BOOK". */
    public abstract String type();

    /** Extra field stored in the CSV (author, minutes ...). */
    public abstract String extra();

    public String getId()        { return id; }
    public String getTitle()     { return title; }
    public boolean isAvailable() { return available; }
    void setAvailable(boolean available) { this.available = available; }

    @Override
    public void borrow(Member member) throws ItemNotAvailableException {
        if (!available) {
            throw new ItemNotAvailableException("'" + title + "' is already on loan");
        }
        available = false;
    }

    @Override
    public void giveBack() { available = true; }

    @Override
    public String toString() {
        return String.format("[%s] %s: %s (%s) - %s",
                type(), id, title, extra(), available ? "available" : "on loan");
    }
}

