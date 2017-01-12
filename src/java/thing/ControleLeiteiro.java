package thing;

/**
 *
 * @author Pedro Ivo
 */
public class ControleLeiteiro {
    private String identificadorVaca;
    private float percentual_gordura;
    private float percentual_proteina;
    private float valor_acumulado_leite;
    private int ccs_anterior;
    private int ccs_atual;
    
    public ControleLeiteiro(){
        
    }

    public ControleLeiteiro(String identificadorVaca, float percentual_gordura, float percentual_proteina, float valor_acumulado_leite, int ccs_anterior, int ccs_atual) {
        this.identificadorVaca = identificadorVaca;
        this.percentual_gordura = percentual_gordura;
        this.percentual_proteina = percentual_proteina;
        this.valor_acumulado_leite = valor_acumulado_leite;
        this.ccs_anterior = ccs_anterior;
        this.ccs_atual = ccs_atual;
    }

    public String getIdentificadorVaca() {
        return identificadorVaca;
    }

    public void setIdentificadorVaca(String identificadorVaca) {
        this.identificadorVaca = identificadorVaca;
    }

    public float getPercentual_gordura() {
        return percentual_gordura;
    }

    public void setPercentual_gordura(float percentual_gordura) {
        this.percentual_gordura = percentual_gordura;
    }

    public float getPercentual_proteina() {
        return percentual_proteina;
    }

    public void setPercentual_proteina(float percentual_proteina) {
        this.percentual_proteina = percentual_proteina;
    }

    public float getValor_acumulado_leite() {
        return valor_acumulado_leite;
    }

    public void setValor_acumulado_leite(float valor_acumulado_leite) {
        this.valor_acumulado_leite = valor_acumulado_leite;
    }

    public int getCcs_anterior() {
        return ccs_anterior;
    }

    public void setCcs_anterior(int ccs_anterior) {
        this.ccs_anterior = ccs_anterior;
    }

    public int getCcs_atual() {
        return ccs_atual;
    }

    public void setCcs_atual(int ccs_atual) {
        this.ccs_atual = ccs_atual;
    }
        
    
}
