package cvgenerator.html;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

class ParagraphWithListTest {
    private ByteArrayOutputStream outContent;
    private PrintStream printStream;

    @BeforeEach
    void setUp() {
        outContent = new ByteArrayOutputStream();
        printStream = new PrintStream(outContent);
    }

    @Test
    void shouldRenderDivWithTitleAndList() {
        ParagraphWithList paragraphWithList = new ParagraphWithList("Umiejętności");
        paragraphWithList.addListItem("Git").addListItem("Docker");

        paragraphWithList.writeHTML(printStream);
        String html = outContent.toString();

        assertThat(html)
                .contains("<div class=\"cv-entry\">")
                .contains("<h4>Umiejętności</h4>")
                .contains("<ul>")
                .contains("Git")
                .contains("Docker")
                .contains("</ul>")
                .contains("</div>");
    }
}