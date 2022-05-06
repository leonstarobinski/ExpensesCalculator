package Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
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
       c.setLayout(new FlowLayout());
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
       c.add(panel);
       JTextArea amount = new JTextArea("Hier schreiben Sie das Amount");
       JTextArea description = new JTextArea("Place holder");
       JTextField date = new JTextField();

       SimpleDateFormat model = new SimpleDateFormat("dd/MM/yyyy");
       JSpinner spinner = new JSpinner(new SpinnerDateModel());
       spinner.setEditor(new JSpinner.DateEditor(spinner, model.toPattern()));

       JTextArea[] list = {new JTextArea(Data.toStringList())};
       list[0].setVisible(true);
       scrollPane = new JScrollPane(list[0]);
       scrollPane.setLayout(new ScrollPaneLayout());
       list[0].setLayout(new FlowLayout());
       c.add(list[0]);
        JButton connectButton = new JButton("Connect");
        panel.add(connectButton);
       backButton.setVisible(false);
       saveButton.setVisible(false);
       amount.setVisible(false);
       description.setVisible(false);
       date.setVisible(false);
       JPanel panel2 = new JPanel();
       panel2.add(spinner);
       spinner.setVisible(false);
       panel2.setLayout(new FlowLayout());
       panel2.setVisible(true);
       c.add(panel2);
       panel2.add(amount);
       panel2.add(description);
       c.add(date);
       expense.setVisible(false);
       deposit.setVisible(false);
       final JTextArea[] j = {new JTextArea(Data.getPercentage())};
       j[0].setEditable(false);
       c.add(j[0]);
       connectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SwingWorker() {
                    @Override
                    protected Object doInBackground() throws Exception {
                        try {
                            client.connect();

                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                        return null;
                    }
                }.execute();

                connectButton.setVisible(false);
                expense.setVisible(true);
                deposit.setVisible(true);
                validate();
                repaint();
            }
        });

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
               repaint();
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
               repaint();
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
                c.remove(list[0]);
               list[0] = new JTextArea(Data.toStringList());
               list[0].setEditable(false);

               c.add(list[0]);
               c.remove(j[0]);
               j[0] = new JTextArea(Data.getPercentage());
               j[0].setEditable(false);
               c.add(j[0]);
               validate();
               repaint();
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
               validate();
               repaint();
           }
       });
       validate();
       repaint();



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
