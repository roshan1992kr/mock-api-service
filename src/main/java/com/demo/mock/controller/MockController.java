package com.demo.mock.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.mock.util.TestUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * <code>MockController</code> is controller to handle request for mock APIs
 */
@RestController
@RequestMapping("/mock")
public class MockController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MockController.class);
    ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
    public String mockPricingApi() throws JsonMappingException, JsonProcessingException {
        LOGGER.info("Request recieved for json value");
        return TestUtils.getStringFromFile("/a.json");
    }
}
