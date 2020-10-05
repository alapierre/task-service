package io.alapierre.task.service.core.dto;

import io.alapierre.task.service.core.model.ProcessStatus;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashMap;

/**
 * Created 04.10.2020 copyright original authors 2020
 *
 * @author Adrian Lapierre {@literal <al@soft-project.pl>}
 */
@Data
public class RunningProcessDTO {

    private String processKey;

    @Size(max = 256)
    private String externalId;

    @NotEmpty
    @Size(max = 128)
    private String owner;

    @NotNull
    private ProcessStatus status;

    private HashMap<String, Object> jsonValues;

    private boolean renewal;

}
