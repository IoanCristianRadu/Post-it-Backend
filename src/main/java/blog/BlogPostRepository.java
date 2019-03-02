package blog;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogPostRepository extends MongoRepository<BlogPost,String> {
    @Query(value = "{title:?0}")
    List<BlogPost> findByTitle(String title);
}
