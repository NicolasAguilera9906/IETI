package com.eci.cosw.springbootsecureapi.controller;

import com.eci.cosw.springbootsecureapi.model.User;
import com.eci.cosw.springbootsecureapi.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


@RestController
@RequestMapping( "user" )
public class UserController
{

    @Autowired
    private UserService userService;

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping( value = "/login", method = RequestMethod.POST )
    public ResponseEntity<?> login( @RequestBody User login ) throws Exception {
        String jwtToken = "";
        if ( login.getEmail() == null || login.getPassword() == null ) {
            return new ResponseEntity<>("Please fill username and password", HttpStatus.NOT_FOUND);
        }
        try {
            String email = login.getEmail();
            String password = login.getPassword();
            userService.findUserByEmailAndPassword(email, password);
            jwtToken = Jwts.builder().setSubject(email).claim("roles", "user").setIssuedAt(new Date()).signWith(
                    SignatureAlgorithm.HS256, "secretkey").compact();
            return new ResponseEntity<>(new Token(jwtToken), HttpStatus.ACCEPTED);
        } catch (Exception e){
            System.out.println(e.getMessage());
            if(e.getMessage()=="Invalid password"){
                return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
            }
            else{
                return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
            }

        }
    }

    public class Token {
        String accessToken;
        public Token( String accessToken )
        {
            this.accessToken = accessToken;
        }
        public String getAccessToken()
        {
            return accessToken;
        }
        public void setAccessToken( String access_token )
        {
            this.accessToken = access_token;
        }
    }

}
