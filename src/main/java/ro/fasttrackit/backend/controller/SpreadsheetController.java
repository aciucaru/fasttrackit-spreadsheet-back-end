package ro.fasttrackit.backend.controller;

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
import ro.fasttrackit.backend.model.SpreadsheetShortInfo;
import ro.fasttrackit.backend.service.SpreadsheetService;

@RestController
@RequestMapping("sheets")
//@CrossOrigin(origins = "http://localhost:4200")
//@CrossOrigin
//@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:4200/editor", "http://localhost:4200/browse"})
public class SpreadsheetController
{
    private final SpreadsheetService service;

    public SpreadsheetController(SpreadsheetService service)
    {
        this.service = service;
    }

    @GetMapping("list")
//    @ResponseStatus(HttpStatus.OK)
//    @CrossOrigin(origins = "http://localhost:4200")
    List<SpreadsheetShortInfo> getSpreadsheetList() { return service.getSpreadsheetList(); }

    @GetMapping("{id}")
//    @ResponseStatus(HttpStatus.OK)
//    @CrossOrigin(origins = "http://localhost:4200")
    SpreadsheetEntity getById(@PathVariable String id)
    {
        Optional<SpreadsheetEntity> optTable = service.getById(id);
        return optTable.orElse(null);
    }

    @GetMapping("one")
//    @ResponseStatus(HttpStatus.OK)
//    @CrossOrigin(origins = "http://localhost:4200")
    SpreadsheetEntity getOne()
    {
        return service.getAll().get(0);
    }

    @PostMapping
//    @ResponseStatus(HttpStatus.OK)
//    @CrossOrigin(origins = "http://localhost:4200")
    SpreadsheetEntity add(@RequestBody SpreadsheetEntity table)
    {
        Optional<SpreadsheetEntity> optTable = service.add(table);
        return optTable.orElse(null);
    }

    @DeleteMapping("{id}")
//    @ResponseStatus(HttpStatus.OK)
//    @CrossOrigin(origins = "http://localhost:4200")
    SpreadsheetEntity delete(@PathVariable String id)
    {
        Optional<SpreadsheetEntity> optTable = service.delete(id);
        return optTable.orElse(null);
    }
}
