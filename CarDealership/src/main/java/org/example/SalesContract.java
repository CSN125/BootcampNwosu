package org.example;

public class SalesContract extends Contract {
    private boolean finance;
    private double salesTax = 0.05;
    private double recordingFee = 100.0;
    private double processingFee;

    public SalesContract(String date, String customerName, String customerEmail, Vehicle vehicleSold, double totalPrice, double monthlyPayment, boolean finance, double salesTax, double recordingFee, double processingFee) {
        super(date, customerName, customerEmail, vehicleSold, totalPrice, monthlyPayment);
        this.finance = finance;
        this.salesTax = salesTax;
        this.recordingFee = recordingFee;
        this.processingFee = processingFee;
    }

    public boolean isFinance() {
        return finance;
    }

    public void setFinance(boolean finance) {
        this.finance = finance;
    }

    public double getSalesTax() {
        return salesTax;
    }

    public void setSalesTax(double salesTax) {
        this.salesTax = salesTax;
    }

    public double getRecordingFee() {
        return recordingFee;
    }

    public void setRecordingFee(double recordingFee) {
        this.recordingFee = recordingFee;
    }

    public double getProcessingFee() {
        return processingFee;
    }

    public void setProcessingFee(double processingFee) {
        this.processingFee = processingFee;
    }

    @Override
    public double getTotalPrice(){
        double price = vehicleSold.getPrice();
        double tax = price * 0.05;
        double recordingFee = 100.0;
        double processingFee;
       if(price < 10000){
           processingFee = 295.0;
       }else{
           processingFee = 495.0;
       }
       return price + tax + recordingFee + processingFee;

    }
    @Override
    public double getMonthlyPayment(){
        if(!finance){
            return 0;
        }

        double loanAmount = getTotalPrice();
        double monthlyPayment;
        if(vehicleSold.getPrice() >= 10000){
            //loan at 4.25 for 48 month, if price is 10,000 or more
            // otherWise they are at 5.25 for 24 months
            double interestRate = 0.0425;
            int month = 48;
            monthlyPayment = (loanAmount * (1 + interestRate)) / month;
        }else{
            double interestRate = 0.0525;
            int month = 24;
            monthlyPayment = (loanAmount * (1 + interestRate)) / month;
        }
        return monthlyPayment;

    }
}
