package pe.com.pichincha.desafio.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity implements Serializable {

    @Column(name = "estado")
    private Boolean estado;

    @CreatedDate
    @Column(name = "fecha_reg_aud", updatable = false)
    private Timestamp fechaRegAud;

    @LastModifiedDate
    @Column(name = "fecha_mod_aud", insertable = false)
    private Timestamp fechaModAud;

    @CreatedBy
    @Column(name = "usubd_reg_aud", updatable = false)
    private String usubdRegAud;

    @LastModifiedBy
    @Column(name = "usubd_mod_aud", insertable = false)
    private String usubdModAud;

    @PrePersist
    private void prePersistEstado() {
        if (estado == null) {
            estado = true;
        }
    }
}
