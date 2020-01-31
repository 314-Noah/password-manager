package de.noah.passwordmanager.crypt;

import java.util.Arrays;
import java.util.List;

import org.bson.Document;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeSaveEvent;

public class MongoDBSaveListener extends AbstractMongoEventListener<Object> {

	private EncryptionUtil encryptionUtil;
	
	public MongoDBSaveListener() {
		encryptionUtil = EncryptionUtil.getInstance();
	}
	
	@Override
	public void onBeforeSave(BeforeSaveEvent<Object> event) {
		
		Document eventObject = event.getDocument();
		
		List<String> keysNotToEncrypt = Arrays.asList("_class", "_id");

        for ( String key : eventObject.keySet() ) {
            if (!keysNotToEncrypt.contains(key)) {
                eventObject.put(key, this.encryptionUtil.encrypt(eventObject.get(key).toString()));
            }
        }


        super.onBeforeSave(event);
	}
	
}
