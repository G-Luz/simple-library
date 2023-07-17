package gluz.book.controller;

import gluz.book.domain.BookDTO;
import gluz.book.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(path = "/v1/book")
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping(path = "/save")
    public BookDTO registerNewBook(@RequestBody BookDTO dto) {
        return bookService.registerNewBook(dto);
    }

    @GetMapping
    public ArrayList<BookDTO> findAllBooks() {
        return (ArrayList<BookDTO>) bookService.findAllBooks();
    }

    @GetMapping(params = "id")
    public BookDTO findBookByID(@RequestParam int id) {
        return bookService.findBookByID(id);
    }

    @PutMapping(path = "/editing", params = "id")
    public BookDTO updateBookData(@RequestParam int id, @RequestBody BookDTO dto) {
        return bookService.updateBook(dto);
    }

    @DeleteMapping(path = "/delete", params = "id")
    public String deleteAuthorData(@RequestParam int id) {
        return bookService.deleteBook(id);
    }


}