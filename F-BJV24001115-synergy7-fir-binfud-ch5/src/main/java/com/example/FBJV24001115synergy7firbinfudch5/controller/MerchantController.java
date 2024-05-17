package com.example.FBJV24001115synergy7firbinfudch5.controller;

import com.example.FBJV24001115synergy7firbinfudch5.model.entity.Merchant;
import com.example.FBJV24001115synergy7firbinfudch5.service.MerchantService;
import com.example.FBJV24001115synergy7firbinfudch5.view.MerchantView;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/merchants")
public class MerchantController {

    @Autowired
    private MerchantService merchantService;

    @PostMapping
    public ResponseEntity<Merchant> addMerchant(@RequestBody Merchant merchant) {
        return ResponseEntity.ok(merchantService.addMerchant(merchant));
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Merchant> updateMerchantStatus(@PathVariable UUID id, @RequestBody Map<String, Boolean> status) {
        return ResponseEntity.ok(merchantService.updateMerchantStatus(id, status.get("open")));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Merchant> getMerchantById(@PathVariable UUID id) {
        return ResponseEntity.ok(merchantService.getMerchantById(id));
    }

    @GetMapping
    public ResponseEntity<List<Merchant>> getOpenMerchants() {
        return ResponseEntity.ok(merchantService.getOpenMerchants());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMerchant(@PathVariable UUID id) {
        merchantService.deleteMerchant(id);
        return ResponseEntity.noContent().build();
    }
}

