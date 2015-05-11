package calc;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calc extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField op1 = new JTextField();
	private JTextField op2 = new JTextField();
	private JTextField res = new JTextField();
	private JLabel equals = new JLabel("=");
	
	private JButton plus = new JButton("+");
	private JButton minus = new JButton("-");
	private JButton mult = new JButton("*");
	private JButton div = new JButton("/");
	
	public Calc() {
		// !!! GridLayout: column value is ignored if both rows and columns are set to non-zero values !!!
		this.setLayout(new GridLayout(2,4));
		
		ActionListener al = new ButtonEval(this);
		plus.addActionListener(al);
		minus.addActionListener(al);
		mult.addActionListener(al);
		div.addActionListener(al);
		
		JPanel buttons = new JPanel(new FlowLayout());
		buttons.add(minus);
		buttons.add(plus);
		buttons.add(div);
		buttons.add(mult);
		
		this.add(op1);
		this.add(op2);
		this.add(equals);
		this.add(res);
		this.add(buttons);
	}
	
	public static void main(String args[]) {
		Calc calc = new Calc();
		calc.setSize(800,500);
		calc.setVisible(true);
	}
	
	public String getOperand1() {
		return this.op1.getText();
	}
	
	public String getOperand2() {
		return this.op2.getText();
	}
	
	public void setResult(Double result) {
		this.res.setText(result.toString());
	}
	

}
