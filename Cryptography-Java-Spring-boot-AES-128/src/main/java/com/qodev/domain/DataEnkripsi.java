package com.qodev.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "mst_encrypt", schema = "public")
public class DataEnkripsi {
    @Id
    @SequenceGenerator(name = "mst_encrypt_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mst_employee_seq")
    @Column(name = "data_id")
    private Integer dataId;

    @Column(name = "encrypt")
    private String encryptData;

    @Column(name = "real_data")
    private String realData;

    @Column(name = "type_encrypt")
    private String typeEncrypt;

    @Column(name = "version")
    private String versi;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "updated_at")
    private Date updatedAt;

    @Column(name = "updated_by")
    private String updatedBy;

    public Integer getDataId() {
        return dataId;
    }

    public void setDataId(Integer dataId) {
        this.dataId = dataId;
    }

    public String getEncryptData() {
        return encryptData;
    }

    public void setEncryptData(String encryptData) {
        this.encryptData = encryptData;
    }

    public String getRealData() {
        return realData;
    }

    public void setRealData(String realData) {
        this.realData = realData;
    }

    public String getTypeEncrypt() {
        return typeEncrypt;
    }

    public void setTypeEncrypt(String typeEncrypt) {
        this.typeEncrypt = typeEncrypt;
    }

    public String getVersi() {
        return versi;
    }

    public void setVersi(String versi) {
        this.versi = versi;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
}
