package com.qodev.service;

import com.qodev.common.AesUtil;
import com.qodev.domain.DataEnkripsi;
import com.qodev.dto.GeneralResponse;
import com.qodev.dto.request.*;
import com.qodev.dto.response.*;
import com.qodev.repository.DataEnkripsiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DataEnkripsiService extends AesUtil {
    @Autowired
    DataEnkripsiRepository encryptRepository;

    public GeneralResponse save(EncryptRequest request) throws Exception {
        if (request.getId() == null){
            return create(request);
        }
        return update(request);
    }

    private GeneralResponse create(EncryptRequest request) throws Exception {

        if (request.getId() == null) {
            //insert
            DataEnkripsi encrypt = new DataEnkripsi();
            encrypt.setEncryptData(encrypt(request.getEncrypt()));
            encrypt.setCreatedAt(new Date());
            encrypt.setRealData(request.getEncrypt());
            encrypt.setVersi("v1");
            encrypt.setTypeEncrypt("AES-128");
            encrypt.setCreatedBy("admin");

            DataEnkripsi save = encryptRepository.save(encrypt);

            return new GeneralResponse<>(201,"success Create "+request.getEncrypt(),save);
        }

        return new GeneralResponse<>(204,"failed data not found",null);
    }

    public GeneralResponse read(searchRequest req) throws Exception {
        if (req == null || (req.getId() == null && req.getEncrypt() == null
                && req.getPage() == null && req.getSize() == null)){
            return new GeneralResponse<>(204,"Payload not found",null);
        } else if (req.getId() != null){
            return getById(req);
        } else {
            return decrypt(req);
        }
    }

    private GeneralResponse update(EncryptRequest request) throws Exception {
        //update
        Optional<DataEnkripsi> encryptOptional = encryptRepository.findById(request.getId());
        if (encryptOptional.isPresent()) {
            DataEnkripsi encrypt = encryptOptional.get();

            if (request.getId() == null){
                encrypt.setDataId(encryptOptional.get().getDataId());
            }

            if (request.getEncrypt() == null){
                encrypt.setEncryptData(encryptOptional.get().getEncryptData());
            } else {
                encrypt.setEncryptData(encrypt(request.getEncrypt()));
                encrypt.setRealData(request.getEncrypt());
                encrypt.setVersi(encryptOptional.get().getVersi());
                encrypt.setTypeEncrypt(encryptOptional.get().getTypeEncrypt());
                encrypt.setCreatedAt(encryptOptional.get().getCreatedAt());
                encrypt.setCreatedBy(encryptOptional.get().getCreatedBy());
            }

            encrypt.setUpdatedAt(new Date());
            encrypt.setUpdatedBy("admin");

            DataEnkripsi save = encryptRepository.save(encrypt);

            return new GeneralResponse<>(200,"success Update id "+request.getId()+" data "+request.getEncrypt(),save);
        }

        return new GeneralResponse<>(204,"failed data not found",null);
    }

    private GeneralResponse getById(searchRequest req){

        Optional<DataEnkripsi> encrypt = encryptRepository.findById(req.getId());
        if (encrypt.isPresent()){

            EncryptResponse data = new EncryptResponse();
            data.setDataId(encrypt.get().getDataId());
            data.setEncrypt(encrypt.get().getEncryptData());
            data.setRealData(encrypt.get().getRealData());
            data.setTypeEncrypt(encrypt.get().getTypeEncrypt());
            data.setCreatedAt(encrypt.get().getCreatedAt());
            data.setCreatedBy(encrypt.get().getCreatedBy());
            data.setUpdatedAt(encrypt.get().getUpdatedAt());
            data.setUpdatedBy(encrypt.get().getCreatedBy());

            return new GeneralResponse<>(200,"Get by id successfully",data);
        }

        return new GeneralResponse<>(204,"Id "+req.getId()+" not found",null);
    }

    private GeneralResponse decrypt(searchRequest req) throws Exception {

        DecryptResponse data = new DecryptResponse();
        data.setRealData(req.getEncrypt());
        data.setDecrypt(decrypt(req.getEncrypt()));

        return new GeneralResponse<>(200,"Decrypt AES-128 Successfully",data);
    }
}
