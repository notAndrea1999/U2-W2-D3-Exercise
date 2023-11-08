package andreademasi.U2W2D3Exercise.controllers;


import andreademasi.U2W2D3Exercise.entities.Blog;
import andreademasi.U2W2D3Exercise.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogPosts")
public class BlogController {
    @Autowired
    private BlogService blogService;

    //GET blogpost
    @GetMapping
    List<Blog> getAllBlogs() {
        return blogService.getAllBlogs();
    }

    //POST crea un nuovo blogpost
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Blog save(@RequestBody Blog blog) {
        return blogService.save(blog);
    }

    //GET blogpost by id
    @GetMapping("/{id}")
    Blog findBlogById(@PathVariable long id) {
        return blogService.findBlogById(id);
    }

    //PUT modifica dello specifico blogpost
    @PutMapping("/{id}")
    Blog findByIdAndUpdate(@PathVariable long id, @RequestBody Blog blog) {
        return blogService.findByIdAndUpdate(id, blog);
    }

    //DELETE del blogpost
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void findByIdAndDelete(@PathVariable long id) {
        blogService.findByIdAndDelete(id);
    }
}
