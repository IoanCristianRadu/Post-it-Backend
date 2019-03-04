package postit.account;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {
    private AccountRepository accountRepository;

    public AccountController(AccountRepository postRepository) {
        this.accountRepository = postRepository;
    }

    @CrossOrigin
    @PutMapping
    public int insert(@RequestBody Account account){
        //Insert only inserts data
        this.accountRepository.insert(account);
        return 200;
    }

    @CrossOrigin
    @PostMapping
    public int update(@RequestBody Account account){
        //Save can update data
        this.accountRepository.save(account);
        return 200;
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public int delete(@PathVariable("id") String id){
        this.accountRepository.deleteById(id);
        return 200;
    }

    @CrossOrigin
    @GetMapping("/login/{username}/{password}")
    public int logIn(@PathVariable("username") String username, @PathVariable("password") String password){
        Account account = this.accountRepository.findByUsername(username);
        if(account.getPassword().equals(password)) return 202;
        return 400;
    }
}
