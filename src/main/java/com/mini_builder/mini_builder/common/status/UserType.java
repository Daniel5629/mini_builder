package com.mini_builder.mini_builder.common.status;

public enum UserType {
    SUPER_ADMIN("SUPER_ADMIN", "최종 관리자"),
    ADMIN("ADMIN", "관리자"),
    MEMBER("MEMBER", "일반회원");

    private final String code;
    private final String name;

    UserType(String code, String name) {
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
