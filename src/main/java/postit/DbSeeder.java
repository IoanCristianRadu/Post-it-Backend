package postit;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import postit.account.Account;
import postit.account.AccountRepository;
import postit.post.Post;
import postit.post.PostRepository;

@Component
public class DbSeeder implements CommandLineRunner {
    private PostRepository postRepository;
    private AccountRepository accountRepository;

    public DbSeeder(PostRepository postRepository, AccountRepository accountRepository) {
        this.postRepository = postRepository;
        this.accountRepository = accountRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Post post1 = new Post("Title 1","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam sodales, lorem quis scelerisque ultrices, augue velit gravida lectus, at fringilla erat mauris eget magna. Morbi ut odio sed ligula aliquam iaculis vehicula a dui. Suspendisse a quam odio. Donec metus neque, porttitor vel ultrices eget, cursus non leo. Aenean vestibulum, urna ac vehicula egestas, sem mi pellentesque lectus, convallis faucibus nisl odio ut arcu. Etiam eget lacus sed diam cursus volutpat pretium a nisl. Morbi nec viverra nunc. Suspendisse vulputate fermentum justo. Duis tincidunt venenatis dui. Praesent ultricies ex est, in euismod turpis sodales a. Aenean vitae sem id dolor iaculis venenatis. Sed non metus volutpat, cursus mauris in, ornare nisi. Sed sed mattis enim.");
        Post post2 = new Post("Title 2", "Morbi eu odio dui. Sed varius lectus in risus vestibulum cursus eu in libero. Etiam sollicitudin mauris venenatis arcu sollicitudin sodales. Aenean non aliquam eros. Praesent elementum lorem dolor, et viverra magna pretium eget. Ut varius lacus ut malesuada maximus. Pellentesque nec metus a mi viverra semper. Fusce luctus posuere lacus, in porttitor tellus. Maecenas nunc magna, fermentum quis tortor eget, feugiat ornare quam. Phasellus faucibus, dui vel porttitor feugiat, lectus dui sodales purus, at molestie eros nibh non eros. Curabitur ut placerat velit. Nunc at sagittis eros. Aenean pharetra risus id eros interdum, sed vulputate massa sagittis.");
        //drop all posts
        this.postRepository.deleteAll();

        //add posts to database
        this.postRepository.save(post1);
        this.postRepository.save(post2);

        Account account = new Account("admin","admin");

        this.accountRepository.deleteAll();
        this.accountRepository.save(account);
    }
}
