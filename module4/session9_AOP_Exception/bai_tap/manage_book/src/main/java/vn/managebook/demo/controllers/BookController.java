package vn.managebook.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.managebook.demo.model.Book;
import vn.managebook.demo.model.Contact;
import vn.managebook.demo.services.BookService;

import javax.websocket.server.PathParam;


@Controller
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping(value = {"","/list"})
    public ModelAndView bookList(){
        return new ModelAndView("/list", "bookList", bookService.findAll());
    }

    @GetMapping("/booking/{id}")
    public String showBook(@PathVariable int id, Model model){
        model.addAttribute("book", bookService.findById(id));
        return "/booking";
    }

    @PostMapping(value = "/booking")
    public String booking(@ModelAttribute Book book){
        if(book.getAmountBook() > 0){
            book.setAmountBook(book.getAmountBook() - 1);
        }
        else {
            return "/error";
        }
        bookService.update(book);
        return "redirect:/list";
    }

    @GetMapping(value = "/list/give_book_back")
    public String giveBookBack(@RequestParam int id, @ModelAttribute Book book){
        book = bookService.findById(id);
        System.out.println(book.getAmountBook());
        if(book.getIdBook() == id){
            book.setAmountBook(book.getAmountBook() + 1);
        }
        bookService.update(book);
        System.out.println(book.getAmountBook());
        return "redirect:/list";
    }

}
