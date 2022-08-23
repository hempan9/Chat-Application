package com.hmp.server.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * @author: hobject
 * date: 8/20/22
 * description: Abstract Entity Class for all entities
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@MappedSuperclass
public abstract class AbstractEntity implements Serializable {
    @ManyToOne
    @JoinColumn(name = "created_by", referencedColumnName = "userName")
    private UserEntity updatedBy;
    private String updatedDateTime;
    private String createdDateTime;

}
