package com.springbootdev.examples.core.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.springbootdev.examples.core.Employee;
import com.springbootdev.examples.core.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class EmployeeController {

    @Autowired
    private JwtUtil util;

    //    @Cacheable(cacheNames = "screenCache", key = "#employeeId")
    @GetMapping("/employees/{employee-id}")
    public Employee getEmployee(@PathVariable("employee-id") Long employeeId) throws Exception {

        Map<String, Object> claims = new HashMap<>();
//        claims.put("company", "rumex");


//        String jwtToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJ1c2VyIiwiaXNzIjoiaXNzdWVyIiwicm9sZSI6InJvbGUiLCJhY2Nlc3NDb2RlIjoiYWNjZXNzQ29kZSIsImlkIjoiaWQiLCJpYXQiOjE1OTI5NzY0OTd9.yXw4-yh4O9Gl-tv8j2gzyWuqd7a6xO-ONOrHC0gx154";
//        System.out.println("------------ Decode JWT ------------");
//        String[] split_string = jwtToken.split("\\.");
//        String base64EncodedHeader = split_string[0];
//        String base64EncodedBody = split_string[1];
//        String base64EncodedSignature = split_string[2];
//
//
//        System.out.println("~~~~~~~~~ JWT Header ~~~~~~~");
//        Base64 base64Url = new Base64(true);
//        String header = new String(base64Url.decode(base64EncodedHeader));
//        System.out.println("JWT Header : " + header);
//
//
//        System.out.println("~~~~~~~~~ JWT Body ~~~~~~~");
//        String body = new String(base64Url.decode(base64EncodedBody));
//        System.out.println("JWT Body : "+body);


//        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXUyJ9.eyJpc3MiOiJhdXRoMCJ9.AbIJTDMFc7yUa5MhvcP03nJPyCPzZtQcGEp-zWfOkEE";
//        try {
//            Algorithm algorithm = Algorithm.HMAC256("secret");
//            JWTVerifier verifier = JWT.require(algorithm)
//                    .withIssuer("auth0")
//                    .build(); //Reusable verifier instance
//            DecodedJWT jwt = verifier.verify(token);
//        } catch (JWTVerificationException exception){
//            //Invalid signature/claims
//        }


//        String tokenN = JWT.create()
//                .withSubject("darshana")
//                .withExpiresAt(new Date(System.currentTimeMillis()))
//                .sign(Algorithm.HMAC512("Q2hhcHo=".getBytes()));
//
//        System.out.println("=====new toke " + tokenN);
//
//        String user = JWT.require(Algorithm.HMAC512("Q2hhcHo=".getBytes()))
//                .build()
//                .verify(tokenN)
//                .getSubject();
//
//        System.out.println("user " + user);


        String user2 = JWT.require(Algorithm.HMAC256("dGVzdA==".getBytes()))
                .build()
                .verify("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiI5NDcxMzAyNTA2MiIsImlzcyI6IlJ1bWV4Iiwicm9sZSI6IlVzZXIiLCJhY2Nlc3NDb2RlIjoiaGZzMHQ2dmFuc3VnbzlkeWpxZTVvOSIsImlkIjoiNWU3MzYwNDZhYmY5MTE2Y2Q5OWQ1ZDliIiwiaWF0IjoxNTkzMTM5OTc3fQ.Q5JR99xrrv7GisIa2_vXAtbbdMcLiY7tmyXhsOuXKHo")
                .getSubject();

        System.out.println("new user " + user2);


        DecodedJWT decodedJWT = JWT.require(Algorithm.HMAC256("dGVzdA==".getBytes()))
                .build()
                .verify("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiI5NDcxMzAyNTA2MiIsImlzcyI6IlJ1bWV4Iiwicm9sZSI6IlVzZXIiLCJhY2Nlc3NDb2RlIjoiaGZzMHQ2dmFuc3VnbzlkeWpxZTVvOSIsImlkIjoiNWU3MzYwNDZhYmY5MTE2Y2Q5OWQ1ZDliIiwiaWF0IjoxNTkzMTM5OTc3fQ.Q5JR99xrrv7GisIa2_vXAtbbdMcLiY7tmyXhsOuXKHo");


        System.out.println(decodedJWT.getSubject());
        System.out.println(decodedJWT.getClaims().get("id").asString());
        System.out.println(decodedJWT.getClaims().get("role").asString());

//
//        String token = util.createToken(claims, "chathuranga");
//
//        System.out.println("====token");
//        System.out.println(token);
//
//        System.out.println(util.extractAllClaims(token));

//        System.out.println(util.extractAllClaims("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJjaGF0aHVyYW5nYSIsImV4cCI6MTU5MzE3NjA1MiwiaWF0IjoxNTkzMTQwMDUyfQ.kqAokQyYhJCCquLF7TuTpzF23px4Rk0pistrhoxHA8U"));
//        System.out.println("=== " + util.extractAllClaims("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiI5NDcxMzAyNTA2MiIsImlzcyI6IlJ1bWV4Iiwicm9sZSI6IlVzZXIiLCJhY2Nlc3NDb2RlIjoiaGZzMHQ2dmFuc3VnbzlkeWpxZTVvOSIsImlkIjoiNWU3MzYwNDZhYmY5MTE2Y2Q5OWQ1ZDliIiwiaWF0IjoxNTkzMTM5NzI3fQ.gpc-8t425l8HgmMEQSYZJvHgDZulJPOqQQFunUL8R3Q"));
//        System.out.println("=== " + util.extractAllClaims("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJ1c2VyIiwiaXNzIjoiaXNzdWVyIiwicm9sZSI6InJvbGUiLCJhY2Nlc3NDb2RlIjoiYWNjZXNzQ29kZSIsImlkIjoiaWQiLCJpYXQiOjE1OTI5NzQ1NzJ9.qOfuHpxICitl9_3kOpVG05XoFf_o8AG-KGtbs4mbxDI"));
//        System.out.println("=== " + util.extractAllClaims("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJ1c2VyIiwiaXNzIjoiaXNzdWVyIiwicm9sZSI6InJvbGUiLCJhY2Nlc3NDb2RlIjoiYWNjZXNzQ29kZSIsImlkIjoiaWQiLCJpYXQiOjE1OTI5NzU2NzV9.8h6kqrZUBKto35kzJmul36WAAeVy55EfT0OSLWgs_0Q"));

        System.out.println("==not from cache");
        return Employee.builder()
                .id("10")
                .name("chathuranga")
                .build();
    }
}
