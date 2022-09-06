package br.com.proteinorte.model;

import java.util.List;

import com.fasterxml.jackson.annotation.*;

@JsonPropertyOrder({"nNF", "Emitente", "NomeFantasia", "CNPJDest", "RuaDest", "numDest", "BairroDest", "MunicipioDest", "UfDest", "CepDest", "FoneDest", "Produtos"})
public class InvoiceHeader {

    private int nNF; // Número da nota
    private String emitente; // Razão social da empresa
    private String nomeFantasia; // Nome fantasia da empresa
    private String cnpjDest; // CNPJ do cliente
    private String ruaDest; // Rua do cliente
    private String numDest; // Número da localização do cliente
    private String bairroDest; // Bairro do cliente
    private String municipioDest; // Cidade do cliente
    private String ufDest; // Estado do cliente
    private long cepDest; // CEP do cliente
    private long foneDest; // Telefone do cliente
    private List<InvoiceProduct> produtos; // Lista dos produtos    

    @JsonProperty("nNF")
    public int getNNF() {
        return nNF;
    }

    @JsonProperty("nNF")
    public void setNNF(int value) {
        this.nNF = value;
    }

    @JsonProperty("Emitente")
    public String getEmitente() {
        return emitente;
    }

    @JsonProperty("Emitente")
    public void setEmitente(String value) {
        this.emitente = value;
    }

    @JsonProperty("NomeFantasia")
    public String getNomeFantasia() {
        return nomeFantasia;
    }

    @JsonProperty("NomeFantasia")
    public void setNomeFantasia(String value) {
        this.nomeFantasia = value;
    }

    @JsonProperty("CNPJDest")
    public String getCnpjDest() {
        return cnpjDest;
    }

    @JsonProperty("CNPJDest")
    public void setCnpjDest(String value) {
        this.cnpjDest = value;
    }

    @JsonProperty("RuaDest")
    public String getRuaDest() {
        return ruaDest;
    }

    @JsonProperty("RuaDest")
    public void setRuaDest(String value) {
        this.ruaDest = value;
    }

    @JsonProperty("numDest")
    public String getNumDest() {
        return numDest;
    }

    @JsonProperty("numDest")
    public void setNumDest(String value) {
        this.numDest = value;
    }

    @JsonProperty("BairroDest")
    public String getBairroDest() {
        return bairroDest;
    }

    @JsonProperty("BairroDest")
    public void setBairroDest(String value) {
        this.bairroDest = value;
    }

    @JsonProperty("MunicipioDest")
    public String getMunicipioDest() {
        return municipioDest;
    }

    @JsonProperty("MunicipioDest")
    public void setMunicipioDest(String value) {
        this.municipioDest = value;
    }

    @JsonProperty("UfDest")
    public String getUfDest() {
        return ufDest;
    }

    @JsonProperty("UfDest")
    public void setUfDest(String value) {
        this.ufDest = value;
    }

    @JsonProperty("CepDest")
    public long getCepDest() {
        return cepDest;
    }

    @JsonProperty("CepDest")
    public void setCepDest(long value) {
        this.cepDest = value;
    }

    @JsonProperty("FoneDest")
    public long getFoneDest() {
        return foneDest;
    }

    @JsonProperty("FoneDest")
    public void setFoneDest(long value) {
        this.foneDest = value;
    }

    @JsonProperty("Produtos")
    public List<InvoiceProduct> getProdutos() {
        return produtos;
    }

    @JsonProperty("Produtos")
    public void setProdutos(List<InvoiceProduct> value) {
        this.produtos = value;
    }
}
