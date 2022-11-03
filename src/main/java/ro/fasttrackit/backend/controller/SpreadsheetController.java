package ro.fasttrackit.backend.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
@CrossOrigin
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
    List<SpreadsheetShortInfo> getSpreadsheetList()
    {
        System.out.println("SpreadsheetController GET");
        return service.getSpreadsheetList();
    }

    @GetMapping("{id}")
//    @ResponseStatus(HttpStatus.OK)
//    @CrossOrigin(origins = "http://localhost:4200")
    SpreadsheetEntity getById(@PathVariable String id)
    {
        Optional<SpreadsheetEntity> optSpreadsheet = service.getById(id);
        System.out.println("SpreadsheetController GET");
        return optSpreadsheet.orElse(null);
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
    SpreadsheetEntity add(@RequestBody SpreadsheetEntity spreadsheet)
    {
        Optional<SpreadsheetEntity> optSpreadsheet = service.add(spreadsheet);
        System.out.println("SpreadsheetController POST");
        return optSpreadsheet.orElse(null);
    }

    @PutMapping("{id}")
    SpreadsheetEntity replace(@PathVariable String id, @RequestBody SpreadsheetEntity newSpreadsheet)
    {
        System.out.println("SpreadsheetController PUT");
        return service.replace(id, newSpreadsheet);
    }

    @DeleteMapping("{id}")
//    @ResponseStatus(HttpStatus.OK)
//    @CrossOrigin(origins = "http://localhost:4200")
    void delete(@PathVariable String id)
    {
        service.delete(id);
    }
}
