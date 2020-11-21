package com.makschornyi.currencyexchangeservice.model;

import org.springframework.context.annotation.ComponentScan;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class ExchangeValue {

    @Id
    private int id;

    @Column(name = "currency_from")
    private String from;

    @Column(name = "currency_to")
    private String to;
    private BigDecimal conversionMultiple;
    private int port;

    public ExchangeValue() {
    }

    public ExchangeValue(int id, String from, String to, BigDecimal conversionMultiple) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.conversionMultiple = conversionMultiple;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getId() {
        return id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public BigDecimal getConversionMultiple() {
        return conversionMultiple;
    }

    public void setConversionMultiple(BigDecimal conversionMultiple) {
        this.conversionMultiple = conversionMultiple;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ExchangeValue)) return false;
        ExchangeValue that = (ExchangeValue) o;
        return Objects.equals(from, that.from) &&
                Objects.equals(to, that.to) &&
                Objects.equals(conversionMultiple, that.conversionMultiple);
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to, conversionMultiple);
    }

    @Override
    public String toString() {
        return "ExchangeValue{" +
                "id=" + id +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", conversionMultiple=" + conversionMultiple +
                '}';
    }
}
