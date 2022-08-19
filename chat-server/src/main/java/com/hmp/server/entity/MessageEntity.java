package com.hmp.server.entity;

import com.hmp.server.entity.generator.MessageIdGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "pro_message")
@Builder(builderMethodName = "MessageEntityBuilder")
@AllArgsConstructor
@NoArgsConstructor
public class MessageEntity {
    @Id
    @GenericGenerator(name = "sequence_message_id", strategy = "com.hmp.server.entity.generator.MessageIdGenerator")
    @GeneratedValue(generator = "sequence_message_id")
    private String messageId;
    private String message;
    private String size;
    private String type;
    @ManyToOne
    @JoinColumn(name = "created_by_user_id", referencedColumnName = "userId")
    private UserEntity createdBy;
    @DateTimeFormat
    private Date createdDateTime;
}
