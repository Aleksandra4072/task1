package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {
    static Scanner equation = new Scanner(System.in); //Ввод данных(вынесено, чтобы воспринималось всеми классами)
    static int num1, num2;
    static char operation;
    static int result;

    public static void main(String[] args) {
    String input = equation.nextLine(); //определение математического знака
    char[] sign = new char[5];

    for (int i=0; i < input.length(); i++){
        sign[i] = input.charAt(i);
        if (sign[i] == '+'){
            operation = '+';
        }
        if (sign[i] == '-'){
            operation = '-';
        }
        if (sign[i] == '*'){
            operation = '*';
        }
        if (sign[i] == '/'){
            operation = '/';
        }
    }
    String signStr = String.valueOf(sign);
    String[] line = signStr.split("[+-/*]"); //разделение выражения на числа, вынос математического знака
    String symbol1 = line[0];
    String symbol2 = line[1];
    String str3 = symbol2.trim();  //удаление пробелов
    num1 = romanToNumber(symbol1);
    num2 = romanToNumber(str3);
        if (num1 < 0 && num2 < 0) {
            result = 0;
        } else {
            result = calculated(num1, num2, operation);
            String resultRoman = convertNumToRoman(result); //выполнение метода convertNumToRoman
            System.out.println(resultRoman);
        }
        num1 = Integer.parseInt(symbol1);
        num2 = Integer.parseInt(str3);
        result = calculated(num1, num2, operation);
        System.out.println(result);
    }

    private static String convertNumToRoman (int numArabian) {
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL"
        };
        return roman[numArabian];
    }


    private static int romanToNumber (String roman) {
        try {
            switch (roman) {
                case "I":
                    return 1;
                case "II":
                    return 2;
                case "III":
                    return 3;
                case "IV":
                    return 4;
                case "V":
                    return 5;
                case "VI":
                    return 6;
                case "VII":
                    return 7;
                case "VIII":
                    return 8;
                case "IX":
                    return 9;
                case "X":
                    return 10;
            }
        } catch (InputMismatchException e) {
            throw new InputMismatchException("");
        }
        return -1;
    }

    public static int calculated (int num1, int num2, char op) {
        int result = 0;
        if (num1 >0 && num1 <=10 && num2 > 0 && num2 <=10){
            switch (op) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    try {
                        result = num1 / num2;
                    } catch (ArithmeticException | InputMismatchException e) {
                        break;
                    }
                    break;
                default:
                    throw new IllegalArgumentException("");
            }
        }
        else{
            throw new Error();
        }
        return result;
    }
}