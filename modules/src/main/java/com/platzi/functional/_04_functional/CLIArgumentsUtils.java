package com.platzi.functional._04_functional;

import java.util.function.Consumer;

public class CLIArgumentsUtils {
    static void showHelp(CLIArguments cliArguments) {
        Consumer<CLIArguments> consumerHelper = cliArguments1 -> {
            if (cliArguments1.isHelp()) {
                System.out.println("The manual has been requested.");
            }
        };

        consumerHelper.accept(cliArguments);
    }
}
