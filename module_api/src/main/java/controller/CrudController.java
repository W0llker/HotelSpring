package controller;


import annotation.LoggerAnnotation;
import dto.DeleteOrFindDto;
import service.CrudApi;

public abstract class CrudController<REQ, RESP> implements ControllerApi<REQ, RESP> {
    private final CrudApi<REQ, RESP> crudService;

    public CrudController(CrudApi<REQ, RESP> crudService) {
        this.crudService = crudService;
    }

    @Override
    @LoggerAnnotation
    public RESP save(REQ req) {
        return crudService.add(req);
    }

    @Override
    @LoggerAnnotation
    public void delete(DeleteOrFindDto dto) {
        crudService.delete(dto.getId());
    }

    @Override
    @LoggerAnnotation
    public RESP update(REQ req) {
        return crudService.update(req);
    }

    @Override
    @LoggerAnnotation
    public RESP findById(Long id) {
        return crudService.findById(id);
    }
}
