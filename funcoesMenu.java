import java.util.ArrayList;

import javax.swing.JOptionPane;

public class funcoesMenu {
    
    static void imprimirLista (ArrayList<Personagens> listaPersonagens) {
        ArrayList<Personagens> copiaListaPersonagens = new ArrayList<Personagens>(listaPersonagens.size());
        for (Personagens personagem : listaPersonagens) {
            Personagens personagemCopia = new Personagens(personagem);
            copiaListaPersonagens.add(personagemCopia);
        }

        int select = 0;

        System.out.println("[1] - Imprimir um trecho da lista \n[2] - Imprimir lista em ordem alfabetica \n[3] - Imprimir lista em ordem de altura \n[4] - Imprimir lista original \n");

        select = Integer.parseInt(JOptionPane.showInputDialog("Digite a opção: "));

        switch (select) {
            case 1: 
                int posMin, posMax;
                posMin = Integer.parseInt(JOptionPane.showInputDialog("Digite a posição inicial: "));
                posMax = Integer.parseInt(JOptionPane.showInputDialog("Digite a posição final: "));

                for (int i = posMin-1; i < posMax; i++){
                    System.out.println("PERSONAGEM "+listaPersonagens.get(i).identificador+": ");
                    System.out.println("Nome: "+listaPersonagens.get(i).nome);
                    System.out.println("Criador: "+listaPersonagens.get(i).criador);
                    System.out.println("Título do Desenho: "+listaPersonagens.get(i).tituloDesenho);
                    System.out.println("Altura: "+listaPersonagens.get(i).altura);
                    System.out.println("Descrição: "+listaPersonagens.get(i).bio);
                    System.out.println("\n\n");
                }

                break;

            case 2:
                ordenacao.quicksortNome(copiaListaPersonagens, 0, (copiaListaPersonagens.size()-1));

                for (Personagens personagem : copiaListaPersonagens) {
                    System.out.println("PERSONAGEM "+personagem.identificador+": ");
                    System.out.println("Nome: "+personagem.nome);
                    System.out.println("Criador: "+personagem.criador);
                    System.out.println("Título do Desenho: "+personagem.tituloDesenho);
                    System.out.println("Altura: "+personagem.altura);
                    System.out.println("Descrição: "+personagem.bio);
                    System.out.println("\n\n");
                }

                break;

            case 3:
                ordenacao.quicksortAltura(copiaListaPersonagens, 0, (copiaListaPersonagens.size()-1));
                
                for (Personagens personagem : copiaListaPersonagens) {
                    System.out.println("PERSONAGEM "+personagem.identificador+": ");
                    System.out.println("Nome: "+personagem.nome);
                    System.out.println("Criador: "+personagem.criador);
                    System.out.println("Título do Desenho: "+personagem.tituloDesenho);
                    System.out.println("Altura: "+personagem.altura);
                    System.out.println("Descrição: "+personagem.bio);
                    System.out.println("\n\n");
                }
                
                break;
            
            case 4:
                for (Personagens personagem : listaPersonagens) {
                    System.out.println("PERSONAGEM "+personagem.identificador+": ");
                    System.out.println("Nome: "+personagem.nome);
                    System.out.println("Criador: "+personagem.criador);
                    System.out.println("Título do Desenho: "+personagem.tituloDesenho);
                    System.out.println("Altura: "+personagem.altura);
                    System.out.println("Descrição: "+personagem.bio);
                    System.out.println("\n\n");
                }
                
                break;
            
            default:
                System.out.println("Opção inválida, voltando ao menu...");
                break;
            }
        
    }

    static void persquisarNome (ArrayList<Personagens> listaPersonagens) {
        ArrayList<Personagens> copiaListaPersonagens = new ArrayList<Personagens>(listaPersonagens.size());
        for (Personagens personagem : listaPersonagens) {
            Personagens personagemCopia = new Personagens(personagem);
            copiaListaPersonagens.add(personagemCopia);
        }
        ordenacao.quicksortNome(copiaListaPersonagens, 0, copiaListaPersonagens.size()-1);
        
        String nomeBusca;
        nomeBusca = JOptionPane.showInputDialog("\n\n\nDigite o nome do personagem que deseja encontrar: ");

        ArrayList<Personagens> encontrados = new ArrayList<Personagens>();
        int cont = 0;
        
        for (Personagens personagem : copiaListaPersonagens) {
            if ((personagem.nome.toLowerCase()).indexOf(nomeBusca.toLowerCase()) != -1) {
                encontrados.add(personagem);
                cont++;
            }
            
        }

        if (cont > 0 ) {
            System.out.println("Lista de personagens encontrados com o nome "+nomeBusca+":\n\n");
            for (Personagens personagem : encontrados) {
                System.out.println("PERSONAGEM "+personagem.identificador+": ");
                System.out.println("Nome: "+personagem.nome);
                System.out.println("Criador"+personagem.criador);
                System.out.println("Título do Desenho: "+personagem.tituloDesenho);
                System.out.println("Altura: "+personagem.altura);
                System.out.println("Descrição: "+personagem.bio);
                System.out.println("\n\n");
            }
        }
        else {
            System.out.println("Nenhum personagem foi encontrado com o nome "+nomeBusca+".\n\n");
        }

    }

