import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Main {
    public static void main(String[] args) {
        //to get an ip finder . we need a message asking for the Url, a text field for entering the URL
        // a button for action and displaying the IP

        //let's start with the frame
        JFrame frame = new JFrame();

        frame.setBounds(100,100,700,150);
        frame.setLayout(new GridLayout());
        frame.setVisible(true);
        frame.setTitle("IP FINDER");

        //now let's add the label to ask for the url

        JLabel label = new JLabel();
        label.setText("please enter the URL");

        //the text field
        JTextField text = new JTextField();

        //the button
        JButton b = new JButton("Get IP");
        //add action to the button
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url = text.getText();

                try {
                    InetAddress ai = InetAddress.getByName(url);
                    String ip = ai.getHostAddress();
                    //let's display the result
                    JOptionPane.showMessageDialog(null,"the IP is : "+ip,"IP",JOptionPane.INFORMATION_MESSAGE);

                } catch (UnknownHostException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });

        //let's add all the components to the frame
        frame.add(label);
        frame.add(text);
        frame.add(b);

    }
}