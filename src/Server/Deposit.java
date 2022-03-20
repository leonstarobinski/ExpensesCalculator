package Server;
import java.util.Date;

public class Deposit implements Transaction {

    private double amount;
    private Date date;
    private String description;

    public Deposit(double amount, Date date, String description){
        this.amount = amount;
        this.date = date;
        this.description = description;
    }
    public Deposit(double amount, Date date){
        this.amount = amount;
        this.date = date;
        this.description = "";
    }





}
