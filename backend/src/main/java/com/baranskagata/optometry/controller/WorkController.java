package com.baranskagata.optometry.controller;

import com.baranskagata.optometry.entity.Optometrist;
import com.baranskagata.optometry.entity.Work;
import com.baranskagata.optometry.service.WorkService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@Slf4j
@CrossOrigin("http://localhost:4200/")
@RequestMapping("/works")
public class WorkController {

    private final WorkService workService;

    @GetMapping()
    ResponseEntity<Page<Work>> getAllWorks(Pageable pageable) {
        return ResponseEntity.ok().body(workService.getWorks(pageable));
    }

    @GetMapping("{id}")
    public ResponseEntity<Work> getWorkById(@PathVariable Long id) {
        return ResponseEntity.ok().body(workService.getWorkById(id));
    }

    @PostMapping()
    public ResponseEntity<Work> createWork(@RequestBody Work work) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/works").toUriString());
        return ResponseEntity.created(uri).body(workService.saveWork(work));
    }

    @PutMapping({"id"})
    public ResponseEntity<Work> updateWorkDetails(@PathVariable Long id, @RequestBody Work workDetails) {
        return ResponseEntity.ok().body(workService.updateWork(id,workDetails));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteWork(@PathVariable Long id) {
        workService.deleteWorkById(id);

        return ResponseEntity.noContent().build();
    }


    @GetMapping("/optometrists")
    public ResponseEntity<List<Optometrist>> getOptometristForWorkId(@RequestParam Long workId) {
        return ResponseEntity.ok().body(workService.getOptometristForWorkId(workId));
    }


}