package eci.ieti.controller;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping( "/api/security" )
public class SecurityController
{


    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping( value = "/login", method = RequestMethod.GET )
    public String addTask() {
        return "Valid token";
    }

}
