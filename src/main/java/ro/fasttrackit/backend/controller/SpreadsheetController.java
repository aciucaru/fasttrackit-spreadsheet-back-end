package ro.fasttrackit.backend.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import ro.fasttrackit.backend.model.SpreadsheetEntity;

@RestController
@RequestMapping("sheets")
public class SpreadsheetController
{
    private final SpreadsheetService service;

    public TableController(SpreadsheetService service)
    {
        this.service = service;
    }

    @GetMapping
    @CrossOrigin(origins = "http://localhost:4200")
    List<SpreadsheetEntity> getAll() { return service.getAll(); }

    @GetMapping("{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    SpreadsheetEntity getById(@PathVariable String id)
    {
        Optional<SpreadsheetEntity> optTable = service.getById(id);
        return optTable.orElse(null);
    }

    @GetMapping("one")
    @CrossOrigin(origins = "http://localhost:4200")
    SpreadsheetEntity getOne()
    {
        return service.getAll().get(0);
    }

    @PostMapping
    @CrossOrigin(origins = "http://localhost:4200")
    SpreadsheetEntity add(@RequestBody SpreadsheetEntity table)
    {
        Optional<SpreadsheetEntity> optTable = service.add(table);
        return optTable.orElse(null);
    }

    @DeleteMapping("{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    SpreadsheetEntity delete(@PathVariable String id)
    {
        Optional<SpreadsheetEntity> optTable = service.delete(id);
        return optTable.orElse(null);
    }
}