package Modelo;

/**
 *
 * @author Giovanna
 */
public class Aluguel {
    private int cod;
    private int coddvd;
    private int codcliente;
    private String data_aluguel;
    private String horario;
    private String data_devolucao;

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public int getCoddvd() {
        return coddvd;
    }

    public void setCoddvd(int coddvd) {
        this.coddvd = coddvd;
    }

    public int getCodcliente() {
        return codcliente;
    }

    public void setCodcliente(int codcliente) {
        this.codcliente = codcliente;
    }

    public String getData_aluguel() {
        return data_aluguel;
    }

    public void setData_aluguel(String data_aluguel) {
        this.data_aluguel = data_aluguel;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getData_devolucao() {
        return data_devolucao;
    }

    public void setData_devolucao(String data_devolucao) {
        this.data_devolucao = data_devolucao;
    }
    
    
}
