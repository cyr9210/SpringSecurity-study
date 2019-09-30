package me.bong.springsecurityusernamenotfoundexception.accont;

import com.sun.xml.internal.ws.api.pipe.ContentType;
import me.bong.springsecurityusernamenotfoundexception.accont.exception.BadCredentials;
import me.bong.springsecurityusernamenotfoundexception.common.IntegrationTest;
import me.bong.springsecurityusernamenotfoundexception.common.utill.ReturnCodes;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

public class AccountControllerTest extends IntegrationTest {

    @Test
    public void getAuth_success() throws Exception {
        AccountDTO.LoginRequestDTO loginRequest = AccountDTO.LoginRequestDTO.builder()
                .email("bong@email.com")
                .password("pass")
                .build();

        this.mockMvc.perform(post("/getAuthorization")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .content(objectMapper.writeValueAsString(loginRequest))
        )
                .andDo(print())
                .andExpect(jsonPath("authorization").value("success 200"))
        ;
    }

    @Test
    public void getAuth_bad_credentials_fail() throws Exception {
        AccountDTO.LoginRequestDTO loginRequest = AccountDTO.LoginRequestDTO.builder()
                .email("bong@email.com")
                .password("passs")
                .build();

        this.mockMvc.perform(post("/getAuthorization")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .content(objectMapper.writeValueAsString(loginRequest))
        )
                .andDo(print())
                .andExpect(jsonPath("authorization").value(Matchers.containsString(ReturnCodes.BAD_CREDENTIALS)))
                ;
    }

    @Test
    public void getAuth_bad_usernamenotfound_fail() throws Exception {
        AccountDTO.LoginRequestDTO loginRequest = AccountDTO.LoginRequestDTO.builder()
                .email("random@email.com")
                .password("pass")
                .build();

        this.mockMvc.perform(post("/getAuthorization")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .content(objectMapper.writeValueAsString(loginRequest))
        )
                .andDo(print())
                .andExpect(jsonPath("authorization").value(Matchers.containsString(ReturnCodes.USER_NOTFOUND)))
        ;
    }
}