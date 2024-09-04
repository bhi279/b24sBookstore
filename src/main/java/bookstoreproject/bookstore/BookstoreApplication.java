package bookstoreproject.bookstore;

import bookstoreproject.bookstore.domain.Book;
import bookstoreproject.bookstore.domain.BookRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BookRepository bookRepository) {
		return (args) -> {
			bookRepository.save(new Book("Akun seikkailut", "Aku Ankka", "A1234B5678", 2000, 12.34));
			bookRepository.save(new Book("Iineksen iltapäiväkahvit", "Iines Ankka", "A4321B8765", 2000, 56.78));
			bookRepository.save(new Book("Roopen säästövinkit", "Roope Ankka", "A3412B7856", 2000, 90.12));
		};

	}
}
