package com.alpha.model;

import com.alpha.model.entity.Book;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

public class BookFileDAO implements BookDAO {
	private ObjectMapper mapper = new ObjectMapper();
	private File file = Paths.get("resources\\Library.txt").toFile();

	public List<Book> getBooksList() throws IOException {
			return  mapper.readValue(file, mapper.getTypeFactory().constructCollectionType(List.class, Book.class));
	}

	@Override
	public void saveBooks(List<Book> books) {
		try {
			mapper.writeValue(file, books);
		} catch (IOException e) {
			//TODO handle exception
			e.printStackTrace();
		}
	}

}
