package br.com.proteinorte.helper;

import java.util.List;
import java.io.IOException;
import com.fasterxml.jackson.databind.*;
import br.com.proteinorte.model.InvoiceHeader;
import com.fasterxml.jackson.core.JsonProcessingException;

public class HelperJSONStructure {

    private static ObjectReader reader;
    private static ObjectWriter writer;

    public static List<InvoiceHeader> fromJsonString(String json) throws IOException {
        return getObjectReader().readValue(json);
    }

    public static String toJsonString(List<InvoiceHeader> obj) throws JsonProcessingException {
        return getObjectWriter().writeValueAsString(obj);
    }

    private static void instantiateMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();

        reader = mapper.readerFor(List.class);
        writer = mapper.writerFor(List.class);
    }

    private static ObjectReader getObjectReader() {
        if (reader == null) {
            instantiateMapper();
        }
        return reader;
    }

    private static ObjectWriter getObjectWriter() {
        if (writer == null) {
            instantiateMapper();
        }
        return writer;
    }
}
