package com.qodev.dto.response;

import java.util.Date;

public class EncryptResponse {
    private Integer dataId;
    private String encrypt;
    private String realData;
    private String typeEncrypt;
    private Date createdAt;
    private String createdBy;
    private Date updatedAt;
    private String updatedBy;

    public Integer getDataId() {
        return this.dataId;
    }

    public void setDataId(Integer dataId) {
        this.dataId = dataId;
    }

    public String getEncrypt() {
        return this.encrypt;
    }

    public void setEncrypt(String encrypt) {
        this.encrypt = encrypt;
    }

    public String getRealData() {
        return this.realData;
    }

    public void setRealData(String realData) {
        this.realData = realData;
    }

    public String getTypeEncrypt() {
        return this.typeEncrypt;
    }

    public void setTypeEncrypt(String typeEncrypt) {
        this.typeEncrypt = typeEncrypt;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUpdatedBy() {
        return this.updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
}
