package com.hmp.server.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: hobject
 * date: 8/20/22
 * description: Abstract Entity Class for all entities
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class AbstractEntity {
    private String updatedBy;
    private String updatedDateTime;
    private String createdDateTime;

}
