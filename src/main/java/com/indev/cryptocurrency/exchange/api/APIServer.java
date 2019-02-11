package com.indev.cryptocurrency.exchange.api;

import com.indev.cryptocurrency.exchange.api.com.indev.cryptocurrency.CryptocurrencyBank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    //public List<String> currencies = new ArrayList<>();

    @Autowired
    private CryptocurrencyBank cryptocurrencyBank ;
    @RequestMapping(method = RequestMethod.GET)
    public List<String> getAll() {
        return cryptocurrencyBank.getCryptoCurrency();
    }
    @RequestMapping(value="cryptocurrencies",method = RequestMethod.POST)
    public List<String> addCurrencie(@RequestParam("name") String name)
    {
        cryptocurrencyBank.getCryptoCurrency().add(name) ;
        return cryptocurrencyBank.getCryptoCurrency() ;
    }
    @RequestMapping(value="cryptocurrencies",method = RequestMethod.DELETE)
    public List<String> deleteCurrencie(@RequestParam("name") String name)
    {
        cryptocurrencyBank.getCryptoCurrency().remove(name);
        return cryptocurrencyBank.getCryptoCurrency() ;
    }
}
