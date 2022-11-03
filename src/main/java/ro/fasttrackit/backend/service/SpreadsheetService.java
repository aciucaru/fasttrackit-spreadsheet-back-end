package ro.fasttrackit.backend.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import ro.fasttrackit.backend.model.SpreadsheetEntity;
import ro.fasttrackit.backend.model.SpreadsheetShortInfo;
import ro.fasttrackit.backend.repository.SpreadsheetRepository;

@Service
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

    public List<SpreadsheetShortInfo> getSpreadsheetList()
    {
        List<SpreadsheetShortInfo> list;
        list = repo.findAll()
                    .stream()
                    .map( (SpreadsheetEntity spreadsheet) ->
                            new SpreadsheetShortInfo(spreadsheet.id(), spreadsheet.name() )
                        )
                    .collect(Collectors.toList());

        return list;
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

    public SpreadsheetEntity replace(String id, SpreadsheetEntity newSpreadsheet)
    {
//        Optional<SpreadsheetEntity> optSpreadsheet = repo.findById(id);
//        if(optSpreadsheet.isPresent())
//            return repo.save(optSpreadsheet.get());
//        else
//            return repo.save(newSpreadsheet);

        return repo.findById(id)
                .map( currentSpreadsheet ->
                        {
                            return repo.save(currentSpreadsheet.withDataFrom(newSpreadsheet));
                        }
                )
                .orElseGet( () ->
                        {
                            return repo.save(newSpreadsheet.withId(id));
                        }
                );
    }

    public void delete(String id)
    {
        repo.deleteById(id);
    }
}
