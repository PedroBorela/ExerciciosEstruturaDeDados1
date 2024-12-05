public class Cidade{
    private String nome;
    private String pais;
    private String atrativos;
    private int avaliacao;

    public Cidade(String nome, String pais, String atrativos, int avaliacao){
        setNome(nome);
        setPais(pais);
        setAtrativos(atrativos);

        try {
            setAvaliacao(avaliacao);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String toString(){
        return "Nome da cidade: "+this.getNome()+"\n País: "+this.getPais()+"\n Atrativos: "+this.getAtrativos()+"\n Avaliação: "+this.getAvaliacao();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getAtrativos() {
        return atrativos;
    }

    public void setAtrativos(String atrativos) {
        this.atrativos = atrativos;
    }

    public int getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(int avaliacao) throws Exception {
        if(avaliacao<0 || avaliacao >10)
        throw new Exception("nota inválida");
        this.avaliacao = avaliacao;
    }
}