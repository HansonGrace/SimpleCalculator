import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.security.Key;
import java.text.DecimalFormat;


public class CalcGUI extends JFrame implements ActionListener,KeyListener {
	
	//declare variables
	 Prakseis praksh = new Prakseis();
	 JButton buttonAc = new JButton("AC");
	 JButton buttonPlusMinus = new JButton("+/-");
	 JButton buttonPercentage = new JButton("%");
	 JButton buttonDia = new JButton("÷");
	 JButton buttonEpi = new JButton("X");
	 JButton buttonMinus = new JButton("-");
	 JButton buttonPlus = new JButton("+");
	 JButton buttonEquals = new JButton("=");
	 JButton buttonKomma = new JButton(",");
	 
	 public JButton[] button = new JButton[10];
	 JButton[] functionButton = {buttonAc, buttonPlusMinus, buttonPercentage, buttonDia, buttonEpi, buttonMinus, buttonPlus, buttonEquals, buttonKomma};
	 JButton button1;
	 public JButton button2;
	 public JButton button3;
	 public JButton button4;
	 public JButton button5;
	 public JButton button6;
	 public JButton button7;
	 public JButton button8;
     public JButton button9;
	 public JButton button0;
	 Font myFont;
	 double num1, num2, result;
	 char function;
	 JTextField textField;
	 //create intrface for calculator
	    CalcGUI() {
	        myFont = new Font("Apple Casual", Font.PLAIN, 20);
	        this.setDefaultCloseOperation(3);
	        this.setLayout(null);
	        this.setSize(300, 300);

	        textField = new JTextField("0");
	        textField.setBounds(0, 0, 300, 30);
	        textField.setEditable(false);
	        textField.setFocusable(false);
	        textField.setFont(myFont);
	        this.add(textField);


	        for (int i = 0; i < 10; i++) {
	            button[i] = new JButton(String.valueOf(i));
	            button[i].addActionListener(this);
	            setKeyBinding(button[i], KeyEvent.VK_0 + i, String.valueOf(i));
	            if (i < 9) {
	                functionButton[i].addActionListener(this);
	            }
	        }

	        Panel panel = new Panel();
	        panel.setBounds(0, 30, 300, 270);
	        panel.setLayout(new GridLayout(5, 3, 5, 5));
		//add interface panels
	        panel.add(buttonAc);
	        panel.add(buttonPlusMinus);
	        panel.add(buttonPercentage);
	        panel.add(buttonDia);
	        panel.add(button[7]);
	        panel.add(button[8]);
	        panel.add(button[9]);
	        panel.add(buttonEpi);
	        panel.add(button[4]);
	        panel.add(button[5]);
	        panel.add(button[6]);
	        panel.add(buttonMinus);
	        panel.add(button[1]);
	        panel.add(button[2]);
	        panel.add(button[3]);
	        panel.add(buttonPlus);
	        panel.add(button[0]);
	        panel.add(buttonKomma);
	        panel.add(buttonEquals);


	        this.add(panel);
	        this.add(textField);
	        this.setResizable(true);
	        this.setVisible(true);
			//add binding to text buttons
	        setKeyBinding(buttonPlus, KeyEvent.VK_PLUS, "PLUS");
	        setKeyBinding(buttonMinus, KeyEvent.VK_MINUS, "MINUS");
	        setKeyBinding(buttonEpi, KeyEvent.VK_MULTIPLY, "MULTIPLY");
	        setKeyBinding(buttonDia, KeyEvent.VK_DIVIDE, "DIVIDE");
	        setKeyBinding(buttonEquals, KeyEvent.VK_ENTER, "ENTER");
	        setKeyBinding(buttonAc, KeyEvent.VK_BACK_SPACE, "BACK_SPACE");
	        setKeyBinding(buttonKomma, KeyEvent.VK_PERIOD, "PERIOD");
	    }

	    public boolean check(double num1, double num2, double result) {
	        if (result == 0) {
	            return false;
	        } else {
	            return true;
	        }
	    }


	    public double GetValueOnScreen() {
	        return Double.parseDouble(textField.getText());
	    }


