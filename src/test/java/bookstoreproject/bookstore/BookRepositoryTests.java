package bookstoreproject.bookstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import bookstoreproject.bookstore.domain.Category;
import bookstoreproject.bookstore.domain.Book;
import bookstoreproject.bookstore.domain.BookRepository;

@DataJpaTest
public class BookRepositoryTests {

    @Autowired
    private BookRepository bookRepository;

    Category crime = new Category("Crime");
    Category cooking = new Category("Cooking");
    Category selfHelp = new Category("Self help");

    // Test to create new books
    @Test
    public void createNewBookTest() {
        bookRepository.save(new Book("Testikirja", "Testi Ankka", "JHKTD5976", 2008, 8.99, crime));

        assertThat(bookRepository.findByIsbn("JHKTD5976").getCategory()).isEqualTo("crime");
    }

    // Test to delete books
    @Test
    public void deleteBooksTest() {
        long repositorySize = bookRepository.count();
        bookRepository.save(new Book("Testikirja", "Testi Ankka", "A1234B5678", 2008, 8.99, crime));
        bookRepository.deleteById(1L);

        assertThat(repositorySize).isEqualTo(bookRepository.count());
    }

    // Test to find books by their isbn
    @Test
    public void findByIsbnTest() {
        Book testikirja = new Book("Testikirja1", "Testi Ankka", "KNDR8567", 2008, 8.99, crime);
        bookRepository.save(testikirja);

        assertThat(testikirja).isEqualTo(bookRepository.findByIsbn("KNDR8567"));
    }
}