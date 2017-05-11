package thing;

import java.util.Calendar;

/**
 *
 * @author Pedro Ivo
 */
public class ProducaoRebanho {
    private String nome_rebanho;
    private Float producao_total;
    private Calendar data_ultimo;

    public ProducaoRebanho() {
    }    
    
    public ProducaoRebanho(String nome_rebanho, Float producao_total, Calendar data_ultimo) {
        this.nome_rebanho = nome_rebanho;
        this.producao_total = producao_total;
        this.data_ultimo = data_ultimo;
    }

    public String getNome_rebanho() {
        return nome_rebanho;
    }

    public void setNome_rebanho(String nome_rebanho) {
        this.nome_rebanho = nome_rebanho;
    }

    public Float getProducao_total() {
        return producao_total;
    }

    public void setProducao_total(Float producao_total) {
        this.producao_total = producao_total;
    }

    public Calendar getData_ultimo() {
        return data_ultimo;
    }

    public void setData_ultimo(Calendar data_ultimo) {
        this.data_ultimo = data_ultimo;
    }
    
    
}
