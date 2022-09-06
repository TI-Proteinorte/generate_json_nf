package br.com.proteinorte.controller;

import br.com.proteinorte.utils.helper.HelperSankhyaDB;
import java.util.List;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.nio.charset.StandardCharsets;
import br.com.proteinorte.constants.Constants;
import br.com.proteinorte.model.InvoiceHeader;
import br.com.proteinorte.model.InvoiceProduct;
import br.com.proteinorte.utils.helper.HelperJSONStructure;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.text.Normalizer;

public class Invoice {

    private List<InvoiceHeader> listInvoiceHeader;
    private List<InvoiceProduct> listInvoiceProduct;

    // Monta o JSON cabeçalho da nota
    public void Processing() throws Exception {

        // Executa o SELECT no banco de dados
        try (
                 ResultSet resultHeader = HelperSankhyaDB.consultaSQLReturnResultSet(Constants.ScripSelectHeader())) {

            // Cria a lista para gerenciar o JSON para várias notas
            listInvoiceHeader = new ArrayList<>();

            while (resultHeader.next()) {

                // Cria objeto para armazenar o cabeçalho da nota fiscal
                InvoiceHeader invoice = new InvoiceHeader();

                invoice.setEmitente(resultHeader.getString("RAZAOSOCIAL"));
                invoice.setNNF(resultHeader.getInt("NUMNOTA"));
                invoice.setNomeFantasia(resultHeader.getString("NOMEFANTASIA"));
                invoice.setCnpjDest(resultHeader.getString("CGC_CPF"));
                invoice.setRuaDest(resultHeader.getString("NOMEEND"));
                invoice.setNumDest(resultHeader.getString("NUMEND"));
                invoice.setBairroDest(resultHeader.getString("NOMEBAI"));
                invoice.setMunicipioDest(resultHeader.getString("NOMECID"));
                invoice.setUfDest(resultHeader.getString("UF"));
                invoice.setCepDest(resultHeader.getInt("CEP"));
                invoice.setFoneDest(resultHeader.getInt("TELEFONE"));

                // Processamento dos itens da nota fiscal
                invoice.setProdutos(ProcessingProduct(invoice.getNNF()));

                // Adiciona os produtos na lista do cabeçalho da nota fiscal
                listInvoiceHeader.add(invoice);
            }
        } catch (Exception e) {
        }
    }

    private List<InvoiceProduct> ProcessingProduct(int notafiscal) throws Exception {

        // Executa o SELECT no banco de dados
        try (
                 ResultSet resulProduct = HelperSankhyaDB.consultaSQLReturnResultSet(Constants.ScripSelectItem(notafiscal))) {

            // Cria a lista de produto
            listInvoiceProduct = new ArrayList<>();

            while (resulProduct.next()) {

                // Cria objeto para armazenar o item da nota fiscal
                InvoiceProduct product = new InvoiceProduct();

                product.setCodigo(resulProduct.getInt("CODPROD"));
                product.setEan(resulProduct.getString("NCM"));
                product.setNome(resulProduct.getString("DESCRPROD"));
                product.setUnidade(resulProduct.getString("CODVOL"));
                product.setPesoBruto(resulProduct.getDouble("PESOBRU"));
                product.setVolume(resulProduct.getDouble("VOLUME"));
                product.setPesoLiquido(resulProduct.getDouble("PESOLIQ"));

                // Adicionar na lista os produtos
                listInvoiceProduct.add(product);
            }
        } catch (Exception e) {
        }

        return listInvoiceProduct;
    }

    public String GenerateJSON() throws Exception {

        StringBuilder stringBuilder = new StringBuilder();
        String semCaracterEspecial = Normalizer.normalize(HelperJSONStructure.toJsonString(listInvoiceHeader), Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");

        stringBuilder.append("__start_fileinformation__{\"name\":\"")
                .append(Constants.nufechamento)
                .append("_PROTEINORTE_NCL.json\",\"")
                .append("size\":")
                .append(semCaracterEspecial.getBytes(StandardCharsets.UTF_8).length)
                .append(",")
                .append("\"type\":\"application/json\",")
                .append("\"lastModifiedDate\":\"Aug 31, 2022 17:14:26\"}")
                .append("__end_fileinformation__")
                .append(semCaracterEspecial);

        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        try {
            return HelperJSONStructure.toJsonString(listInvoiceHeader);
        } catch (JsonProcessingException e) {
            return "Error: " + e.toString();
        }
    }

}
