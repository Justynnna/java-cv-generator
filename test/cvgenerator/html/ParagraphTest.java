package cvgenerator.html;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

class ParagraphTest {
    private ByteArrayOutputStream outContent;
    private PrintStream printStream;

    @BeforeEach
    void setUp() {
        outContent = new ByteArrayOutputStream();
        printStream = new PrintStream(outContent);
    }

    @Test
    void shouldRenderParagraphWithContent() {
        Paragraph paragraph = new Paragraph("Doświadczenie zawodowe");

        paragraph.writeHTML(printStream);
        String html = outContent.toString();

        assertThat(html)
                .contains("<p>")
                .contains("Doświadczenie zawodowe")
                .contains("</p>");
    }
}