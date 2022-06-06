package business.abstracts;

import entities.Book;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface Operations {
   public void AddBook  (Book book) throws IOException;
   public void DeleteBook(int id);
   public Book GetBookById(int id);
   public List<Book> GetAllBook() throws IOException;
   public int lastIndex() throws IOException;
}
