package com.app.dashboard.controllers;

import com.app.dashboard.ShelterRepository;
import com.app.dashboard.models.Shelter;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
    @ApiOperation(value = "Get all Shelters", notes = "Get a list of all Shelters optionally giving a limit and offset, default is first 50.")
    public List<Shelter> getAllShelters(
            @RequestParam(required = false) Integer limit,
            @RequestParam(required = false) Integer skip
    ) {
        // Check if limit and skip parameters are provided and use default values if not
        int limitValue = (limit != null) ? limit : 50;
        int skipValue = (skip != null) ? skip : 0;
        
        return repository.getSheltersPaganeted(skipValue, limitValue);
    }
}
