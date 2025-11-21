package strategy.discount;

public class pizzaDis implements applydiscount {
    @Override
    public double apply(double price) {
        double result = price * 0.85;
        return Math.round(result * 100.0) / 100.0; 
    }

}
