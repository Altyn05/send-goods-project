package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.model.Dispatch;
import org.example.model.Good;
import org.example.repository.DispatchRepository;
import org.example.repository.GoodRepository;
import org.example.service.DispatchService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class DispatchServiceImpl implements DispatchService {

    private final DispatchRepository dispatchRepository;

    private final GoodRepository goodRepository;


    @Override
    public List<Dispatch> getAllDispatches() {
        return dispatchRepository.findAll();
    }

    @Override
    public Dispatch getDispatchById(Long id) {
        return dispatchRepository.findById(id).orElse(null);
    }

    @Override
    public Dispatch save(Dispatch dispatch) {
        List<Good> savedGoods = dispatch.getGoods();
        dispatch.setGoods(new ArrayList<>());
        Dispatch dispatch1 = dispatchRepository.save(dispatch);
        dispatch1.setGoods(savedGoods);
        dispatch1.setSumWeight(savedGoods.stream().map(Good::getWeight).reduce(Integer::sum).orElse(0));
        return dispatchRepository.save(dispatch1);
    }

    @Override
    public Dispatch updateDispatch(Long id, Dispatch dispatch) {
        if (!dispatchRepository.existsById(id)) {
            return null;
        }
        dispatch.setId(id);
        return dispatchRepository.save(dispatch);
    }

    ;

    @Override
    public boolean deleteDispatch(Long id) {
        if (!dispatchRepository.existsById(id)) {
            return false;
        }
        dispatchRepository.deleteById(id);
        return true;
    }
}
