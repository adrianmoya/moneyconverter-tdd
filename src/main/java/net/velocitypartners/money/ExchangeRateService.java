package net.velocitypartners.money;

import java.math.BigDecimal;

public interface ExchangeRateService {

	BigDecimal getExchangeRate(String fromCurrencyCode, String toCurrencyCode);
}
