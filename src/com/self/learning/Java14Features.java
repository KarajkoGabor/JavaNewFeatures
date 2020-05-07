package com.self.learning;

import java.util.Arrays;

import static java.lang.System.out;

public class Java14Features {


    public void swtichDemo(String day){

        out.println("~~~~~ Switch demo ~~~~~~");
        out.println("The day you want to check is: " + day);

        String result = switch (day) {
            case "Mon", "Tue", "Wed", "Thu", "Fri" -> day + " is a workday";
            case "Sat", "Sun" -> day + " is a weekend";
            default -> {
                if(day.isEmpty())
                    yield "It's empty, insert something next time";
                else
                    yield "Looks like you don't know the days";
            }
        };

        out.println(result);

    }

    /**
     * This will give back the following message
     * Cannot invoke "String.isEmpty()" because "str" is null
     */
    public void nPEMessageDemo(){

        out.println("~~~~~ NPE message demo ~~~~~~");
        String str = null;
        try {
            str.isEmpty();
        }catch (Exception e) {
            out.println(e.getMessage());
        }
    }

}
