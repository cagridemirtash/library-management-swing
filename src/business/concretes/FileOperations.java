package business.concretes;

import business.abstracts.Operations;
import entities.Book;
import java.io.*;

import java.util.ArrayList;
import java.util.List;

public class FileOperations implements Operations {
    @Override
    public void AddBook(Book book) throws IOException {
        String line=book.getId()+","+book.getBookName()+","+book.getBookAuthor()+","+book.getPageNumber()+","+book.getBookTopic()+"\n";
        File file = new File("data.txt");
        FileWriter fileWriter=new FileWriter(file,true);
        BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
        bufferedWriter.write(line);
        bufferedWriter.close();


    }

    @Override
    public void DeleteBook(int id) {

    }

    @Override
    public Book GetBookById(int id) {
        return null;
    }

    @Override
    public List<Book> GetAllBook() throws IOException {
        String line;
        String[] tempLine;
        Book book;
        List<Book> list=new ArrayList<>();
        File file=new File("data.txt");
        FileReader fileReader=new FileReader(file);
        BufferedReader bufferedReader=new BufferedReader(fileReader);
        while((line=bufferedReader.readLine())!=null){
            book=new Book();
            tempLine=line.split(",");
            book.setId(Integer.parseInt(tempLine[0]));
            book.setBookName(tempLine[1]);
            book.setBookAuthor(tempLine[2]);
            book.setPageNumber(Integer.parseInt(tempLine[3]));
            book.setBookTopic(tempLine[4]);
            list.add(book);
            tempLine=null;
        }

        bufferedReader.close();
        return list;
    }

    public int lastIndex() throws IOException {

        int sonIndex=0;
        List<Book> list=GetAllBook();
        for (Book book :
                list) {
            if (book.getId() > sonIndex) {
                sonIndex= book.getId();
            }
        }
        return sonIndex+1;

    }
}