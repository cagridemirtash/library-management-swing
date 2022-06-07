package business.abstracts;

import entities.Book;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface Operations {
   public void AddBook  (Book book) throws IOException;
   public void DeleteBook(int id) throws IOException;
   public Book GetBookById(int id) throws IOException;
   public List<Book> GetAllBook() throws IOException;
   public int lastIndex() throws IOException;
   public double avgFileNumber(List<Book>list);
   public int sumPageNumber(List<Book>list);
   public int  bookCount(List<Book>list);
}
