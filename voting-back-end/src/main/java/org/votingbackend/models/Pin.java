package org.votingbackend.models;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import org.votingbackend.enums.Category;
import org.votingbackend.enums.PinType;

@Entity
public class Pin {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer pinId;
    @Column(length = 5)
    private String pin;
    @Column
    @Nullable
    private Category pinCategory;
    @Column
    private PinType pinType;
    @Column
    private String ownerName;
    @Column
    private String company;

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

    @Nullable
    public Category getPinCategory() {
        return pinCategory;
    }

    public void setPinCategory(@Nullable Category pinCategory) {
        this.pinCategory = pinCategory;
    }


    public PinType getPinType() {
        return pinType;
    }

    public void setPinType(PinType pinType) {
        this.pinType = pinType;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
