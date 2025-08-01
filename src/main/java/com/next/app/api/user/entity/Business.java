package com.next.app.api.user.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "business_go")
@Data
public class Business {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String businessNumber;
    @Column
    private String companyName;
    @Column
    private String representativeName;
    @Column
    private String contactEmail;
    @Column
    private String contactPhone;
    @Column
    private String address;
    @Column(name = "registeredAt")
    private java.time.LocalDateTime createdAt;
    // Constructors

    public Business() {}
    public Business(String businessNumber, String companyName, String representativeName,String contactEmail,
                    String contactPhone,String address) {
        this.businessNumber = businessNumber;
        this.companyName = companyName;
        this.representativeName = representativeName;
        this.contactEmail =contactEmail;
        this.contactPhone=contactPhone;
        this.address=address;
    }
    // Getters and Setters
    public Long getId() {
        return id;
    }
    public String getbusinessNumber() {
        return businessNumber;
    }
    public void setbusinessNumber(String businessNumber) {
        this.businessNumber = businessNumber;
    }
    public String getcompanyName() {
        return companyName;
    }
    public void setcompanyName(String companyName) {
        this.companyName = companyName;
    }
    public String getrepresentativeName() {
        return representativeName;
    }
    public void setrepresentativeName(String representativeName) {
        this.representativeName = representativeName;
    }

    public String getcontactEmail() {
        return contactEmail;
    }
    public void setcontactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }
    public String getcontactPhone() {
        return contactPhone;
    }
    public void setcontactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }
    public String getaddress() {
        return address;
    }
    public void setaddress(String address) {
        this.address = address;
    }

    @PrePersist
    protected void onCreate() {
        createdAt = java.time.LocalDateTime.now();
    }
}

