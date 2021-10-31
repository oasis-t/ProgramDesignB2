import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UI extends JFrame {
    JFrame frame;
    JPanel jp;
    JLabel jl;
    JTextField jtf;
    JButton jb;

    public UI(){
        frame = new JFrame("24点游戏");    //创建Frame窗口
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new BorderLayout());

        jl = new JLabel("username: ");
        jl.setFont(new Font("console",Font.BOLD,16));
        jtf =new JTextField("",10);
        jtf.setHorizontalAlignment(JTextField.CENTER);

        jb = new JButton("生成随机数");

        jp.add(jl);
        jp.add(jtf);
        jp.add(jb);
        contentPane.add(jp);

        frame.setBounds(300,200,600,400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}