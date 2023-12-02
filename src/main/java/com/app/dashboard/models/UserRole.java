package com.app.dashboard.models;

public enum UserRole {
    VIEW,
    MANAGER,
    ADMIN;

    public static boolean isValidRole(String role) {
        for (UserRole userRole : UserRole.values()) {
            if (userRole.name().toLowerCase().equals(role.toLowerCase())) {
                return true;
            }
        }
        return false;
    }
}
