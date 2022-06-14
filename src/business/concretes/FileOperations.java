package business.concretes;

import business.abstracts.Operations;
import entities.Book;
import java.io.*;

import java.util.ArrayList;
import java.util.List;

public class FileOperations implements Operations {
    @Override
    public void addBook(Book book) throws IOException {
        String line=String.format("%d,%s,%s,%d,%s\n", book.getId(), book.getBookName(), book.getBookAuthor(), book.getPageNumber(), book.getBookTopic());
        File file = new File("data.txt");
        FileWriter fileWriter=new FileWriter(file,true);
        BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
        bufferedWriter.write(line);
        bufferedWriter.close();
    }

    @Override
    public void deleteBook(int id) throws IOException {
        List<Book> list=getAllBook();
        fileClear();
        for (Book book:list
             ) {
            if (book.getId()!=id){
              addBook(book);
            }
        }
    }

    @Override
    public Book getBookById(int id) throws IOException {
        List<Book> list=getAllBook();
        for (Book book:list
        ) {
            if (book.getId()==id){
                return book;
            }
        }
        return null;
    }

    @Override
    public List<Book> getAllBook() throws IOException {
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

    public void updateBook(Book book) throws IOException {
        List<Book> list=getAllBook();
        fileClear();
        for (Book newBook:list) {
            if (newBook.getId()!=book.getId()){
                addBook(newBook);
            }
            else{
                addBook(book);
            }
        }
    }

    public int lastIndex() throws IOException {
        int sonIndex=0;
        List<Book> list=getAllBook();
        for (Book book :
                list) {
            if (book.getId() > sonIndex) {
                sonIndex= book.getId();
            }
        }
        return sonIndex+1;

    }
    public double avgFileNumber(List<Book>list)  {
        List<Integer>numberList=new ArrayList<>();
        for (Book book :
                list) {numberList.add(book.getPageNumber());
        }

        return numberList.stream().mapToInt(a -> a).average().orElse(0);
    }
    public int sumPageNumber(List<Book>list)  {
        int sum=0;
        List<Integer>numberList=new ArrayList<>();
        for (Book book :
                list) {numberList.add(book.getPageNumber());
        }
        return numberList.stream().reduce(0, Integer::sum);
    }
    public int  bookCount(List<Book>list){
        return list.size();
    }
    private void fileClear() throws IOException {
        File file = new File("data.txt");
        FileWriter fileWriter=new FileWriter(file,false);
        BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
        bufferedWriter.write("");
        bufferedWriter.close();
    }

}
