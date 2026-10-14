/** Anything that can be lent out. */
public interface Borrowable {
    void borrow(Member member) throws ItemNotAvailableException;
    void giveBack();
}
