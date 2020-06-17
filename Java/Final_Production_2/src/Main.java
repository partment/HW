import java.awt.*;
import java.awt.event.*;

import java.util.ArrayList;

import javax.swing.*;

public class Main {
	private static JFrame jframe = new JFrame("Good Life Foods");
	
    public static void main(String args[]) {
    	jframe.setSize(300, 75);
    	jframe.setLocationRelativeTo(null);
    	jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
    	jframe.setVisible(true);
    	
    	jframe.getContentPane().setLayout((LayoutManager) new FlowLayout(FlowLayout.CENTER));
    	
    	Button placeOrder = new Button("Place an Order");
    	Button register = new Button("Register");
    	Button orderManagement = new Button("Manage Orders");
    	
    	jframe.add(placeOrder);
    	jframe.add(register);
    	jframe.add(orderManagement);
    	
    	placeOrder.addActionListener(new ActionListener() {
    	    @Override
    	    public void actionPerformed(ActionEvent e) {
    	    	displayOrder();
    	    }
    	});
    	
    	register.addActionListener(new ActionListener() {
    	    @Override
    	    public void actionPerformed(ActionEvent e) {
    	    	Register();
    	    }
    	});
    	
    	orderManagement.addActionListener(new ActionListener() {
    	    @Override
    	    public void actionPerformed(ActionEvent e) {
    	    	displayOrderManagement();
    	    }
    	});
    }
    
    private static void Register() {
    	String id = JOptionPane.showInputDialog(jframe, "Please enter your membership id :", null);
    	String address = JOptionPane.showInputDialog(jframe, "Please enter your address :", null);
    	String fallback;
    	if(id != null && address != null) {
    		Register register = new Register();
	    	fallback = register.entrance(id, address);
    	}else {
    		fallback = "Operation Canceled";
    	}
    	JOptionPane.showMessageDialog(jframe, fallback);
    }
    
    private static void displayOrder() {
    	String id = JOptionPane.showInputDialog(jframe, "Please enter your membership id :", null);
    	Database database = new Database();
    	if(database.isIDexists(id)) {
    		JDialog dialog = new JDialog(jframe, "Place an Order");
        	
        	dialog.setSize(555, 665);
        	dialog.setLocationRelativeTo(null);
        	dialog.setVisible(true);
        	
        	JPanel panel = new OrderPanel(dialog, id);
        	dialog.getContentPane().add(panel);
            dialog.pack();
    	}else {
    		JOptionPane.showMessageDialog(jframe, "Please register first!");
    	}
    }
    
    private static void displayOrderManagement() {
    	String id = JOptionPane.showInputDialog(jframe, "Please enter your membership id :", null);
    	Database database = new Database();
    	if(database.isIDexists(id)) {
    		JDialog dialog = new JDialog(jframe, "Order Management");
        	
        	dialog.setSize(300, 540);
        	dialog.setLocationRelativeTo(null);
        	dialog.setVisible(true);
        	
        	JPanel panel = new OrderManagementPanel(dialog, id);
        	dialog.getContentPane().add(panel);
            dialog.pack();
    	}else {
    		JOptionPane.showMessageDialog(jframe, "Please register first!");
    	}
    }
}

class OrderPanel extends JPanel {
	private JLabel jcomp1;
    private JTextField name_quan;
    private JLabel jcomp3;
    private JTextField value_quan;
    private JLabel jcomp5;
    private JTextField name_wei;
    private JTextField value_wei;
    private JLabel jcomp8;
    private JButton add_quan;
    private JButton add_wei;
    private JList list;
    private JButton delete;
    private JButton confirm;
    private JLabel jcomp14;
    private JLabel jcomp15;
    
    DefaultListModel listmo;
    
    private Order order;

