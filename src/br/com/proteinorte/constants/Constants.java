package br.com.proteinorte.constants;

public final class Constants {

    public static String getHeader;
    public static String getProduct;
    public static String getJSON;
    public static String getHiperlink;

    public static String nufechamento;

    public static String MenssageHiperlink() {

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("<a id=\"alink\" href=\"")
                .append("/mge/download.mge?fileName=sab://ANEXO&downloadFileName=")
                .append(nufechamento)
                .append("_PROTEINORTE_NCL.json")
                .append("&pkValues={NUFECHAMENTO:")
                .append(nufechamento)
                .append("}&tableName=AD_FECCAR")
                .append("\" target=\"_teste\">Clique aqui para baixar o arquivo JSON da carga ")
                .append(nufechamento);

        getHiperlink = stringBuilder.toString();

        return stringBuilder.toString();
    }

    // Script para selecionar o cabeçalho da nota fiscal
    public static String ScripSelectHeader() throws Exception {

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("SELECT CAB.NUMNOTA,").append(" ")
                .append("EMP.RAZAOSOCIAL,").append(" ")
                .append("EMP.NOMEFANTASIA,").append(" ")
                .append("PAR.CGC_CPF,").append(" ")
                .append("END.TIPO || ' ' || END.NOMEEND AS NOMEEND,").append(" ")
                .append("PAR.NUMEND,").append(" ")
                .append("BAI.NOMEBAI,").append(" ")
                .append("CID.NOMECID,").append(" ")
                .append("UFS.UF,").append(" ")
                .append("PAR.CEP,").append(" ")
                .append("UPPER(REGEXP_REPLACE(TRIM(PAR.TELEFONE), '[^0-9A-Za-z]', '')) AS TELEFONE").append(" ")
                .append("FROM AD_FECCAR CAR").append(" ")
                .append("INNER JOIN AD_FECCOM COM ON COM.NUFECHAMENTO = CAR.NUFECHAMENTO").append(" ")
                .append("INNER JOIN TGFCAB CAB ON CAB.ORDEMCARGA = COM.NUMDOCUMENTO").append(" ")
                .append("AND CAB.CODEMP = COM.CODEMP").append(" ")
                .append("INNER JOIN TSIEMP EMP ON EMP.CODEMP = CAB.CODEMP").append(" ")
                .append("INNER JOIN TGFPAR PAR ON PAR.CODPARC = CAB.CODPARC").append(" ")
                .append("LEFT JOIN TSIEND END ON END.CODEND = PAR.CODEND").append(" ")
                .append("LEFT JOIN TSIBAI BAI ON BAI.CODBAI = PAR.CODBAI").append(" ")
                .append("LEFT JOIN TSICID CID ON CID.CODCID = PAR.CODCID").append(" ")
                .append("LEFT JOIN TSIUFS UFS ON UFS.CODUF = CID.UF").append(" ")
                .append("WHERE CAR.NUFECHAMENTO = ")
                .append(nufechamento).append(" ")
                .append("AND CAB.TIPMOV = 'V'");

        getHeader = stringBuilder.toString();

        return stringBuilder.toString();
    }

    // Script para selecionar os itens da nota fiscal
    public static String ScripSelectItem(long notaFiscal) throws Exception {

        StringBuilder stringBuilder = new StringBuilder();

        // Montagem da query para retorna o cabeçalho da NOTA Fiscal
        stringBuilder.append("SELECT ITE.CODPROD,").append(" ")
                .append("PRO.NCM,").append(" ")
                .append("PRO.DESCRPROD,").append(" ")
                .append("PRO.CODVOL,").append(" ")
                .append("PRO.PESOBRUTO * ITE.QTDNEG AS PESOBRU,").append(" ")
                .append("ITE.QTDNEG / AGRUPMIN AS VOLUME,").append(" ")
                .append("PRO.PESOLIQ * ITE.QTDNEG AS PESOLIQ").append(" ")
                .append("FROM AD_FECCAR CAR").append(" ")
                .append("INNER JOIN AD_FECCOM COM ON COM.NUFECHAMENTO = CAR.NUFECHAMENTO").append(" ")
                .append("INNER JOIN TGFCAB CAB ON CAB.ORDEMCARGA = COM.NUMDOCUMENTO").append(" ")
                .append("AND CAB.CODEMP = COM.CODEMP").append(" ")
                .append("INNER JOIN TGFITE ITE ON ITE.NUNOTA = CAB.NUNOTA").append(" ")
                .append("INNER JOIN TGFPRO PRO ON PRO.CODPROD = ITE.CODPROD").append(" ")
                .append("INNER JOIN TSIEMP EMP ON EMP.CODEMP = CAB.CODEMP").append(" ")
                .append("INNER JOIN TGFPAR PAR ON PAR.CODPARC = CAB.CODPARC").append(" ")
                .append("LEFT JOIN TSIEND END ON END.CODEND = PAR.CODEND").append(" ")
                .append("LEFT JOIN TSIBAI BAI ON BAI.CODBAI = PAR.CODBAI").append(" ")
                .append("LEFT JOIN TSICID CID ON CID.CODCID = PAR.CODCID").append(" ")
                .append("LEFT JOIN TSIUFS UFS ON UFS.CODUF = CID.UF").append(" ")
                .append("WHERE CAR.NUFECHAMENTO = ")
                .append(nufechamento).append(" ")
                .append("AND CAB.NUMNOTA = ")
                .append(notaFiscal).append(" ")
                .append("AND CAB.TIPMOV = 'V'");

        getProduct = stringBuilder.toString();

        return stringBuilder.toString();
    }
}
