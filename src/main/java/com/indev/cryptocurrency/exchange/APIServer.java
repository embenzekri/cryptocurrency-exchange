package com.indev.cryptocurrency.exchange;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@SpringBootConfiguration
public class APIServer {

    public static void main(String[] args) {
        SpringApplication.run(APIServer.class, args);
    }

}

@RestController
class CustomerController {

    private List<String> currencies = new ArrayList<>();

    /*@RequestMapping(method = RequestMethod.GET)
    public List<String> getAll() {
        return Arrays.asList("Ayoub", "Mehdi");
    }*/

    @RequestMapping(value = "/cryptocurrencies", method = RequestMethod.GET)
    public List<String> getAllCurrencies(){
        return currencies;
    }

    @RequestMapping(value = "/cryptocurrencies", method = RequestMethod.POST)
    public List<String> addCurrency(@RequestParam String name){
        currencies.add(name);
        return currencies;
    }

    @RequestMapping(value = "/cryptocurrencies", method = RequestMethod.DELETE)
    public List<String> deleteCurrency(@RequestParam String name){
        currencies.remove(name);
        return currencies;
    }
}
