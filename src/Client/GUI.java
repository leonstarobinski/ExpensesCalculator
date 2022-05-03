package Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

public class GUI extends JFrame {
   private Container c;

   public GUI(Client client){
       setSize(800,600);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setFont(Font.getFont(Font.SANS_SERIF));
       setVisible(true);
       c = this.getContentPane();
       c.setLayout(new FlowLayout());
       c.add(new JLabel("Expense Calculator"));
       JButton expense = new JButton("Add Expense");
       JButton deposit = new JButton("Add Deposit");

       JTextArea amount = new JTextArea("Hier schreiben Sie das Amount");
       JTextField description = new JTextField();
       JTextField date = new JTextField();
       amount.setVisible(true);
       description.setVisible(false);
       date.setVisible(false);
       c.add(amount);
       c.add(description);
       c.add(date);

       expense.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
             expense.setVisible(false);
             deposit.setVisible(false);
               amount.setVisible(true);


           }
       });

       deposit.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               expense.setVisible(false);
               deposit.setVisible(false);

           }
       });
       c.add(expense);
       c.add(deposit);
       setVisible(true);



   }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GUI(new Client());
            }
        });

    }
}
