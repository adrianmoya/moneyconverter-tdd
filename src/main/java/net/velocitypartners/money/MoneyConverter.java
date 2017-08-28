package net.velocitypartners.money;

import java.math.BigDecimal;

public class MoneyConverter {
	
	private static final int SCALE = 2; 
	private ExchangeRateService exchangeRateService;
	

	public MoneyConverter(ExchangeRateService exchangeRateService) {
		this.exchangeRateService = exchangeRateService;
	}

	public BigDecimal convertUSDtoCOP(BigDecimal amountInUSD) {
		BigDecimal usdToCopExchangeRate = exchangeRateService.getExchangeRate("USD", "COP");
		return amountInUSD.multiply(usdToCopExchangeRate).setScale(SCALE);
	}

}