	    public String MaybeDoubleToInt(double a) {
	        DecimalFormat decimalFormat = new DecimalFormat("#.##");
	        return decimalFormat.format(a);
	    }

	    boolean k = true;

	    public void actionPerformed(ActionEvent e) {
	        for (int i = 0; i < 10; i++) {
	            if (e.getSource() == button[i]) {
	                if (k) {
	                    textField.setText(String.valueOf(i));
	                    k = false;
	                } else {
	                    textField.setText(textField.getText().concat(String.valueOf(i)));
	                }
	            }
	        }
	        if (e.getSource() == buttonAc) {
	            textField.setText("0");
	            k = true;
	        }
	        if (e.getSource() == buttonPlus) {
	            function = '+';
	            num1 = Double.parseDouble(textField.getText());
	            k = true;
	        }
	        if (e.getSource() == buttonMinus) {
	            function = '-';
	            num1 = Double.parseDouble(textField.getText());
	            k = true;
	        }
	        if (e.getSource() == buttonEpi) {
	            function = '*';
	            num1 = Double.parseDouble(textField.getText());
	            k = true;
	        }
	        if (e.getSource() == buttonDia) {
	            function = '/';
	            num1 = Double.parseDouble(textField.getText());
	            k = true;
	        }
	        if (e.getSource() == buttonPlusMinus) {
	            if (Double.parseDouble(textField.getText()) != 0) {
	                textField.setText(MaybeDoubleToInt(praksh.PlusMinus(GetValueOnScreen())));
	            }
	        }
	        if (e.getSource() == buttonPercentage) {
	            textField.setText(MaybeDoubleToInt(praksh.Percentage(GetValueOnScreen())));
	        }
	        if (e.getSource() == buttonKomma) {
	            textField.setText(textField.getText().concat("."));
	        }
	        if (e.getSource() == buttonEquals) {
	            num2 = GetValueOnScreen();
	            switch (function) {
	                case '+':
	                    result = praksh.Plus(num1, num2);
	                    break;
	                case '-':
	                    result = praksh.Minus(num1, num2);
	                    break;
	                case '*':
	                    result = praksh.Multiply(num1, num2);
	                    break;
	                case '/':
	                    result = praksh.Div(num1, num2);
	                    break;
	            }
	            if ((int) result == result) {
	                textField.setText(String.valueOf(MaybeDoubleToInt(result)));
	            } else {
	                textField.setText(String.valueOf(result));
	            }
	            num1 = result;
	            k = true;
	        }
	    }

	    public void keyTyped(KeyEvent e) {
	    }

	    @Override
	    public void keyPressed(KeyEvent e) {
	        int key = e.getKeyCode();
	        if (key >= KeyEvent.VK_0 && key <= KeyEvent.VK_9) {
	            int num = key - KeyEvent.VK_0;
	            button[num].doClick();
	        } else if (key == KeyEvent.VK_DECIMAL || key == KeyEvent.VK_PERIOD) {
	            buttonKomma.doClick();
	        } else if (key == KeyEvent.VK_PLUS || key == KeyEvent.VK_ADD) {
	            buttonPlus.doClick();
	        } else if (key == KeyEvent.VK_MINUS || key == KeyEvent.VK_SUBTRACT) {
	            buttonMinus.doClick();
	        } else if (key == KeyEvent.VK_MULTIPLY) {
	            buttonEpi.doClick();
	        } else if (key == KeyEvent.VK_DIVIDE || key == KeyEvent.VK_SLASH) {
	            buttonDia.doClick();
	        } else if (key == KeyEvent.VK_ENTER) {
	            buttonEquals.doClick();
	        } else if (key == KeyEvent.VK_BACK_SPACE) {
	            buttonAc.doClick();
	        }
	    }

	    @Override
	    public void keyReleased(KeyEvent e) {
	    }


	    private void setKeyBinding(JButton button, int keyCode, String actionName) {
	        InputMap inputMap = button.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
	        ActionMap actionMap = button.getActionMap();

	        inputMap.put(KeyStroke.getKeyStroke(keyCode, 0), actionName);
	        actionMap.put(actionName, new AbstractAction() {
	            public void actionPerformed(ActionEvent e) {
	                button.doClick();
	            }
	        });
	    }
}