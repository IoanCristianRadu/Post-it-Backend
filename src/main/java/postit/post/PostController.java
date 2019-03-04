package postit.post;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
    private PostRepository postRepository;

    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @CrossOrigin
    @GetMapping("/all")
    public List<Post> getAll(){
        List<Post> posts = this.postRepository.findAll();

        return posts;
    }

    @CrossOrigin
    @PutMapping
    public int insert(@RequestBody Post post){
        //Insert only inserts data
        this.postRepository.insert(post);
        return 200;
    }

    @CrossOrigin
    @PostMapping
    public int update(@RequestBody Post post){
        //Save can update data
        this.postRepository.save(post);
        return 200;
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public int delete(@PathVariable("id") String id){
        this.postRepository.deleteById(id);
        return 200;
    }

    @CrossOrigin
    @GetMapping("/title/{title}")
    public List<Post> getByTitle(@PathVariable("title") String title){
        List<Post> posts = this.postRepository.findByTitle(title);
        return posts;
    }
}
