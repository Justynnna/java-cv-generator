package cvgenerator.html;

import java.io.PrintStream;


public class ParagraphWithList extends Paragraph{
    private final UnorderedList list = new UnorderedList();
    public ParagraphWithList() {}
    public ParagraphWithList(String content) { super(content);}
    @Override
    public ParagraphWithList setContent(String title) {
        super.setContent(title);
        return this;
    }
    public ParagraphWithList addListItem(String item) {
        this.list.addItem(item);
        return this;
    }
    @Override
    public void writeHTML(PrintStream out) {
        out.println("  <div class=\"cv-entry\">");
        if (this.content != null) {
            out.println("    <h4>" + this.content + "</h4>");
        }
        this.list.writeHTML(out);
        out.println("  </div>");
    }
}