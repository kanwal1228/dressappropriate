package com.Codetest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by kanwal on 4/3/16.
 */
class Command {
    private HashMap command;
    private List<String> leaveHot;
    private List<String> leaveCold;

    Command(){

        command = new HashMap<String,String>();
        leaveHot = new ArrayList<String>();
        leaveCold = new ArrayList<String>();
    }

    void generateCommandlist(){
        // rule for HOT and COLD temp
        command.put("1HOT", "sandals ,");
        command.put("1COLD","boots ,");

        command.put("2HOT","sun visor ,");
        command.put("2COLD","hat ,");

        command.put("3HOT","fail ,");
        command.put("3COLD","socks ,");

        command.put("4HOT","t-shirt ,");
        command.put("4COLD","shirt ,");

        command.put("5HOT","fail ,");
        command.put("5COLD","jacket ,");

        command.put("6HOT","shorts ,");
        command.put("6COLD","pants ,");

        command.put("7HOT","leaving house");
        command.put("7COLD","leaving house");

        command.put("8HOT","Removing PJs ,");
        command.put("8COLD","Removing PJs ,");

        //adding conditions necessary before leaving house
        leaveHot.addAll(Arrays.asList("1","2","4","6","8"));
        leaveCold.addAll(Arrays.asList("1","2","3","4","5","6","8"));
    }

    //returns the description of command to be printed on screen
    String commandDescription(String cmd){

        return command.get(cmd).toString();
    }

    //to check whether we have all the clothes based on temp before leaving
    boolean preleave(String temp,List<String> cmd){
        if(temp.equals("7HOT")){
            for(String val : leaveHot){
                if(!cmd.contains(val)){
                    return false;
                }
            }

        }
        else if(temp.equals("7COLD")){
            for(String val : leaveCold){
                if(!cmd.contains(val)){
                    return false;
                }
            }

        }
        return true;

    }


}
