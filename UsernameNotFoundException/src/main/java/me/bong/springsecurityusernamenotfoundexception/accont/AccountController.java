package me.bong.springsecurityusernamenotfoundexception.accont;

import lombok.RequiredArgsConstructor;
import me.bong.springsecurityusernamenotfoundexception.accont.exception.AccountNotFound;
import me.bong.springsecurityusernamenotfoundexception.accont.exception.BadCredentials;
import me.bong.springsecurityusernamenotfoundexception.common.ResponseVO;
import me.bong.springsecurityusernamenotfoundexception.common.utill.ReturnCodes;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AccountController {

    private final AuthenticationManager authenticationManager;

    @PostMapping("/getAuthorization")
    public ResponseEntity getAuthorization(@RequestBody AccountDTO.LoginRequestDTO requestDTO) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(requestDTO.getEmail(), requestDTO.getPassword());

        try {
            Authentication authenticate = authenticationManager.authenticate(token);
            ResponseVO response = ResponseVO.builder().authorization("success " + ReturnCodes.OK).build();
            return ResponseEntity.ok(response);
        } catch (AuthenticationException e) {
            if (e instanceof BadCredentialsException)
                throw new BadCredentials();

            if (e instanceof UsernameNotFoundException)
                throw new AccountNotFound();
        }
        ResponseVO fail = ResponseVO.builder().authorization("fail").build();
        return ResponseEntity.ok(fail);
    }
}
