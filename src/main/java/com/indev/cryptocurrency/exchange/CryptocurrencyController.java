package com.indev.cryptocurrency.exchange;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
class CryptocurrencyController {

    @Autowired
    private CryptocurrencyBank cryptocurrencyBank;

    @GetMapping("/cryptocurrencies")
    public List<String>  getAllSupportedCryptoCurrencey() {
        return cryptocurrencyBank.getSupportedCryptoCurrencies();
    }

    @PostMapping("/cryptocurrencies")
    public List<String> addSupportedCryptocurrency(@RequestParam("name") String cryptocurrencyName) {
        cryptocurrencyBank.addSupportedCryptoCurrency(cryptocurrencyName);
        return  cryptocurrencyBank.getSupportedCryptoCurrencies();
    }

    @DeleteMapping("/cryptocurrencies")
    public List<String> deleteSupportedCryptocurrency(@RequestParam("name") String cryptocurrencyName) {
        cryptocurrencyBank.deleteSupportedCryptoCurrency(cryptocurrencyName);
        return  cryptocurrencyBank.getSupportedCryptoCurrencies();
    }


}