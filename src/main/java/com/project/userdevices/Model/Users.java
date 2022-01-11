package com.project.userdevices.Model;

import com.project.userdevices.Controller.CascadeSave;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;
import java.util.Set;


@Document("Users")
public class Users {

    @Id
    private String userid;
    private String email;
    private String phone;
    private List<Profile> profile;
    @DBRef(lazy = true)
    private Set<Device> devices;

    public Users(String email, String phone, List<Profile> profile, Set<Device> devices) {
        this.email = email;
        this.phone = phone;
        this.profile = profile;
        this.devices = devices;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Profile> getProfile() {
        return profile;
    }

    public void setProfile(List<Profile> profile) {
        this.profile = profile;
    }

    public Set<Device> getDevices() {
        return devices;
    }

    public void setDevices(Set<Device> devices) {
        this.devices = devices;
    }
}
