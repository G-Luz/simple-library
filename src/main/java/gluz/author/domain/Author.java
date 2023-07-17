package gluz.author.domain;


import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor

@Getter
@Setter

@Entity
@Table(name = "author")
public class Author{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String name;
    private String birthdate;
    private String email;

}
