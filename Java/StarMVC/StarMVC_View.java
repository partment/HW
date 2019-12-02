import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
 
public class StarMVC_View {
    public static void main(String args[]) {
        JFrame star = new JFrame("Star MVC");
        star.setSize(300, 100);
        star.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        star.setLayout(new FlowLayout());

        JLabel label = new JLabel("Alphabet : ");
        JTextField input = new JTextField(10);
        JButton enter = new JButton("Confirm");
        JLabel resultlabel = new JLabel("Result : ");

        enter.addActionListener(new ActionListener() {        
    		public void actionPerformed(ActionEvent e) {
    			String alphabet = input.getText();
         		StarMVC_Controller controller = new StarMVC_Controller();
        		String result = controller.Forwarding(alphabet);
        		resultlabel.setText("Result : "+result);
    		}
		}); 

        star.add(label);
        star.add(input);
        star.add(enter);
        star.add(resultlabel);

        star.setVisible(true);
    }
}