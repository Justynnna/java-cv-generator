package cvgenerator.html;

import java.io.PrintStream;

class ListItem {
    private final String content;
    ListItem(String content) {
        this.content = content;
    }
    void writeHTML(PrintStream out) {
        out.println("   <li>");
        out.println(content);
        out.println("   </li>");
    }
}
