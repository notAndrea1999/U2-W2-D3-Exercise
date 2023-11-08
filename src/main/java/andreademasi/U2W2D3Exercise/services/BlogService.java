package andreademasi.U2W2D3Exercise.services;


import andreademasi.U2W2D3Exercise.entities.Blog;
import andreademasi.U2W2D3Exercise.exceptions.NotFoundException;
import andreademasi.U2W2D3Exercise.repositories.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BlogService {

    @Autowired
    private BlogRepository blogRepo;


    //GET authors
    public List<Blog> getAllBlogs() {
        return blogRepo.findAll();
    }


    //POST crea un nuovo blog
    public Blog save(Blog blog) {
        blog.setCover("https://picsum.photos/200/300");
        return blogRepo.save(blog);
    }

    //GET blog by id

    public Blog findBlogById(long id) {
        return blogRepo.findById(id).orElseThrow(() -> new NotFoundException(id));
    }


    //PUT modifica dello specifico blog
    public Blog findByIdAndUpdate(long id, Blog blog) {
        Blog foundBlog = this.findBlogById(id);
        foundBlog.setCategory(blog.getCategory());
        foundBlog.setTitle(blog.getTitle());
        foundBlog.setCover(blog.getCover());
        foundBlog.setContenuto(blog.getContenuto());
        foundBlog.setReadingTime(blog.getReadingTime());
        foundBlog.setUser(blog.getUser());
        return blogRepo.save(foundBlog);
    }

    //DELETE del blog
    public void findByIdAndDelete(long id) {
        Blog foundBlog = this.findBlogById(id);
        blogRepo.delete(foundBlog);
    }
}
