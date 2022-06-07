import entities.Book;

import javax.swing.*;
import java.awt.*;

public class BookRenderer extends JLabel implements ListCellRenderer<Book> {
    @Override
    public Component getListCellRendererComponent(JList<? extends Book> list, Book book, int index, boolean isSelected, boolean cellHasFocus) {
        setText(String.format("Id:%d      Name:%s     Author:%s    PageNumber:%d    Topic:%s",book.getId(),book.getBookName(),book.getBookAuthor(),book.getPageNumber(),book.getBookTopic()));
        return this;
    }
}
