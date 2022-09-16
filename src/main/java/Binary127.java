import java.util.Scanner;

public class Binary127 {

    public static void main(String[] args) throws Exception {

        String dexToBinary;
        System.out.println("Введите целое число от 0 до 127");

        Scanner userInput = new Scanner(System.in);
        if (userInput.hasNextInt() == false) {
            throw new Exception("Введено не число");
        }

        int number = userInput.nextInt();
        if (number > 127) {
            throw new Exception("Введено число больше 127!!");
        } else if (number < 0) {
            throw new Exception("Введено число меньше 0!!");
        }
        System.out.println("Binary");
        dexToBinary = convertDexToBinary(number);
        System.out.println(convertDexToBinary(number));


        System.out.println("Dex");
        System.out.println(convertBinaryToDex(dexToBinary));
    }

    public static String convertDexToBinary(int whole) {
        int remainder;
        int countRemainder = 0;
        StringBuilder strTwo = new StringBuilder();
        do {
            remainder = whole % 2;
            strTwo.append(remainder);
            whole = whole / 2;
            countRemainder++;
        } while (whole > 0);
        for (int i = countRemainder; i < 7; i++) {
            strTwo.append(0);
        }
        return strTwo.reverse().toString();
    }

    public static int convertBinaryToDex(String strBinary) {
        int dex = 0;
        int source = 0;

        for (int i = 0; i < strBinary.length() - 1; i++) {
            source = (Integer.parseInt(strBinary.substring(i, i + 1)) * 2);

            dex = dex + pow(source, strBinary.length() - i - 1);
        }
        dex = dex + Integer.parseInt(strBinary.substring(strBinary.length() - 1, strBinary.length()));
        return dex;
    }

    private static int pow(int value, int powValue) {
        int result = 1;
        for (int i = 1; i <= powValue; i++) {
            result = result * value;
        }
        return result;
    }
}

