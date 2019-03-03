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
    public int insert(@RequestBody BlogPost blogPost){
        //Insert only inserts data
        this.blogPostRepository.insert(blogPost);
        return 200;
    }

    @CrossOrigin
    @PostMapping
    public int update(@RequestBody BlogPost blogPost){
        //Save can update data
        this.blogPostRepository.save(blogPost);
        return 200;
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public int delete(@PathVariable("id") String id){
        this.blogPostRepository.deleteById(id);
        return 200;
    }

    @CrossOrigin
    @GetMapping("/title/{title}")
    public List<BlogPost> getByTitle(@PathVariable("title") String title){
        List<BlogPost> blogPosts = this.blogPostRepository.findByTitle(title);
        return blogPosts;
    }
}
