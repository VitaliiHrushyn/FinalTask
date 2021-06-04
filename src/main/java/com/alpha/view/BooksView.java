package com.alpha.view;

import com.alpha.model.entity.Book;
import java.util.List;

public class BooksView {

	public void printMessage(String message) {
		System.out.print(message);
	}

	public void printListBooks(List<Book> books) {
		if (books.size() == 0) {
			System.out.println("No books found");

		} else {
			printTableHeader();
			for (Book book : books) {
				System.out.println(convertBookToString(book));
			}
		}
	}

	private void printTableHeader() {
		for (int i = 0; i < 105; i++) {
			System.out.print("-");
		}
		System.out.println();
		System.out.println(String.format("%-23s | %-30s | %-20s | %-5s | %-5s | %-10s",
				"Author",
				"Title",
				"Publisher",
				"Year",
				"Pages",
				"Price"));
		for (int i = 0; i < 105; i++) {
			System.out.print("-");
		}
		System.out.println();
	}

	private String convertBookToString(Book book) {
		return String.format("%-23s | %-30s | %-20s | %-5d | %-5d | %-8.2f",
								book.getAuthor(),
								book.getTitle(),
								book.getPublisher(),
								book.getYear(),
								book.getCountPages(),
								book.getPrice());
	}

	public void printMenu() {
		System.out.println(
				"---------------------\n" +
				"1 - Get list of books\n" +
				"2 - Add new book\n" +
				"3 - Change books cost\n" +
				"4 - Find book\n" +
				"0 - Exit"
		);
	}

	public void printNewBook(Book book) {
		System.out.println("Added new book:");
		printTableHeader();
		System.out.println(convertBookToString(book));
	}
}
