package postit;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import postit.account.Account;
import postit.account.AccountRepository;
import postit.comment.Comment;
import postit.post.Post;
import postit.post.PostRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class DbSeeder implements CommandLineRunner {
    private PostRepository postRepository;
    private AccountRepository accountRepository;

    public DbSeeder(PostRepository postRepository, AccountRepository accountRepository) {
        this.postRepository = postRepository;
        this.accountRepository = accountRepository;
    }

    @Override
    public void run(String... args) {
        //drop all posts
        this.postRepository.deleteAll();
        ArrayList<Comment> arrayListComment = new ArrayList<>();

        arrayListComment.add(new Comment("mary",
                "The grid system is really cool, each area get it's own little plaza.", 0));

        arrayListComment.add(new Comment("andrew",
                "That was the original idea, but not the final execution. Zoom in and check. All the \"inner plazas\" in the picture are the roofs of warehouses, parkings, supermarkets... at ground level.\n" +
                        "\n" +
                        "The only 2 parks in this picture are next to Sagrada Familia and are open parks, not inner.\n" +
                        "\n" +
                        "PS: There are quite a few inner parks scattered through the city, though.", 0));

        arrayListComment.add(new Comment("marcus",
                "Wow the difference is like night and day", 0));
        arrayListComment.add(new Comment("oscar",
                "As a northern European I gotta say this image of perfection makes me shudder. The city without curves and bends and lakes in-between and more organic structures isn't something I'd wanna live in... Impressive shot tho", 0));

        Post post1 = new Post("Barcelona, day and night", "The Urban planner was a revolutionist well ahead of his time, he'd incorporated roads of larger width and corners to accommodate the usage of horse carriages for example which has now allowed easier traffic flow and regular spaces for taxi pick up and drop off. Understanding the importance of maintaing the dichotomy of urbanism and nature, he also incorporated open spaces, parks and greenery within most blocks as well. He provides a fantastic example of thinking ahead of your current time and means, and really incorporating future scenarios. Now his work maintains practicality and beauty all these years, Ildefons Cerdà's philosophy and legacy lives on.",
                "mary", "https://external-preview.redd.it/wtyyftyAgZ_8TL-c9Aej2EEbwwzsRToso0jTNW6y11M.jpg?auto=webp&s=931afd93ff17aea2aa82bf6bed8cca5797987b19");
        post1.setComments(arrayListComment);

        //add posts to database
        this.postRepository.save(post1);


        arrayListComment.clear();
        arrayListComment.add(new Comment("mary",
                "If the test actually misspelled \"finish\" it would be technically correct ... but this is just throwing away points for trying to be funny. Not worth it.", 0));

        arrayListComment.add(new Comment("andrew",
                "This joke was in a Danish line of commercials that ran from 1989. Its a shop keeper and a customer who cant pronounce the name of the product - in this one he took a English lesson on tape to finally make it.\n" +
                        "\n" +
                        "https://www.youtube.com/watch?v=knsaerPhmgw\n" +
                        "\n" +
                        "I can imagine the Finnish people being sick and tired of this joke, but it sure has shown its longevity.", 0));

        Post post2 = new Post("Close!", "I like that agressive \"NO !!\" on the side too, it accurately represents the Finnish reaction to this.",
                "andrew", "https://i.redd.it/j54dqiwioeu01.jpg");
        post2.setComments(arrayListComment);

        this.postRepository.save(post2);


        arrayListComment.clear();
        arrayListComment.add(new Comment("marcus",
                "I'm not exactly sure how I should rate this? Germany has almost the same size, but austria is smaller, even though the GDP per capita is a little bit higher.\n" +
                        "What are the values? Is it based on GDP per km²?", 0));

        arrayListComment.add(new Comment("andrew",
                "This map is scaled based on GDP ber sqkm of a country.\n" +
                        "It assumes that each km2 in scaled countries has GDP of 10 million usd.", 0));


        Post post3 = new Post("Map of European countries sized according to their national GDP", "I did not expect France to be so small! Wow!",
                "oscar", "https://i.redd.it/70to23y1iul21.png");
        post3.setComments(arrayListComment);
        this.postRepository.save(post3);

        Account account1 = new Account("admin", "admin");
        Account account2 = new Account("marcus", "marcus");
        Account account3 = new Account("andrew", "andrew");
        Account account4 = new Account("mary", "mary");

        this.accountRepository.deleteAll();
        this.accountRepository.save(account1);
        this.accountRepository.save(account2);
        this.accountRepository.save(account3);
        this.accountRepository.save(account4);
    }
}
