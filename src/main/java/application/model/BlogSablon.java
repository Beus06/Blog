package application.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BlogSablon {

    @Id
    private long sablonId;
    private String colour;
    private String alphabet;
    private String style;

    public BlogSablon() {
    }

    public BlogSablon(long sablonId, String colour, String alphabet, String style) {
        this.sablonId = sablonId;
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
