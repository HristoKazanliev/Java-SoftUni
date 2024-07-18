package bg.softuni.mobilelele.service;

import bg.softuni.mobilelele.model.dto.ExRatesDTO;

import java.math.BigDecimal;
import java.util.List;

public interface ExRateService {
    boolean hasInitializedExRates();
    ExRatesDTO fetchExRates();
    void updateExRates(ExRatesDTO exRatesDTO);
    BigDecimal convert(String from, String to, BigDecimal amount);
    List<String> allSupportedCurrencies();
}
