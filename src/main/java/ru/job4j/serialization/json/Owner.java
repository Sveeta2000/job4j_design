package ru.job4j.serialization.json;

import java.util.Objects;

public final class Owner {
    private final String ownerName;
    private final String phone;
    private final int ownerID;

    public Owner(String ownerName, String phone, int ownerID) {
        this.ownerName = ownerName;
        this.phone = phone;
        this.ownerID = ownerID;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getPhone() {
        return phone;
    }

    public int getOwnerID() {
        return ownerID;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        var that = (Owner) obj;
        return Objects.equals(this.ownerName, that.ownerName)
               && Objects.equals(this.phone, that.phone)
               && this.ownerID == that.ownerID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ownerName, phone, ownerID);
    }

    @Override
    public String toString() {
        return "Owner["
                + "ownerName=" + ownerName + ", "
                + "phone=" + phone + ", "
                + "ownerID=" + ownerID + ']';
    }

}
