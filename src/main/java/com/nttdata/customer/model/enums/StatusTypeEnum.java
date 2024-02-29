package com.nttdata.customer.model.enums;

import lombok.Getter;

@Getter
public enum StatusTypeEnum {
    ACTIVE("Active"),
    BUSINESS("Business");

    private String value;

    StatusTypeEnum(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public static StatusTypeEnum fromValue(String value) {
        for (StatusTypeEnum b : StatusTypeEnum.values()) {
            if (b.value.equals(value)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
}
