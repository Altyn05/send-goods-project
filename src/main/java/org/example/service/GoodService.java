package org.example.service;

import org.example.model.Good;

import java.util.List;

public interface GoodService {
    List<Good> getGoodsByDispatchId(Long Id);
}
