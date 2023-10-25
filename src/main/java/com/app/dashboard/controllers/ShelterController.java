package com.app.dashboard.controllers;

import com.app.dashboard.ShelterRepository;
import com.app.dashboard.models.Shelter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5000")
public class ShelterController {

    @Autowired
    ShelterRepository repository;

    @ApiIgnore
    @RequestMapping(value="/")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }

    @GetMapping("/shelters")
    @CrossOrigin
    public List<Shelter> getAllShelters(){
        return repository.getSheltersPaganeted(10, 10);
    }
}
