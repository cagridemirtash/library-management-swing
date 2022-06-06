package entities;

public class Book {
    private int id;
    private String bookName;
    private String bookAuthor;
    private int pageNumber;
    private String bookTopic;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getBookTopic() {
        return bookTopic;
    }

    public void setBookTopic(String bookTopic) {
        this.bookTopic = bookTopic;
    }
}
