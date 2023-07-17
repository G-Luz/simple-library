package gluz.author.controller;

import gluz.author.domain.AuthorDTO;
import gluz.author.service.AuthorService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(path = "/v1/author")
public class AuthorController {
    private AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping(path = "/save")
    public AuthorDTO addNewAuthor(@RequestBody AuthorDTO dto) {
        return authorService.saveNewAuthor(dto);
    }

    @GetMapping
    public ArrayList<AuthorDTO> findAllAuthors() {
        return (ArrayList<AuthorDTO>) authorService.findAllAuthor();
    }

    @GetMapping(params = "id")
    public AuthorDTO findAuthorByID(@RequestParam int id) {
        return authorService.findAuthorByID(id);
    }

    @PutMapping(path = "/editing", params = "id")
    public AuthorDTO updateAuthorData(@RequestParam int id, @RequestBody AuthorDTO dto) {
        return authorService.updateAuthor(dto);
    }

    @DeleteMapping(path = "/delete", params = "id")
    public String deleteAuthorData(@RequestParam int id) {
        return authorService.deleteAuthor(id);
    }


}
