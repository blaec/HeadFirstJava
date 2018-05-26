package org.blaec.HeadFirstJava.DotCom.Test;


import org.blaec.HeadFirstJava.DotCom.Game.DotCom;

import java.util.ArrayList;
import java.util.Arrays;

public class SimpleDotComTester {
    public static void main(String[] args)
    {
        DotCom dot = new DotCom();
        String[] locations = {"2", "3", "4"};
        ArrayList<String> locs = new ArrayList(Arrays.asList(locations));
        dot.setLocationCells(locs);
        String userGuess = "2";
        String result = dot.checkYourself(userGuess);
        System.out.println(result);
    }
}

