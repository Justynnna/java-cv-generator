package cvgenerator.html;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class UnorderedList {
    List<ListItem> elements = new ArrayList<>();
    public UnorderedList addItem(String content) {
        ListItem item = new ListItem(content);
        this.elements.add(item);
        return this;
    }
    public void writeHTML(PrintStream out) {
        out.println("<ul>");
        for (ListItem element : elements) {
            element.writeHTML(out);
        }
        out.println("</ul>");
    }
}
