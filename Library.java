package librarysystem.models;

import java.util.ArrayList;
import java.util.HashMap;

public class Library {
	private ArrayList<Book> books = new ArrayList<>();
	private ArrayList<Member> members = new ArrayList<>();
	private HashMap<Integer, Integer> issuedBooks = new HashMap<>();

	public void addBook(Book book) {
		books.add(book);
		System.out.println("Book added: " + book);
	}

	public void addMember(Member member) {
		members.add(member);
		System.out.println("Member added: " + member);
	}

	public void issueBook(int bookId, int memberId) {
		for (Book book : books) {
			if (book.getId() == bookId && !book.isIssued()) {
				book.issue();
				issuedBooks.put(bookId, memberId);
				System.out.println("Book '" + book.getTitle() + "' issued to " + getMemberName(memberId));
				return;
			}
		}
		System.out.println("Book not available or already issued!");
	}

	public void returnBook(int bookId) {
		for (Book book : books) {
			if (book.getId() == bookId && book.isIssued()) {
				book.returnBook();
				issuedBooks.remove(bookId);
				System.out.println("Book returned: " + book.getTitle());
				return;
			}
		}
		System.out.println("Invalid return operation!");
	}

	public void showBooks() {
		System.out.println("\n--- Library Books ---");
		for (Book book : books) {
			System.out.println(book);
		}
	}

	private String getMemberName(int memberId) {
		for (Member member : members) {
			if (member.getId() == memberId)
				return member.getName();
		}
		return "Unknown Member";
	}
}
