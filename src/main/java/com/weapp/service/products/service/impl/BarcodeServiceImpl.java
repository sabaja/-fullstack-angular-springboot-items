package com.weapp.service.products.service.impl;

import com.weapp.service.products.entity.Barcode;
import com.weapp.service.products.repository.BarcodeRepository;
import com.weapp.service.products.service.BarcodeService;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
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
