package com.rachacartaserver.enumerations;

public enum UserRole {
    CUSTOMER("CUSTOMER"),
    ADMIN("ADMIN");

    private String role;

    UserRole(String level){
        this.role = level;
    }

    public String getRole(){
        return role;
    }

    public static String retrieveByRole(String level) {
        for (UserRole userLevel : UserRole.values()) {
            if (userLevel.getRole() == level) {
                return userLevel.getRole();
            }
        }

        return null;
    }

}
