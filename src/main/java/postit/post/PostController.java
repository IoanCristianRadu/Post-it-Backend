package postit.post;

import org.springframework.web.bind.annotation.*;
import postit.comment.Comment;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
public class PostController {
    private PostRepository postRepository;

    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @CrossOrigin
    @GetMapping("/all")
    public List<Post> getAll() {
        return this.postRepository.findAll();
    }

    @CrossOrigin
    @GetMapping("/username/{username}")
    public List<Post> postComment(@PathVariable("username") String username) {
        return this.postRepository.findByUsername(username);
    }

    @CrossOrigin
    @GetMapping("/title/{title}")
    public List<Post> getByTitle(@PathVariable("title") String title) {
        return this.postRepository.findByTitle(title);
    }

    @CrossOrigin
    @PutMapping
    public int insert(@RequestBody Post post) {
        //Insert only inserts data
        this.postRepository.insert(post);
        return 200;
    }

    @CrossOrigin
    @PutMapping("/comment/{id}")
    public void postComment(@PathVariable("id") String id, @RequestBody Comment comment) {
        Optional<Post> optionalPost = this.postRepository.findById(id);
        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();
            post.addComment(comment);
            this.postRepository.save(post);
            System.out.println(post);
        }
    }

    @CrossOrigin
    @PostMapping
    public int update(@RequestBody Post post) {
        //Save can update data
        this.postRepository.save(post);
        return 200;
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public int delete(@PathVariable("id") String id) {
        this.postRepository.deleteById(id);
        return 200;
    }
}
