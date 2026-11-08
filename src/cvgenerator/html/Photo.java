package cvgenerator.html;

import java.io.PrintStream;

public class Photo {
    private String url;
    public Photo(String url) {
        this.url = url;
    }
    public void writeHTML(PrintStream out) {
        if (url != null && !url.isEmpty()) {
            out.println("<img src=\"");
            out.println(url);
            out.println("\" class=\"profile-photo\">");
        }
    }
}