    static void pesquisarAltura (ArrayList<Personagens> listaPersonagens) {
        ArrayList<Personagens> copiaListaPersonagens = new ArrayList<Personagens>(listaPersonagens.size());
        for (Personagens personagem : listaPersonagens) {
            Personagens personagemCopia = new Personagens(personagem);
            copiaListaPersonagens.add(personagemCopia);
        }
        ordenacao.quicksortAltura(copiaListaPersonagens, 0, (copiaListaPersonagens.size()-1));

        
        double alturaMin, alturaMax;
        alturaMin = Double.parseDouble(JOptionPane.showInputDialog("Digite a altura mínima: "));
        alturaMax = Double.parseDouble(JOptionPane.showInputDialog("Digite a altura máxima: "));

        ArrayList<Personagens> encontrados = new ArrayList<Personagens>();
        int cont = 0;
        
        for (Personagens personagem : copiaListaPersonagens) {
            if (personagem.altura >= alturaMin && personagem.altura <= alturaMax) {
                encontrados.add(personagem);
                cont++;
            }
        }

        if (cont > 0 ) {
            System.out.println("Lista de personagens encontrados com a altura entre "+alturaMin+" e "+alturaMax+" metros:\n\n");
            for (Personagens personagem : encontrados) {
                System.out.println("PERSONAGEM "+personagem.identificador+": ");
                System.out.println("Nome: "+personagem.nome);
                System.out.println("Criador"+personagem.criador);
                System.out.println("Título do Desenho: "+personagem.tituloDesenho);
                System.out.println("Altura: "+personagem.altura);
                System.out.println("Descrição: "+personagem.bio);
                System.out.println("\n\n");
            }
        }
        else {
            System.out.println("Nenhum personagem foi encontrado com a altura entre "+alturaMin+" e "+alturaMax+" metros.\n\n");
        }


    }

    static void adicionarPersonagem (ArrayList<Personagens> listaPersonagens, String cabecalho) {
        String nomeAdd, criadorAdd, tituloAdd, bioAdd;
        double alturaAdd;
        Personagens personagemAdd;

        nomeAdd = JOptionPane.showInputDialog("Informe o nome do personagem que deseja adicionar: ");
        criadorAdd = JOptionPane.showInputDialog("Informe o criador do personagem: ");
        tituloAdd = JOptionPane.showInputDialog("Informe o título do desenho do personagem: ");
        alturaAdd = Double.parseDouble(JOptionPane.showInputDialog("Informe a altura do personagem: "));
        bioAdd = JOptionPane.showInputDialog("Informe a descricao do personagem: ");

        personagemAdd = new Personagens(listaPersonagens.size()+1, nomeAdd, criadorAdd, tituloAdd, alturaAdd, bioAdd);
        
        listaPersonagens.add(personagemAdd);

        int arq;
        arq = Integer.parseInt(JOptionPane.showInputDialog("Onde deseja salvar as alterações? \n\n [1] - Arquivo .CSV (sera criado um arquivo binario com o mesmo nome)\n [2] - Arquivo Binário\n"));

        String nomeArq;
        nomeArq = JOptionPane.showInputDialog("Qual o nome do arquivo? (sem a extensao, ex: .csv)\nATENCAO: Caso o nome do arquivo ja existir, o mesmo sera substituido!");

        if (arq == 1) {
            arquivo.salvarCSV_BIN(listaPersonagens, cabecalho, nomeArq);
        }
        else {
            arquivo.salvarBIN(listaPersonagens, cabecalho, nomeArq);
        }

        System.out.println("\nPersonagem adicionado com sucesso!\n");

    }

