package me.bong.springsecurityusernamenotfoundexception.accont;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
public class AccountRepositoryTest {

    @Autowired
    private AccountRepository accountRepository;

    private String email = "bong@email.com";
    private String pass = "pass";
    private String name = "bong";

    @Before
    public void setup() {
        Account account = Account.builder()
                .email(email)
                .password(pass)
                .name(name)
                .build();

        accountRepository.save(account);
    }

    @Test
    public void findByEmail() {
        Optional<Account> byEmail = accountRepository.findByEmail(email);
        assertThat(byEmail.get().getName()).isEqualTo(name);
    }

}