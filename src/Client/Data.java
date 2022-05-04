package Client;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Data {
    private static ArrayList<Data> arrayList = new ArrayList<Data>();
    private double amount;
    private boolean isDeposit;
    private String description;
    private Date date;
    private static double balance = 0;



    public Data(double amount, String description, Date date, boolean isDeposit){
        this.amount = amount;
        this.description = description;
        this.date = date;
        this.isDeposit = isDeposit;
        arrayList.add(this);
        if(isDeposit){
            balance = balance + amount;
        }
        else{
            balance-= amount;
        }
    }
    public static String[] toStringArray(){
        String str[] = new String[arrayList.size()];

        for(int i =0; i<str.length; i++){
            SimpleDateFormat model = new SimpleDateFormat("dd/MM/yyyy");
           if(arrayList.get(i).isDeposit) {
               str[i] =""+ model.format(arrayList.get(i).date)+"  "+arrayList.get(i).description+"  "+arrayList.get(i).amount+ " D";
           }
           else{
               str[i] =""+ model.format(arrayList.get(i).date)+"  "+arrayList.get(i).description+"  "+arrayList.get(i).amount+ " E";
           }
        }
        return str;
    }
    public static ArrayList getArrayList() {
        return arrayList;
    }
    public static double getBalance(){
        return balance;
    }
    public static String getPercentage(){
        double counter = 0;
        ArrayList percentageList = new ArrayList();
        for (Data d: arrayList) {
            if(!d.isDeposit){
                counter+=d.amount;
            }
        }
        String str = "";
        for (Data d:arrayList
             ) {
            if(!d.isDeposit){
                boolean temp = false;
                for(int i=0; i< arrayList.size(); i++){
                    if(d.description.equals(percentageList.get(i))){
                        temp = true;
                    }
                }
                if(!temp){
                    percentageList.add(d.description);
                }
            }
        }
        for(int i=0; i< percentageList.size(); i++){
            str +=  percentageList.get(i)+ ": ";
            for(int j=0; j< arrayList.size(); i++){

            }
        }
    }

}
