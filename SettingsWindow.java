package ru.geekbrains.java_one.lesson_7;

//import org.omg.SendingContext.RunTime;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsWindow extends JFrame { //наследуем свойства от JFrame, чтобы сделать GameWindow окошком
    private static final int WINDOW_WIDTH = 350; // задаем переменную для ширины окна
    private static final int WINDOW_HEIGHT = 270; // задаем переменную для высоты окна
    private static final int MIN_WIN_LENGTH = 3; // задаем минимальный размер выигрышной комбинации
    private static final int MIN_FIELD_SIZE = 3; // задаем минимальный размер поля
    private static final int MAX_FIELD_SIZE = 10; // задаем максимальный размер поля
    private static final String FIELD_SIZE_PREFIX = "  Field size is: "; // будем делать вывод для пользователя о размере поля
    private static final String WIN_LENGTH_PREFIX = "  Win length is: "; // будем делать вывод для пользователя о размере выигрышной комбинации

    private GameWindow gameWindow; // будем передавать ссылку на тот объект, относительно которого центрироваться
    private JRadioButton humVSAI; // круглая кнопка - можно выбрать только одну из них
    private JRadioButton humVShum; // круглая кнопка - можно выбрать только одну из них
    private JSlider slideWinLen; // слайдер
    private JSlider slideFieldSize; // слайдер

    SettingsWindow(GameWindow gameWindow) {  // принимает ссылку/ярлычок gameWindow
        this.gameWindow = gameWindow;
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT); // устанавливаем ширину, высоту
        Rectangle gameWindowBounds = gameWindow.getBounds(); // Rectangle класс прямоугольник. создаем новый прямоугольник. берем у gameWindow границы и кладем их в объект класса Rectangel
        int posX = (int) gameWindowBounds.getCenterX() - WINDOW_WIDTH / 2; // getCentre(получаем координату центра окна gameWindowBounds по X, и сдвигаем окно сеттингов влево на половину ширины окна сеттингов
        int posY = (int) gameWindowBounds.getCenterY() - WINDOW_HEIGHT / 2; // getCentre(получаем координату центра окна gameWindowBounds по Y и сдвигаем окно сеттингов вверх на половину высоты окна сеттингов
        setLocation(posX, posY); // устанавливаем местоположение относительно левого верхнего угла экрана
        setResizable(false); // делаем окна неизменяемым
        setTitle("Creating new game"); // устанавливаем название окна
        setLayout(new GridLayout(10, 1)); // сетка 10 строк 1 столбец
        addGameModeControls(); // вызываем метод
        addGameFieldControls(); // вызываем метод
        JButton btnStart = new JButton("Start new game"); // добавляем новую кнопку
        btnStart.addActionListener(new ActionListener() { // добавляем слушатель события на кнопку
            @Override
            public void actionPerformed(ActionEvent e) {
                btnStartClick(); // при нажатии на кнопку вызываем этот метод
            }
        });
        add(btnStart);
    }

    private void addGameModeControls() { // создаем метод для выбора режима игры и игроков
        add(new JLabel("  Choose game mode:")); // добавим окну надпись
        humVSAI = new JRadioButton("Human vs. AI", true); // круглая кнопка - можно выбрать только одну из них. true - одна сразу выбрана
        humVShum = new JRadioButton("Human vs. Human"); // круглая кнопка - можно выбрать только одну из них
        ButtonGroup gameMode = new ButtonGroup(); // создаем группу для объединения кнопок, чтобы они работали вместе
        gameMode.add(humVSAI); // добавляем в группу кнопку
        gameMode.add(humVShum); // добавляем в группу кнопку
        add(humVSAI); // добавлем кнопку
        add(humVShum); // добавлем кнопку
    }

    private void addGameFieldControls() { // создаем метод который добавит всякие управляющие компоненты
        JLabel lbFieldSize = new JLabel(FIELD_SIZE_PREFIX + MIN_FIELD_SIZE); // создаем JLabel с инфой о текущем поле
        JLabel lbWinLength = new JLabel(WIN_LENGTH_PREFIX + MIN_WIN_LENGTH); // создаем JLabel с инфой о текущей длине выигрышной комбинации
        slideFieldSize = new JSlider(MIN_FIELD_SIZE, MAX_FIELD_SIZE, MIN_FIELD_SIZE); // создаем слайдер для выбора размера поля. три параметра в () минимальной значение, максимальное значение и текущее значение
        slideWinLen = new JSlider(MIN_WIN_LENGTH, MIN_FIELD_SIZE, MIN_FIELD_SIZE); // создаем слайдер для выбора размера выигрышной комбинации
        slideFieldSize.addChangeListener(new ChangeListener() { // добавляем слушатель изменений
            @Override
            public void stateChanged(ChangeEvent e) {
                int currentValue = slideFieldSize.getValue(); // получаем значение слайдера и записываем его в currentValue
                lbFieldSize.setText(FIELD_SIZE_PREFIX + currentValue); //меняем текст у размера поля
                slideWinLen.setMaximum(currentValue); // устанавливаем максимальное значение для слайдера с выигрышной комбинацией
            }
        });
        slideWinLen.addChangeListener(new ChangeListener() { // добавляем слушатель изменений
            @Override
            public void stateChanged(ChangeEvent e) {
                lbWinLength.setText(WIN_LENGTH_PREFIX + slideWinLen.getValue()); // дл выигрышной комбинации установим текст WIN_LENGTH_PREFIX + получим текущее значение слайдера
            }
        });

        add(new JLabel("  Choose field size")); // добавляем название
        add(lbFieldSize); // добавляем лэйбл
        add(slideFieldSize); // добавляем слайдер
        add(new JLabel("  Choose win length")); // добавляем название
        add(lbWinLength); // добавляем лэйбл
        add(slideWinLen); // добавляем слайдер
    }

    private void btnStartClick() {
        int fieldSize = slideFieldSize.getValue(); // собираем выбранное значение со слайдера размера поля
        int winLen = slideWinLen.getValue(); // собираем выбранное значение со слайдера размера выигрышной комбинации

        int gameMode; // объявляем новую переменную
        if (humVSAI.isSelected()) { // если выбран режим humVSAI
            gameMode = Map.MODE_HVA; // в gameMode кладем MODE_HVA из Map
        } else if (humVShum.isSelected()) { // если выбран режим humVShum
            gameMode = Map.MODE_HVH; // в gameMode кладем MODE_HVH из Map
        } else { // иначе
            throw new RuntimeException("Unexpected game mode!"); // выкидываем исключение - неожиданный game mode
        }

        gameWindow.startNewGame(gameMode, fieldSize, fieldSize, winLen); // чтобы вызвать из Map startNewGame, вызываем метод startNewGame из GameWindow

        setVisible(false); // делаем окно невидимым
    }
}