package ro.fasttrackit.backend.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import ro.fasttrackit.backend.model.SpreadsheetEntity;
import ro.fasttrackit.backend.repository.SpreadsheetRepository;

public class SpreadsheetService
{
    private final SpreadsheetRepository repo;

    public SpreadsheetService(SpreadsheetRepository repo)
    {
        this.repo = repo;
    }

    public List<SpreadsheetEntity> getAll()
    {
        return repo.findAll();
    }

    public Optional<SpreadsheetEntity> getById(String id)
    {
        return repo.findById(id);
    }

    public Optional<SpreadsheetEntity> add(SpreadsheetEntity table)
    {
        SpreadsheetEntity tableEntity = repo.save(table);
        return Optional.of(tableEntity);
    }

    public Optional<SpreadsheetEntity> delete(String id)
    {
        Optional<SpreadsheetEntity> optTableEntity = repo.findById(id);
        return optTableEntity;
    }
}
