package io.alapierre.task.service.core.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.HashMap;

/**
 * Created 03.10.2020 copyright original authors 2020
 *
 * @author Adrian Lapierre {@literal <al@soft-project.pl>}
 */
@Data
public class ProcessDefinitionDTO {

    private String key;

    @Size(max = 256)
    @NotEmpty
    private String name;

    private boolean renewal;

    private HashMap<String, Object> formSchema;

}
