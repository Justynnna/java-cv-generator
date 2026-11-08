package cvgenerator.html;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

class PhotoTest {
    private ByteArrayOutputStream outContent;
    private PrintStream printStream;

    @BeforeEach
    void setUp() {
        outContent = new ByteArrayOutputStream();
        printStream = new PrintStream(outContent);
    }

    @Test
    void shouldRenderImgTagWithCorrectSrcAndClass() {
        Photo photo = new Photo("jan-kowalski.png");
        photo.writeHTML(printStream);
        String html = outContent.toString();

        assertThat(html)
                .contains("<img src=\"")
                .contains("jan-kowalski.png")
                .contains("\" class=\"profile-photo\">");
    }

    @Test
    void shouldNotRenderAnythingWhenUrlIsNull() {
        Photo photo = new Photo(null);
        photo.writeHTML(printStream);
        assertThat(outContent.toString()).isEmpty();
    }
}