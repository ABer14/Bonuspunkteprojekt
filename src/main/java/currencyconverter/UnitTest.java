package currencyconverter;

import org.junit.Test;

public class UnitTest {

        @Test
        public void testCreateCurrency() {
            CurrencyTable.createCurrency();
        }
        @Test
        public void testGetCurrencyNames() {
            CurrencyTable.getCurrencyNames();
        }
        @Test
        public void testGetCurrencyValues() {
            CurrencyTable.getCurrencyValues();
        }
        @Test
        public void testBuyCurrency() {
            Converter.buyCurrency();
        }

        @Test
        public void testSellCurrency() {
            Converter.sellCurrency();
        }
        @Test
        public void testCurrencyConverter() {
            Converter.currencyConverter();
        }
        @Test
        public void testConverterRun() {
            Converter.converterRun();
        }
    }

