package br.com.proteinorte.helper;

import br.com.sankhya.jape.EntityFacade;
import br.com.sankhya.jape.dao.JdbcWrapper;
import br.com.sankhya.jape.sql.NativeSql;
import br.com.sankhya.modelcore.util.EntityFacadeFactory;
import java.sql.ResultSet;

public class HelperSankhyaDB {

    // Metodo para SELECT
    public static ResultSet consultaSQLReturnResultSet(final String query) throws Exception {
        JdbcWrapper jdbc = null;
        final EntityFacade dwfEntityFacade = EntityFacadeFactory.getDWFFacade();
        jdbc = dwfEntityFacade.getJdbcWrapper();
        jdbc.openSession();
        NativeSql sql = null;
        try {
            sql = new NativeSql(jdbc);
            sql.appendSql(query);
            final ResultSet result = sql.executeQuery();
            return result;
        } catch (Exception throwable) {
            NativeSql.releaseResources(sql);
            throw throwable;
        }
    }

    // Metodo para UPDATE, INSERT e DROP
    public static void execQuery(final String query) throws Exception {
        JdbcWrapper jdbc = null;
        final EntityFacade dwfEntityFacade = EntityFacadeFactory.getDWFFacade();
        jdbc = dwfEntityFacade.getJdbcWrapper();
        jdbc.openSession();
        NativeSql sql = null;
        try {
            sql = new NativeSql(jdbc);
            sql.appendSql(query);
            sql.executeUpdate();
        } catch (Exception throwable) {
            NativeSql.releaseResources(sql);
            throw throwable;
        }
        NativeSql.releaseResources(sql);
    }

}
