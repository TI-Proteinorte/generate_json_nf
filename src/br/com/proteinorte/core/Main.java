package br.com.proteinorte.core;

import br.com.proteinorte.utils.Constants;
import br.com.proteinorte.controller.Invoice;
import br.com.sankhya.extensions.actionbutton.Registro;
import br.com.sankhya.extensions.actionbutton.ContextoAcao;
import br.com.sankhya.extensions.actionbutton.AcaoRotinaJava;

public class Main implements AcaoRotinaJava {

    @Override
    public void doAction(ContextoAcao contexto) throws Exception {

        // Captura a seleção do usuário
        Registro[] registros = contexto.getLinhas();

        // Retorna a primeira linha
        Registro r = registros[0];

        // Retorna o número do fechamento
        Constants.nufechamento = String.valueOf(r.getCampo("NUFECHAMENTO"));

        // Instancia objeto para processamento do JSON
        Invoice invoice = new Invoice();

        // Busca os dados da nota fiscal e grava na lista para montar o JSON
        invoice.Processing();

        // Grava o JSON no campo        
        r.setCampo("ANEXO", invoice.GenerateJSON());

        // Envio de mensagem com link para download pelo usuário
        contexto.setMensagemRetorno(Constants.MenssageHiperlink());
    }
}
