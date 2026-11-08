package cvgenerator.html;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DocumentTest {

    @Test
    void shouldCorrectlySerializeAndDeserializeDocumentWithInheritance() {

        Document originalDoc = new Document("John Smith - CV");
        originalDoc.setPhoto("photo.jpg");
        originalDoc.addSection("Skills")
                .addParagraph("General experience in IT")
                .addParagraph(new ParagraphWithList("Known technologies")
                        .addListItem("Java")
                        .addListItem("C++"));

        String json1 = originalDoc.toJson();

        Document deserializedDoc = Document.fromJson(json1);

        String json2 = deserializedDoc.toJson();

        assertThat(json1).contains("\"type\": \"ParagraphWithList\"");
        assertThat(json1).contains("Known technologies");
        assertThat(json1).contains("Java");

        assertThat(json2).isEqualTo(json1);
    }

    @Test
    void shouldCorrectlySerializeAndDeserializePolymorphicObjects() {

        Document originalDoc = new Document("John Smith - CV");
        originalDoc.setPhoto("https://example.com/photo.jpg");

        Section skillsSection = originalDoc.addSection("Skills");
        skillsSection.addParagraph("Basic information");

        ParagraphWithList skillsParagraph =
                new ParagraphWithList("Programming languages");
        skillsParagraph.addListItem("Java");
        skillsParagraph.addListItem("C++");

        skillsSection.addParagraph(skillsParagraph);

        String json1 = originalDoc.toJson();

        Document deserializedDoc = Document.fromJson(json1);

        String json2 = deserializedDoc.toJson();

        assertThat(json1)
                .contains("\"type\": \"ParagraphWithList\"")
                .contains("Programming languages")
                .contains("Java")
                .contains("C++");

        assertThat(json2).isEqualTo(json1);
    }
}