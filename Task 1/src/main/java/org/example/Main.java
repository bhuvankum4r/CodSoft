//Number Game, where the users have to guess 

package org.example;

import java.util.*;

public class Main
{
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();
    static int Guess, Tries = 0; ;
    static int Actual = random.nextInt(100) + 1;
    public static void main(String[] args)
    {
        System.out.print("Guess a number between 1 & 100: ");
        Guess = scanner.nextInt();
        int Diff = Guess - Actual;
        Run(Diff);
    }
    public static int Run(int Diff)
    {
        if(Diff > 40)
            System.out.println("Wrong Guess! Number is wayyy too high!");
        else if(Diff > 20 && Diff < 40)
            System.out.println("Wrong Guess! Number is too high!");
        else if(Diff > 10 && Diff < 20)
            System.out.println("Wrong Guess! Number is high!");
        else if(Diff > 0 && Diff < 10)
            System.out.println("Wrong Guess! Number is a bit high!");
        else if(Diff < 0 && -10 < Diff)
            System.out.println("Wrong Guess! Number is a bit low!");
        else if(Diff < -10 && -20 < Diff)
            System.out.println("Wrong Guess! Number is low!");
        else if(Diff < -20 && -40 < Diff)
            System.out.println("Wrong Guess! Number is too low!");
        else if(Diff < -40)
            System.out.println("Wrong Guess! Number is wayyy too low!");
        else
        {
            System.out.println("Correct! Your guess is right!");
            System.out.println("You got it in " + Tries + " guesses!");
            return 0;
        }
        System.out.print("Guess a number again: ");
        Guess = scanner.nextInt();
        Tries++;
        Diff = Guess - Actual;
        return Run(Diff);
    }
}




