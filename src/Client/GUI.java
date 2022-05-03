package Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GUI extends JFrame {
   private Container c;
    final private double[] amountInput = new double[1];
    final private String[] descriptionInput = new String[1];
    final private Date[] dateInput = new Date[1];
    private boolean isDeposit = false;
   public GUI(Client client){



       setSize(800,600);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setFont(Font.getFont(Font.SANS_SERIF));
       setVisible(true);
       c = this.getContentPane();
       c.setLayout(new BorderLayout());
       c.add(new JLabel("Expense Calculator"));
       JButton expense = new JButton("Add Expense");
       JButton deposit = new JButton("Add Deposit");
       JButton saveButton = new JButton("Save");

       JPanel panel = new JPanel();
       panel.setLayout(new FlowLayout());
       panel.add(expense);
       panel.add(deposit);
       panel.add(saveButton);
       c.add(panel, BorderLayout.SOUTH);
       JTextArea amount = new JTextArea("Hier schreiben Sie das Amount");
       JTextArea description = new JTextArea("Place holder");
       JTextField date = new JTextField();

       SimpleDateFormat model = new SimpleDateFormat("dd/MM/yyyy");
       JSpinner spinner = new JSpinner(new SpinnerDateModel());
       spinner.setEditor(new JSpinner.DateEditor(spinner, model.toPattern()));




       saveButton.setVisible(false);
       amount.setVisible(false);
       description.setVisible(false);
       date.setVisible(false);
       JPanel panel2 = new JPanel();
       panel2.add(spinner);
       spinner.setVisible(false);
       panel2.setLayout(new FlowLayout());
       panel2.setVisible(true);
       c.add(panel2, BorderLayout.NORTH);
       panel2.add(amount);
       panel2.add(description);
       c.add(date);
       String[] temp = {"Hello"};
       JList[] list = {new JList(temp)};
        list[0].setVisible(true);
        c.add(list[0], BorderLayout.CENTER);

       expense.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               expense.setVisible(false);
               deposit.setVisible(false);
               amount.setVisible(true);
               description.setVisible(true);
               saveButton.setVisible(true);
               spinner.setVisible(true);
               isDeposit = false;
           }
       });


       deposit.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               expense.setVisible(false);
               deposit.setVisible(false);
               amount.setVisible(true);
               description.setVisible(true);
               saveButton.setVisible(true);
               spinner.setVisible(true);
               isDeposit = true;
           }
       });
       saveButton.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               amountInput[0] = Double.parseDouble(amount.getText());
               descriptionInput[0] = description.getText();
               dateInput[0] = new Date(model.format(spinner.getValue()));
               Data data = new Data(amountInput[0], descriptionInput[0], dateInput[0], isDeposit);
               String[] temp = new String[1];
               String[] test = {"test"};
               JList temp2 = new JList(Data.toStringArray());
               list[0].setVisible(false);
               temp2.setVisible(true);
               c.add(temp2, BorderLayout.CENTER);
               System.out.println("test");
           }
       });
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
