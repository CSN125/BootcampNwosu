package org.example;

import java.io.File;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class FileManager {
    public static void saveToFile(Order order){

        String dir = "receipts/"; // the folder you are saving too
        String filePath = createFileName();
        File file = new File(dir,filePath);

        try(FileWriter fw = new FileWriter(file)){
            //add the items to the receipt
            fw.write("Order Summary \n");
            for(OrderItem item : order.getOrderItems()) {
              fw.write(item.toString() + "\n");
            }
          fw.write("\n"+String.valueOf(order.getToTalCost()));

        }catch (Exception e){
            System.out.println(e.getLocalizedMessage());
        }

    }

    private static String createFileName(){
        LocalDateTime currentDate = LocalDateTime.now();
        StringBuilder fileName = new StringBuilder();

        System.out.println(currentDate.toLocalDate());

        for (String dateString: currentDate.toLocalDate().toString().split("-")){
            fileName.append(dateString);
        }

        fileName.append("-");

        for (String timeString: currentDate.toLocalTime().truncatedTo(ChronoUnit.SECONDS).toString().split(":")){
            fileName.append(timeString);
        }
        fileName.append(".txt");

        return  fileName.toString();
    }

}
