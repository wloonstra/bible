package nl.wiggertloonstra.bible.contants;

public enum Urls {
    
    INSTANCE;
    
    public String overview() {
        return "overzicht.html";
    }
    
    public String overview(int categoryId) {
        return overview() + "?categoryId=" + categoryId;
    }
    
    public String viewtext(int textId) {
        return "tekst.html" + "?textId=" + textId;
    }

}
