package com.device.test.apps.service;

import com.device.test.apps.dto.AppsRequest;
import com.device.test.apps.model.Apps;
import com.device.test.apps.repository.AppsRepository;
import com.device.test.notification.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AppsService {
    @Autowired
    private AppsRepository appsRepository;

    //saving all apps
    public Apps saveApps(AppsRequest appsRequest){
        Apps apps=new Apps();
        apps.setName(appsRequest.getName());
        apps.setPrivate_key(appsRequest.getPrivate_key());
        return appsRepository.save(apps);
    }

    //getting all apps
    public List<Apps> getAllApps(){
        List<Apps> apps= new ArrayList<>();
        Streamable.of(appsRepository.findAll())
                .forEach(apps::add);
        return apps;
    }

    //deleting all apps
    public void deleteAll(){appsRepository.deleteAll();}

    //finding app by ID
    public Optional <Apps> getApps(String id) {
        return appsRepository.findById(Integer.valueOf(id));
    }

    //updating apps
    public Apps updateApps(Apps apps) {
        return appsRepository.save(apps);
    }
    //deleting apps by id
    public void deleteApps(Integer id){
        appsRepository.deleteById(id);
    }

    public Optional<Apps> getById(Integer id) {
        return this.appsRepository.findById(id);
    }

    public void addService(Apps updateApps) {
    }

    public Apps updateService(Integer id,Apps updateApps) {
        appsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("App does not exist with id: " + id));
        updateApps.setId(id);
        updateApps.setName(updateApps.getName());
        updateApps.setPrivate_key(updateApps.getPrivate_key());
        return this.appsRepository.save(updateApps);
    }
}
