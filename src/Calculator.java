import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener{

    //creating a calculator object in the main
    public static void main(String[] args) {

        Calculator calc = new Calculator();
    }

    JFrame frame;
    JTextField textfield;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[17];
    JButton additionButton,subtractionButton,multiplyButton,divisionButton,decimalButton, equalButton;
    JButton sinButton, cosButton, tanButton, InvsinButton, InvcosButton, InvtanButton, deleteButton;
    JButton clearButton, negationButton, remainderButton, empButton2;
    JPanel panel;

    Font systemFont = new Font("Calibri",Font.BOLD,25);

    int mathOperator;
    double num1 = 0, num2 = 0, result = 0;


    Calculator(){

        frame = new JFrame("calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(590, 700);
        frame.setLayout(null);

        //display screen
        textfield = new JTextField();
        textfield.setBounds(50, 25, 350, 50);
        textfield.setFont(systemFont);
        textfield.setEditable(false);

        //function button initialization
        additionButton = new JButton("+");
        subtractionButton = new JButton("-");
        multiplyButton = new JButton("*");
        divisionButton = new JButton("/");
        decimalButton = new JButton(".");
        equalButton = new JButton("=");
        deleteButton = new JButton("DEL");
        clearButton = new JButton("CLR");
        negationButton = new JButton("(-)");
        sinButton = new JButton("sin");
        cosButton = new JButton("cos");
        tanButton = new JButton("tan");
        InvsinButton = new JButton("asin");
        InvcosButton = new JButton("acos");
        InvtanButton = new JButton("atan");
        remainderButton = new JButton("%");
        empButton2 = new JButton(" ");

        functionButtons[0] = additionButton;
        functionButtons[1] = subtractionButton;
        functionButtons[2] = multiplyButton;
        functionButtons[3] = divisionButton;
        functionButtons[4] = decimalButton;
        functionButtons[5] = equalButton;
        functionButtons[6] = deleteButton;
        functionButtons[7] = clearButton;
        functionButtons[8] = negationButton;
        functionButtons[9] = sinButton;
        functionButtons[10] = cosButton;
        functionButtons[11] = tanButton;
        functionButtons[12] = InvsinButton;
        functionButtons[13] = InvcosButton;
        functionButtons[14] = InvtanButton;
        functionButtons[15] = remainderButton;
        functionButtons[16] = empButton2;

        for( int i = 0 ; i < 17 ; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(systemFont);
            functionButtons[i].setFocusable(false);
        }

        for(int i = 0; i<10 ;i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(systemFont);
            numberButtons[i].setFocusable(false);
        }

        //base panel initialization
        panel = new JPanel();
        panel.setBounds(50, 100, 350, 420);
        panel.setLayout(new GridLayout(6,4,10,10));

        //constructing base panel
        panel.add(InvsinButton);       //row 1
        panel.add(InvcosButton);
        panel.add(InvtanButton);
        panel.add(remainderButton);
        panel.add(sinButton);          //row 2
        panel.add(cosButton);
        panel.add(tanButton);
        panel.add(empButton2);
        panel.add(numberButtons[1]);   //row 3
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(additionButton);
        panel.add(numberButtons[4]);    //row 4
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subtractionButton);
        panel.add(numberButtons[7]);    //row 5
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(multiplyButton);
        panel.add(decimalButton);       //row 6
        panel.add(numberButtons[0]);
        panel.add(equalButton);
        panel.add(divisionButton);

        //below base panel
        negationButton.setBounds(50,550,110,50);
        deleteButton.setBounds( 170,550,110,50);
        clearButton.setBounds(290,550,110,50);

        //constructing final frame
        frame.add(panel);
        frame.add(negationButton);
        frame.add(deleteButton);
        frame.add(clearButton);
        frame.add(textfield);
        frame.setVisible(true);
    }

    //defining each button's function of the calculator
    @Override
    public void actionPerformed(ActionEvent e) {

        double degree, radian =0, val=0;
        String text;

        for(int i = 0; i < 10; i++) {
            if(e.getSource() == numberButtons[i]) {
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource() == decimalButton) {
            textfield.setText(textfield.getText().concat("."));
        }

        //math operator functions
        if(e.getSource() == additionButton) {
            num1 = Double.parseDouble(textfield.getText());
            mathOperator = 1;
            textfield.setText("");
        }
        else if(e.getSource() == subtractionButton) {
            num1 = Double.parseDouble(textfield.getText());
            mathOperator = 2;
            textfield.setText("");
        }
        else if(e.getSource() == multiplyButton) {
            num1 = Double.parseDouble(textfield.getText());
            mathOperator =  3;
            textfield.setText("");
        }
        else if(e.getSource() == divisionButton) {
            num1 = Double.parseDouble(textfield.getText());
            mathOperator = 4;
            textfield.setText("");
        }
        else if(e.getSource() == remainderButton) {
            num1 = Double.parseDouble(textfield.getText());
            mathOperator = 11;
            textfield.setText("");
        }
        else
        {
            if(e.getSource() == sinButton) {
                textfield.setText("sin ");
                mathOperator = 5;
            }
            if(e.getSource() == cosButton) {
                textfield.setText("cos ");
                mathOperator = 6;
            }
            if(e.getSource() == tanButton) {
                textfield.setText("tan ");
                mathOperator = 7;
            }
            if(e.getSource() == InvsinButton) {
                textfield.setText("asin ");
                mathOperator = 8;
            }
            if(e.getSource() == InvcosButton) {
                textfield.setText("acos ");
                mathOperator = 9;
            }
            if(e.getSource() == InvtanButton) {
                textfield.setText("atan ");
                mathOperator = 10;
            }
        }

        if(e.getSource() == equalButton) {

            text = textfield.getText();
            String[] str = text.split(" ");

            switch(mathOperator) {
                case 1:                //addition
                    num2 = Double.parseDouble(textfield.getText());
                    result = num1 + num2;
                    break;
                case 2:                //subtraction
                    num2 = Double.parseDouble(textfield.getText());
                    result = num1 - num2;
                    break;
                case 3:                //multiplication
                    num2 = Double.parseDouble(textfield.getText());
                    result = num1 * num2;
                    break;
                case 4 :               //division
                    num2 = Double.parseDouble(textfield.getText());
                    result = num1 / num2;
                    break;
                case 5:               //sin

                    degree = Double.parseDouble(str[1]);
                    radian = Math.toRadians(degree);

                    num1 = Math.sin(radian);
                    result = num1;
                    break;
                case 6:               //cos
                    degree = Double.parseDouble(str[1]);
                    radian = Math.toRadians(degree);
                    num1 = Math.cos(radian);
                    result = num1;
                    break;
                case 7 :               //tan
                    degree = Double.parseDouble(str[1]);
                    radian = Math.toRadians(degree);
                    num1 = Math.tan(radian);
                    result = num1;
                    break;
                case 8:                //asin
                    val = Double.parseDouble(str[1]);
                    radian = Math.asin(val);
                    degree = Math.toDegrees(radian);
                    result = degree;
                    break;
                case 9:                //acos
                    val = Double.parseDouble(str[1]);
                    radian = Math.acos(val);
                    degree = Math.toDegrees(radian);
                    result = degree;
                    break;
                case 10 :              //atan
                    val = Double.parseDouble(str[1]);
                    radian = Math.atan(val);
                    degree = Math.toDegrees(radian);
                    result = degree;
                    break;
                case 11 :
                    num2 = Double.parseDouble(textfield.getText());
                    result = num1 % num2;
                    break;
            }
            textfield.setText(String.valueOf(result));
            num1 = result;
        }
        if(e.getSource() == clearButton) {
            textfield.setText("");
            result = 0.0;
        }
        if(e.getSource() == deleteButton) {
            String string = textfield.getText();
            textfield.setText("");
            for(int i = 0; i<string.length() - 1; i++) {
                textfield.setText(textfield.getText()+string.charAt(i));
            }
        }
        if(e.getSource() == negationButton) {

            double temp = Double.parseDouble(textfield.getText() );
            temp *= -1;
            textfield.setText(String.valueOf(temp));
        }
    }
}
