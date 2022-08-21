package com.hmp.server.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: hobject
 * date: 8/20/22
 * description: Dto class for mapping abstract entity
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AbstractDto {
    private String updatedBy;
    private String updatedDateTime;
    private String createdDateTime;
}
