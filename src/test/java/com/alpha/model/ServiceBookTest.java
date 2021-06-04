package com.alpha.model;

import com.alpha.model.entity.Book;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class ServiceBookTest {
	private static ServiceBooks serviceBooks;

	@BeforeClass
	public static void beforeClass() {
		try {
			serviceBooks = new ServiceBooks(new BookTestDAO());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetBookList() {
		List<Book> books = serviceBooks.getBookList();
		Assert.assertNotNull("bookList does not exist", books);
	}

	@Test
	public void testChangePrice() {
		serviceBooks.changePrice(100);
		Book book = serviceBooks.findBooks("Shevchenko").get(0);
		Assert.assertEquals( 800.0, book.getPrice(),0.001);
	}

	@Test
	public void testFindBooks() {
		serviceBooks.changePrice(100);
		Book book = serviceBooks.findBooks("Shevchenko").get(0);
		Assert.assertEquals("Kobzar", book.getTitle());
	}

	@Test
	public void testAddBook() {
		serviceBooks.addBook("New Book", "New Author", "Osvita", 2000, 111, 111.0);
		Assert.assertEquals(12, serviceBooks.getBookList().size());
	}

}
