package postit.post;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post,String> {
    //@Query(value = "{title:?0}")
    List<Post> findByTitle(String title);
}
