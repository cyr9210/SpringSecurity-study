package me.bong.springsecurityusernamenotfoundexception.accont;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class AccountDTO {

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class LoginRequestDTO {
        private String email;
        private String password;

        @Builder
        public LoginRequestDTO(String email, String password) {
            this.email = email;
            this.password = password;
        }
    }

}
