package com.Codetest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static javafx.application.Platform.exit;

public class Main {

    private static boolean checkTemp(String temp){
        if(temp.equals("HOT") || temp.equals("COLD")){
            return true;
        }
        System.out.println("fail");
        return false;

    }

    private static boolean jammiesON(String jammies){
        if(jammies.equals("8")){
            return true;
        }
        System.out.println("fail");
        return false;

    }

    private static void answer(String inputSequence) {
        Rule rule = new Rule();

        String[] inputseprate = inputSequence.split(" ");

        //Proceed only if Temperature is present in the command and the second command is to remove the jammies
        if (checkTemp(inputseprate[0]) && jammiesON(inputseprate[1])) {
            rule.createRuleList();
            //List to hold the commands already processed to avoid duplication
            List<String> processedcmd = new ArrayList<String>();

            Command cmd = new Command();
            //generating the command list which holds the command description for all commands
            cmd.generateCommandlist();

            int i = 2;
            processedcmd.add("8");

            System.out.print(cmd.commandDescription(inputseprate[1] + inputseprate[0]));

            while (inputseprate.length > i) {
                //check whether we have already processed the same command or not
                if (processedcmd.contains(inputseprate[i])) {
                    System.out.println(" fail ");
                    break;
                }

                //check whether rule exist in the list command
                List<Integer> commandList = rule.getlist(inputseprate[i] + inputseprate[0]);
                if (commandList == null) {
                    System.out.println(" fail ");
                    break;
                }
                else if(inputseprate[i].equals("7")){
                    if(!cmd.preleave(inputseprate[i] + inputseprate[0], processedcmd)){
                        System.out.println(" fail ");
                        return;
                    }
                }

                //add command to processed command list

                processedcmd.add(inputseprate[i]);
                System.out.print(cmd.commandDescription(inputseprate[i] + inputseprate[0]));

                for (String key : processedcmd) {
                    if (!processedcmd.contains(key)) {
                        System.out.print(" fail ");
                        return;
                    }
                }
                i++;

            }

        }

    }

    public static void main(String[] args) {
	// write your code here
        //testing with valid inputs
        String input = "COLD 8 6 3 4 2 5 1 7";
        answer(input);
        System.out.println();


        //testing with valid inputs different temp
        input = "HOT 8 6 4 2 1 7";
        answer(input);
        System.out.println();

        //testing with valid inputs different temp
        input = "COLD 8 6 4 2 1 7";
        answer(input);
        System.out.println();


        //testing with invalid inputs -to check various scenarios
        input = "COLD 8 6 4 1 7";
        answer(input);
        System.out.println();

        input = "8 6 4 1 7";
        answer(input);
        System.out.println();

        //testing with invalid inputs -to check various scenarios
        input = "HOT 8 7";
        answer(input);
        System.out.println();

        //testing with invalid inputs -to check various scenarios
        input = "HOT 8 6 6";
        answer(input);
        System.out.println();

        //testing with invalid inputs -to check various scenarios
        input = "COLD 6";
        answer(input);
        System.out.println();

    }


}
