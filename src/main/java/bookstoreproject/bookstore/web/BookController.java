package bookstoreproject.bookstore.web;

import bookstoreproject.bookstore.domain.BookRepository;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/index")
    public String showIndexPage() {
        return "index";
    }

    @RequestMapping(value = { "/", "/booklist" })
    public String booklist(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        return "booklist";
    }

}