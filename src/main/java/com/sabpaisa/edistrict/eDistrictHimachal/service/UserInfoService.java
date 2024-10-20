package com.sabpaisa.edistrict.eDistrictHimachal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sabpaisa.edistrict.eDistrictHimachal.model.UserInfo;
import com.sabpaisa.edistrict.eDistrictHimachal.repository.UserInfoRepository;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class UserInfoService {
	
	  @Autowired
	    private UserInfoRepository userInfoRepository;

	    public void saveUserInfo(String name, String email, String keyy) {
	        UserInfo userInfo = new UserInfo(name, email, keyy);
	        userInfoRepository.save(userInfo);
	    }
	    

    public String createHash(String encryptedValue) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-512");
            byte[] hashBytes = digest.digest(encryptedValue.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error creating hash", e);
        }
    }

    
    public boolean compareHash(String providedHash, String encryptedValue) {
        String calculatedHash = createHash(encryptedValue);
        System.out.println(calculatedHash);
        return calculatedHash.equals(providedHash);
    }
}
