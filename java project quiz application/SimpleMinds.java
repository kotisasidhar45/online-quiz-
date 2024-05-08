import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class SimpleMinds extends JFrame implements ActionListener
{
    JButton b1,b2;
    public JTextField tf1;
    public String name;
    SimpleMinds()
    {
        setBounds(40,200,1200,500);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/login.jpeg"));
        JLabel j1=new JLabel(i1);
        j1.setBounds(0,0,500,450);
        add(j1);

        JLabel j2=new JLabel("Simple Minds");
        j2.setBounds(680,20,300,40);
        j2.setFont(new Font("Mongolian baiti",Font.BOLD,40));
        j2.setForeground(Color.blue);
        add(j2);

        JLabel j3=new JLabel("Enter your Email");
        j3.setBounds(720,100,400,100);
        j3.setFont(new Font("Mongolian baiti",Font.BOLD,20));
        j3.setForeground(Color.blue);
        add(j3);

        tf1 = new JTextField();
        tf1.setBounds(720,180,150,20);
        add(tf1);

        b1=new JButton("Next");
        b1.setBounds(720,220,60,20);
        b1.setBackground(Color.blue);
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        add(b1);

        b2=new JButton("exit");
        b2.setBounds(810,220,60,20);
        b2.setBackground(Color.blue);
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        add(b2);

        setVisible(true);
    }

    public static void main(String[] args)
    {

        new SimpleMinds();
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {

            if(e.getSource()==b1)
            {
                this.setVisible(false);
                name=tf1.getText();
                new Rules(tf1.getText());
            }
            else
            {
                System.exit(0);
            }
    }
}