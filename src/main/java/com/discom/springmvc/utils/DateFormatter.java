package com.discom.springmvc.utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

class DateFormatter extends JFrame implements ActionListener {

    JTextField txt1, txt2, txt3, txt4;

    JButton btn;

    public DateFormatter() {

        setLayout(new FlowLayout());

        add(new JLabel("Language"));

        add(txt1 = new JTextField(15));

        add(new JLabel("Country"));

        add(txt2 = new JTextField(15));

        add(new JLabel("Date:"));

        add(txt3 = new JTextField(15));

        add(new JLabel("Time:"));

        add(txt4 = new JTextField(15));

        add(btn = new JButton("Apply Formatting"));

        txt3.setEditable(false);

        txt4.setEditable(false);

        setSize(630, 320);

        setTitle("Date and Time Formatter");

        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btn.addActionListener(this);

    }

    DateFormatter(String msg) {
        Locale deLocale = new Locale("hi", "HI");
        Locale frLocale = new Locale("hi", "HI");
        System.out.println("Default language name (default): " +
                deLocale.getDisplayLanguage());
        System.out.println("German language name (German): " +
                deLocale.getDisplayLanguage(deLocale));
        System.out.println("German language name (French): " +
                deLocale.getDisplayLanguage(frLocale));
    }

    public static void main(String args[]) {

        // new DateFormatter();
        new DateFormatter("");
    }

    public void actionPerformed(ActionEvent e) {

        Locale locale = new Locale(txt1.getText(), txt2.getText());

        DateFormat df = DateFormat.getDateInstance(DateFormat.FULL, locale);

        DateFormat tf = DateFormat.getTimeInstance(DateFormat.FULL, locale);

        Date d = new Date();

        txt3.setText(df.format(d));

        txt4.setText(tf.format(d));

    }
}