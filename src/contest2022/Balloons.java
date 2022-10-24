package contest2022;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Balloons {

    public static void main(String[] args) throws IOException {

        // lee datos del archivo "./resources/balloons.txt"
        Scanner sc = new Scanner(new File("./resources/balloons/balloons.txt"));

        // abre el archivo para grabar en "./resources/balloons-result.txt"
        PrintWriter pw = new PrintWriter(new FileWriter("./resources/balloons/balloons-result.txt"));

        int cases = sc.nextInt();
        sc.nextLine();
        for (int i = 1; i < cases + 1; i++) {
            processCase(sc, pw, i);
        }

        pw.close();
    }

    public static void processCase(Scanner sc2, PrintWriter pw2, int nCase2) throws IOException {

        // lee un cases entero del archivo
        String[] costs = sc2.nextLine().split(" ");
        int greenCost = Integer.parseInt(costs[0]);
        int purpleCost = Integer.parseInt(costs[1]);
        int biggerCost = Math.max(greenCost, purpleCost);
        int smallestCost = Math.min(greenCost, purpleCost);
        int participants = sc2.nextInt();
        sc2.nextLine();
        int total1Left = 0;
        int total1Rigth = 0;
        int iLeft;
        int iRigth;


        for (int i = 1; i < participants + 1; i++) {
            String[] iresults = sc2.nextLine().split(" ");
            iLeft = Integer.parseInt(iresults[0]);
            iRigth = Integer.parseInt(iresults[1]);
            if (iLeft == 1) {
                total1Left++;
            }
            if (iRigth == 1) {
                total1Rigth++;
            }
        }
        int max1 = Math.max(total1Left, total1Rigth);
        int min1 = Math.min(total1Left, total1Rigth);
        int minimumCost = max1 * smallestCost + min1 * biggerCost;

        // ejemplo de grabar ese cases en el archivo de salida:
        pw2.println("Case #" + nCase2 + ": " + minimumCost);
    }
}