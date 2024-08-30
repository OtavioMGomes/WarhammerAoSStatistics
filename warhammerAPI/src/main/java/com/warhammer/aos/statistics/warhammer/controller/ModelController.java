package com.warhammer.aos.statistics.warhammer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.warhammer.aos.statistics.warhammer.model.Model;
import com.warhammer.aos.statistics.warhammer.service.ModelService;

@RestController
@RequestMapping("/api/model")
public class ModelController {

  @Autowired
  ModelService service;

    @GetMapping
    public Page<Model> index(Pageable pageable){
        return service.listAll(pageable);
    }

    @GetMapping("{id}")
    public ResponseEntity<Model> show(@PathVariable Integer id){
        return ResponseEntity.of(service.getById(id));
    }

    // @PostMapping("duvida/{id}")
    // public ResponseEntity<Atividade> duvida(@PathVariable Integer id, @RequestBody String jsonString){

    //     var optUsuario = usuarioService.getById(id);
    //     Optional<TipoAtividade>  optTipoAtividade= tpAtividadeService.getById(11);

    //     if(!optUsuario.isEmpty() && !optTipoAtividade.isEmpty()){

    //         Atividade atividade = new Atividade();

    //         atividade.addUsuario(optUsuario.get());
    //         atividade.addTipoAtividade(optTipoAtividade.get());
    //         atividade.setDesc(jsonString);

    //         service.save(atividade);
        
    //         return ResponseEntity
    //                 .status(HttpStatus.CREATED)
    //                 .body(atividade);

    //     }else{
    //         return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    //     }

    // }

    // @PutMapping()
    // public ResponseEntity<CategoriaDTO> update(@RequestBody @Valid Categoria newCategoria){
    //     Optional<Categoria> opt = service.findById(newCategoria.getId());

    //     if(opt.isEmpty())
    //         return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

    //     Categoria categoria = opt.get();
    //     BeanUtils.copyProperties(newCategoria, categoria);

    //     service.save(categoria);
    //     Optional<CategoriaDTO> dto = Optional.of(new CategoriaDTO().convert(categoria));

    //     return ResponseEntity.of(dto);
        
    // }
  
}
