package me.bong.springsecurityusernamenotfoundexception.accont;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "mt_account")
@Getter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false, of = { "id" })
public class Account {

    @Id
    @Column(name = "id", length = 50)
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @GeneratedValue(generator = "system-uuid")
    private String id;

    @Column(name = "email", length = 100, nullable = false)
    private String email;

    @Column(name = "password", length = 100, nullable = false)
    private String password;

    @Column(name = "name", length = 100)
    private String name;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private Set<AccountRole> roles;

    @Builder
    public Account(String email, String password, String name) {
        Set<AccountRole> set = new HashSet<>();
        set.add(AccountRole.USER);

        this.email = email;
        this.password = password;
        this.name = name;
        this.roles = set;
    }
}
