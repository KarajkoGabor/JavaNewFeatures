package com.self.learning;

import java.util.Arrays;
import java.util.stream.Stream;

import static java.lang.System.out;

public class Java14Features {


    public void swtichDemo(String day){

        out.println("~~~~~ Switch demo ~~~~~~");
        out.println("The day you want to check is: " + day);

        String result = switch (day) {
            case "Mon", "Tue", "Wed", "Thu", "Fri"
                    -> day + " is a workday";
            case "Sat", "Sun"
                    -> day + " is a weekend";
            default
                    -> {
                if(day.isEmpty())
                    yield "It's empty, insert something next time";
                else
                    yield "Looks like you don't know the days";
            }
        };

        out.println(result);

    }

    public void swtichExhaustiveDemo(ExampleEnums myEnum){

        out.println("~~~~~ Switch exhaustive demo ~~~~~~");

        String result = switch (myEnum) {
            case ONE -> "one";
            case TWO -> "two";
            case SOME_OTHER_SOMETHING -> "Some other value no one thought about! Thanks IDE!";
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

    public void recordDemo() {

        out.println("~~~~~ RECORD demo ~~~~~~");

        try {
            Person slave = new Person("Joska", "Pista", 0);

            out.println(slave.toString());
        } catch (Exception e) {
            out.println(e.getMessage());
        }

        try {
            Person assassin = new Person("", "", 1000);

            out.println(assassin.toString());
        } catch (Exception e) {
            out.println(e.getMessage());
        }

        try {
            Person person = new Person("Joska", "Pista", 1000);

            out.println(person.toString());
        } catch (Exception e) {
            out.println(e.getMessage());
        }

    }

    public void instanceOfDemo() {

        out.println("~~~~~ Instance of pattern demo ~~~~~~");

        Stream.of(new Cat(), new Dog()).forEach(animal ->  {
                if(animal instanceof Cat cat) {
                    cat.meow();
                } else if(animal instanceof Dog dog) {
                    dog.voof();
                }
        });

    }

}
