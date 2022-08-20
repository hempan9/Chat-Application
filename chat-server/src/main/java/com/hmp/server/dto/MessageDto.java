package com.hmp.server.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Builder(builderMethodName = "MessageEntityBuilder")
@AllArgsConstructor
@NoArgsConstructor
public class MessageDto {
    private Long messageId;
    private String message;
    private String size;
    private String type;
    private Long createdByUserId;
    private LocalDateTime createdDateTime;
}
