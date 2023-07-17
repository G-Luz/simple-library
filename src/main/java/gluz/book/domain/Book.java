package gluz.book.domain;


import gluz.author.domain.Author;
import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor

@Getter
@Setter

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String isbn;

    @Column(name = "totalpages")
    private int totalPages;
    private String gender;

    @JoinColumn(name = "authorid")
    @ManyToOne
    private Author author;

}
