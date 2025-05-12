package com.williams.spring_auth_initializer.auth.entities.util;

import java.util.Arrays;
import java.util.List;

public enum Role {

    CUSTOMER(Arrays.asList(
            Permission.READ,
            Permission.UPDATE)),
    ADMINISTRATOR(Arrays.asList(
            Permission.SAVE,
            Permission.READ,
            Permission.UPDATE)),
    OWNER(Arrays.asList(
            Permission.SAVE,
            Permission.READ,
            Permission.UPDATE,
            Permission.DELETE,
            Permission.UPDATE_ROLE));

    private List<Permission> permissions;

    Role(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }
}
