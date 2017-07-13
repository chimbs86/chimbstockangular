package com.jdriven.ng2boot;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.WebClient;
import com.jdriven.ng2boot.UrlMaker.Builder;

import org.joda.time.DateTime;
import org.joda.time.DateTimeUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.bind.DatatypeConverter;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import static org.joda.time.DateTime.now;

/**
 * Created by chimbs on 7/6/17.
 */
@RestController
public class MainEntry {
    private static final String USERNAME = "26dc03fe8fe209e253c541c2f238c8d6";
    private static final String PASSWORD = "82a16b62a6d2e2d66c133306cd39698e";


    @RequestMapping("/quote")
    public String hello(@RequestParam String symbol) throws IOException {

        Builder url = new Builder();
        url.withTicker(symbol);
        url.withStartDate(now().minusYears(5));
        url.withEndtDate(now());
        String response = getJson(url.build().getUrlForHistoric());
        ObjectMapper mapper = new ObjectMapper();
        Wrapper wrapper = mapper.readValue(response, Wrapper.class);

        List<Historic> historicData = wrapper.getData();

        InvestmentCalculator calc = new InvestmentCalculator(historicData, 1000, symbol);

        return calc.getReturn();
    }

    private String getJson(String url) throws IOException {
        WebClient client = getWebClient(USERNAME, PASSWORD);
        Page page = client.getPage(new URL(url));
        String response = page.getWebResponse().getContentAsString();
        return response;
    }

    private WebClient getWebClient(String username, String password) {
        WebClient webClient = new WebClient();
        String base64encodedUsernameAndPassword = base64Encode(username + ":" + password);
        webClient.addRequestHeader("Authorization", "Basic " + base64encodedUsernameAndPassword);
        return webClient;
    }

    private static String base64Encode(String stringToEncode) {
        return DatatypeConverter.printBase64Binary(stringToEncode.getBytes());
    }
}
