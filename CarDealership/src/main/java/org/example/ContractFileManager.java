package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ContractFileManager {
    public void saveContract(Contract contract){
        try{
            FileWriter fileWriter = new FileWriter("src/main/resources/contract.csv", true);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            Vehicle vehicle = contract.getVehicleSold();
            if(contract instanceof SalesContract){
                SalesContract salesContract = (SalesContract)contract;
                writer.write("Sale" + contract.getDate() + "|" +
                        contract.getCustomerName() + "|" +
                        contract.getCustomerEmail() + "|" +
                        vehicle.getVin() + "|" +
                        vehicle.getYear() + "|" +
                        vehicle.getMake() + "|" +
                        vehicle.getModel() + "|" +
                        vehicle.getVehicleType() + "|" +
                        vehicle.getColor() + "|" +
                        vehicle.getOdometer() + "|" +
                        vehicle.getPrice() + "|" +
                        salesContract.getSalesTax()+ "|" +
                        salesContract.getRecordingFee() + "|" +
                        salesContract.getProcessingFee() + "|" +
                        salesContract.getTotalPrice() + "|" + (salesContract.isFinance() ? "Yes" : "NO") + "|" +
                        salesContract.getMonthlyPayment());
            }
            else if (contract instanceof LeaseContract){
                LeaseContract lease = (LeaseContract) contract;
                writer.write("Lease|" + contract.getDate() + "|" +
                        contract.getDate() + "|" +
                        contract.getCustomerName() + "|" +
                        contract.getCustomerEmail() + "|" +
                        vehicle.getVin() + "|" +
                        vehicle.getYear() + "|" +
                        vehicle.getMake() + "|" +
                        vehicle.getModel() + "|" +
                        vehicle.getVehicleType() + "|" +
                        vehicle.getColor() + "|" +
                        vehicle.getOdometer() + "|" +
                        vehicle.getPrice() + "|" +
                        lease.getExpectingEndingValue() + "|" +
                        lease.getLeaseFee() + "|" +
                        lease.getTotalPrice() + "|" +
                        lease.getMonthlyPayment());
            }
            writer.newLine();
            writer.close();

        }catch (IOException e){
            System.out.println("Error Saving Contract");

        }
    }
}
