import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UI extends JFrame {


    public static void main(String[] args) {
        JFrame frame;
        JPanel jp;
        JLabel jl1,jl2;
        JTextField jtf1,jtf2;
        JButton jb1,jb2,jb3;
        JTextArea jta;

        frame = new JFrame("24点游戏");    //创建Frame窗口
        /* Container contentPane = frame.getContentPane();
        contentPane.setLayout(new BorderLayout());*/
        frame.setBounds(300, 200, 400, 300);
//        frame.setLayout(new FlowLayout(FlowLayout.LEFT));

        jp = new JPanel();

        jl1 = new JLabel("username: ");
        jl2 = new JLabel();
        jl1.setFont(new Font("console", Font.BOLD, 16));
        jtf1 = new JTextField("", 15);
        jtf2 = new JTextField("", 15);
        jtf1.setHorizontalAlignment(SwingConstants.LEFT);
        jta = new JTextArea(10,25);
        /*jta.setAlignmentX(200);
        jta.setAlignmentY(20);*/

        jb1 = new JButton("Confirm");
        jb1.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                baseInfo.getUsername(jtf1.getText());
                System.out.println(baseInfo.username);
            }
        });
        jb2 = new JButton("开始游戏");
        jb2.setHorizontalAlignment(SwingConstants.LEFT);
        jb2.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jl2.setText(index.returnFinalStr());
//                jta.setText(checkAnswer.checkAnswer());//获取finalStr
            }
        });
//        jb2.setHorizontalAlignment(SwingConstants.CENTER);

        jb3 = new JButton("提交表达式");
        jb3.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = jtf2.getText();
                jtf2.setText(s.replace('#','=')+" = "+baseInfo.calResult());
            }
        });



        jp.add(jl1);
        jp.add(jtf1);
        jp.add(jb1);
        jp.add(jb2);
//        jp.add(jta);
        jp.add(jl2);
        jp.add(jtf2);
        jp.add(jb3);
        frame.add(jp);

//        frame.setBounds(300,200,600,400);
        frame.setResizable(true);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

}