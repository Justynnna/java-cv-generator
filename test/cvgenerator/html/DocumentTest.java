package cvgenerator.html;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class DocumentTest {
    @Test
    void shouldCorrectlySerializeAndDeserializeDocumentWithInheritance() {
        
        Document originalDoc = new Document("Jan Kowalski - CV");
        originalDoc.setPhoto("photo.jpg");
        originalDoc.addSection("Umiejętności")
                .addParagraph("Ogólne doświadczenie w IT")
                .addParagraph(new ParagraphWithList("Znane technologie")
                        .addListItem("Java")
                        .addListItem("C++"));

        String json1 = originalDoc.toJson();

        Document deserializedDoc = Document.fromJson(json1);

        String json2 = deserializedDoc.toJson();
        assertThat(json1).contains("\"type\": \"ParagraphWithList\"");
        assertThat(json1).contains("Znane technologie");
        assertThat(json1).contains("Java");

        assertThat(json2).isEqualTo(json1);
    }

    @Test
    void shouldSerializeAndDeserializeWithPolymorphismCorrectly() {
        
        Document doc1 = new Document("Jan Kowalski - CV");
        doc1.setPhoto("https://example.com/photo.jpg");

        Section section = doc1.addSection("Umiejętności");
        section.addParagraph("Podstawowe informacje");

        ParagraphWithList skillsParagraph = new ParagraphWithList("Języki programowania");
        skillsParagraph.addListItem("Java");
        skillsParagraph.addListItem("C++");
        section.addParagraph(skillsParagraph);

        
        String json1 = doc1.toJson();

        
        Document doc2 = Document.fromJson(json1);

        
        String json2 = doc2.toJson();

        
        
        assertThat(json1)
                .contains("\"type\": \"ParagraphWithList\"")
                .contains("Języki programowania")
                .contains("Java")
                .contains("C++");

        
        assertThat(json2).isEqualTo(json1);
}
}