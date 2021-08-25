package ressources;

public class definition {

    private String intitule;
    private String word;
    private Direction direction;

    public definition() {
        super();
    }

    public void setWord(String p_Word) {
        this.word = p_Word;
    }

    public String getWord() {
        return this.word;
    }

    public void setIntitule(String parIntitule) {
        this.intitule = parIntitule;
    }

    public String getIntitule() {
        return this.intitule + "";
    }

    public void setDirection(Direction parDirection) {
        this.direction = parDirection;
    }

    public Direction getDirection() {
        return this.direction;
    }

    public enum Direction {
        HD, HI, VD, VI
    }
}