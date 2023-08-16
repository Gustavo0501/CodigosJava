import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class arquivo {
    static void salvarCSV_BIN (ArrayList<Personagens> listaPersonagens, String cabecalho, String nomeArq) {
        BufferedWriter bw = null;
        String divisor = ";";
        
        try {
            bw = new BufferedWriter(new FileWriter(nomeArq + ".csv"));
            
            bw.write(cabecalho+"\n");
            
            for (Personagens personagem : listaPersonagens) {
                bw.write(String.valueOf(personagem.identificador));
                bw.write(divisor);
                bw.write(personagem.nome);
                bw.write(divisor);
                bw.write(personagem.criador);
                bw.write(divisor);
                bw.write(personagem.tituloDesenho);
                bw.write(divisor);
                bw.write(String.valueOf(personagem.altura));
                bw.write(divisor);
                bw.write(personagem.bio);
                bw.write("\n");
            }


            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    
    }

    static void salvarBIN (ArrayList<Personagens> listaPersonagens, String cabecalho, String nomeArq) {

    }

}
