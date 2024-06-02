package com.example.FBJV24001115synergy7firbinfudch6.service;

import com.example.FBJV24001115synergy7firbinfudch6.model.entity.Merchant;

import java.util.List;
import java.util.UUID;

public interface MerchantService {
    Merchant addMerchant(Merchant merchant);

    Merchant updateMerchantStatus(UUID merchantId, boolean isOpen);

    Merchant getMerchantById(UUID id);

    List<Merchant> getOpenMerchants();

    void deleteMerchant(UUID id);
}