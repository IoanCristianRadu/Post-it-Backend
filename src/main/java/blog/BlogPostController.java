package blog;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class BlogPostController {
    private BlogPostRepository blogPostRepository;

    public BlogPostController(BlogPostRepository blogPostRepository) {
        this.blogPostRepository = blogPostRepository;
    }

    @CrossOrigin
    @GetMapping("/all")
    public List<BlogPost> getAll(){
        List<BlogPost> posts = this.blogPostRepository.findAll();

        return posts;
    }

    @CrossOrigin
    @PutMapping
    public void insert(@RequestBody BlogPost blogPost){
        //Insert only inserts data
        this.blogPostRepository.insert(blogPost);
    }

    @CrossOrigin
    @PostMapping
    public void update(@RequestBody BlogPost blogPost){
        //Save can update data
        this.blogPostRepository.save(blogPost);
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id){
        this.blogPostRepository.deleteById(id);
    }

    @CrossOrigin
    @GetMapping("/title/{title}")
    public List<BlogPost> getByTitle(@PathVariable("title") String title){
        List<BlogPost> blogPosts = this.blogPostRepository.findByTitle(title);

        return blogPosts;
    }
}