	public OrderPanel(Dialog dialog, String id) {
        //construct preComponents

        jcomp1 = new JLabel ("Name");
        name_quan = new JTextField (5);
        jcomp3 = new JLabel ("Quantity");
        value_quan = new JTextField (5);
        jcomp5 = new JLabel ("Name");
        name_wei = new JTextField (5);
        value_wei = new JTextField (5);
        jcomp8 = new JLabel ("Weight");
        add_quan = new JButton ("ADD");
        add_wei = new JButton ("ADD");
        
        list = new JList ();
        list.setModel(new DefaultListModel());
        listmo = (DefaultListModel)list.getModel();
        
        delete = new JButton ("Delete Selected");
        confirm = new JButton ("Confirm");
        jcomp14 = new JLabel ("Sub Total : ");
        jcomp15 = new JLabel ("Total (with ship fee) :");
        
        order = new Order();

        setPreferredSize (new Dimension (555, 665));
        setLayout (null);

        add (jcomp1);
        add (name_quan);
        add (jcomp3);
        add (value_quan);
        add (jcomp5);
        add (name_wei);
        add (value_wei);
        add (jcomp8);
        add (add_quan);
        add (add_wei);
        add (list);
        add (delete);
        add (confirm);
        add (jcomp14);
        add (jcomp15);

        jcomp1.setBounds (5, 5, 100, 25);
        name_quan.setBounds (5, 25, 285, 25);
        jcomp3.setBounds (295, 5, 100, 25);
        value_quan.setBounds (295, 25, 150, 25);
        jcomp5.setBounds (5, 50, 100, 25);
        name_wei.setBounds (5, 70, 285, 25);
        value_wei.setBounds (295, 70, 150, 25);
        jcomp8.setBounds (295, 50, 100, 25);
        add_quan.setBounds (450, 25, 100, 25);
        add_wei.setBounds (450, 70, 100, 25);
        list.setBounds (5, 105, 545, 460);
        delete.setBounds (5, 570, 130, 25);
        confirm.setBounds (450, 635, 100, 25);
        jcomp14.setBounds (140, 570, 245, 25);
        jcomp15.setBounds (140, 595, 245, 25);
        
        add_quan.addActionListener(new ActionListener() {
    	    @Override
    	    public void actionPerformed(ActionEvent e) {
    	    	String name = name_quan.getText();
    	    	String quan = value_quan.getText();
    	    	if(!(name.equals("") && quan.equals(""))) {
    	    		if(order.isCake(name)) {
    	    			String message = JOptionPane.showInputDialog(dialog, "Please enter your cake message", null);
    	    			order.addOrderQuanCake(name, quan, message);
    	    		}else {
    	    			order.addOrderQuan(name, quan);
    	    		}
    	    		name_quan.setText("");
    	    		value_quan.setText("");
    	    		updateOrderPanel();
    	    	}else {
    	    		JOptionPane.showMessageDialog(dialog, "Name and Quantity can't be empty.");
    	    	}
    	    }
    	});
        
        add_wei.addActionListener(new ActionListener() {
    	    @Override
    	    public void actionPerformed(ActionEvent e) {
    	    	String name = name_wei.getText();
    	    	String wei = value_wei.getText();
    	    	if(!(name.equals("") && wei.equals(""))) {
    	    		order.addOrderWei(name, wei);
    	    		name_wei.setText("");
    	    		value_wei.setText("");
    	    		updateOrderPanel();
    	    	}else {
    	    		JOptionPane.showMessageDialog(dialog, "Name and Weight can't be empty.");
    	    	}
    	    }
    	});
        
        delete.addActionListener(new ActionListener() {
    	    @Override
    	    public void actionPerformed(ActionEvent e) {
    	    	int index = list.getSelectedIndex();
    	    	order.deleteOrder(index);
    	    	updateOrderPanel();
    	    }
    	});
        
        confirm.addActionListener(new ActionListener() {
    	    @Override
    	    public void actionPerformed(ActionEvent e) {
    	    	String fallback = order.confirmOrder(id);
    	    	JOptionPane.showMessageDialog(dialog, fallback);
    	    	if(!(fallback.equals("You haven't ordered anything yet.") || fallback.equals("Total value must have more than NTD400."))) {
    	    		dialog.dispose();
    	    	}
    	    }
    	});
    }
	
	private void updateOrderPanel() {
		jcomp14.setText("Sub Total : "+order.calcSubTotal());
		jcomp15.setText("Total (with ship fee) :"+order.calcTotal());
		ArrayList<String> items = order.getOrder();
		listmo.clear();
		for(int i = 0;i<items.size();i++) {
			listmo.addElement(items.get(i));
		}
	}
}

class OrderManagementPanel extends JPanel {
    private JList list;
    private JButton delete;
    private DefaultListModel listmo;
    OrderManagement order;

    public OrderManagementPanel(Dialog dialog, String id) {

        //construct components
    	order = new OrderManagement();
        list = new JList ();
        
        list.setModel(new DefaultListModel());
        listmo = (DefaultListModel)list.getModel();
        
        updateOrderManagementPanel();

        //adjust size and set layout
        setPreferredSize (new Dimension (300, 540));
        setLayout (null);

        //add components
        add (list);

        //set component bounds (only needed by Absolute Positioning)
        list.setBounds (5, 5, 290, 530);
        
        list.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                if (evt.getClickCount() == 2) {
                	int index = list.locationToIndex(evt.getPoint());
                	String id = listmo.getElementAt(index).toString().split(" ")[0];
                	String fallback = order.getOrderByID(id);
                	JOptionPane.showMessageDialog(dialog, fallback);
                }
            }
        });
    }
    
    private void updateOrderManagementPanel() {
    	ArrayList<String> items = order.getOrders();
		listmo.clear();
		for(int i = 0;i<items.size();i++) {
			listmo.addElement(items.get(i));
		}
    }
}