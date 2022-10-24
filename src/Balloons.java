import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Balloons {

    public static void main(String[] args) throws IOException {

        // lee datos del archivo "./resources/balloons.txt"
        Scanner sc = new Scanner(new File("./resources/balloons.txt"));

        // abre el archivo para grabar en "./resources/balloons-result.txt"
        PrintWriter pw = new PrintWriter(new FileWriter("./resources/balloons-result.txt"));

        int cases = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < cases; i++) {
            processCase(sc, pw, i);
        }

        pw.close();
    }

    public static void processCase(Scanner sc, PrintWriter pw, int nCase) throws IOException {

        // lee un cases entero del archivo
        String cost = sc.nextLine();
        int greenCost = cost.charAt(0);
        int purpleCost = cost.charAt(2);
        int biggerCost = Math.max(greenCost, purpleCost);
        int smallestCost = Math.min(greenCost, purpleCost);
        int participants = sc.nextInt();
        int total1Left = 0;
        int total1Rigth = 0;
        int iLeft;
        int iRigth;


        for (int i = 1; i < participants + 1; i++) {
            sc.nextLine();
            String iresults = sc.nextLine();
            iLeft = iresults.charAt(0);
            iRigth = iresults.charAt(2);
            if (iLeft == 1) {
                total1Left++;
            }
            if (iRigth == 1) {
                total1Rigth++;
            }
        }
        int max1 = Math.max(total1Left, total1Rigth);
        int min1 = Math.min(total1Rigth, total1Rigth);
        int minimumCost = max1 * smallestCost + min1 * biggerCost;

        // ejemplo de grabar ese cases en el archivo de salida:
        pw.println("Case #1: " + minimumCost);
    }
}