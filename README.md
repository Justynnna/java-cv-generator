# Java CV Generator

A Java-based CV generator that transforms an object-oriented document structure into JSON and HTML output.

The project provides a simple API for building CV documents programmatically, organizing content into sections and paragraphs, and generating a ready-to-open HTML file.

---

## ✨ Features

### 📄 Document creation
- Create CV documents using the `Document` class.
- Add sections with `addSection()`.
- Add paragraphs using `addParagraph()`.
- Include profile photos with `setPhoto()`.

### 🧩 Flexible content structure
- Organize information into reusable `Section` and `Paragraph` objects.
- Create list-based paragraphs using `ParagraphWithList`.
- Use method chaining to build documents in a readable and concise way.

### 🔄 Data serialization
- Export document data to JSON using `toJson()`.
- Reconstruct document objects from JSON using `fromJson()`.
- Support polymorphic paragraph serialization, preserving concrete paragraph types.

### 🌐 HTML generation
- Generate HTML documents using `writeHTML()`.
- Export the generated CV to a standalone `.html` file.

---

## 🛠️ Technologies

- **Java** — core application logic and object-oriented design
- **JUnit 5** — unit testing
- **AssertJ** — readable test assertions

---

## 📁 Project structure

```text
.
├── src/
│   ├── main/
│   │   └── java/
│   │       └── cvgenerator/
│   │           ├── Main.java
│   │           └── html/
│   │               ├── Document.java
│   │               ├── Section.java
│   │               ├── Paragraph.java
│   │               └── ParagraphWithList.java
│   └── test/
│       └── java/
│           └── cvgenerator/
│               └── html/
│                   └── DocumentTest.java
└── README.md
```

---

## 🚀 Getting started

1. Clone the repository:

   ```bash
   git clone https://github.com/YOUR_USERNAME/java-cv-generator.git
   ```

2. Open the project in IntelliJ IDEA or another Java IDE.

3. Run the `Main` class.

4. The application generates:
    - `cv.json` — serialized CV data
    - `cv.html` — generated HTML document

The output files are saved in the application's working directory.

---

## 💡 Example

A CV can be built programmatically using a fluent API:

```java
Document cv = new Document("Jane Kowalski - CV");

cv.addSection("Education")
    .addParagraph("University studies")
    .addParagraph(
        new ParagraphWithList()
            .setContent("Courses")
            .addListItem("English")
            .addListItem("Spanish")
    );

String json = cv.toJson();
```

The resulting document can then be exported to JSON and HTML.

---

## 🧪 Tests

The project includes unit tests written with JUnit 5 and AssertJ.

The demonstrated tests cover:
- JSON serialization and deserialization.
- Preservation of document content after a serialization round trip.
- Polymorphic serialization of different paragraph types.
- Correct reconstruction of `ParagraphWithList` objects.

---

## 📌 Project scope

This project explores object-oriented design, inheritance, polymorphism, serialization, and HTML generation in Java.

It is a lightweight implementation intended for learning and experimentation rather than a full-featured CV editing platform.

---

## 📜 License 
This project is open-source and available under the MIT License.