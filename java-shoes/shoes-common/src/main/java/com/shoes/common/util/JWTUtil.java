package com.shoes.common.util;

import cn.hutool.json.JSONUtil;
import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.RSASSASigner;
import com.nimbusds.jose.crypto.RSASSAVerifier;
import com.shoes.common.entity.TokenEntity;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPublicKey;
import java.text.ParseException;
import java.util.Map;

/**
 * @Author: Tomcat
 * @Date: 2023/7/12
 **/
public class JWTUtil {
    public static String getToken(TokenEntity tokenEntity) throws NoSuchAlgorithmException, JOSEException {
        // (1) 生成RSA公钥-秘钥对
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        // (2) Create RSA signer
        JWSSigner signer = new RSASSASigner(keyPair.getPrivate());

        // (3) 生成jws头
        JWSHeader jwsHeader = new JWSHeader
                .Builder(JWSAlgorithm.RS512)    // 指定 RSA 算法
                .type(JOSEObjectType.JWT)
                .build();

        // (4) 生成jws对象
        JWSObject jwsObject = new JWSObject(jwsHeader, new Payload(JSONUtil.toJsonStr(tokenEntity)));
        // (5) 给jwt签名
        jwsObject.sign(signer);
        // (6) 生成jwt字符串
        String jwtToken = jwsObject.serialize();
        System.out.println(jwtToken);
        return jwtToken;
    }

    public static boolean validate(String jwtToken) throws ParseException, JOSEException, NoSuchAlgorithmException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        JWSVerifier verifier = new RSASSAVerifier((RSAPublicKey) keyPair.getPublic());
        JWSObject parseObj = JWSObject.parse(jwtToken);
        if(parseObj.verify(verifier)) {
            Map<String, Object> stringObjectMap = parseObj.getPayload().toJSONObject();
            System.err.println(stringObjectMap);
        }
        return true;
    }

}
