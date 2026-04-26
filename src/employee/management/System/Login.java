package employee.management.System;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JTextField tusername;
    JPasswordField tpassword;

    JButton login, exit ;

    Login() {

        JLabel username = new JLabel("Username");
        username.setBounds(40, 20, 100, 20);
        add(username);

        tusername = new JTextField();
        tusername.setBounds(150, 20, 150, 30);
        add(tusername);

        JLabel password = new JLabel("Password");
        password.setBounds(40, 70, 100, 20);
        add(password);


        tpassword = new JPasswordField();
        tpassword.setBounds(150, 70, 150, 30);
        add(tpassword);

        login = new JButton("LOGIN");
        login.setBounds(150, 140, 150, 30);
        login.setBackground(Color.GREEN);
        login.setForeground(Color.black);
        login.addActionListener(this);
        add(login);

        exit = new JButton("EXIT");
        exit.setBounds(150, 180, 150, 30);
        exit.setBackground(Color.red);
        exit.setForeground(Color.black);
        exit.addActionListener(this);
        add(exit);

        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i22 = i11.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        ImageIcon i33 = new ImageIcon(i22);
        JLabel imgg = new JLabel(i33);
        imgg.setBounds(350, 10, 600, 400);
        add(imgg);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/LoginB.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0, 0, 600, 300);
        add(img);

        setSize(600, 300);
        setLocation(450, 200);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == login){
            try{
                String username = tusername.getText();
                String password = tpassword.getText();

                conn conn = new conn();

                String querry = "select * from login where username = '"+ username +"' and password = '"+ password +"'";
                ResultSet resultSet = conn.statement.executeQuery(querry);
                if (resultSet.next()){
                    setVisible(false);
                    new Main_class();

                }else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                }


            }catch (Exception E){
                E.printStackTrace();
            }
        }else if (e.getSource()== exit){
            System.exit(123);
        }
    }

    static void main(String[] args) {

        new Login();
    }
}
