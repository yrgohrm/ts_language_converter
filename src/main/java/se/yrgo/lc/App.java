package se.yrgo.lc;

import java.util.List;
import java.util.Scanner;
import se.yrgo.lc.languages.AllLang;
import se.yrgo.lc.languages.Base64;
import se.yrgo.lc.languages.Language;
import se.yrgo.lc.languages.Robber;

/**
 * Write a phrase in all supported languages.
 *
 */
public class App {
    public static void main(String[] args) {
        var languages = List.of(new Robber(), new AllLang());

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Please enter a phrase:");
            String phrase = scanner.nextLine();

            for (Language lang : languages) {
                System.out.printf("The phrase in %s is: %s%n", lang.name(), lang.encode(phrase));
            }
        }
    }
}
