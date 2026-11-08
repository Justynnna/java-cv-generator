package cvgenerator.html;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

class UnorderedListTest {
    private ByteArrayOutputStream outContent;
    private PrintStream printStream;

    @BeforeEach
    void setUp() {
        outContent = new ByteArrayOutputStream();
        printStream = new PrintStream(outContent);
    }

    @Test
    void shouldRenderUnorderedListWithItems() {
        UnorderedList list = new UnorderedList();
        list.addItem("Java").addItem("Spring");

        list.writeHTML(printStream);
        String html = outContent.toString();
        assertThat(html).containsIgnoringWhitespaces("""
            <ul>
               <li>Java</li>
               <li>Spring</li>
            </ul>
            """);
    }
}