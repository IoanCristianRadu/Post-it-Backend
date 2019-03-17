package postit.account;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {
    private AccountRepository accountRepository;

    public AccountController(AccountRepository postRepository) {
        this.accountRepository = postRepository;
    }

    //test
    @CrossOrigin
    @GetMapping("/login/{username}/{password}")
    public int logIn2(@PathVariable("username") String username, @PathVariable("password") String password) {
        Account account = this.accountRepository.findByUsername(username);
        if (account.getPassword().equals(password)) return 202;
        return 400;
    }

    @CrossOrigin
    @PutMapping
    public int insert(@RequestBody Account account) {
        //Insert only inserts data
        this.accountRepository.insert(account);
        return 200;
    }

    @CrossOrigin
    @PostMapping
    public int update(@RequestBody Account account) {
        //Save can update data
        this.accountRepository.save(account);
        return 200;
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public int delete(@PathVariable("id") String id) {
        this.accountRepository.deleteById(id);
        return 200;
    }

    @CrossOrigin
    @PostMapping("/login")
    public String logIn(@RequestBody UsernamePassword usernamePassword) {
        Account account = this.accountRepository.findByUsername(usernamePassword.getUsername());
        if (account.getPassword().equals(usernamePassword.getPassword())) return "\"" + account.getId() + "\"";
        return "";
    }
}

class UsernamePassword {
    private String username;
    private String password;

    public UsernamePassword(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UsernamePassword{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
