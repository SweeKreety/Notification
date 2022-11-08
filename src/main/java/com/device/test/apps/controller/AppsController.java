package com.device.test.apps.controller;

import com.device.test.apps.dto.AppsRequest;
import com.device.test.apps.model.Apps;
import com.device.test.apps.repository.AppsRepository;
import com.device.test.apps.service.AppsService;
import com.device.test.notification.dto.NotificationRequest;
import com.device.test.notification.exception.ResourceNotFoundException;
import com.device.test.notification.model.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AppsController {
    @Autowired
    private AppsService appsService;

    @GetMapping("/apps")
    public List<Apps> getAllApps(){
        return appsService.getAllApps();
    }

    @PostMapping("/apps")
    public Apps saveApps(@RequestBody AppsRequest apps) {
        return appsService.saveApps(apps);
    }
    @RequestMapping(value= "/app/{id}", method = RequestMethod.GET)
    public Optional<Apps> apps(@PathVariable String id){
        return appsService.getApps(id);
    }
    @DeleteMapping("/apps")
    public void deleteApps(){
        appsService.deleteAll();
    }


    @PutMapping("app/{id}")
    public ResponseEntity<Apps> updateNotification(@PathVariable Integer id, @RequestBody Apps apps) {
        Apps updateApps = this.appsService.updateService(id,apps);
        return ResponseEntity.ok(updateApps);
    }
    @RequestMapping(value= "/app/{id}", method = RequestMethod.DELETE)
            @ResponseBody
    public String deleteApp(@PathVariable Integer id) {
        appsService.deleteApps(id);
        return "app has been deleted successfully";

    }

}
