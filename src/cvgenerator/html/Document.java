package cvgenerator.html;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.typeadapters.RuntimeTypeAdapterFactory;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Document {
    private String title;
    private Photo photo;
    private List<Section> sections = new ArrayList<>();
    public Document() {}
    public Document(String title) {
        this.title = title;
    }
    Document setTitle(String title) {
        this.title = title;
        return this;
    }

    public Document setPhoto(String photoUrl) {
        this.photo = new Photo(photoUrl);
        return this;
    }
    public Section addSection(String title) {
        Section s = new Section(title);
        sections.add(s);
        return s;
    }
    private static Gson createGson() {
        RuntimeTypeAdapterFactory<Paragraph> adapter =
                RuntimeTypeAdapterFactory
                        .of(Paragraph.class, "type")
                        .registerSubtype(Paragraph.class, "Paragraph")
                        .registerSubtype(ParagraphWithList.class, "ParagraphWithList");

        return new GsonBuilder()
                .registerTypeAdapterFactory(adapter)
                .setPrettyPrinting()
                .create();
    }
    public String toJson(){
        return createGson().toJson(this);
    }
    public static Document fromJson(String jsonString) {
        return createGson().fromJson(jsonString, Document.class);
    }
    public void writeHTML(PrintStream out) {
        out.println("<!DOCTYPE html>");
        out.println("<html lang=\"pl\">");
        out.println("<head>");
        out.println("    <meta charset=\"UTF-8\">");
        out.println("    <title>" + title + "</title>");
        out.println("    <style>");
        out.println("        @import url('https://fonts.googleapis.com/css2?family=Inter:wght@300;400;600;700&display=swap');");
        out.println("        ");
        out.println("        * {");
        out.println("            box-sizing: border-box;");
        out.println("        }");
        out.println("        body {");
        out.println("            font-family: 'Inter', system-ui, -apple-system, sans-serif;");
        out.println("            max-width: 850px;");
        out.println("            margin: 40px auto;");
        out.println("            padding: 40px 50px;");
        out.println("            color: #2d3748;");
        out.println("            background-color: #ffffff;");
        out.println("            box-shadow: 0 10px 25px rgba(0, 0, 0, 0.08);");
        out.println("            border-radius: 12px;");
        out.println("            line-height: 1.6;");
        out.println("        }");
        out.println("        .header-container {");
        out.println("            display: flex;");
        out.println("            justify-content: space-between;");
        out.println("            align-items: center;");
        out.println("            padding-bottom: 25px;");
        out.println("            border-bottom: 2px solid #e2e8f0;");
        out.println("            margin-bottom: 35px;");
        out.println("            position: relative;");
        out.println("        }");
        out.println("        .header-container::after {");
        out.println("            content: '';");
        out.println("            position: absolute;");
        out.println("            bottom: -2px;");
        out.println("            left: 0;");
        out.println("            width: 80px;");
        out.println("            height: 2px;");
        out.println("            background: linear-gradient(90deg, #2563eb, #3b82f6);");
        out.println("        }");
        out.println("        .header-container h1 {");
        out.println("            margin: 0;");
        out.println("            font-size: 2.4em;");
        out.println("            font-weight: 700;");
        out.println("            color: #1e293b;");
        out.println("            letter-spacing: -0.5px;");
        out.println("        }");
        out.println("        .header-container img {");
        out.println("            width: 130px;");
        out.println("            height: 130px;");
        out.println("            object-fit: cover;");
        out.println("            border: 3px solid #ffffff;");
        out.println("            outline: 2px solid #cbd5e1;");
        out.println("            box-shadow: 0 10px 15px -3px rgba(0, 0, 0, 0.1);");
        out.println("            transition: transform 0.2s ease;");
        out.println("        }");
        out.println("        section, .section {");
        out.println("            margin-bottom: 30px;");
        out.println("        }");
        out.println("        section h2, h2 {");
        out.println("            display: flex;");
        out.println("            align-items: center;");
        out.println("            color: #1e293b;");
        out.println("            font-size: 1.25em;");
        out.println("            font-weight: 600;");
        out.println("            text-transform: uppercase;");
        out.println("            letter-spacing: 0.8px;");
        out.println("            margin-top: 0;");
        out.println("            margin-bottom: 18px;");
        out.println("        }");
        out.println("        section h2::before, h2::before {");
        out.println("            content: '';");
        out.println("            display: inline-block;");
        out.println("            width: 8px;");
        out.println("            height: 8px;");
        out.println("            background-color: #2563eb;");
        out.println("            border-radius: 50%;");
        out.println("            margin-right: 12px;");
        out.println("        }");
        out.println("        section h2::after, h2::after {");
        out.println("            content: '';");
        out.println("            flex: 1;");
        out.println("            height: 1px;");
        out.println("            background-color: #f1f5f9;");
        out.println("            margin-left: 15px;");
        out.println("        }");
        out.println("        @media print {");
        out.println("            body {");
        out.println("                box-shadow: none;");
        out.println("                margin: 0;");
        out.println("                padding: 0;");
        out.println("            }");
        out.println("        }");
        out.println("    </style>");
        out.println("</head>");
        out.println("<body>");

        out.println("<header class=\"header-container\">");
        out.println("    <h1>" + title + "</h1>");
        if (this.photo != null) {
            this.photo.writeHTML(out);
        }
        out.println("</header>");

        for (Section section: sections) {
            section.writeHTML(out);
        }
        out.println("</body>");
        out.println("</html>");
    }
}
