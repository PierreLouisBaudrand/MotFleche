package ressources;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class dictionary {

    List<String> dictio = new ArrayList<String>();
    List<String> dictioParsed = new ArrayList<String>();

    public dictionary() 
    {
        String fichier = "fichiers/liste_francais.txt";
        
        java.net.URL fileURL = dictionary.class.getClassLoader().getResource(fichier);

        try {
            InputStream fis = new FileInputStream(fileURL.getFile());
            InputStreamReader isr = new InputStreamReader(fis, "utf-8");
            BufferedReader br = new BufferedReader(isr);
            String line;
            while ((line = br.readLine()) != null) {
                dictio.add(line);
            }
            br.close();
        } catch (IOException e) 
        {
            System.out.println("Erreur lors de la lecture du fichier");
            e.printStackTrace();
        }
    }

    public void getWords(List<String> dico) 
    {
        dico.forEach(System.out::println);
    }

    public List<String> searchByLenght(int p_taille) 
    {
        for (String data : dictio) {
            if (data.length() == p_taille) 
            {
                dictioParsed.add((data));
            }
        }
        dictioParsed.forEach(System.out::println);
        return dictioParsed;
    }

    public List<String> searchByChar(String p_Letter) 
    {
        for (String data : dictio) {
            if (data.startsWith(p_Letter)) 
            {
                dictioParsed.add((data));
            }
        }
        dictioParsed.forEach(System.out::println);
        return dictioParsed;
    }

    public List<String> searchByMatches(String parWord) 
    {

        for (String data : dictio) {
            if (data.matches(parWord.toLowerCase())) 
            {
                dictioParsed.add(data);
            }
        }
        dictioParsed.forEach(System.out::println);
        return dictioParsed;
    }
}