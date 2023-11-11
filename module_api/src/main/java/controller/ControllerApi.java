package controller;

import dto.DeleteOrFindDto;
import org.springframework.web.bind.annotation.*;

public interface ControllerApi<REQ, RESP> {
    @PostMapping("save")
    RESP save(@RequestBody REQ req);
    @GetMapping("id")
    RESP findById(@RequestParam Long id);
    @DeleteMapping("delete")
    void delete(@RequestBody DeleteOrFindDto dto);
    @PutMapping("update")
    RESP update(@RequestBody REQ req);
}
