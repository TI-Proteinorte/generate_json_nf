package br.com.proteinorte.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"codigo", "EAN", "Nome", "Unidade", "PesoLiquido", "Volume", "PesoBruto"})
public class InvoiceProduct {

    private long codigo; // Código do produto - Sankhya
    private String ean; // EAN do produto
    private String nome; // Descrição do produto
    private String unidade; // Unidade de medida do produto
    private double pesoLiquido; // Peso líquido do produto    
    private double volume; // Volume do produto
    private double pesoBruto; // Peso bruto do produto
    private double valorUnitario; // Valor Unitário

    @JsonProperty("codigo")
    public long getCodigo() {
        return codigo;
    }

    @JsonProperty("codigo")
    public void setCodigo(long value) {
        this.codigo = value;
    }

    @JsonProperty("EAN")
    public String getEan() {
        return ean;
    }

    @JsonProperty("EAN")
    public void setEan(String value) {
        this.ean = value;
    }

    @JsonProperty("Nome")
    public String getNome() {
        return nome;
    }

    @JsonProperty("Nome")
    public void setNome(String value) {
        this.nome = value;
    }

    @JsonProperty("Unidade")
    public String getUnidade() {
        return unidade;
    }

    @JsonProperty("Unidade")
    public void setUnidade(String value) {
        this.unidade = value;
    }

    @JsonProperty("PesoLiquido")
    public double getPesoLiquido() {
        return pesoLiquido;
    }

    @JsonProperty("PesoLiquido")
    public void setPesoLiquido(double value) {
        this.pesoLiquido = value;
    }

    @JsonProperty("Volume")
    public double getVolume() {
        return volume;
    }

    @JsonProperty("Volume")
    public void setVolume(double value) {
        this.volume = value;
    }

    @JsonProperty("PesoBruto")
    public double getPesoBruto() {
        return pesoBruto;
    }

    @JsonProperty("PesoBruto")
    public void setPesoBruto(double value) {
        this.pesoBruto = value;
    }

    @JsonProperty("Valor_unitario")
    public double getValorUnitario() {
        return valorUnitario;
    }

    @JsonProperty("Valor_unitario")
    public void setValorUnitario(double value) {
        this.valorUnitario = value;
    }
}
