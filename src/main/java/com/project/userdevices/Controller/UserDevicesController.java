package com.project.userdevices.Controller;

import com.project.userdevices.Model.Device;
import com.project.userdevices.Model.Users;
import com.project.userdevices.Service.UserDevicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
public class UserDevicesController {

    @Autowired
    private UserDevicesService userDevicesService;

    @PostMapping("/insertUser")
    public ResponseEntity<Users> createUser(@RequestBody Users users){

        Users user = userDevicesService.createUser(users);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PostMapping("/{id}/insertDevice")
    public ResponseEntity<Device> createDevice(@PathVariable String id,@RequestBody Device device){

        device.setUserID(id);
        Device device_ =    userDevicesService.createDevice(device);
//        Optional<Users> optional = userDevicesService.findUserById(id);
//        Users users = optional.get();
//
//
//        String ids= device_.getDeviceId();
//        Set<String> deviceIds = new HashSet<>();
//        deviceIds.add(ids);
//
//        Set<Device> deviceSet = deviceIds.stream()
//                .map(deviceId -> userDevicesService.findDevicesById(deviceId))
//                .filter(Optional::isPresent)
//                .map(Optional::get)
//                .collect(Collectors.toSet());
//
//
//
//        users.setDevices(deviceSet);
//        device_.setUserID(id);
//        Users userUpdated =  userDevicesService.createUser(users);
        return new ResponseEntity<>(device_, HttpStatus.CREATED);
    }

    @GetMapping("/getDevices/{id}")
    public Optional<Users> getDevices(@PathVariable("id") String id ){

        Optional<Users> devices = userDevicesService.findById(id);
        return  devices;
    }

    @PutMapping("/updateDevice/{id}")
    public String updateDevice(@PathVariable("id") String id ,  @RequestBody Device device){

            userDevicesService.updateDevice(id,device);
            return "Successfully updated";

    }

    @PostMapping("/user/{id}/devices")
    public ResponseEntity<Users> addDevices(@PathVariable String id, @RequestBody List<String> deviceIds) {

        Optional<Users> optional = userDevicesService.findUserById(id);

        if (optional.get().equals(null)) {
            return new ResponseEntity<>(null, HttpStatus.OK);
        }

        Users users = optional.get();

        Set<Device> deviceSet = deviceIds.stream()
                .map(deviceId -> userDevicesService.findDevicesById(deviceId))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toSet());

        users.setDevices(deviceSet);

        Users userUpdated =  userDevicesService.createUser(users);

        return new ResponseEntity<>(userUpdated, HttpStatus.OK);
    }
}
