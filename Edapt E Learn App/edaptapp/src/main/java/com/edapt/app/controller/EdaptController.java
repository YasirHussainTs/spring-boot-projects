package com.edapt.app.controller;

import com.edapt.app.dto.EdaptDto;
import com.edapt.app.service.EdaptService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/edapt")
public class EdaptController{

    private EdaptService edaptService;

    @GetMapping("{id}")
    public ResponseEntity<EdaptDto> getEdapt(@PathVariable Long id) {
        return new ResponseEntity<>(edaptService.getEdaptById(id), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<EdaptDto>> getAllEdapt() {
        List<EdaptDto> edapts = edaptService.getAllEdapt();
        return ResponseEntity.ok(edapts);
    }
}
