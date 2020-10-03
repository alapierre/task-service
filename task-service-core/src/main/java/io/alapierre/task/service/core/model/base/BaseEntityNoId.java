package io.alapierre.task.service.core.model.base;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.TypeDef;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.time.LocalDateTime;

/**
 * Created 03.10.2020 copyright original authors 2020
 *
 * @author Adrian Lapierre {@literal <al@soft-project.pl>}
 */
@MappedSuperclass
@Getter
@Setter
@TypeDef(
        name = "jsonb",
        typeClass = JsonBinaryType.class
)
public class BaseEntityNoId {

    @Version
    int version;

    @CreatedDate
    @Column(name = "CREATED", updatable = false)
    LocalDateTime created;

    @LastModifiedDate
    @Column(name = "LAST_MODIFIED")
    LocalDateTime lastModified;

    @CreatedBy
    @Column(name = "created_by", updatable = false)

    String createdBy;
    @LastModifiedBy
    @Column(name = "modified_by")
    String lastModifiedBy;

    @Column(name = "behalf_created_by", updatable = false)
    String behalfCreatedBy;

    @Column(name = "behalf_modified_by")
    String behalfLastModifiedBy;

}
