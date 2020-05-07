package com.self.learning;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.System.out;

public class Java12Features {

    private static final String ORIGINAL_TEST_FILE_PATH = "src/resources/TestFile.json";
    private static final String DIFFERENT_TEST_FILE_PATH = "src/resources/TestFileDifferent.json";
    private static final String EQUAL_TEST_FILE_PATH = "src/resources/TestFileEqual.json";

    /**
     * Java 12 Feature - Files.mismatch() - Compare the contents of two files to determine whether there is a mismatch between them
     * The addition of the Files.mismatch(Path,Path) method is another step in accomplishing the ["Inputs/Outputs methods to make common I/O tasks easy to do"]
     * and makes it easier to determine when two files that are not the same file are still "equal" or have the same content.
     * @throws IOException
     */

    public void mismatchFeatureDemo() throws IOException {

        Path originalFilePath = Path.of(ORIGINAL_TEST_FILE_PATH);
        Path differentFilePath = Path.of(DIFFERENT_TEST_FILE_PATH);
        Path equalFilePath = Path.of(EQUAL_TEST_FILE_PATH);

        out.println("~~~~~~~~~~~~~~~~~~~ FILES MISMATCH DEMO ~~~~~~~~~~~~~~~~~~~");

        out.println("Files.mismatch - Original and Original files are the " + mismatchDemo(originalFilePath, originalFilePath));
        out.println("Files.isSameFile - Original and Original files are the " + isSameFileDemo(originalFilePath, originalFilePath));
        out.println("~~~~~~~~~~~~~~~~~~~");
        out.println("Files.mismatch - Original and Copied files are the " + mismatchDemo(originalFilePath, equalFilePath));
        out.println("Files.isSameFile - Original and Copied files are the " + isSameFileDemo(originalFilePath, equalFilePath));
        out.println("~~~~~~~~~~~~~~~~~~~");
        out.println("Files.mismatch - Original and Different files are the " + mismatchDemo(originalFilePath, differentFilePath));
        out.println("Files.isSameFile - Original and Different files are the " + isSameFileDemo(originalFilePath, differentFilePath));
        out.println("~~~~~~~~~~~~~~~~~~~");
        out.println("Files.mismatch - Original and Different files are the position: " + Files.mismatch(originalFilePath, differentFilePath));

    }

    public void compactNumberFormatDemo(final long numberToFormat) {

        out.println("~~~~~ Compact Number format demo ~~~~~");

        final NumberFormat numberFormatDefault
                = NumberFormat.getCompactNumberInstance();
        final NumberFormat numberFormatUsLong
                = NumberFormat.getCompactNumberInstance(Locale.US, NumberFormat.Style.LONG);
        final NumberFormat numberFormatUkShort
                = NumberFormat.getCompactNumberInstance(Locale.UK, NumberFormat.Style.SHORT);
        final NumberFormat numberFormatUkLong
                = NumberFormat.getCompactNumberInstance(Locale.UK, NumberFormat.Style.LONG);
        final NumberFormat numberFormatGrShort
                = NumberFormat.getCompactNumberInstance(Locale.GERMANY, NumberFormat.Style.SHORT);
        final NumberFormat numberFormatGrLong
                = NumberFormat.getCompactNumberInstance(Locale.GERMANY, NumberFormat.Style.LONG);
        final NumberFormat numberFormatChShort
                = NumberFormat.getCompactNumberInstance(Locale.CHINA, NumberFormat.Style.SHORT);
        final NumberFormat numberFormatChLong
                = NumberFormat.getCompactNumberInstance(Locale.CHINA, NumberFormat.Style.LONG);
        final NumberFormat numberFormatJpShort
                = NumberFormat.getCompactNumberInstance(Locale.JAPAN, NumberFormat.Style.SHORT);
        final NumberFormat numberFormatJpLong
                = NumberFormat.getCompactNumberInstance(Locale.JAPAN, NumberFormat.Style.LONG);
        out.println("Demonstrating Compact Number Formatting on '" + numberToFormat + "':");
        out.println("\tDefault:  " + numberFormatDefault.format(numberToFormat));
        out.println("\tUS/Long:  " + numberFormatUsLong.format(numberToFormat));
        out.println("\tUK/Short: " + numberFormatUkShort.format(numberToFormat));
        out.println("\tUK/Long:  " + numberFormatUkLong.format(numberToFormat));
        out.println("\tCH/Short: " + numberFormatChShort.format(numberToFormat));
        out.println("\tCH/Long:  " + numberFormatChLong.format(numberToFormat));
        out.println("\tDE/Short: " + numberFormatGrShort.format(numberToFormat));
        out.println("\tDE/Long:  " + numberFormatGrLong.format(numberToFormat));
        out.println("\tJP/Short: " + numberFormatJpShort.format(numberToFormat));
        out.println("\tJP/Long:  " + numberFormatJpLong.format(numberToFormat));

    }

    public void teeingDemo() {

        out.println("~~~~~ TEEing demo ~~~~~");

        out.println("Split a stream of strings to two sequences");

        var filteredStrings = Stream.of(
                "abc",
                "abc12",
                "aaaaa",
                "1234565"
        ).collect(
                Collectors.teeing(
                        Collectors.filtering(word -> word.matches(".*\\d+"), Collectors.toList()),
                        Collectors.filtering(word -> !word.matches(".*\\d+"), Collectors.toList()),
                        (List<String> list1, List<String> list2) -> List.of(list1, list2)
                )
        );

        out.println(filteredStrings);

    }

    public void stringMethodsDemos() {

        out.println("~~~~~ Indent demo ~~~~~");

        String exampleString = "This is an example \n this is a line break";

        out.println("0 Indent");
        out.println(exampleString.indent(0));

        out.println("Bigger than 0 Indent");
        out.println(exampleString.indent(5));

        out.println("Lower than 0 Indent");
        out.println(exampleString.indent(-5));


        out.println("~~~~~ Transform demo ~~~~~");
        var resultString = exampleString
                        .transform(s -> s + " some other string")
                        .transform(String::toUpperCase)
                        .transform(s -> s + "\n")
                        .transform(s -> s + " some even more string");
        System.out.println(resultString);

    }

    private String mismatchDemo(Path path1, Path path2) throws IOException {
        return Files.mismatch(path1, path2) == -1 ? "Same" : "Different";
    }

    private String isSameFileDemo(Path path1, Path path2) throws IOException {
        return Files.isSameFile(path1, path2) ? "Same" : "Different";
    }

}
