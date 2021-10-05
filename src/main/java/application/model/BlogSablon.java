package application.model;

public class BlogSablon {

    private long idSablon;
    private String colour;
    private String alphabet;
    private String style;

    public BlogSablon() {
    }

    public BlogSablon(long idSablon, String colour, String alphabet, String style) {
        this.idSablon = idSablon;
        this.colour = colour;
        this.alphabet = alphabet;
        this.style = style;
    }

    public String getColour() {
        return colour;
    }

    public String getAlphabet() {
        return alphabet;
    }

    public String getStyle() {
        return style;
    }
}
