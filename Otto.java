package OttoMachine;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class Otto {

	private JFrame frame;
	private JPanel panelWelcome;
	private JPanel panelMenu;
	private JTextField textField_1;

	private User user1;
	private User user2;
	private User user3;
	private Account anAccount;
	private Payment aPayment;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Otto window = new Otto();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Otto() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		/** 
		Create some users
		 */
		user1 = new User(43891512, "John", "Smith");
		user2 = new User(34579260, "Mary", "Graham");
		user3 = new User(94887462, "Bill", "Doe");
		
		anAccount = new Account();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));

		JPanel panelWelcome = new JPanel();
		frame.getContentPane().add(panelWelcome, "name_23905255523783");
		panelWelcome.setLayout(null);
		panelWelcome.setVisible(true);

		JLabel label = new JLabel("WELCOME!");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Papyrus", Font.BOLD, 35));
		label.setBounds(111, 32, 221, 74);
		panelWelcome.add(label);
		
		JPanel panelMenu = new JPanel();
		frame.getContentPane().add(panelMenu, "name_25215411239751");
		panelMenu.setLayout(null);
		panelMenu.setVisible(false);

		JLabel lblSelectUser = new JLabel("Select user ID");
		lblSelectUser.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblSelectUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectUser.setBounds(133, 118, 169, 16);
		panelWelcome.add(lblSelectUser);
		
		JComboBox<Integer> comboBox = new JComboBox<Integer>();
		comboBox.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		comboBox.addItem(user1.getUserId());
		comboBox.addItem(user2.getUserId());
		comboBox.addItem(user3.getUserId());
		comboBox.setSelectedItem(null);
		comboBox.setBounds(124, 146, 188, 41);
		panelWelcome.add(comboBox);
		

		JLabel lblWelcome = new JLabel("");
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setBounds(112, 6, 211, 29);
		panelMenu.add(lblWelcome);

		JButton button = new JButton("GO");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelWelcome.setVisible(false);
				panelMenu.setVisible(true);
				int value = (int)comboBox.getSelectedItem();
				switch(value) {
					case 43891512: 
						lblWelcome.setText("Welcome " + user1.getfirstname() + " " + user1.getlastname());
						break;
					case 34579260: 
						lblWelcome.setText("Welcome " + user2.getfirstname() + " " + user2.getlastname());
						break;
					case 94887462: 
						lblWelcome.setText("Welcome " + user3.getfirstname() + " " + user3.getlastname());
						break;
				}
			}
		});
		button.setBounds(158, 199, 117, 29);
		panelWelcome.add(button);

		JButton btnDeposit = new JButton("Deposit money");
		btnDeposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean again = true;
				while (again) {
					String inputDeposit = JOptionPane.showInputDialog(null, "Enter the amount to deposit: ");
					double amount = 0;
					if (inputDeposit == null) {
						JOptionPane.showMessageDialog(null, "Action canceled.");
						again = false;
					} else {
						try {
							amount = Double.parseDouble(inputDeposit);
							if (anAccount.setBalance(amount) == false) {
								JOptionPane.showMessageDialog(null, "Invalid amount.");
								again = true;
							} else {
								anAccount.deposit(amount);
								double nbalance = anAccount.getBalance();
								String s = new String();
								s = "Account balance: " + String.valueOf(nbalance);
								textField_1.setText(s);
								String toAccount = "Customer self-service";
								String description = "Deposit money";
								aPayment = new Payment(toAccount, description, amount);
								again = false;
							}				
						}
						catch (NumberFormatException c) {
							JOptionPane.showMessageDialog(null, "Please enter a number.");
						}
					}
				}
			}
		});
		btnDeposit.setBounds(43, 102, 148, 63);
		panelMenu.add(btnDeposit);

		JButton btnWithdrawMoney = new JButton("Withdraw money");
		btnWithdrawMoney.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean again = true;
				while (again) {
					String inputWithdraw = JOptionPane.showInputDialog(null, "Enter the amount to withdraw: ");
					double amount = 0;
					if (inputWithdraw == null) {
						JOptionPane.showMessageDialog(null, "Action canceled.");
						again = false;
					} else {
						try {
							amount = Double.parseDouble(inputWithdraw);
							double balance = anAccount.getBalance();
							if (amount < 0 || amount > balance) {
								JOptionPane.showMessageDialog(null, "Invalid amount.");
								again = true;
							} else {
								anAccount.withdraw(amount);
								double nbalance = anAccount.getBalance();
								String s = new String();
								s = "Account balance: " + String.valueOf(nbalance);
								textField_1.setText(s);
								String toAccount = "Customer self-service";
								String description = "Withdraw money";
								aPayment = new Payment(toAccount, description, -amount);
								again = false;
							}				
						}
						catch (NumberFormatException c) {
							JOptionPane.showMessageDialog(null, "Please enter a number.");
						}
					}
				}
			}
		});
		btnWithdrawMoney.setBounds(250, 102, 148, 63);
		panelMenu.add(btnWithdrawMoney);

		JButton btnMakeAPayment = new JButton("Make a payment");
		btnMakeAPayment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean again = true;
				while (again) {
					String bAccount = JOptionPane.showInputDialog("Enter beneficiary account number: ");
					if (bAccount == null) {
						JOptionPane.showMessageDialog(null, "Action canceled.");
						again = false;
					} else {
						String description = JOptionPane.showInputDialog("Enter description: ");
						if (description == null) {
							JOptionPane.showMessageDialog(null, "Action canceled.");
							again = false;
						} else {
							boolean again2 = true;
							while (again2) {
							String inputPayment = JOptionPane.showInputDialog("Enter amount to transfer: ");
							double amount = 0;
							if (inputPayment == null) {
								JOptionPane.showMessageDialog(null, "Action canceled.");
								again = false;
								again2 = false;
							} else {
								try {
									amount = Double.parseDouble(inputPayment);
									double balance = anAccount.getBalance();
									if (amount < 0 || amount > balance) {
										JOptionPane.showMessageDialog(null, "Invalid amount.");
										again2 = true;
									} else {
										anAccount.withdraw(amount);
										double nbalance = anAccount.getBalance();
										String s = new String();
										s = "Account balance: " + String.valueOf(nbalance);
										textField_1.setText(s);
										aPayment = new Payment(bAccount, description, -amount);
										again = false;
										again2 = false;
									}				
								}
								catch (NumberFormatException c) {
									JOptionPane.showMessageDialog(null, "Please enter a number.");
								}
							}
						}
						}
					}
				}
			}
		});
		btnMakeAPayment.setBounds(43, 177, 148, 63);
		panelMenu.add(btnMakeAPayment);

		JButton btnLatestTransaction = new JButton("Latest transaction");
		btnLatestTransaction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, aPayment.getDescription());
			}
		});
		btnLatestTransaction.setBounds(250, 177, 148, 63);
		panelMenu.add(btnLatestTransaction);

		JButton btnLogOut = new JButton("Log out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelWelcome.setVisible(true);
				panelMenu.setVisible(false);
				anAccount.reset();
				textField_1.setText("");
			}
		});
		btnLogOut.setBounds(164, 252, 117, 29);
		panelMenu.add(btnLogOut);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setBounds(72, 36, 296, 34);
		panelMenu.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblChooseAnAction = new JLabel("Choose an action");
		lblChooseAnAction.setHorizontalAlignment(SwingConstants.CENTER);
		lblChooseAnAction.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblChooseAnAction.setBounds(121, 71, 202, 29);
		panelMenu.add(lblChooseAnAction);
		
		frame.setLocationRelativeTo(null);
	}
}
