package cvgenerator.html;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

class SectionTest {
    private ByteArrayOutputStream outContent;
    private PrintStream printStream;

    @BeforeEach
    void setUp() {
        outContent = new ByteArrayOutputStream();
        printStream = new PrintStream(outContent);
    }

    @Test
    void shouldRenderSectionWithTitleAndParagraphs() {
        Section section = new Section("Education");
        section.addParagraph("AGH University of Science and Technology");

        section.writeHTML(printStream);
        String html = outContent.toString();

        assertThat(html)
                .contains("<section>")
                .contains("AGH University of Science and Technology")
                .contains("</section>");
    }
}