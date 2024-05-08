import javax.mail.MessagingException;
import javax.swing.*;
import java.awt.*;
public class Score extends JFrame
{
    String email;
    Score(int marks,String uname) throws MessagingException {
        email=uname;
        setBounds(60,300,1500,200);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel l1=new JLabel("Your response has been submitted successfully...\n" +
                "You can fill out this form only once.\n" +
                "\n"+
                "Try contacting the owner of the form if you think this is a mistake.\n" +
                "\n");
        l1.setBounds(50,90,2000,35);
        l1.setFont(new Font("Mongolian baiti",Font.BOLD,20));
        l1.setForeground(Color.magenta);

        l1.setForeground(Color.BLUE);
        add(l1);
        new mailinjava(marks,email);
        setVisible(true);
        new Thread(){
            public void run(){
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.exit(0);
            }
        }.start();
    }
    public static void main(String[] args)
    {
    }
}
