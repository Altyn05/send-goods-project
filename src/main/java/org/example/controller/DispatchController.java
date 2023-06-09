package org.example.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.model.Dispatch;
import org.example.model.Good;
import org.example.service.DispatchService;
import org.example.service.GoodService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/dispatches")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DispatchController {

    DispatchService dispatchService;
    GoodService goodService;

    @GetMapping("/all")
    public List<Dispatch> getAll(){

        return dispatchService.getAllDispatches();
    }
    @GetMapping("/{dispatch_id}")
    public Dispatch getDispatchById(@PathVariable("dispatch_id") Long dispatchId){
       return dispatchService.getDispatchById(dispatchId);
    }
    @GetMapping("/goods/{dispatch_id}")
    public List<Good> getGoodsByDispatchId(@PathVariable("dispatch_id") Long dispatchId){
        return goodService.getGoodsByDispatchId(dispatchId);
    }
    @PostMapping()
    public Dispatch createDispatch(@RequestBody Dispatch dispatch){

        return dispatchService.save(dispatch);
    }
    @PutMapping("/{dispatch_id}")
    public ResponseEntity<Dispatch> updateDispatch(@PathVariable("dispatch_id") Long id, @RequestBody Dispatch dispatch) {
        Dispatch updatedDispatch = dispatchService.updateDispatch(id, dispatch);
        if (updatedDispatch == null) {
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedDispatch);
    }
    @DeleteMapping("/{dispatch_id}")
    public ResponseEntity<?> deleteDispatch(@PathVariable("dispatch_id") Long id) {
        boolean wasDispatchDeleted = dispatchService.deleteDispatch(id);
        if(!wasDispatchDeleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
