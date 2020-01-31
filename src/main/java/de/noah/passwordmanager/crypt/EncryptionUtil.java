package de.noah.passwordmanager.crypt;

import org.jasypt.util.text.BasicTextEncryptor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class EncryptionUtil {

	private BasicTextEncryptor textEncryptor;
	
	public EncryptionUtil() {

        textEncryptor = new BasicTextEncryptor();
        textEncryptor.setPassword("*-hhk<>vdh4324hsdf-h4-s3b4rt#b4w7526$v7u");
    }

    public String encrypt(String textToEncrypt) {
        return this.textEncryptor.encrypt(textToEncrypt);
    }

    public String decrypt(String encryptedText) {
        return this.textEncryptor.decrypt(encryptedText);
    }
    
    @Bean
    public MongoDBSaveListener mongoDBBeforeSaveEventListener() {
        return new MongoDBSaveListener();
    }

    @Bean
    public MongDBLoadListener mongoDBAfterLoadEventListener() {
        return new MongDBLoadListener();
    }
	
}
