package net.velocitypartners.money;

import java.math.BigDecimal;

public class MoneyConverter {
	
	private static final int SCALE = 2; 
	private BigDecimal usdToCopExchangeRate;

	public MoneyConverter(BigDecimal usdToCopExchangeRate) {
		this.usdToCopExchangeRate = usdToCopExchangeRate.setScale(SCALE);
	}

	public BigDecimal convertUSDtoCOP(BigDecimal amountInUSD) {
		return amountInUSD.multiply(usdToCopExchangeRate).setScale(SCALE);
	}

}
