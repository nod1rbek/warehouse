package uz.pdp.appwarehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.appwarehouse.entity.Currency;
import uz.pdp.appwarehouse.payload.Result;
import uz.pdp.appwarehouse.repository.CurrencyRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CurrencyService {

    @Autowired
    CurrencyRepository currencyRepository;

    // CREATE
    public Result addCurrencyService(Currency currency) {
        boolean exists = currencyRepository.existsByName(currency.getName());
        if (exists) {
            return new Result("ERROR! This currency already added", false);
        }
        Currency addedCurrency = new Currency(currency.getName(), currency.isActive());
        currencyRepository.save(addedCurrency);
        return new Result("Currency added", true);
    }

    // READ
    public List<Currency> getCurrencies() {
        return currencyRepository.findAll();
    }

    // ReadById
    public Currency getCurrencyById(Integer id) {
        Optional<Currency> optionalCurrency = currencyRepository.findById(id);
        return optionalCurrency.orElseGet(Currency::new);
    }

    // UPDATE
    public Result editCurrency(Integer id, Currency currency) {
        Optional<Currency> optionalCurrency = currencyRepository.findById(id);
        if (optionalCurrency.isPresent()) {
            Currency editedCurrency = optionalCurrency.get();
            editedCurrency.setName(currency.getName());
            editedCurrency.setActive(currency.isActive());

            currencyRepository.save(editedCurrency);
            return new Result("This currency edited", true);
        }
        return new Result("This currency not found", false);
    }

    // DELETE
    public Result deleteCurrency(Integer id) {
        try {
            currencyRepository.deleteById(id);
            return new Result("This currency deleted", true);
        } catch (Exception e) {
            return new Result("ERROR! This currency not found", false);
        }
    }
}
