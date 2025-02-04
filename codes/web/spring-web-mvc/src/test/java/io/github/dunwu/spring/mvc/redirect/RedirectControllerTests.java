package io.github.dunwu.spring.mvc.redirect;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class RedirectControllerTests {

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() throws Exception {
        this.mockMvc = standaloneSetup(new RedirectController(new DefaultFormattingConversionService()))
            .alwaysExpect(status().isMovedTemporarily()).build();
    }

    @Test
    public void uriTemplate() throws Exception {
        this.mockMvc.perform(get("/redirect/uriTemplate")).andExpect(redirectedUrl("/redirect/a123?date=12%2F31%2F11"));
    }

    @Test
    public void uriComponentsBuilder() throws Exception {
        this.mockMvc.perform(get("/redirect/uriComponentsBuilder"))
                    .andExpect(redirectedUrl("/redirect/a123?date=12/31/11"));
    }

}
