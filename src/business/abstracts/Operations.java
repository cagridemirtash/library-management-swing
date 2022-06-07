package business.abstracts;

import entities.Book;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface Operations {
   public void addBook  (Book book) throws IOException;
   public void deleteBook(int id) throws IOException;
   public Book getBookById(int id) throws IOException;
   public List<Book> getAllBook() throws IOException;
   public int lastIndex() throws IOException;
   public double avgFileNumber(List<Book>list);
   public int sumPageNumber(List<Book>list);
   public int  bookCount(List<Book>list);
}
