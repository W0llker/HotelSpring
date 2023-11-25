package controller;

import dto.DeleteOrFindDto;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

public interface ControllerApi<REQ, RESP> {
    @PostMapping("save")
    RESP save(@RequestBody @Valid REQ req);
    @GetMapping("id")
    RESP findById(@RequestParam Long id);
    @DeleteMapping("delete")
    void delete(@RequestBody DeleteOrFindDto dto);
    @PutMapping("update")
    RESP update(@RequestBody @Valid REQ req);
}
