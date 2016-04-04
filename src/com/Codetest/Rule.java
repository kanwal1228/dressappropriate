package com.Codetest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by kanwal on 4/1/16.
 */

//class to hold the rules in the map for easier maintenance
class Rule {
    private HashMap ruleMap;


    Rule(){
        ruleMap = new HashMap<String,List<Integer>>();
    }

    //to add a precedence list to the rule map
    private void addlist(String key, List<Integer> predList){
        ruleMap.put(key,predList);
    }

    //getting a precedence list based on the key
    List<Integer> getlist(String key){
        return (List<Integer>)ruleMap.get(key);
    }

    //creating rule list for the hashmap
    void createRuleList(){

        // rule for HOT and COLD temp
        this.addlist("1HOT",Arrays.asList(8));
        this.addlist("1COLD",Arrays.asList(8,3,6));

        this.addlist("2HOT",Arrays.asList(8,4));
        this.addlist("2COLD",Arrays.asList(8,4));

        this.addlist("3COLD",Arrays.asList(8,3,6));

        this.addlist("4HOT",Arrays.asList(8));
        this.addlist("4COLD",Arrays.asList(8));

        this.addlist("5COLD",Arrays.asList(8,4));

        this.addlist("6HOT",Arrays.asList(8));
        this.addlist("6COLD",Arrays.asList(8));

        this.addlist("7HOT",Arrays.asList(8));
        this.addlist("7COLD",Arrays.asList(8));

    }

}


