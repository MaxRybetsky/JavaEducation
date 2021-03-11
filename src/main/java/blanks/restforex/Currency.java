package blanks.restforex;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Currency {
    private boolean success;
    @JsonProperty("base")
    private CurrencyCode currencyCode;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate date;
    private Map<CurrencyCode, Double> rates = new HashMap<>();

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public CurrencyCode getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(CurrencyCode currencyCode) {
        this.currencyCode = currencyCode;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Map<CurrencyCode, Double> getRates() {
        return rates;
    }

    public void setRates(Map<CurrencyCode, Double> rates) {
        this.rates = rates;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "success=" + success +
                ", currencyCode=" + currencyCode +
                ", date=" + date +
                ", rates=" + rates +
                '}';
    }
}
