import javax.mail.MessagingException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Quiz extends JFrame implements ActionListener {
    JRadioButton rb1, rb2, rb3, rb4;
    JButton LifeLine, next, submit;
    JLabel qno;
    JLabel que;
    JLabel timer;
    String uname;
    String[][] q = new String[10][5];
    public String[][] pa = new String[10][1];   //Person Answer
    public String[][] qa = new String[10][2];   //Question Ansewer
    ButtonGroup bg;
    int FinalScore;

    int scorer = 0, cnt = 0;
    int i, j;

    Quiz(String userName) throws InterruptedException {
        uname = userName;
        //All questions with answers
        q[0][0] = "Which is used to find and fix bugs in the Java programs.?";
        q[0][1] = "JVM";
        q[0][2] = "JDB";
        q[0][3] = "JDK";
        q[0][4] = "JRE";

        q[1][0] = "What is the return type of the hashCode() method in the Object class?";
        q[1][1] = "int";
        q[1][2] = "Object";
        q[1][3] = "long";
        q[1][4] = "void";

        q[2][0] = "Which package contains the Random class?";
        q[2][1] = "java.util package";
        q[2][2] = "java.lang package";
        q[2][3] = "java.awt package";
        q[2][4] = "java.io package";

        q[3][0] = "An interface with no fields or methods is known as?";
        q[3][1] = "Runnable Interface";
        q[3][2] = "Abstract Interface";
        q[3][3] = "Marker Interface";
        q[3][4] = "CharSequence Interface";

        q[4][0] = "In which memory a String is stored, when we create a string using new operator?";
        q[4][1] = "Stack";
        q[4][2] = "String memory";
        q[4][3] = "Random storage space";
        q[4][4] = "Heap memory";

        q[5][0] = "Which of the following is a marker interface?";
        q[5][1] = "Runnable interface";
        q[5][2] = "Remote interface";
        q[5][3] = "Readable interface";
        q[5][4] = "Result interface";

        q[6][0] = "Which keyword is used for accessing the features of a package?";
        q[6][1] = "import";
        q[6][2] = "package";
        q[6][3] = "extends";
        q[6][4] = "export";

        q[7][0] = "In java, jar stands for?";
        q[7][1] = "Java Archive Runner";
        q[7][2] = "Java Archive";
        q[7][3] = "Java Application Resource";
        q[7][4] = "Java Application Runner";

        q[8][0] = "Which of the following is a mutable class in java?";
        q[8][1] = "java.lang.StringBuilder";
        q[8][2] = "java.lang.Short";
        q[8][3] = "java.lang.Byte";
        q[8][4] = "java.lang.String";

        q[9][0] = "Which of the following option leads to the portability and security of Java?";
        q[9][1] = "Bytecode is executed by JVM";
        q[9][2] = "The applet makes the Java code secure and portable";
        q[9][3] = "Use of exception handling";
        q[9][4] = "Dynamic binding between objects";

        //Answers of questions
        /////////////////////////////////////////////////////////////////////////////////////////////
        qa[0][1] = "JDB";                                                                          //
        qa[1][1] = "int";                                                                          //
        qa[2][1] = "java.util package";                                                            //
        qa[3][1] = "Marker Interface";                                                             //
        qa[4][1] = "Heap memory";                                                                  //
        qa[5][1] = "Remote interface";                                                             //
        qa[6][1] = "import";                                                                       //
        qa[7][1] = "Java Archive";                                                                 //
        qa[8][1] = "java.lang.StringBuilder";                                                      //
        qa[9][1] = "Bytecode is executed by JVM";                                                  //
        /////////////////////////////////////////////////////////////////////////////////////////////

        setBounds(50, 20, 1340, 750);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/quiz.jpg"));
        JLabel l1 = new JLabel(i1);
        l1.setBounds(0, 0, 1440, 392);
        add(l1);

        qno = new JLabel(" ");
        qno.setBounds(120, 450, 530, 30);
        qno.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(qno);

        que = new JLabel(" ");
        que.setBounds(140, 450, 530, 30);
        que.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(que);

        rb1 = new JRadioButton(" ");
        rb1.setBounds(120, 490, 230, 30);
        rb1.setBackground(Color.white);
        rb1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(rb1);

        rb2 = new JRadioButton(" ");
        rb2.setBounds(120, 513, 230, 30);
        rb2.setBackground(Color.white);
        rb2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(rb2);

        rb3 = new JRadioButton(" ");
        rb3.setBounds(120, 533, 230, 30);
        rb3.setBackground(Color.white);
        rb3.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(rb3);

        rb4 = new JRadioButton(" ");
        rb4.setBounds(120, 553, 230, 30);
        rb4.setBackground(Color.white);
        rb4.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(rb4);

        bg = new ButtonGroup();
        bg.add(rb1);
        bg.add(rb2);
        bg.add(rb3);
        bg.add(rb4);

        /////* Next button */////
        next = new JButton("Next");
        next.setBounds(1000, 600, 230, 60);
        next.setBackground(Color.blue);
        next.setForeground(Color.white);
        next.setFont(new Font("Tahoma", Font.PLAIN, 15));
        next.addActionListener(this);
        add(next);

        /////* Submit button *//////
        submit = new JButton("submit");
        submit.setBounds(1000, 500, 230, 60);
        submit.setBackground(Color.blue);
        submit.setForeground(Color.white);
        submit.setFont(new Font("Tahoma", Font.PLAIN, 15));
        submit.addActionListener(this);
        add(submit);

        timer = new JLabel("");
        timer.setBounds(1000, 400, 230, 20);
        add(timer);
        start(cnt);

        new Thread() {
            public void run() {
                String time;
                for (i = 9; i >= 0; i--) {
                    for (j = 59; j >= 0; j--) {
                        time = "" + i + ":" + j;
                        timer.setText(time);
                        timer.setBounds(1070, 430, 140, 27);
                        timer.setFont(new Font("Tahoma",Font.BOLD,25));
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                try {
                    setVisible(false);
                    pa[cnt][0]=bg.getSelection().getActionCommand();
                    if(qa[cnt][1].equals(pa[cnt][0])){
                        scorer=scorer+1;
                    }
                    new Score(scorer,uname);
                } catch (MessagingException e) {
                    e.printStackTrace();
                }
            }
        }.start();
        setVisible(true);
    }

    public void start(int cnt) {
        qno.setText("" + (cnt + 1) + ".");
        que.setText(q[cnt][0]);

        rb1.setLabel(q[cnt][1]);
        rb1.setActionCommand(q[cnt][1]);

        rb2.setLabel(q[cnt][2]);
        rb2.setActionCommand(q[cnt][2]);

        rb3.setLabel(q[cnt][3]);
        rb3.setActionCommand(q[cnt][3]);

        rb4.setLabel(q[cnt][4]);
        rb4.setActionCommand(q[cnt][4]);

        bg.clearSelection();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == next && cnt < 9)       //NEXT BUTTON .......
        {
            if (bg.getSelection() == null) {
                pa[cnt][0] = "";
            } else {
                pa[cnt][0] = bg.getSelection().getActionCommand();
                if (qa[cnt][1].equals(pa[cnt][0])) {
                    scorer = scorer + 1;
                    FinalScore = scorer;
                }
                cnt++;
                start(cnt);
            }
        } else if (e.getSource() == submit && cnt <= 9)  //SUBMIT
        {
            if (bg.getSelection() == null) {
                pa[cnt][0] = "";
            } else {
                pa[cnt][0] = bg.getSelection().getActionCommand();
                if (qa[cnt][1].equals(pa[cnt][0])) {
                    scorer = scorer + 1;
                    FinalScore = scorer;
                }
                cnt++;
                setVisible(false);
                try {
                    new Score(scorer, uname);
                } catch (MessagingException ex) {
                    ex.printStackTrace();
                }
            }
        } else if (e.getSource() == submit)       //SUBMIT
        {
            setVisible(false);
            try {
                new Score(scorer, uname);
                setVisible(false);
            } catch (MessagingException ex) {
                ex.printStackTrace();
            }
        }
    }
}




