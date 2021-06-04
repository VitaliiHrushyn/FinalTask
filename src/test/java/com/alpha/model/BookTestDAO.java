package com.alpha.model;

import com.alpha.model.entity.Book;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BookTestDAO implements BookDAO {
	@Override
	public List<Book> getBooksList() throws IOException {
		List<Book> bookList = new ArrayList<>();
		bookList.add(new Book("Kobzar", "Taras Shevchenko", "Osvita", 2000, 358, 400.0));
		bookList.add(new Book("Lisova pisnia", "Lesia Ukrainka", "Barvinok", 1999, 221, 193.0));
		bookList.add(new Book("Zakhar Berkut", "Ivan Franko", "NashFormat", 2001, 145, 168.5));
		bookList.add(new Book("Toreadors from Vasiukivka", "Vsevelod Nestaiko", "Ranok", 2003, 285, 175.0));
		bookList.add(new Book("Nights near Dikanka", "Mykola Gogol", "Ranok", 1999, 235, 112.9));
		bookList.add(new Book("Black Council", "Panteleimon Kulish", "Osvita", 1998, 321, 155.3));
		bookList.add(new Book("Eneida", "Ivan Kotliarevskyi", "NashFormat", 2004, 201, 110.0));
		bookList.add(new Book("Fata morgana", "Mykhailo Kotsiubynskyi", "Teza", 2006, 156, 100.0));
		bookList.add(new Book("Marusia Churai", "Lina Kostenko", "A-ba-ba-ha-la-ma-ha", 2000, 100, 68.9));
		bookList.add(new Book("One hundred thousand", "Ivan Karpenko-Karyi", "Folio", 2007, 358, 225.5));
		bookList.add(new Book("Kaidash's family", "Ivan Nechui-Levytskyi", "Barvinok", 2008, 233, 134.5));
		return bookList;
	}

	@Override
	public void saveBooks(List<Book> books) {

	}
}
