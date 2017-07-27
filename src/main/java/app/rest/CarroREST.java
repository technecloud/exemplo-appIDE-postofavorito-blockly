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
 * Controller para expor serviços REST de Carro
 *
 * @generated
 **/
@RestController
@RequestMapping(value = "/api/rest/Carro")
public class CarroREST {

  /**
   * Classe de negócio para manipulação de dados
   *
   * @generated
   */
  @Autowired
  @Qualifier("CarroBusiness")
  private CarroBusiness carroBusiness;

  /**
   * @generated
   */
  @Autowired
  @Qualifier("AbastecimentoBusiness")
  private AbastecimentoBusiness abastecimentoBusiness;
  /**
   * Serviço exposto para novo registro de acordo com a entidade fornecida
   *
   * @generated
   */
  @RequestMapping(method = RequestMethod.POST)
  public Carro post(@Validated @RequestBody final Carro entity) throws Exception {
    return carroBusiness.post(entity);
  }

  /**
   * Serviço exposto para salvar alterações de acordo com a entidade fornecida
   *
   * @generated
   */
  @RequestMapping(method = RequestMethod.PUT)
  public Carro put(@Validated @RequestBody final Carro entity) throws Exception {
    return carroBusiness.put(entity);
  }

  /**
   * Serviço exposto para salvar alterações de acordo com a entidade e id fornecidos
   * 
   * @generated
   */
  @RequestMapping(method = RequestMethod.PUT, value = "/{carroId}")
  public Carro put(@Validated @RequestBody final Carro entity, @PathVariable("carroId") java.lang.String carroId) throws Exception {
    return carroBusiness.put(entity);
  }  

  /**
   * Serviço exposto para remover a entidade de acordo com o id fornecido
   * 
   * @generated
   */
  @RequestMapping(method = RequestMethod.DELETE, value = "/{carroId}")
  public void delete(@PathVariable("carroId") java.lang.String carroId) throws Exception {
    carroBusiness.delete(carroId);
  }

  /**
   * NamedQuery list
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET
  )
  public HttpEntity<PagedResources<Carro>> listParams (Pageable pageable, PagedResourcesAssembler assembler){
    return new ResponseEntity<>(assembler.toResource(carroBusiness.list(pageable)), HttpStatus.OK);
  }


  /**
   * OneToMany Relationship GET
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET
  , value="/{instanceId}/Abastecimento")
  public HttpEntity<PagedResources<Abastecimento>> findAbastecimento(@PathVariable("instanceId") java.lang.String instanceId, Pageable pageable, PagedResourcesAssembler assembler) {
    return new ResponseEntity<>(assembler.toResource(carroBusiness.findAbastecimento(instanceId, pageable)), HttpStatus.OK);
  }

  /**
   * OneToMany Relationship DELETE
   * @generated
   */
  @RequestMapping(method = RequestMethod.DELETE
  , value="/{instanceId}/Abastecimento/{relationId}")
  public void deleteAbastecimento(@PathVariable("relationId") java.lang.String relationId) throws Exception {
    this.abastecimentoBusiness.delete(relationId);
  }

  /**
   * OneToMany Relationship PUT
   * @generated
   */
  @RequestMapping(method = RequestMethod.PUT
  , value="/{instanceId}/Abastecimento/{relationId}")
  public Abastecimento putAbastecimento(@Validated @RequestBody final Abastecimento entity, @PathVariable("relationId") java.lang.String relationId) throws Exception {
    return this.abastecimentoBusiness.put(entity);
  }

  /**
   * OneToMany Relationship POST
   * @generated
   */
  @RequestMapping(method = RequestMethod.POST
  , value="/{instanceId}/Abastecimento")
  public Abastecimento postAbastecimento(@Validated @RequestBody final Abastecimento entity, @PathVariable("instanceId") java.lang.String instanceId) throws Exception {
  Carro carro = this.carroBusiness.get(instanceId);
  entity.setCarro(carro);
    return this.abastecimentoBusiness.post(entity);
  }



  /**
   * Serviço exposto para recuperar a entidade de acordo com o id fornecido
   *
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET, value = "/{id}")
  public Carro get(@PathVariable("id") java.lang.String id) throws Exception {
    return carroBusiness.get(id);
  }

}
