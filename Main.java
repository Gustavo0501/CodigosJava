import java.util.ArrayList;

import javax.swing.JOptionPane;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {       
        ArrayList<Personagens> listaPersonagens = new ArrayList<Personagens>();

        String cabecalho = "";

        int arquivo;
        arquivo = Integer.parseInt(JOptionPane.showInputDialog("Informe a opção de arquivo que deseja ler: \n\n [1] - Arquivo .CSV \n [2] - Arquivo Binário\n"));


        String nomeArq;
        nomeArq = JOptionPane.showInputDialog("Informe o nome do arquivo (sem a extensão, ex: .csv)");

        File arqPersonagens;
        
        if (arquivo == 1) {
            arqPersonagens = new File(nomeArq + ".csv");
        }
        else {
            arqPersonagens = new File(nomeArq + ".bin");
        }
        
        if (arqPersonagens.exists()) {
            if(arquivo == 1) {

                BufferedReader br = null;
                String linha = "";
                String divisor = ";";
                
                try {
                    br = new BufferedReader(new FileReader(nomeArq + ".csv"));
                    
                    linha = br.readLine();
                    cabecalho = linha;
                    
                    while ((linha = br.readLine()) != null) {
                        String[] personagemLido = linha.split(divisor); 
                        Personagens personagem = new Personagens(Integer.parseInt(personagemLido[0]), personagemLido[1], personagemLido[2], personagemLido[3],Double.parseDouble(personagemLido[4]), personagemLido[5]);
                        listaPersonagens.add(personagem);
                    }


                    
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (br != null) {
                        try {
                            br.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
            else {
                System.out.println("Opção de arquivo binário em construção!!!");
            }

            int select = 0;

            do {
                switch (select) {
                    case 0:
                        System.out.println("\n\n\nMENU PRINCIPAL: \n\n[1] - Mostrar lista completa\n[2] - Pesquisar por nome\n[3] - Pesquisar por altura\n[4] - Adicionar personagem\n[5] - Editar personagem \n[6] - Retirar personagem\n[7] - Exportar arquivo\n\n[-1] - Para encerrar o programa\n");
                        break;

                    case 1:
                        funcoesMenu.imprimirLista(listaPersonagens);
                        break;

                    case 2:
                        funcoesMenu.persquisarNome(listaPersonagens);
                        break;

                    case 3:
                        funcoesMenu.pesquisarAltura(listaPersonagens);
                        break;

                    case 4:
                        funcoesMenu.adicionarPersonagem(listaPersonagens, cabecalho);
                        break;

                    case 5:
                        funcoesMenu.editarPersonagem(listaPersonagens, cabecalho);
                        break;

                    case 6:
                        funcoesMenu.retirarPersonagem(listaPersonagens, cabecalho);
                        break;

                    case 7:
                        funcoesMenu.exportarArquivo(listaPersonagens, cabecalho);
                        break;

                    default:
                        System.out.println("Programa encerrado!");
                        break;
                }

                if (select != -1 && select != 0) {
                    System.out.println("\n[0] - Para voltar ao menu principal\n[-1] - Para encerrar o programa");
                    select = Integer.parseInt(JOptionPane.showInputDialog("Digite a opção: "));
                    
                }
                else {
                    select = Integer.parseInt(JOptionPane.showInputDialog("Digite a opção: "));
                }


            } while (select != -1);
            
            


        }
        else {
            System.out.println("Não foi possível abrir o arquivo!");
        }

        System.out.println("Programa Encerrado!");

    }   

}