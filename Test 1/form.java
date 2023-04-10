import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class Test extends JFrame implements ActionListener {

	// Components of the Form
	private Container c;
	private JLabel title;
	private JLabel select;
	private JCheckBox checkout;
	private JCheckBox build;
	private ButtonGroup options;
	private JLabel add;
	private JTextArea tadd;
	private JTextArea prompt;
	private JCheckBox term;
	private JButton sub;
	private JButton reset;
	private JTextArea tout;
	private JLabel res;
	private JTextArea resadd;
	private JButton downloadButton;

	// constructor, to initialize the components
	// with default values.
	public Test() {
		setTitle("Groovy to Yaml");
		setBounds(300, 90, 900, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		c = getContentPane();
		c.setLayout(null);

		Border border = BorderFactory.createLineBorder(Color.CYAN, 15);
		((JComponent) getContentPane()).setBorder(border);
		// getContentPane().setBackground(Color.WHITE);

		title = new JLabel("Groovy to Yaml");
		title.setFont(new Font("Monospaced", Font.BOLD, 30));
		title.setSize(300, 30);
		title.setLocation(300, 30);
		c.add(title);

		select = new JLabel("Groovy Actions");
		select.setFont(new Font("Arial", Font.PLAIN, 18));
		select.setSize(200, 20);
		select.setLocation(100, 150);
		c.add(select);

		checkout = new JCheckBox("CHECKOUT");
		checkout.setFont(new Font("Arial", Font.PLAIN, 12));
		checkout.setSelected(true);
		checkout.setSize(150, 20);
		checkout.setLocation(200, 200);
		checkout.setSelected(false);
		c.add(checkout);

		build = new JCheckBox("BUILD");
		build.setFont(new Font("Arial", Font.PLAIN, 12));
		build.setSelected(false);
		build.setSize(200, 20);
		build.setLocation(200, 230);
		c.add(build);

		options = new ButtonGroup();
		options.add(checkout);
		options.add(build);

		add = new JLabel("Input");
		add.setFont(new Font("Arial", Font.PLAIN, 18));
		add.setSize(100, 20);
		add.setLocation(100, 300);
		c.add(add);

		tadd = new JTextArea();
		tadd.setFont(new Font("Arial", Font.PLAIN, 15));
		tadd.setSize(200, 75);
		tadd.setLocation(200, 300);
		tadd.setLineWrap(true);
		c.add(tadd);

		prompt = new JTextArea();
		prompt.setFont(new Font("Arial", Font.PLAIN, 15));
		prompt.setSize(200, 25);
		prompt.setLocation(200, 270);
		prompt.setLineWrap(true);
		c.add(prompt);


		term = new JCheckBox("Confirm");
		term.setFont(new Font("Arial", Font.PLAIN, 12));
		term.setSize(250, 20);
		term.setLocation(200, 400);
		c.add(term);

		sub = new JButton("ToYaml");
		sub.setFont(new Font("Arial", Font.PLAIN, 15));
		sub.setSize(100, 20);
		sub.setLocation(200, 450);
		sub.addActionListener(this);
		c.add(sub);

		downloadButton = new JButton("Download");
		downloadButton.setFont(new Font("Arial", Font.PLAIN, 12));
		downloadButton.setSize(90, 20);
		downloadButton.setLocation(710, 70);
		downloadButton.addActionListener(this);
		c.add(downloadButton);

		reset = new JButton("Reset");
		reset.setFont(new Font("Arial", Font.PLAIN, 15));
		reset.setSize(100, 20);
		reset.setLocation(295, 450);
		reset.addActionListener(this);
		c.add(reset);

		tout = new JTextArea();
		tout.setFont(new Font("Arial", Font.PLAIN, 15));
		tout.setSize(300, 400);
		tout.setLocation(500, 100);
		tout.setLineWrap(true);
		tout.setEditable(false);
		c.add(tout);

		res = new JLabel("");
		res.setFont(new Font("Arial", Font.PLAIN, 20));
		res.setSize(500, 25);
		res.setLocation(100, 500);
		c.add(res);

		resadd = new JTextArea();
		resadd.setFont(new Font("Arial", Font.PLAIN, 15));
		resadd.setSize(200, 75);
		resadd.setLocation(580, 175);
		resadd.setLineWrap(true);
		c.add(resadd);

		setVisible(true);

		checkout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkout.isSelected()) {
					// Checkbox is selected
					prompt.setText("Enter Github URL");

					
					
				} else {
					// Checkbox is not selected
					tadd.setText("Github URL not selected");
				}
				if (checkout.isEnabled()) {
					String userInput = tadd.getText();
					
				}
			}
		});

	}

	// method actionPerformed()
	// to get the action performed
	// by the user and act accordingly
	public void actionPerformed(ActionEvent e) {

		/*
		 * if (checkout.isSelected()) { String input = JOptionPane.showInputDialog(this,
		 * "Enter GIT Hub URL:"); tadd.setText(input); } else { tadd.setText(""); }
		 */

		if (e.getSource() == sub) 
		{ 
			if (term.isSelected()) 
			{ 
				String data1;

				if (checkout.isSelected())


					data1 = "- uses: actions/checkout@v3\r\n" + "  with:\r\n" +
							"    # Repository name with owner. For example, actions/checkout\r\n" +
							"    # Default: ${{ github.repository }}\r\n" + "    repository: ''" + "\n";


				else data1 = " build:\r\n" + "    runs-on: ubuntu-latest" + "\n";


				String text = tout.getText();


				/*  try { // Create a new text file with the user input as content File file =
		  new File("user_input.txt"); FileWriter writer = new FileWriter(file);
		  writer.write(text); writer.close();

		  JOptionPane.showMessageDialog(null, "File downloaded successfully!"); } catch
		  (IOException ex) { JOptionPane.showMessageDialog(null,
		  "Error creating file: " + ex.getMessage()); }
				 */
				tout.setText(data1); tout.setEditable(false);
				res.setText("Converted to Yaml Format..");

			} else { tout.setText(""); resadd.setText(""); res.setText("Please confirm");
			} }

		else if (e.getSource() == reset) 
		{ String def = ""; 
		tadd.setText(def);
		res.setText(def); 
		tout.setText(def); 
		term.setSelected(false);
		resadd.setText(def); 
		}

	}

}


/*
 * public void actionPerformeds(ActionEvent e) { checkout.addActionListener(new
 * ActionListener() {
 * 
 * @Override public void actionPerformed(ActionEvent e) { if
 * (checkout.isSelected()) { tadd.setText("Checkbox is selected"); } else {
 * tadd.setText(""); // clear the text if checkbox is deselected } } }); } }
 */

// Driver Code
class Form {

	public static void main(String[] args) throws Exception {
		Test f = new Test();

	}
}
