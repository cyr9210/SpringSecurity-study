package me.bong.springsecurityusernamenotfoundexception;

import lombok.RequiredArgsConstructor;
import me.bong.springsecurityusernamenotfoundexception.accont.Account;
import me.bong.springsecurityusernamenotfoundexception.accont.AccountRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TestRunner implements ApplicationRunner {

    private final PasswordEncoder passwordEncoder;
    private final AccountRepository accountRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Account account = Account.builder()
                .email("bong@email.com")
                .password(passwordEncoder.encode("pass"))
                .name("bong")
                .build();

        accountRepository.save(account);
    }
}
