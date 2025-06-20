interface Doc {
    void show();
}

class PdfDoc implements Doc {
    public void show() {
        System.out.println("Showing PDF document.");
    }
}

class WordDoc implements Doc {
    public void show() {
        System.out.println("Showing Word document.");
    }
}

class ExcelDoc implements Doc {
    public void show() {
        System.out.println("Showing Excel document.");
    }
}

class DocFactory {
    public static Doc getDoc(String type) {
        if (type == null) return null;

        type = type.toLowerCase();
        switch (type) {
            case "pdf":
                return new PdfDoc();
            case "word":
                return new WordDoc();
            case "excel":
                return new ExcelDoc();
            default:
                System.out.println("Unknown document type.");
                return null;
        }
    }
}

public class Factory {
    public static void main(String[] args) {
        Doc d1 = DocFactory.getDoc("pdf");
        if (d1 != null) d1.show();

        Doc d2 = DocFactory.getDoc("word");
        if (d2 != null) d2.show();

        Doc d3 = DocFactory.getDoc("excel");
        if (d3 != null) d3.show();
    }
}
