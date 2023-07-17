package gluz.author.service;

import gluz.author.domain.Author;
import gluz.author.domain.AuthorDTO;
import gluz.author.persistence.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {

    private AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public AuthorDTO saveNewAuthor(AuthorDTO dto) {
        Author author = new Author();
        author.setName(dto.getName());
        author.setBirthdate(dto.getBirthdate());
        author.setEmail(dto.getEmail());
        authorRepository.save(author);
        return convertToDTO(author);
    }

    public List<AuthorDTO> findAllAuthor() {
        List<AuthorDTO> dtos = new ArrayList<AuthorDTO>();
        List<Author> authors = authorRepository.findAll();
        for (Author author : authors) {
            dtos.add(convertToDTO(author));
        }
        return dtos;
    }

    public AuthorDTO findAuthorByID(int id) {
        return convertToDTO(authorRepository.findById(id).get());
    }

    public String deleteAuthor(int id){
        Author author = new Author();
        author.setId(id);
        authorRepository.delete(author);
        return "Autor excluído com sucesso!";
    }

    public AuthorDTO updateAuthor(AuthorDTO dto){
        Author author = new Author();
        author.setId(dto.getId());
        author.setName(dto.getName());
        author.setBirthdate(dto.getBirthdate());
        author.setEmail(dto.getEmail());
        authorRepository.save(author);
        return convertToDTO(author);
    }

    public AuthorDTO convertToDTO(Author author) {
        AuthorDTO dto = new AuthorDTO();
        dto.setId(author.getId());
        dto.setName(author.getName());
        dto.setBirthdate(author.getBirthdate());
        dto.setEmail(author.getEmail());
        return dto;
    }

}
