package librarysystem.models;

public class Main {
	public static void main(String[] args) {
		Library library = new Library();

		// Add books
		library.addBook(new Book(1, "Java Programming", "James Gosling"));
		library.addBook(new Book(2, "Python Basics", "Guido van Rossum"));

		// Add members
		library.addMember(new Member(101, "Alice"));
		library.addMember(new Member(102, "Bob"));

		// Show all books
		library.showBooks();

		// Issue a book
		library.issueBook(1, 101);

		// Show books again
		library.showBooks();

		// Return a book
		library.returnBook(1);

		// Final book list
		library.showBooks();
	}
}