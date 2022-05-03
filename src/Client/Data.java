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

    public Data(double amount, String description, Date date, boolean isDeposit){
        this.amount = amount;
        this.description = description;
        this.date = date;
        this.isDeposit = isDeposit;
        arrayList.add(this);
    }
    public static String[] toStringArray(){
        String str[] = new String[arrayList.size()];
        for(int i =0; i<str.length; i++){
            SimpleDateFormat model = new SimpleDateFormat("dd/MM/yyyy");
            str[i] =""+ model.format(arrayList.get(i).date)+"  "+arrayList.get(i).description+"  "+arrayList.get(i).amount;
        }
        return str;
    }
    public static ArrayList getArrayList() {
        return arrayList;
    }
}
