package com.project.userdevices.Service;

import com.project.userdevices.Model.Device;
import com.project.userdevices.Model.Users;
import com.project.userdevices.Repository.DeviceRepository;
import com.project.userdevices.Repository.UserDevicesRepo;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDevicesService {

    @Autowired
    private UserDevicesRepo userDevicesRepo;
    @Autowired
    private DeviceRepository deviceRepository;


    public Users createUser(Users user){
        userDevicesRepo.save(user);
        return user;
    }

    public Device createDevice(Device device){
        deviceRepository.save(device);
        return device;
    }

    public Optional findUserById(String id){
        return userDevicesRepo.findById(id);
    }

    public Optional<Device> findDevicesById(String deviceId) {
        return  deviceRepository.findById(deviceId);
    }

    public Optional<Users> findById(String id){
       Optional<Users> devices = userDevicesRepo.findById(id);
       return devices;

    }

    public void updateDevice(String id , Device device){
        Optional<Device> devices = deviceRepository.findById(id);

        Device _device = devices.get();
        //_device.setUserID(device.getUserID());
        _device.setOs(device.getOs());
        _device.setModel(device.getModel());
        _device.setName(device.getName());

        deviceRepository.save(_device);
    }

    public Users updateUser(String id , Users user){
        Optional<Users> users = userDevicesRepo.findById(id);

        Users _users = users.get();
        //_device.setUserID(device.getUserID());
        _users.setDevices(user.getDevices());

        return  userDevicesRepo.save(_users);
    }
}

