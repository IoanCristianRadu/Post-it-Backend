package blog;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DbSeeder implements CommandLineRunner {
    private BlogPostRepository blogPostRepository;

    public DbSeeder(BlogPostRepository blogPostRepository) {
        this.blogPostRepository = blogPostRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        BlogPost post = new BlogPost("Title","Content");

        //drop all posts
        this.blogPostRepository.deleteAll();

        //add posts to database
        this.blogPostRepository.save(post);

    }
}
