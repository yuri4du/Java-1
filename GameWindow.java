package ru.geekbrains.java_one.lesson_7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame { //наследуем свойства от JFrame, чтобы сделать GameWindow окошком
    private static final int WIN_WIDTH = 507; // задаем переменную для ширины окна
    private static final int WIN_HEIGHT = 555; // задаем переменную для высоты окна
    private static final int WIN_POSX = 650; // задаем отступ для левого верхнего угла нашего окна по Х вправо от левого края
    private static final int WIN_POSY = 250; // задаем отступ для левого верхнего угла нашего окна по Y вниз от верхнего края
    private Map map;
    private Map map2;
    private SettingsWindow settings;

    GameWindow() { // конструктор окна
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // устанавливаем действие при операции закрытия по умолчанию - выйти при закрытии
        setSize(WIN_WIDTH, WIN_HEIGHT); // устанавливаем размер окна
        setLocation(WIN_POSX, WIN_POSY); // устанавливаем отступ от левого верхнего угла экрана(0,0)
        // setLocationRelativeTo(null); // автоматически выровняет по центру экрана
        setTitle("TicTacToe"); // название окошка
        setResizable(false); // так сделаем окно неизменяемым
        JButton btnStartGame = new JButton("Start new game"); // создаем кнопку с текстом
        JButton btnExit = new JButton("Exit"); // создаем кнопку с текстом
        map = new Map(); // создаем новую панель Map
        settings = new SettingsWindow(this); // вызываем конструктор SettingsWindow и говорим, что нужно передать ссылку/ярлычок на этот(this) созаваемый сейчас объект GameWindow
        // this - это ссылка на создаваемый сейчас объект

        btnStartGame.addActionListener(new ActionListener() { // добавляем слушатель события на кнопку старт гейм
            @Override
            public void actionPerformed(ActionEvent e) {
                settings.setVisible(true); // при нажатии кнопки старт новой игры станет видно окно settings
            }
        });
        btnExit.addActionListener(new ActionListener() { // добавляем слушатель события на кнопку exit
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // чтобы выход был штатный
            }
        });
        // FlowLayout кладет компоненты друг за другом

        JPanel panelBottom = new JPanel(); // создаем новым компонент JPanel (холст, пустой прямоугольник)
        panelBottom.setLayout(new GridLayout(1, 2)); // setLayout - добавляется компоновщик; GridLayout компоновщик - добавляет сетку
        panelBottom.add(btnStartGame); // добавляем кнопку на панель
        panelBottom.add(btnExit); // добавляем кнопку на панель
        add(panelBottom, BorderLayout.SOUTH); // BorderLayout компоновщик или менеджер размещений South это низ
        add(map); // добавляем панель Map
        setVisible(true); // делает окошки видимыми
    }

    void startNewGame(int mode, int fieldSizeX, int fieldSizeY, int winLength) {
        map2 = new Map(fieldSizeX);
        add(map2);
        setVisible(true);
        map.startNewGame(mode, fieldSizeX, fieldSizeY, winLength); // вызывает из Map`ы метод startNewGame

    }
}