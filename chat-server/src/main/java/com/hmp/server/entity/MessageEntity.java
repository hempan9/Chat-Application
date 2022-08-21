package com.hmp.server.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "pro_message")
@AllArgsConstructor
@NoArgsConstructor
public class MessageEntity extends AbstractEntity {
    @Id
    @GeneratedValue(generator = "message-sequence-generator")
    @GenericGenerator(
            name = "message-sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "message_sequence"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "9122222"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            })
    private Long messageId;
    private String message;
    private String size;
    private String type;
//    @ManyToOne
//    @JoinColumn(name = "created_by_user_id", referencedColumnName = "userId")
//    private UserEntity createdBy;
//    @DateTimeFormat
//    private LocalDateTime createdDateTime;
}
