import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Rules extends JFrame implements ActionListener
{
        String  name;
        JButton b1,b2;
        Rules(String username)
        {
                name=username;
                setBounds(50,100,1000,650);
                getContentPane().setBackground(Color.white);
                setLayout(null);

                JLabel l1=new JLabel("Instuctions");
                l1.setBounds(300,20,1200,70);
                l1.setFont(new Font("Viner Hand ITC",Font.BOLD,40));
                l1.setForeground(Color.BLUE);
                add(l1);

                JLabel l2=new JLabel("<html>"+"Close all programs, including email"+"<br><br>"
                        +"Click on the Click here to open the exam link provided in the email from The College."
                       +"<br><br>"+"Click 'Log In For Your Exam Here' at the bottom of the screen."
                        +"<br><br>"+"Have your Proctor enter the Username and Password provided in the email from The College and click enter."
                        +"<br><br>"+"To begin the exam, click on the link to the appropriate exam listed under Online Assessments."+"<html>");
                l2.setBounds(10,40,1200,400);
                l2.setFont(new Font("Mongolian baiti",Font.BOLD,20));
                l2.setForeground(Color.black);
                add(l2);

                b1=new JButton("START");
                b1.setBounds(220,420,90,40);
                b1.setForeground(Color.white);
                b1.setBackground(Color.blue);
                b1.addActionListener(this);
                add(b1);

                b2=new JButton("BACK");
                b2.setBounds(500,420,90,40);
                b2.setForeground(Color.white);
                b2.setBackground(Color.blue);
                b2.addActionListener(this);
                add(b2);

                setVisible(true);
        }
    public static void main(String[] args)
    {
    }
    @Override
    public void actionPerformed(ActionEvent et) {
        if(et.getSource()==b1){
                this.setVisible(false);
            try {
                new Quiz(name);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }}
            else {
                setVisible(false);
                new SimpleMinds();
            }
        }
    }

