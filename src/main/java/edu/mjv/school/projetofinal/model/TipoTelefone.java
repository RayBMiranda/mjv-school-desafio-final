package edu.mjv.school.projetofinal.model;

public enum TipoTelefone {
    FIXO("Fixo"), 
    CELULAR("Celular"),
    WHATSAPP("WhatsApp");

    private String descricao;

    private TipoTelefone(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
