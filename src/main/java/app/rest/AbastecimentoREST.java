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
 * Controller para expor serviços REST de Abastecimento
 *
 * @generated
 **/
@RestController
@RequestMapping(value = "/api/rest/Abastecimento")
public class AbastecimentoREST {

  /**
   * Classe de negócio para manipulação de dados
   *
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
  public Abastecimento post(@Validated @RequestBody final Abastecimento entity) throws Exception {
    return abastecimentoBusiness.post(entity);
  }

  /**
   * Serviço exposto para salvar alterações de acordo com a entidade fornecida
   *
   * @generated
   */
  @RequestMapping(method = RequestMethod.PUT)
  public Abastecimento put(@Validated @RequestBody final Abastecimento entity) throws Exception {
    return abastecimentoBusiness.put(entity);
  }

  /**
   * Serviço exposto para salvar alterações de acordo com a entidade e id fornecidos
   * 
   * @generated
   */
  @RequestMapping(method = RequestMethod.PUT, value = "/{abastecimentoId}")
  public Abastecimento put(@Validated @RequestBody final Abastecimento entity, @PathVariable("abastecimentoId") java.lang.String abastecimentoId) throws Exception {
    return abastecimentoBusiness.put(entity);
  }  

  /**
   * Serviço exposto para remover a entidade de acordo com o id fornecido
   * 
   * @generated
   */
  @RequestMapping(method = RequestMethod.DELETE, value = "/{abastecimentoId}")
  public void delete(@PathVariable("abastecimentoId") java.lang.String abastecimentoId) throws Exception {
    abastecimentoBusiness.delete(abastecimentoId);
  }

  /**
   * NamedQuery list
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET
  )
  public HttpEntity<PagedResources<Abastecimento>> listParams (Pageable pageable, PagedResourcesAssembler assembler){
    return new ResponseEntity<>(assembler.toResource(abastecimentoBusiness.list(pageable)), HttpStatus.OK);
  }



  /**
   * Serviço exposto para recuperar a entidade de acordo com o id fornecido
   *
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET, value = "/{id}")
  public Abastecimento get(@PathVariable("id") java.lang.String id) throws Exception {
    return abastecimentoBusiness.get(id);
  }

}
