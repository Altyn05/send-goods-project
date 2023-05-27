package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.model.Dispatch;
import org.example.model.Good;
import org.example.repository.DispatchRepository;
import org.example.service.DispatchService;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class DispatchServiceImpl implements DispatchService {

    private final DispatchRepository dispatchRepository;


    @Override
    public List<Dispatch> getAllDispatches() {
        return dispatchRepository.findAll();
    }

    @Override
    public Dispatch getDispatchById(Long id) {
        return dispatchRepository.getById(id);
    }

    @Override
    public Dispatch save(Dispatch dispatch) { return dispatchRepository.save(dispatch); }

    @Override
    public Dispatch updateDispatch(Long id, Dispatch dispatch) {
        if (!dispatchRepository.existsById(id)){
            return null;
        }
        dispatch.setId(id);
        return dispatchRepository.save(dispatch); };

    @Override
    public boolean deleteDispatch(Long id) {
        if (!dispatchRepository.existsById(id)) {
            return false;
        }
        dispatchRepository.deleteById(id);
        return true;
    }
}
