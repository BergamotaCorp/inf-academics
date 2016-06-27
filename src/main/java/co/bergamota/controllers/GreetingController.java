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
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }

    @Autowired
    BookRepository bookRepository;

    @RequestMapping("/getBooks")
    public ArrayList<Book> books() {
        return Lists.newArrayList(bookRepository.findAll());
    }
}