    static void editarPersonagem (ArrayList<Personagens> listaPersonagens, String cabecalho) {
        int identificadorBuscado;
        int select = 0;

        identificadorBuscado = Integer.parseInt(JOptionPane.showInputDialog("Digite o identificador do personagem a ser editado: "));

        System.out.println("PERSONAGEM "+listaPersonagens.get(identificadorBuscado-1).identificador+": ");
        System.out.println("Nome: "+listaPersonagens.get(identificadorBuscado-1).nome);
        System.out.println("Criador"+listaPersonagens.get(identificadorBuscado-1).criador);
        System.out.println("Título do Desenho: "+listaPersonagens.get(identificadorBuscado-1).tituloDesenho);
        System.out.println("Altura: "+listaPersonagens.get(identificadorBuscado-1).altura);
        System.out.println("Descrição: "+listaPersonagens.get(identificadorBuscado-1).bio);
        System.out.println("\n\n");

        
        int numeroDigitado;
        numeroDigitado = Integer.parseInt(JOptionPane.showInputDialog("Você deseja alterar os dados desse personagem? \n\n[1] - Sim \n[2] - Não\n"));

        if (numeroDigitado==1){

            do{
                String novoNome;
                String novoCriador;
                String novoTitulo;
                double novaAltura;
                String novaDescricao;
    
                switch (select) {
                case 0:
                    System.out.println("[1] - Editar nome do personagem\n[2] - Editar o nome do criador\n[3] - Editar o Titulo\n[4] - Editar Altura\n[5] - Editar Descricao\n\n[-1] - Para sair da edicao\n");
                    break;
    
                case 1:
                    novoNome = JOptionPane.showInputDialog("Digite o novo nome do personagem: ");
                    listaPersonagens.get(identificadorBuscado-1).nome = novoNome;
                    System.out.println("\nNome do personagem alterado com sucesso!\n");
                    
                    break;
    
                case 2:
                    novoCriador = JOptionPane.showInputDialog("Digite o novo criador do personagem: ");
                    listaPersonagens.get(identificadorBuscado-1).criador = novoCriador;
                    System.out.println("\nCriador do personagem alterado com sucesso!\n");

                    break;
    
                case 3:
                    novoTitulo = JOptionPane.showInputDialog("Digite o novo titulo do desenho: ");
                    listaPersonagens.get(identificadorBuscado-1).tituloDesenho = novoTitulo;
                    System.out.println("\nTítulo do desenho do personagem alterado com sucesso!\n");
                    
                    break;
                
                case 4:
                    novaAltura = Double.parseDouble(JOptionPane.showInputDialog("Digite a nova altura do personagem: "));
                    listaPersonagens.get(identificadorBuscado-1).altura = novaAltura;
                    System.out.println("\nAltura do personagem alterada com sucesso!\n");
                    
                    break;
    
                case 5:
                    novaDescricao = JOptionPane.showInputDialog("Digite a nova descriacao personagem: ");
                    listaPersonagens.get(identificadorBuscado-1).bio = novaDescricao;
                    System.out.println("\nDescrição do personagem alterada com sucesso!\n");
                    
                    break;
                
                default:
                    break;
                }
                if (select != -1 && select != 0) {
                    System.out.println("\n[0] - Para voltar ao menu de edicao\n[-1] - Para encerrar a edicao");
                    select = Integer.parseInt(JOptionPane.showInputDialog("Digite a opção: "));
                }
                else {
                    select = Integer.parseInt(JOptionPane.showInputDialog("Digite a opção: "));
                }

            }while(select!= -1);

            int arq;
            arq = Integer.parseInt(JOptionPane.showInputDialog("Onde deseja salvar as alterações? \n\n [1] - Arquivo .CSV (sera criado um arquivo binario com o mesmo nome)\n [2] - Arquivo Binário\n"));

            String nomeArq;
            nomeArq = JOptionPane.showInputDialog("Qual o nome do arquivo? (sem a extensao, ex: .csv)\nATENCAO: Caso o nome do arquivo ja existir, o mesmo sera substituido!");

            if (arq == 1) {
                arquivo.salvarCSV_BIN(listaPersonagens, cabecalho, nomeArq);
            }
            else {
                arquivo.salvarBIN(listaPersonagens, cabecalho, nomeArq);
            }

            System.out.println("Edição concluída com sucesso!\n");
        }

        System.out.println("\n");
    }

