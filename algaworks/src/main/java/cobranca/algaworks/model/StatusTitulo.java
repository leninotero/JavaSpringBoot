package cobranca.algaworks.model;

public enum StatusTitulo {
    PENDENTE("Pendente"),
    RECEBIDO("Recebido");

    private String descriçao;

    StatusTitulo(String descricao){
        this.descriçao = descricao;
    }

    public String getDescriçao(){
        return descriçao;
    }
}
