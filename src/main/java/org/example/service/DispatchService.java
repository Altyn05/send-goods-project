package org.example.service;


import org.example.model.Dispatch;
import org.example.model.Good;

import java.util.List;

public interface DispatchService {
    List<Dispatch> getAllDispatches();
    Dispatch getDispatchById(Long id);
    Dispatch save(Dispatch dispatch);
    Dispatch updateDispatch(Long id, Dispatch dispatch);
    boolean deleteDispatch(Long id);
}
