package com.ttrzcinski;

import com.ttrzcinski.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    private static Brain brain;

    public static void main(String[] args) {
        //Show all the inputed params
        List<String> result = Arrays.asList(args).stream()
                .filter(s->s.startsWith("-"))
                .collect(Collectors.toList());
        boolean consoleHelp = result.stream()
                .filter(s->s.equals("-?"))
                .count() > 0;
        boolean consoleVerbose = result.stream()
                .filter(s->s.equals("-outputEverything"))
                .count() > 0;

        if (consoleHelp) {
            System.out.println("Known args:");
            System.out.println("outputEverything - output eveything to the console.");
            System.out.println("?                - Shows help in console.");
            return;
        }
        //Shows argas in the console
        result.forEach(item->System.out.println("I got an arg: " + item));
        if (consoleVerbose) System.out.println("Creating the brain shop");
        //Create the BrainShop
        BrainShop brainShop = new BrainShop();

        //Create new brain
        Main.brain = brainShop.createNew();
    }
}
