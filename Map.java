package ru.geekbrains.java_one.lesson_7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Map extends JPanel { // наследуем от JPanel
    public static final int MODE_HVH = 0; // создаем константу для режима человек против человека
    public static final int MODE_HVA = 1; // создаем константу для режима человек против АИ


    Map() { // конструктор
        setBackground(Color.DARK_GRAY); // устанавливаем цвет фона панели Map

    }

    Map(int fieldSizeX) {
        JPanel playField = new JPanel();
        setBackground(Color.DARK_GRAY);
        playField.setLayout(new GridLayout(fieldSizeX, fieldSizeX));

        int fieldValue = fieldSizeX * fieldSizeX;
         for (int i = 0; i < fieldValue; i++) {
             JButton button = new JButton("");
            playField.add(button);
            button.setPreferredSize(new Dimension(45,45));
             button.addActionListener(new ActionListener() {
                 @Override
                 public void actionPerformed(ActionEvent e) {
                     button.setText("X");
                 }
             });
         }

        add(playField);
        setVisible(true);



        
    }
    void startNewGame(int mode, int fieldSizeX, int fieldSizeY, int winLength) { // метод принимает режим игры, размер поля по X, размер поля по Y, выигрышная длина
        System.out.printf("mode: %d, size: %d, len: %d\n", mode, fieldSizeX, winLength); // выводим на экран режим игры, размер поля и выигрышную длину

    }
}