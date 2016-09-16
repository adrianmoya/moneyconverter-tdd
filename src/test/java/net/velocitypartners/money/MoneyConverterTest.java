package net.velocitypartners.money;

import java.math.BigDecimal;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class MoneyConverterTest {

	private MoneyConverter converter;
	
	@Before
	public void setup(){
		BigDecimal usdToCopExchangeRate = new BigDecimal("2920.82"); //Today! 
		converter = new MoneyConverter(usdToCopExchangeRate);
	}

	@Test
	public void itConvertsUSDtoCOP(){
		//Given
		BigDecimal amountToConvert = new BigDecimal("10.00");
		//When
		BigDecimal result = converter.convertUSDtoCOP(amountToConvert);
		//Then
		assertEquals(new BigDecimal("29208.20"), result);
	}
}
