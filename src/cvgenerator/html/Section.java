package cvgenerator.html;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Section {
    String title;
    List<Paragraph> paragraphs = new ArrayList<>();
    public Section() {}
    public Section(String title) {
        this.title = title;
    }
    public Section setTitle(String title){
        this.title = title;
        return this;
}
    public Section addParagraph(String paragraphText){
        Paragraph par = new Paragraph(paragraphText);
        paragraphs.add(par);
        return this;
    }
    public Section addParagraph(Paragraph p){
        paragraphs.add(p);
        return this;
    }

    public void writeHTML(PrintStream out) {
        out.println("  <section>");
        if (title != null) {
            out.println("    <h2>" + title + "</h2>");
        }
        for (Paragraph paragraph : paragraphs) {
            paragraph.writeHTML(out);
        }
        out.println("  </section>");
    }
}
