import java.util.Scanner;

public class Zad2 {

    public static void main(String[] args) throws Exception {

        String dexToBinary;
        try {
            System.out.println("Введите целое число");
            Scanner userInput = new Scanner(System.in);
            int number = userInput.nextInt();
            System.out.println("Binary");
            dexToBinary = convertDexToBinary(number);
            System.out.println(convertDexToBinary(number));
        } catch (Exception number) {
            throw new Exception("Вводить можно только цифры");
        }

        System.out.println("Dex");
        System.out.println(convertBinaryToDex(dexToBinary));
    }

    public static String convertDexToBinary(int whole) {
        int remainder;
        StringBuilder strTwo = new StringBuilder();
        do {
            remainder = whole % 2;
            strTwo.append(remainder);
            whole = whole / 2;
        } while (whole > 0);
        return strTwo.reverse().toString();
    }

    public static int convertBinaryToDex(String strBinary) {
        int dex=0;
        int source=0;

        for (int i =0; i<strBinary.length()-1 ; i++) {
            source = (Integer.parseInt(strBinary.substring(i , i+1))*2);

            dex=dex+ pow(source,strBinary.length()-i-1);
        }
        dex=dex+Integer.parseInt(strBinary.substring(strBinary.length()-1 , strBinary.length()));
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

