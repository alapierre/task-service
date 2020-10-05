package io.alapierre.task.service.core.converter;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.modelmapper.AbstractConverter;

import java.util.HashMap;

/**
 * Created 03.10.2020 copyright original authors 2020
 *
 * @author Adrian Lapierre {@literal <al@soft-project.pl>}
 */
public class JsonConverter extends AbstractConverter<String, HashMap<String,Object>> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @SneakyThrows
    @Override
    protected HashMap<String, Object> convert(String source) {
        TypeReference<HashMap<String,Object>> typeRef = new TypeReference<>() {};
        return objectMapper.readValue(source, typeRef);
    }
}
