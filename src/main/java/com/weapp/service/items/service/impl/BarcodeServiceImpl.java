package com.weapp.service.items.service.impl;

import com.weapp.service.items.entity.Barcode;
import com.weapp.service.items.repository.BarcodeRepository;
import com.weapp.service.items.service.BarcodeService;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigInteger;
import java.util.Objects;
import java.util.Optional;

public class BarcodeServiceImpl implements BarcodeService {

    @Autowired
    private BarcodeRepository barcodeRepository;

    @Override
    public Barcode findById(String id) {
        if (Objects.nonNull(id) && isParsableAndGreaterThanZero(id)) {
            final Optional<Barcode> barcode = barcodeRepository.findById(id);
            return barcode.orElseGet(Barcode::new);
        }
        return new Barcode();

    }

    private boolean isParsableAndGreaterThanZero(String id) {
        return NumberUtils.isParsable(id) && new BigInteger(id).compareTo(BigInteger.ZERO) > 0;
    }
}
