package org.votingbackend.models;

import jakarta.persistence.*;
import org.votingbackend.enums.Type;

@Entity
public class Pin {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer pinId;
    @Column(length = 5)
    private String pin;
    @Column
    private Type pinType;
    @Column
    private String ownerName;

    public Pin() {
    }

    public long getPinId() {
        return pinId;
    }

    public void setPinId(int pinId) {
        this.pinId = pinId;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public Type getPinType() {
        return pinType;
    }

    public void setPinType(Type pinType) {
        this.pinType = pinType;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
}
