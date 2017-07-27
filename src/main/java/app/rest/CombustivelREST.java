package app.rest;

import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.*;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.*;
import org.springframework.beans.factory.annotation.*;
import java.util.*;
import app.entity.*;
import app.business.*;

/**
 * Controller para expor serviços REST de Combustivel
 *
 * @generated
 **/
@RestController
@RequestMapping(value = "/api/rest/Combustivel")
public class CombustivelREST {

  /**
   * Classe de negócio para manipulação de dados
   *
   * @generated
   */
  @Autowired
  @Qualifier("CombustivelBusiness")
  private CombustivelBusiness combustivelBusiness;

  /**
   * Serviço exposto para novo registro de acordo com a entidade fornecida
   *
   * @generated
   */
  @RequestMapping(method = RequestMethod.POST)
  public Combustivel post(@Validated @RequestBody final Combustivel entity) throws Exception {
    return combustivelBusiness.post(entity);
  }

  /**
   * Serviço exposto para salvar alterações de acordo com a entidade fornecida
   *
   * @generated
   */
  @RequestMapping(method = RequestMethod.PUT)
  public Combustivel put(@Validated @RequestBody final Combustivel entity) throws Exception {
    return combustivelBusiness.put(entity);
  }

  /**
   * Serviço exposto para salvar alterações de acordo com a entidade e id fornecidos
   * 
   * @generated
   */
  @RequestMapping(method = RequestMethod.PUT, value = "/{combustivelId}")
  public Combustivel put(@Validated @RequestBody final Combustivel entity, @PathVariable("combustivelId") java.lang.String combustivelId) throws Exception {
    return combustivelBusiness.put(entity);
  }  

  /**
   * Serviço exposto para remover a entidade de acordo com o id fornecido
   * 
   * @generated
   */
  @RequestMapping(method = RequestMethod.DELETE, value = "/{combustivelId}")
  public void delete(@PathVariable("combustivelId") java.lang.String combustivelId) throws Exception {
    combustivelBusiness.delete(combustivelId);
  }

  /**
   * NamedQuery list
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET
  )
  public HttpEntity<PagedResources<Combustivel>> listParams (Pageable pageable, PagedResourcesAssembler assembler){
    return new ResponseEntity<>(assembler.toResource(combustivelBusiness.list(pageable)), HttpStatus.OK);
  }



  /**
   * Serviço exposto para recuperar a entidade de acordo com o id fornecido
   *
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET, value = "/{id}")
  public Combustivel get(@PathVariable("id") java.lang.String id) throws Exception {
    return combustivelBusiness.get(id);
  }

}
