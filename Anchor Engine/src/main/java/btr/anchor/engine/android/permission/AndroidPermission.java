package btr.anchor.engine.android.permission;

public enum AndroidPermission {

    INTERNET("android.permission.INTERNET");

    AndroidPermission(String permission) {
        this.permission = permission;
    }

    String permission;

}