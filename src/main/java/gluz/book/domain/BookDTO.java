package gluz.book.domain;

import gluz.author.domain.Author;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class BookDTO {

    private int id;
    private String name;
    private String isbn;
    private int totalPages;
    private String gender;
    private int authorID;

    public Book handleBuildDTO(){
        Author author = new Author();
        Book book = new Book();
        book.setName(this.getName());
        book.setIsbn(this.getIsbn());
        book.setGender(this.getGender());
        book.setTotalPages(this.getTotalPages());
        author.setId(this.getAuthorID());
        book.setAuthor(author);
        return book;
    }
}
