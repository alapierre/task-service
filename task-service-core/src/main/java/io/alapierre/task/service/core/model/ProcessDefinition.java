package io.alapierre.task.service.core.model;

import io.alapierre.task.service.core.model.base.BaseEntityNoId;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * Created 21.09.2020 copyright original authors 2020
 *
 * @author Adrian Lapierre {@literal <al@soft-project.pl>}
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class ProcessDefinition extends BaseEntityNoId {

    @Id
    @Size(max = 256)
    private String key;

    @Size(max = 128)
    @NotEmpty
    private String processType;

    @Size(max = 256)
    @NotEmpty
    private String name;

    private boolean renewal;

    @Lob
    private String formSchema;

    public ProcessDefinition(String processKey) {
        this.key = processKey;
    }
}
