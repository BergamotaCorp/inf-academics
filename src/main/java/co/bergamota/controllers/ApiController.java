package co.bergamota.controllers;

import co.bergamota.business.objects.Book;
import co.bergamota.business.objects.Greeting;
import co.bergamota.dataaccess.BookRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api")
public class ApiController {
    @Autowired
    BookRepository bookRepository;

    @RequestMapping("/book/getBooks")
    public ArrayList<Book> books() {
        return Lists.newArrayList(bookRepository.findAll());
    }

}