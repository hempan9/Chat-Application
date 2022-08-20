package com.hmp.server.enums;

/**
 * Message status enum
 */
public enum MessageStatusEnum {
    SUBMITTED("Submitted"),
    SENT("Sent"),
    SEEN("Seen"),
    DELIVERED("Delivered"),
    FAILED("Failed");
    private String value;

    MessageStatusEnum(String value) {
        this.value = value;

    }



}
