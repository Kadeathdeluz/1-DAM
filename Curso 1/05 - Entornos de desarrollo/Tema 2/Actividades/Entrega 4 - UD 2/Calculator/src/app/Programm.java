package app;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class Programm {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        JFrame frame = new JFrame("JFrame");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(494,494);
        frame.setLayout(new GridBagLayout());

		JLabel element_1699914469447 = new JLabel("Número 1");
        GridBagConstraints constraints_element_1699914469447 = new GridBagConstraints();
        constraints_element_1699914469447.gridx = 1;
        constraints_element_1699914469447.gridy = 1;
        constraints_element_1699914469447.gridwidth = 1;
        constraints_element_1699914469447.gridheight = 1;
        constraints_element_1699914469447.fill = GridBagConstraints.HORIZONTAL;
        frame.add(element_1699914469447, constraints_element_1699914469447);

		JTextField element_1699914475213 = new JTextField(20);
        GridBagConstraints constraints_element_1699914475213 = new GridBagConstraints();
        constraints_element_1699914475213.gridx = 3;
        constraints_element_1699914475213.gridy = 1;
        constraints_element_1699914475213.gridwidth = 2;
        constraints_element_1699914475213.gridheight = 1;
        constraints_element_1699914475213.fill = GridBagConstraints.HORIZONTAL;
        frame.add(element_1699914475213, constraints_element_1699914475213);
        
        JLabel element_1699914471877 = new JLabel("Número 2");
        GridBagConstraints constraints_element_1699914471877 = new GridBagConstraints();
        constraints_element_1699914471877.gridx = 1;
        constraints_element_1699914471877.gridy = 2;
        constraints_element_1699914471877.gridwidth = 1;
        constraints_element_1699914471877.gridheight = 1;
        constraints_element_1699914471877.fill = GridBagConstraints.HORIZONTAL;
        frame.add(element_1699914471877, constraints_element_1699914471877);

		JTextField element_1699914480598 = new JTextField(20);
        GridBagConstraints constraints_element_1699914480598 = new GridBagConstraints();
        constraints_element_1699914480598.gridx = 3;
        constraints_element_1699914480598.gridy = 2;
        constraints_element_1699914480598.gridwidth = 2;
        constraints_element_1699914480598.gridheight = 1;
        constraints_element_1699914480598.fill = GridBagConstraints.HORIZONTAL;
        frame.add(element_1699914480598, constraints_element_1699914480598);

		JButton element_1699914485148 = new JButton("Sumar");
        GridBagConstraints constraints_element_1699914485148 = new GridBagConstraints();
        constraints_element_1699914485148.gridx = 6;
        constraints_element_1699914485148.gridy = 1;
        constraints_element_1699914485148.gridwidth = 2;
        constraints_element_1699914485148.gridheight = 1;
        constraints_element_1699914485148.fill = GridBagConstraints.HORIZONTAL;
        frame.add(element_1699914485148, constraints_element_1699914485148);

		JLabel element_1699914499723 = new JLabel("suma");
        GridBagConstraints constraints_element_1699914499723 = new GridBagConstraints();
        constraints_element_1699914499723.gridx = 9;
        constraints_element_1699914499723.gridy = 1;
        constraints_element_1699914499723.gridwidth = 1;
        constraints_element_1699914499723.gridheight = 1;
        constraints_element_1699914499723.fill = GridBagConstraints.HORIZONTAL;
        frame.add(element_1699914499723, constraints_element_1699914499723);

		JButton element_1699914487024 = new JButton("Restar");
        GridBagConstraints constraints_element_1699914487024 = new GridBagConstraints();
        constraints_element_1699914487024.gridx = 6;
        constraints_element_1699914487024.gridy = 2;
        constraints_element_1699914487024.gridwidth = 2;
        constraints_element_1699914487024.gridheight = 1;
        constraints_element_1699914487024.fill = GridBagConstraints.HORIZONTAL;
        frame.add(element_1699914487024, constraints_element_1699914487024);

		JLabel element_1699914501897 = new JLabel("resta");
        GridBagConstraints constraints_element_1699914501897 = new GridBagConstraints();
        constraints_element_1699914501897.gridx = 9;
        constraints_element_1699914501897.gridy = 2;
        constraints_element_1699914501897.gridwidth = 1;
        constraints_element_1699914501897.gridheight = 1;
        constraints_element_1699914501897.fill = GridBagConstraints.HORIZONTAL;
        frame.add(element_1699914501897, constraints_element_1699914501897);

		JButton element_1699914488963 = new JButton("Multiplicar");
        GridBagConstraints constraints_element_1699914488963 = new GridBagConstraints();
        constraints_element_1699914488963.gridx = 6;
        constraints_element_1699914488963.gridy = 3;
        constraints_element_1699914488963.gridwidth = 2;
        constraints_element_1699914488963.gridheight = 1;
        constraints_element_1699914488963.fill = GridBagConstraints.HORIZONTAL;
        frame.add(element_1699914488963, constraints_element_1699914488963);

		JLabel element_1699914503979 = new JLabel("multiplicación");
        GridBagConstraints constraints_element_1699914503979 = new GridBagConstraints();
        constraints_element_1699914503979.gridx = 9;
        constraints_element_1699914503979.gridy = 3;
        constraints_element_1699914503979.gridwidth = 1;
        constraints_element_1699914503979.gridheight = 1;
        constraints_element_1699914503979.fill = GridBagConstraints.HORIZONTAL;
        frame.add(element_1699914503979, constraints_element_1699914503979);

		JButton element_1699914490577 = new JButton("Dividir");
        GridBagConstraints constraints_element_1699914490577 = new GridBagConstraints();
        constraints_element_1699914490577.gridx = 6;
        constraints_element_1699914490577.gridy = 4;
        constraints_element_1699914490577.gridwidth = 2;
        constraints_element_1699914490577.gridheight = 1;
        constraints_element_1699914490577.fill = GridBagConstraints.HORIZONTAL;
        frame.add(element_1699914490577, constraints_element_1699914490577);

		JLabel element_1699914506213 = new JLabel("división");
        GridBagConstraints constraints_element_1699914506213 = new GridBagConstraints();
        constraints_element_1699914506213.gridx = 9;
        constraints_element_1699914506213.gridy = 4;
        constraints_element_1699914506213.gridwidth = 1;
        constraints_element_1699914506213.gridheight = 1;
        constraints_element_1699914506213.fill = GridBagConstraints.HORIZONTAL;
        frame.add(element_1699914506213, constraints_element_1699914506213);

        //Zona de Listeners, cuando todos los elementos se han inicializado
        element_1699914485148.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                double a = Double.parseDouble(element_1699914475213.getText());
                double b = Double.parseDouble(element_1699914480598.getText());
                double result = a + b;

                element_1699914499723.setText("" + result);
            }
        });
        element_1699914487024.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                double a = Double.parseDouble(element_1699914475213.getText());
                double b = Double.parseDouble(element_1699914480598.getText());
                double result = a - b;

                element_1699914501897.setText("" + result);
            }
        });

        element_1699914488963.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                double a = Double.parseDouble(element_1699914475213.getText());
                double b = Double.parseDouble(element_1699914480598.getText());
                double result = a * b;

                element_1699914503979.setText("" + result);
            }
        });

        element_1699914490577.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                double a = Double.parseDouble(element_1699914475213.getText());
                double b = Double.parseDouble(element_1699914480598.getText());
                double result = a / b;

                element_1699914506213.setText("" + result);
            }
        });


        frame.setVisible(true);
    }
}
