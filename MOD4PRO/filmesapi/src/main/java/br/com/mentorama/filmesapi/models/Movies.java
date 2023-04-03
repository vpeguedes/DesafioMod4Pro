package br.com.mentorama.filmesapi.models;

public class Movies {
    private Integer id;
    private String nomeFilme;
    private String nomeDiretor;
    private Integer anoFilme;
    private Integer notaFilme;

    public Movies(final Integer id, final String nomeFilme, final String nomeDiretor, final Integer anoFilme, final Integer notaFilme) {
        this.id = id;
        this.nomeFilme = nomeFilme;
        this.nomeDiretor = nomeDiretor;
        this.anoFilme = anoFilme;
        this.notaFilme = notaFilme;
    }

    public Integer getId() {
        return id;
    }

    public String getNomeDiretor() {
        return nomeDiretor;
    }

    public Integer getAnoFilme() {
        return anoFilme;
    }

    public Integer getNotaFilme() {
        return notaFilme;
    }

    public String getNomeFilme() {
        return nomeFilme;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNomeFilme(String nomeFilme) {
        this.nomeFilme = nomeFilme;
    }

    public void setNomeDiretor(String nomeDiretor) {
        this.nomeDiretor = nomeDiretor;
    }

    public void setAnoFilme(Integer anoFilme) {
        this.anoFilme = anoFilme;
    }

    public void setNotaFilme(Integer notaFilme) {
        this.notaFilme = notaFilme;
    }
}
