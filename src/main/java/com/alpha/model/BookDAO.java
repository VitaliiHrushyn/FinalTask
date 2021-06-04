package com.alpha.model;

import com.alpha.model.entity.Book;

import java.io.IOException;
import java.util.List;

public interface BookDAO {
	List<Book> getBooksList() throws IOException;
	void saveBooks(List<Book> books);
}
