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
    private JScrollPane scrollPane;
   public GUI(Client client){



       setSize(350,500);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setFont(Font.getFont(Font.SANS_SERIF));
       setVisible(true);
       c = this.getContentPane();
       c.setLayout(new BorderLayout());
       c.add(new JLabel("Expense Calculator"));
       JButton expense = new JButton("Add Expense");
       JButton deposit = new JButton("Add Deposit");
       JButton saveButton = new JButton("Save");
       JButton backButton = new JButton("Back");

       JPanel panel = new JPanel();
       panel.setLayout(new FlowLayout());
       panel.add(expense);
       panel.add(deposit);
       panel.add(backButton);
       panel.add(saveButton);
       c.add(panel, BorderLayout.SOUTH);
       JTextArea amount = new JTextArea("Hier schreiben Sie das Amount");
       JTextArea description = new JTextArea("Place holder");
       JTextField date = new JTextField();

       SimpleDateFormat model = new SimpleDateFormat("dd/MM/yyyy");
       JSpinner spinner = new JSpinner(new SpinnerDateModel());
       spinner.setEditor(new JSpinner.DateEditor(spinner, model.toPattern()));

       JList[] list = {new JList(Data.toStringArray())};
       list[0].setVisible(true);
       scrollPane = new JScrollPane(list[0]);
       c.add(scrollPane, BorderLayout.CENTER);

       backButton.setVisible(false);
       saveButton.setVisible(false);
       amount.setVisible(false);
       description.setVisible(false);
       date.setVisible(false);
       JLabel label = new JLabel("Welcome!");
       JPanel panel2 = new JPanel();
       panel2.setSize(500, 100);
       panel2.add(label);
       panel2.add(spinner);
       spinner.setVisible(false);
       panel2.setLayout(new FlowLayout());
       panel2.setVisible(true);
       c.add(panel2, BorderLayout.NORTH);
       panel2.add(amount);
       panel2.add(description);
       c.add(date);


       expense.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               expense.setVisible(false);
               deposit.setVisible(false);
               amount.setVisible(true);
               description.setVisible(true);
               saveButton.setVisible(true);
               backButton.setVisible(true);
               spinner.setVisible(true);
               isDeposit = false;
               validate();
           }
       });


       deposit.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               expense.setVisible(true);
               deposit.setVisible(false);
               amount.setVisible(true);
               description.setVisible(true);
               backButton.setVisible(true);
               saveButton.setVisible(true);
               spinner.setVisible(true);
               isDeposit = true;
               validate();
           }
       });
       saveButton.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               validate();
               amountInput[0] = Double.parseDouble(amount.getText());
               descriptionInput[0] = description.getText();
               SimpleDateFormat model = new SimpleDateFormat("MM/dd/yyyy");
               dateInput[0] = new Date(model.format(spinner.getValue()));
               Data data = new Data(amountInput[0], descriptionInput[0], dateInput[0], isDeposit);
               list[0] = new JList(Data.toStringArray());
               //list[0].setVisible(true);
               list[0].validate();
               c.add(list[0], BorderLayout.CENTER);
               validate();
           }

       }
       );
       backButton.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               validate();
               expense.setVisible(true);
               deposit.setVisible(true);
               amount.setVisible(false);
               description.setVisible(false);
               saveButton.setVisible(false);
               backButton.setVisible(false);
               spinner.setVisible(false);
           }
       });
       validate();



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
