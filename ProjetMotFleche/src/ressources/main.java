package ressources;

public class main {
    
    public static void main(String[] args) 
    {
        System.out.println("Program compiled sucessfuly");
        dictionary dictionnaire = new dictionary();
        grid grid = new grid(10, 10);
        
        //Test 1
        grid.setCellDef(2, 2, "mot de négation", "non", null, null, definition.Direction.VI, null);
        
        //Test 2
        grid.setCellDef(3, 2, "p_Def4", "test", "p_Def5", "oui", definition.Direction.HD, definition.Direction.VI);
        
        //Test 3
        grid.setWord(4, 1, "word", definition.Direction.HD);
        
        grid.displayGrid2();
        System.out.println();
        System.out.println(grid.checkCell(2, 1, definition.Direction.HD));

    }
}