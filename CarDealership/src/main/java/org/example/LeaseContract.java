package org.example;

public class LeaseContract extends Contract {
private double expectingEndingValue;
private double leaseFee;

    public LeaseContract(String date, String customerName, String customerEmail, Vehicle vehicleSold, double totalPrice, double monthlyPayment, double expectingEndingValue, double leaseFee) {
        super(date, customerName, customerEmail, vehicleSold, totalPrice, monthlyPayment);
        this.expectingEndingValue = expectingEndingValue;
        this.leaseFee = leaseFee;
    }

    public double getExpectingEndingValue() {
        return expectingEndingValue;
    }

    public void setExpectingEndingValue(double expectingEndingValue) {
        this.expectingEndingValue = expectingEndingValue;
    }

    public double getLeaseFee() {
        return leaseFee;
    }

    public void setLeaseFee(double leaseFee) {
        this.leaseFee = leaseFee;
    }
//lease fee 7%
    //expectingEndingValue 50% of originalPrice
    //leases are financed at 4.0 for 36 months
    @Override
    public double getTotalPrice(){
        double price = vehicleSold.getPrice();
        double leaseFee = price * 0.07;
        return price + leaseFee;
    }

    @Override
    public double getMonthlyPayment(){
        double leaseAmount = getTotalPrice();
        double interestRate = 0.04;
        int month = 36;

        double totalInterest = leaseAmount * (1 + interestRate);
        double monthlyPayment = totalInterest / month;
        return monthlyPayment;
    }
}
