package de.noah.passwordmanager.crypt;

import java.util.Arrays;
import java.util.List;

import org.bson.Document;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.AfterLoadEvent;

public class MongDBLoadListener extends AbstractMongoEventListener<Object> {

	private EncryptionUtil encryptionUtil;
	
	public MongDBLoadListener() {
		encryptionUtil = EncryptionUtil.getInstance();
	}
	
	@Override
    public void onAfterLoad(AfterLoadEvent<Object> event) {

        Document eventObject = event.getDocument();

      
        List<String> keysNotToDecrypt = Arrays.asList("_class", "_id");

        for ( String key : eventObject.keySet() ) {
            if (!keysNotToDecrypt.contains(key)) {
                eventObject.put(key, this.encryptionUtil.decrypt(eventObject.get(key).toString()));
            }
        }

        super.onAfterLoad(event);
    }
}
