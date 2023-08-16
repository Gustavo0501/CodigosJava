public class Personagens {
    int identificador;
    String nome;
    String criador;
    String tituloDesenho;
    double altura;
    String bio;
    
    
    Personagens (int identificador, String nome, String criador, String tituloDesenho, double altura, String bio) {
        this.identificador = identificador;
        this.nome = nome;
        this.criador = criador;
        this.tituloDesenho = tituloDesenho;
        this.altura = altura;
        this.bio = bio;
    }

    Personagens (Personagens personagemOriginal) {
        this.copy(personagemOriginal);
    }

    public int getIdentificador() {
        return identificador;
    }

    public String getNome() {
        return nome;
    }

    public String getCriador() {
        return criador;
    }

    public String getTituloDesenho() {
        return tituloDesenho;
    }

    public double getAltura() {
        return altura;
    }

    public String getBio() {
        return bio;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCriador(String criador) {
        this.criador = criador;
    }

    public void setTituloDesenho(String tituloDesenho) {
        this.tituloDesenho = tituloDesenho;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void copy (Personagens personagemOriginal){
        this.setIdentificador(personagemOriginal.getIdentificador());
        this.setNome(personagemOriginal.getNome());
        this.setCriador(personagemOriginal.getCriador());
        this.setTituloDesenho(personagemOriginal.getTituloDesenho());
        this.setAltura(personagemOriginal.getAltura());
        this.setBio(personagemOriginal.getBio());
    }


}
