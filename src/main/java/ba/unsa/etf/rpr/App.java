package ba.unsa.etf.rpr;

import java.util.Scanner;

public class App
{
    public static void main( String[] args ) {
        System.out.println("Unesite izraz: ");
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        ExpressionEvaluator ee = new ExpressionEvaluator();
        try {
            System.out.println("Rješenje je " + ee.evaluate(str));
        } catch (NumberFormatException e) {
            throw new RuntimeException("Pogreska pri unosu");
        } catch (Exception e) {
            e.getMessage();
        }
    }
}