    static void retirarPersonagem (ArrayList<Personagens> listaPersonagens, String cabecalho) {
        int identificadorBuscado, numeroDigitado;

        identificadorBuscado = Integer.parseInt(JOptionPane.showInputDialog("Digite o identificador do personagem que deseja retirar: "));

        System.out.println("PERSONAGEM "+listaPersonagens.get(identificadorBuscado-1).identificador+": ");
        System.out.println("Nome: "+listaPersonagens.get(identificadorBuscado-1).nome);
        System.out.println("Criador"+listaPersonagens.get(identificadorBuscado-1).criador);
        System.out.println("Título do Desenho: "+listaPersonagens.get(identificadorBuscado-1).tituloDesenho);
        System.out.println("Altura: "+listaPersonagens.get(identificadorBuscado-1).altura);
        System.out.println("Descrição: "+listaPersonagens.get(identificadorBuscado-1).bio);
        System.out.println("\n\n");

        numeroDigitado = Integer.parseInt(JOptionPane.showInputDialog("Você deseja remover os dados desse personagem? \n\n[1] - Sim \n[2] - Não\n"));

        if (numeroDigitado == 1){
            for (int i = identificadorBuscado; i < listaPersonagens.size(); i++){
                listaPersonagens.get(i-1).nome = listaPersonagens.get(i).nome;
                listaPersonagens.get(i-1).tituloDesenho = listaPersonagens.get(i).tituloDesenho;
                listaPersonagens.get(i-1).altura = listaPersonagens.get(i).altura;
                listaPersonagens.get(i-1).criador = listaPersonagens.get(i).criador;
                listaPersonagens.get(i-1).bio = listaPersonagens.get(i).bio;
            }
            listaPersonagens.remove(listaPersonagens.size()-1);
            
            int arq;
            arq = Integer.parseInt(JOptionPane.showInputDialog("Onde deseja salvar as alterações? \n\n [1] - Arquivo .CSV (sera criado um arquivo binario com o mesmo nome)\n [2] - Arquivo Binário\n"));

            String nomeArq;
            nomeArq = JOptionPane.showInputDialog("Qual o nome do arquivo? (sem a extensao, ex: .csv)\nATENCAO: Caso o nome do arquivo ja existir, o mesmo sera substituido!");

            
            if (arq == 1) {
                arquivo.salvarCSV_BIN(listaPersonagens, cabecalho, nomeArq);

            }
            else {
                arquivo.salvarBIN(listaPersonagens, cabecalho, nomeArq);

            }

            System.out.println("\n\nPersonagem removido com sucesso!\n\n");
        }
    }

    static void exportarArquivo (ArrayList<Personagens> listaPersonagens, String cabecalho) {
        int arq;
        arq = Integer.parseInt(JOptionPane.showInputDialog("Informe a opção de arquivo que deseja salvar: \n\n [1] - Arquivo .CSV \n [2] - Arquivo Binário\n"));

        String nomeArq;
        nomeArq = JOptionPane.showInputDialog("Qual o nome do arquivo? (sem a extensao, ex: .csv)\nATENCAO: Caso o nome do arquivo ja existir, o mesmo sera substituido!");

        int arqTipo;
        arqTipo = Integer.parseInt(JOptionPane.showInputDialog("[1] - Salvar o arquivo nao ordenado\n[2] - Salvar o arquivo em ordem alfabetica\n[3] - Salvar o arquivo em ordem de altura\n"));

        if (arq == 1) {
            if (arqTipo == 1) {
                arquivo.salvarCSV_BIN(listaPersonagens, cabecalho, nomeArq);
            
            }
            else if (arqTipo == 2) {
                ArrayList<Personagens> copiaListaPersonagens = new ArrayList<Personagens>(listaPersonagens.size());
                for (Personagens personagem : listaPersonagens) {
                    Personagens personagemCopia = new Personagens(personagem);
                    copiaListaPersonagens.add(personagemCopia);
                }

                ordenacao.quicksortNome(copiaListaPersonagens, 0, copiaListaPersonagens.size()-1);
                
                arquivo.salvarCSV_BIN(copiaListaPersonagens, cabecalho, nomeArq);
            }

            else if (arqTipo == 3) {
                ArrayList<Personagens> copiaListaPersonagens = new ArrayList<Personagens>(listaPersonagens.size());
                for (Personagens personagem : listaPersonagens) {
                    Personagens personagemCopia = new Personagens(personagem);
                    copiaListaPersonagens.add(personagemCopia);
                }

                ordenacao.quicksortAltura(copiaListaPersonagens, 0, copiaListaPersonagens.size()-1);
                
                arquivo.salvarCSV_BIN(copiaListaPersonagens, cabecalho, nomeArq);
            }
        }
        else {
            if (arqTipo == 1) {
                arquivo.salvarBIN(listaPersonagens, cabecalho, nomeArq);
            }
            else if (arqTipo == 2) {
                ArrayList<Personagens> copiaListaPersonagens = new ArrayList<Personagens>(listaPersonagens.size());
                for (Personagens personagem : listaPersonagens) {
                    Personagens personagemCopia = new Personagens(personagem);
                    copiaListaPersonagens.add(personagemCopia);
                }

                ordenacao.quicksortNome(copiaListaPersonagens, 0, copiaListaPersonagens.size()-1);
                
                arquivo.salvarBIN(copiaListaPersonagens, cabecalho, nomeArq);
            }
            else if (arqTipo == 3) {
                ArrayList<Personagens> copiaListaPersonagens = new ArrayList<Personagens>(listaPersonagens.size());
                for (Personagens personagem : listaPersonagens) {
                    Personagens personagemCopia = new Personagens(personagem);
                    copiaListaPersonagens.add(personagemCopia);
                }

                ordenacao.quicksortAltura(copiaListaPersonagens, 0, copiaListaPersonagens.size()-1);
                
                arquivo.salvarBIN(copiaListaPersonagens, cabecalho, nomeArq);
            }

        }

        System.out.println("Arquivo exportado com sucesso!\n");

    }

}
