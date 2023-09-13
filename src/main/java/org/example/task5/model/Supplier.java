package org.example.task5.model;

import javax.persistence.*;

@Entity
@Table(name = "suppliers")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long supplierId;
    @Column(name = "name")
    private String supplierName;
    private String city;
    private String country;

    public Supplier() {
    }

    public Supplier(String supplierName, String city, String country) {
        this.supplierName = supplierName;
        this.city = city;
        this.country = country;
    }

    public Supplier(Long supplierId, String supplierName, String city, String country) {
        this.supplierId = supplierId;
        this.supplierName = supplierName;
        this.city = city;
        this.country = country;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Supplier{"
                + "supplierId=" + supplierId
                + ", supplierName='" + supplierName + '\''
                + ", city='" + city + '\''
                + ", country='" + country + '\''
                + '}';
    }
}
