package Client;

import java.text.DecimalFormat;
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

        String str = "Balance: "+balance+ "\nYour expenses are "+ counter + " Euros\n";
        for (Data d:arrayList
             ) {
            if(!d.isDeposit){
                boolean temp = false;

                for(int i=0; i< percentageList.size(); i++){
                    if(d.description.equals(percentageList.get(i))){
                        temp = true;
                    }
                }
                if(!temp){
                    percentageList.add(d.description);
                }
            }
        }
        DecimalFormat df = new DecimalFormat("#.##");
        for(int i=0; i< percentageList.size(); i++){
            str +=  percentageList.get(i)+ ": ";
            double temp =0;
            for(int j=0; j< arrayList.size(); j++){
                if((percentageList.get(i).equals(arrayList.get(j).description))&&!(arrayList.get(j).isDeposit)){
                    temp+=arrayList.get(j).amount;
                }
            }
            str+= "is "+ df.format((temp/counter)*100)+"% of your expenses."+"\n";
        }
        return str;
    }

    public static void main(String[] args) {
        new Data(100, "Tom", new Date(), false);
        new Data(50, "D", new Date(), true);
        new Data(600, "D", new Date(), true);
        new Data(200, "Michelle", new Date(), false);
        System.out.println(getPercentage());
    }
}
