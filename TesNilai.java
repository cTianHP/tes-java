import java.util.Scanner;

/**
 * TesNilai
 */

public class TesNilai {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Input nilai: ");
        double nilai = input.nextDouble();
        System.out.println("Nilai: "+ nilai);
        System.out.print("Predikat: ");
        if (nilai >= 90.0)
            System.out.print("A");
        else if (nilai >= 80.0)
            System.out.print("B");
        else if (nilai >= 70.0)
             System.out.print("C");
        else if (nilai >= 60.0)
             System.out.print("D");
        else
            System.out.print("F");
    }
}