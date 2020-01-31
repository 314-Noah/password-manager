package de.noah.passwordmanager.collections.userdata;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserDataReposity extends MongoRepository<UserData, String> {

}
