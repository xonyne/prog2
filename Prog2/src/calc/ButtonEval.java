package calc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonEval implements ActionListener{
	
	Calc calc;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Double val1 = Double.parseDouble(calc.getOperand1());
		Double val2 = Double.parseDouble(calc.getOperand2());
		Double result = 0d;	
		
		if (e.getActionCommand().equals("+")) {
			result = val1 + val2;
		} else if (e.getActionCommand().equals("-")) { 
			result = val1 - val2;
		} else if (e.getActionCommand().equals("*")) {
			result = val1 * val2;
		} else if (e.getActionCommand().equals("/")) {
			result = val1 / val2;
		}
		
		calc.setResult(result);
		
	}
	
	public ButtonEval(Calc calc){
		this.calc = calc;
	}

}
