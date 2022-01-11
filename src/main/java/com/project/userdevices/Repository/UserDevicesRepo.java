package com.project.userdevices.Repository;

import com.project.userdevices.Model.Users;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDevicesRepo extends MongoRepository<Users,String> {

}
