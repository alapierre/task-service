package io.alapierre.task.service.core.model;

import io.alapierre.task.service.core.model.base.BaseEntityNoId;
import io.alapierre.task.service.core.model.pk.StepKey;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.Size;


/**
 * Created 21.09.2020 copyright original authors 2020
 *
 * @author Adrian Lapierre {@literal <al@soft-project.pl>}
 */
@Entity
@Getter
@Setter
@AssociationOverrides({
    @AssociationOverride(name = "key.procesDefinition", joinColumns = @JoinColumn(name = "process_definition_key"))}
    )
public class ProcessStepsDefinition extends BaseEntityNoId {

    @EmbeddedId
    private StepKey key;

    @Size(max = 256)
    private String stepName;

    private int lp;

    @Type(type = "jsonb")
    private String formSchema;

    public String getStepKeyString() {
        return key != null ? key.getStepKey() : null;
    }

}
