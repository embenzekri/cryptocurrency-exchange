package com.indev.cryptocurrency.exchange.api;

import com.indev.cryptocurrency.exchange.api.cryptocurrency.CryptocurrencyBank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
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
    @Autowired
    private CryptocurrencyBank cryptoCurrencies;
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<String>> getAll() {
        return  ResponseEntity.ok(cryptoCurrencies.getSupportedCryptoCurrency());
    }
    @RequestMapping(value = "cryptocurrencies",method=RequestMethod.POST)
    public ResponseEntity<List<String>> add(@RequestParam("name") String cryptoCurrency){
        cryptoCurrencies.addSupportedCryptoCurrency(cryptoCurrency);
        return  ResponseEntity.ok(cryptoCurrencies.getSupportedCryptoCurrency());

    }
    @RequestMapping(value="cryptocurrencies",method=RequestMethod.DELETE)
    public ResponseEntity<List<String>> delete(@RequestParam("name") String cryptoCurrency){
        cryptoCurrencies.removeCryptoCurrency(cryptoCurrency);
        return ResponseEntity.ok(cryptoCurrencies.getSupportedCryptoCurrency());
    }
}
