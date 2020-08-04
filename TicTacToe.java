package ru.geekbrains.com;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

        private static final char DOT_HUMAN = 'X'; // игрок ставит Х
        private static final char DOT_AI = 'O'; // компьютер ставит О
        private static final char DOT_EMPTY = '.'; // ставим точку в пустой ячейке
        private static final Scanner SCANNER = new Scanner(System.in); // средство для игрока, чтобы сделать ход
        private static final Random RANDOM = new Random(); // генератор псевдослучайных чисел
        private static int fieldSizeY; // размер поля по вертикали
        private static int fieldSizeX; // размер поля по горизонтали
        private static char[][] field; // инициализируем игровое поле

        private static void initField() {
            fieldSizeX = 3; // задаем размер поля по Х
            fieldSizeY = 3; // задаем размер поля по Y
            field = new char[fieldSizeY][fieldSizeX]; //инициализируем новое поле с размерами X и Y
            for (int y = 0; y < fieldSizeY; y++) { // перебираем построчно все ячеци массива и ставим '.'
                for (int x = 0; x < fieldSizeX; x++) {
                    field[y][x] = DOT_EMPTY;
                }
            }
        }

        private static void printField() { // печатаем поле в консоли
            System.out.print("+"); // печатаем '+'
            for (int x = 0; x < fieldSizeX * 2 + 1; x++) //идем от 0 до 7 - верхняя шапка состоит из 7 символов
                System.out.print((x % 2 == 0) ? "-" : x / 2 + 1); // если символ четный, ставим '-'. если нечетный, то значение X делим на 2 и прибавляем 1, так получаем в шапке -1-2-3
            System.out.println(); //печатаем пустую строку

            for (int y = 0; y < fieldSizeY; y++) { // перебираем строки
                System.out.print(y + 1 + "|"); // печатаем значение у+1 и |
                for (int x = 0; x < fieldSizeX; x++) // перебираем столбцы в каждой строке
                    System.out.print(field[y][x] + "|"); // так как field[y][x] = DOT_EMPTY, а DOT_EMPTY = '.', то печатаем '.' и '|'
                System.out.println(); // печатаем пустую строку
            }

            for (int x = 0; x <= fieldSizeX * 2 + 1; x++)
                System.out.print("-"); // печатаем под полем '-'
            System.out.println(); // печатаем пустую строку
        }

        private static void humanTurn() { // ход хумана
            int x;
            int y;
            do { // исполняем код ниже пока не выполнится условия while (координаты будут в рамках поля и клетка будет пустая)
                System.out.println("Введите координаты хода X и Y (от 1 до 3) через пробел >>> ");
                x = SCANNER.nextInt() - 1; // запросим координату по Х и отнимем 1, т.к. индексы начинаются с 0
                y = SCANNER.nextInt() - 1; // запросим координату по Y и отнимем 1, т.к. индексы начинаются с 0
            } while (!isValidCell(x, y) || !isEmptyCell(x, y)); // проверяем введенные координаты клетки на валидность и пустоту
            field[y][x] = DOT_HUMAN; // ставим Х во введенные координаты хумана
        }

        private static boolean isEmptyCell(int x, int y) { // проверяем пустая ли клетка
            return field[y][x] == DOT_EMPTY; // если по этим координатам '.', то клетка пустая для хода
        }

        private static boolean isValidCell(int x, int y) { // проверяем введенные координаты. в поле ли они, или хуман промахнулся
            return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
        }

        private static void aiTurn() { // ход компьютера
            int x;
            int y;
            do {
                x = RANDOM.nextInt(fieldSizeX); // получим рандомное число между 0 и числом, которое на 1 меньше переданного. т.к. Х у нас =3, то рандомное число будет в интервале от 0 до 2
                y = RANDOM.nextInt(fieldSizeY); // то же самое, только по Y
            } while (!isEmptyCell(x, y)); // если клетка не пуста, то заново генерим X и Y
            field[y][x] = DOT_AI; // если клетка с полученными координатами пустая, то в неё ставим 0
        }

        private static boolean checkDraw() { // проверка на ничью
            for (int y = 0; y < fieldSizeY; y++) { // бежим по Y
                for (int x = 0; x < fieldSizeX; x++) { // бежим по X
                    if (isEmptyCell(x, y)) return false; // если находим пустую клетку, то возвращаем ложь (не ничья)
                }
            }
            return true;// если не находим пустую клетку, то возвращаем правда (ничья)
        }

        private static boolean checkWin(char c) { // передаем некий символ 'c', по которому будем проверять победу X или 0
            // hor
            //if (field[0][0] == c && field[0][1] == c && field[0][2] == c) return true;
            //if (field[1][0] == c && field[1][1] == c && field[1][2] == c) return true;
           // if (field[2][0] == c && field[2][1] == c && field[2][2] == c) return true;

            int sumX = 0;
            for (int y = 0; y < fieldSizeY; y++) {
                for (int x = 0; x < fieldSizeX; x++) {
                    if (field[y][x] == c) sumX += 1;
                    if (sumX == 3) return true;
                }
                sumX = 0;
            }

            // ver
            //if (field[0][0] == c && field[1][0] == c && field[2][0] == c) return true;
           // if (field[0][1] == c && field[1][1] == c && field[2][1] == c) return true;
           // if (field[0][2] == c && field[1][2] == c && field[2][2] == c) return true;

            int sumY = 0;
            for (int x = 0; x < fieldSizeY; x++) {
                for (int y = 0; y < fieldSizeY; y++) {
                    if (field[y][x] == c) sumY += 1;
                    if (sumY == 3) return true;
                }
                sumY = 0;
            }


            // dia
            //if (field[0][0] == c && field[1][1] == c && field[2][2] == c) return true;
           // if (field[0][2] == c && field[1][1] == c && field[2][0] == c) return true;
            //return false;

            int sumDia = 0;
            for (int x = 0; x < fieldSizeX; x++) {
                if (field[x][x] == c) sumDia += 1;
                if (sumDia == 3) return true;
            }

            int sumDiaReverse = 0;
            for (int x = fieldSizeX - 1; x == 0; x--) {
                if (field[x][x] == c) sumDiaReverse += 1;
                if (sumDiaReverse == 3) return true;
            }

            return false;
        }

        public static void main(String[] args) {
            initField(); // инициализируем поле через вызов метода
            printField(); // печатаем поле через вызов метода
            String answer;
            do {
                while (true) {
                    humanTurn(); // запускаем метод Ход хумана
                    if (checkEndGame(DOT_HUMAN, "Human win!")) break;
                    aiTurn(); // запускаем метод Ход компьютера
                    if (checkEndGame(DOT_AI, "Computer win!")) break;
                }
                System.out.println("Wanna play again? (y/n) >>> ");
                answer = SCANNER.next();
            } while (answer.equals("y"));
            SCANNER.close();
        }

        private static boolean checkEndGame(char dot, String winMessage) {
            printField();
            if (checkWin(dot)) {
                System.out.println(winMessage);
                return true;
            }
            if (checkDraw()) {
                System.out.println("Draw!");
                return true;
            }
            return false;
        }
    }
