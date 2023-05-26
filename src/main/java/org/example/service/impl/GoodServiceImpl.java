package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.model.Good;
import org.example.repository.GoodRepository;
import org.example.service.GoodService;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
public class GoodServiceImpl implements GoodService {

    private final GoodRepository goodRepository;

    @Override
    public List<Good> getGoodsByDispatchId(Long Id) {
        return goodRepository.getGoodsByDispatchId(Id);
    }
}
