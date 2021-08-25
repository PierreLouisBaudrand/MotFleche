package ressources;

public class cell{

    private definition[] definitionArray = new definition[2];
    private int x;
    private int y;
    private letters letter;
    private int type;


    public cell(int p_X, int p_Y)
    {
        this.y = p_Y;
        this.x = p_X;
        this.type = 0;
    }

    public void addDef(String parDef, String parMot, String parDef2, String parMot2, definition.Direction parDirection)
    {
        this.definitionArray[0] = new definition();
        this.definitionArray[0].setIntitule(parDef);
        this.definitionArray[0].setWord(parMot);
        this.definitionArray[0].setDirection(parDirection);
        this.definitionArray[1] = new definition();
        this.definitionArray[1].setIntitule(parDef2);
        this.definitionArray[1].setWord(parMot2);
    }

    public void addLetter(String parLetter)
    {
        this.letter = new letters();
        this.letter.setLetter(parLetter);
    }

    public void setType(int parType)
    {

        this.type = parType;
    }


    public String getDef(int idx)
    {
        return  this.definitionArray[idx].getIntitule() + " " + this.definitionArray[idx].getWord();
    }

    public String getWord(int idx)
    
    {
        return  this.definitionArray[idx].getWord();
    }


    public String getLetter()
    {
        return letter.getLetter();
    }


    public int getType()
    {
        return this.type;
    }
    public int getCoordX()
    {
        return x;
    }
    public int getCoordY()
    {
        return y;
    }
}