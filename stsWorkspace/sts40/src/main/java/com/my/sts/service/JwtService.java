package com.my.sts.service;

import java.security.Key;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

//@Component
//@Service
public class JwtService {
//	Key key=Keys.secretKeyFor(SignatureAlgorithm.HS256);
	String keymsg="12345678901234567890123456789012";
	Key key=Keys.hmacShaKeyFor(keymsg.getBytes());
	
	public String jwtCreate(String username) {
//		SecretKey signingKey=Jwts.SIG.HS256.key().build();
		String jwt = Jwts.builder()                     // (1)
			    .header()                                   // (2) optional
			        .keyId("aKeyId")
			        .and()
			    .subject(username)                             // (3) JSON Claims, or
			    //.content(aByteArray, "text/plain")        //     any byte[] content, with media type
			    .signWith(key)                       // (4) if signing, or
			    //.encryptWith(key, keyAlg, encryptionAlg)  //     if encrypting
			    .compact();                                 // (5)
		
		return jwt;
	}
	
	public String parseInfo(String token) {
		Jwt jwt=Jwts.parser()
			.setSigningKey(key)
			.build()
			.parseSignedClaims(token);
		Claims claim=(Claims) jwt.getBody();
		return (String) claim.get("sub");
	}
}
