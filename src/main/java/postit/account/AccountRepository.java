package postit.account;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends MongoRepository<Account, String> {
    //@Query(value = "{username:?0}")
    Account findByUsername(String username);
}
