package com.alpha.model;

import com.alpha.controller.BooksController;
import com.alpha.model.entity.Book;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ServiceBooks {
	private static final Logger logger = LogManager.getLogger(ServiceBooks.class);

	private List<Book> bookList;
	private BookDAO bookDAO;

	public ServiceBooks(BookDAO bookDAO) throws IOException {
		this.bookDAO = bookDAO;
		this.bookList = bookDAO.getBooksList();
	}

	public List<Book> getBookList() {
		return new ArrayList<>(bookList);
	}

	public Book addBook(String name, String author, String publisher, int year, int countPages, double price) {
		Book newBook = new Book(name, author, publisher, year, countPages, price);
		bookList.add(newBook);
		logger.info("Created new book: {}", newBook);
		return newBook;
	}

	public void changePrice(int percents) {
		bookList.stream().forEach(book -> book.setPrice(book.getPrice() + book.getPrice() * percents / 100.0));
		logger.info("Books price change to {} percents", percents);
	}

	public List<Book> findBooks(String param) {
		return bookList.stream().filter(book -> isEqualsToParam(book, param)).collect(Collectors.toList());
	}

	private boolean isEqualsToParam(Book book, String param) {
		if (book.getAuthor().toUpperCase().contains(param.toUpperCase())) return true;
		if (book.getPublisher().equalsIgnoreCase(param)) return true;
		try {
			if (book.getYear() >= Integer.valueOf(param)) return true;
		} catch (NumberFormatException ex) {/* it was not an integer */}

		return false;
	}

	public void saveBooks() {
		bookDAO.saveBooks(bookList);
	}
}
