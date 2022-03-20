package Server;

import java.util.ArrayList;

public class List {
    private ArrayList <Transaction> list = new ArrayList <Transaction> ();
    public void add(Transaction transaction){
         list.add(transaction);
    }
    public boolean remove(Transaction transaction){
        return list.remove(transaction);

    }

}
