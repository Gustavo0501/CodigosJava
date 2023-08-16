import java.util.ArrayList;
import java.util.Collections;

public class ordenacao {
    static int particionaNome (ArrayList<Personagens> copiaListaPersonagens, int p, int r) {
        String personagemPivo;
        personagemPivo = copiaListaPersonagens.get(r).nome;
        int j = p;
        int k;
        for (k = p; k < r; k++) {
            if ((copiaListaPersonagens.get(k).nome.compareToIgnoreCase(personagemPivo)) <= 0) {
                Collections.swap(copiaListaPersonagens, j, k);
                int temp = copiaListaPersonagens.get(j).identificador;
                copiaListaPersonagens.get(j).identificador = copiaListaPersonagens.get(k).identificador;
                copiaListaPersonagens.get(k).identificador = temp;
                j++; 
            } 
        }
        Collections.swap(copiaListaPersonagens, j, r);
        int temp = copiaListaPersonagens.get(j).identificador;
        copiaListaPersonagens.get(j).identificador = copiaListaPersonagens.get(r).identificador;
        copiaListaPersonagens.get(r).identificador = temp;
        return j; 
    }
    
    static void quicksortNome(ArrayList<Personagens> copiaListaPersonagens, int pos_personagemPivo, int fim) {
        int pos_novo_personagemPivo;
        if (pos_personagemPivo < fim) {
            pos_novo_personagemPivo = particionaNome(copiaListaPersonagens, pos_personagemPivo, fim);
            quicksortNome(copiaListaPersonagens, pos_personagemPivo, pos_novo_personagemPivo-1); 
            quicksortNome(copiaListaPersonagens, pos_novo_personagemPivo + 1, fim);
        }
    }
    
    static int particionaAltura (ArrayList<Personagens> copiaListaPersonagens, int p, int r) {
        double personagemPivo;
        personagemPivo = copiaListaPersonagens.get(r).altura;
        int j = p;
        int k;
        for (k = p; k < r; k++) {
            if (copiaListaPersonagens.get(k).altura <= personagemPivo) {
                Collections.swap(copiaListaPersonagens, j, k);
                int temp = copiaListaPersonagens.get(j).identificador;
                copiaListaPersonagens.get(j).identificador = copiaListaPersonagens.get(k).identificador;
                copiaListaPersonagens.get(k).identificador = temp;
                j++; 
            } 
        }
        Collections.swap(copiaListaPersonagens, j, r);
        int temp = copiaListaPersonagens.get(j).identificador;
        copiaListaPersonagens.get(j).identificador = copiaListaPersonagens.get(r).identificador;
        copiaListaPersonagens.get(r).identificador = temp;
        return j;
    }
    
    static void quicksortAltura(ArrayList<Personagens> copiaListaPersonagens, int pos_personagemPivo, int fim) {
        int pos_novo_personagemPivo;
        if (pos_personagemPivo < fim) {
            pos_novo_personagemPivo = particionaAltura(copiaListaPersonagens, pos_personagemPivo, fim);
            quicksortAltura(copiaListaPersonagens, pos_personagemPivo, pos_novo_personagemPivo-1); 
            quicksortAltura(copiaListaPersonagens, pos_novo_personagemPivo + 1, fim);
        }
    }

}
