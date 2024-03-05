package com.nttdata.customer.model.enums;

import lombok.Getter;

@Getter
public enum DocumentTypeEnum {
    DNI("DNI"),
    RUC("RUC");

    private String value;

    DocumentTypeEnum(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public static DocumentTypeEnum fromValue(String value) {
        for (DocumentTypeEnum b : DocumentTypeEnum.values()) {
            if (b.value.equals(value)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
}
