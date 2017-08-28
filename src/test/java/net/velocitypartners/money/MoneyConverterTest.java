package net.velocitypartners.money;

import java.math.BigDecimal;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

public class MoneyConverterTest {

	private MoneyConverter converter;
	
	@Mock
	private ExchangeRateService mockedExchangeRateService;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this); 
		converter = new MoneyConverter(mockedExchangeRateService);
	}

	@Test
	public void itConvertsUSDtoCOP(){
		//Given
		BigDecimal amountToConvert = new BigDecimal("10.00");
		when(mockedExchangeRateService.getExchangeRate("USD", "COP")).thenReturn(new BigDecimal("2920.82"));
		//When
		BigDecimal result = converter.convertUSDtoCOP(amountToConvert);
		//Then
		assertEquals(new BigDecimal("29208.20"), result);
		verify(mockedExchangeRateService).getExchangeRate("USD", "COP");
	}
}
