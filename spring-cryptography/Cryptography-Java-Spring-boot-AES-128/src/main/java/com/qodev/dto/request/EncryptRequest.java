package com.qodev.dto.request;

public class EncryptRequest {
    private Integer id;
    private String encrypt;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer dataId) {
        this.id = dataId;
    }

    public String getEncrypt() {
        return this.encrypt;
    }

    public void setEncrypt(String encrypt) {
        this.encrypt = encrypt;
    }
}
