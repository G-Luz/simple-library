package gluz.book.service;

import gluz.book.domain.Book;
import gluz.book.domain.BookDTO;
import gluz.book.persistence.BookRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public BookDTO registerNewBook(BookDTO dto) {
        Book book;
        book = dto.handleBuildDTO();
        bookRepository.saveAndFlush(book);
        return convertToDTO(book);
    }

    public List<BookDTO> findAllBooks() {
        List<BookDTO> dtos = new ArrayList<BookDTO>();
        List<Book> books = bookRepository.findAll();
        for (Book book : books) {
            dtos.add(convertToDTO(book));
        }
        return dtos;
    }

    public BookDTO findBookByID(int id) {
        return convertToDTO(bookRepository.findById(id).get());
    }

    public BookDTO updateBook(BookDTO dto) {
        Book book = new Book();
        book.setId(dto.getId());
        book = dto.handleBuildDTO();
        bookRepository.save(book);
        return convertToDTO(book);
    }

    public String deleteBook(int id) {
        Book book = new Book();
        book.setId(id);
        bookRepository.delete(book);
        return "Livro excluído com sucesso!";
    }

    public BookDTO convertToDTO(Book book) {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setId(book.getId());
        bookDTO.setName(book.getName());
        bookDTO.setIsbn(book.getIsbn());
        bookDTO.setGender(book.getGender());
        bookDTO.setTotalPages(book.getTotalPages());
        bookDTO.setAuthorID(bookDTO.getAuthorID());
        return bookDTO;
    }
}
