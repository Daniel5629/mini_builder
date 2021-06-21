package com.mini_builder.mini_builder.common.enumerate;

public enum MemberType {

    STAFF("STAFF", "스태프"),
    CLIENT("CLIENT", "의뢰자"),
    BUILDER("BUILDER", "시공사");

    private final String code;
    private final String name;

    MemberType(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

}
