package cvgenerator;

import cvgenerator.html.*;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class Main {
    public static void main(String[] args) {
        Document cv = new Document("John Doe - CV");
        cv.setPhoto("https://upload.wikimedia.org/wikipedia/commons/3/3a/Cat03.jpg?utm_source=pl.wikipedia.org&utm_campaign=index&utm_content=original");
        cv.addSection("Education")
                .addParagraph("2021-2025 Bachelor of Science in Computer Science, Technical University")
                .addParagraph(
                        new ParagraphWithList().setContent("Certificates & Courses")
                                .addListItem("Oracle Certified Professional: Java SE Developer")
                                .addListItem("Advanced Data Structures and Algorithms in C++")
                                .addListItem("English for Professional Communication (C1 Level)")
                );
        cv.addSection("Skills")
                .addParagraph(
                        new ParagraphWithList().setContent("Core Technologies")
                                .addListItem("Java (Object-Oriented Programming, Collections, Streams)")
                                .addListItem("C / C++ (Memory Management, Pointer Manipulation)")
                                .addListItem("Git & GitHub (Version Control, Collaborative Workflow)")
                );
        String jsonContent = cv.toJson();
        try (PrintWriter jsonWriter = new PrintWriter("example_cv.json")) {
            jsonWriter.println(jsonContent);
            System.out.println("Zapisano plik cv.json");
        } catch (FileNotFoundException e) {
            System.err.println("Błąd podczas zapisu pliku JSON: " + e.getMessage());
        }
        try (PrintStream htmlWriter = new PrintStream("example_cv.html")) {
            cv.writeHTML(htmlWriter);
            System.out.println("Zapisano plik cv.html");
        } catch (FileNotFoundException e) {
            System.err.println("Błąd podczas zapisu pliku HTML: " + e.getMessage());
        }
    }
}