package com.hmp.server.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

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
    @Column(name = "message_id")
    private Long messageId;
    @Column(name = "message")
    private String message;
    @Column(name = "message_size")
    private String size;
    @Column(name = "message_type")
    private String type;

}
