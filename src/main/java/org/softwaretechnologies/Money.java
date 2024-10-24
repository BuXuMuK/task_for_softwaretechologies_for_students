package org.softwaretechnologies;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Money {
    private final MoneyType type;
    private final BigDecimal amount;

    public Money(MoneyType type, BigDecimal amount) {
        this.type = type;
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Money)) return false;
        Money other = (Money) o;


        BigDecimal thisAmount = (amount == null) ? BigDecimal.ZERO : amount.setScale(4, RoundingMode.HALF_UP);
        BigDecimal otherAmount = (other.amount == null) ? BigDecimal.ZERO : other.amount.setScale(4, RoundingMode.HALF_UP);

        return this.type == other.type && thisAmount.compareTo(otherAmount) == 0;
    }

    @Override
    public int hashCode() {
        BigDecimal scaledAmount = (amount == null) ? BigDecimal.ZERO : amount.setScale(4, RoundingMode.HALF_UP);
        int amountValue = scaledAmount.multiply(BigDecimal.valueOf(10000)).intValue();

        int typeId;
        if (type == null) {
            typeId = 5;
        } else {
            switch (type) {
                case USD:
                    typeId = 1;
                    break;
                case EURO:
                    typeId = 2;
                    break;
                case RUB:
                    typeId = 3;
                    break;
                case KRONA:
                    typeId = 4;
                    break;
                default:
                    typeId = 5;
                    break;
            }
        }


        if (amountValue >= (Integer.MAX_VALUE - 5)) {
            return Integer.MAX_VALUE;
        }
        return amountValue + typeId;
    }

    @Override
    public String toString() {
        if (type == null && amount == null) {
            return "null: null";
        }
        if (type == null) {
            return "null: " + (amount == null ? "null" : amount.setScale(4, RoundingMode.HALF_UP));
        }
        if (amount == null) {
            return type + ": null";
        }
        return type + ": " + amount.setScale(4, RoundingMode.HALF_UP);
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public MoneyType getType() {
        return type;
    }

    public static void main(String[] args) {
        Money euroMoney = new Money(MoneyType.EURO, BigDecimal.valueOf(10.00012));
        Money usdMoney = new Money(MoneyType.USD, BigDecimal.valueOf(10.5000));

        System.out.println(euroMoney.toString());
        System.out.println(usdMoney.toString());
        System.out.println(usdMoney.hashCode());
        System.out.println(euroMoney.equals(usdMoney));


        Money sameEurMoney = new Money(MoneyType.EURO, BigDecimal.valueOf(10.00010));
        System.out.println(euroMoney.equals(sameEurMoney));
    }
}