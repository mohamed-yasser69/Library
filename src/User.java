import java.util.ArrayList;
import java.util.List;

/**
 * Step 2 & 3: Abstract base for all library users.
 * showRole() and getBorrowLimit() are abstract -> each subclass
 * (Student, Teacher, Librarian...) must define its own behavior.
 * This is the polymorphism hook used for borrowing limits (Page 10)
 * and role display (Page 3).
 */
public abstract class User {
    private int userId;
    private String userName;
    private List<Book> borrowedBooks = new ArrayList<>();

    public User(int userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }


    public abstract String showRole();


    public abstract int getBorrowLimit();

    public boolean canBorrowMore() {
        return borrowedBooks.size() < getBorrowLimit();
    }

    public void addBorrowedBook(Book book) {
        borrowedBooks.add(book);
    }

    public void removeBorrowedBook(Book book) {
        borrowedBooks.remove(book);
    }

    @Override
    public String toString() {
        return "[" + userId + "] " + userName + " - Role: " + showRole()
                + " - Books borrowed: " + borrowedBooks.size() + "/" + getBorrowLimit();
    }
}
