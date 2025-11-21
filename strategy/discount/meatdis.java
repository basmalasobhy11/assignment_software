package strategy.discount;

public class meatdis implements applydiscount {
    @Override
    public double apply(double price) {
        double result = price * 0.55;
        return Math.round(result * 100.0) / 100.0; 
    }
}
