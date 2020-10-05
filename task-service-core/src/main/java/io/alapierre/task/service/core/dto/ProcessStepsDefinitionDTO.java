package io.alapierre.task.service.core.dto;

import io.alapierre.task.service.core.model.pk.StepKey;
import lombok.Data;

import javax.persistence.Lob;
import javax.validation.constraints.Size;

/**
 * Created 03.10.2020 copyright original authors 2020
 *
 * @author Adrian Lapierre {@literal <al@soft-project.pl>}
 */
@Data
public class ProcessStepsDefinitionDTO {

    private StepKey key;

    @Size(max = 256)
    private String stepName;

    private int lp;

    @Lob
    private String formSchema;

}
