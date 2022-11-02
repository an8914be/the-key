package com.de.application.thekeyfetchdataservice.helper;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.web.util.UriComponentsBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * HTTP-Helper class
 */
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
public abstract class HttpHelper {
    @Autowired
    protected MockMvc mockMvc;

    public UriComponentsBuilder uriBuilder(String endpoint) {
        return UriComponentsBuilder.fromPath(endpoint);
    }

    protected ResultActions performPost(UriComponentsBuilder uriBuilder, String jsonContent) throws Exception {
        return this.mockMvc.perform(post(uriBuilder.encode().build().toUriString())
                .contentType(MediaType.APPLICATION_JSON).content(jsonContent)).andDo(print());
    }

    protected ResultActions performGet(UriComponentsBuilder uriBuilder) throws Exception {
        return this.mockMvc.perform(get(uriBuilder.encode().build().toUriString())).andDo(print());
    }
}