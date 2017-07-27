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
 * Controller para expor serviços REST de Posto
 *
 * @generated
 **/
@RestController
@RequestMapping(value = "/api/rest/Posto")
public class PostoREST {

  /**
   * Classe de negócio para manipulação de dados
   *
   * @generated
   */
  @Autowired
  @Qualifier("PostoBusiness")
  private PostoBusiness postoBusiness;

  /**
   * @generated
   */
  @Autowired
  @Qualifier("UserBusiness")
  private UserBusiness userBusiness;
  /**
   * @generated
   */
  @Autowired
  @Qualifier("ComentarioBusiness")
  private ComentarioBusiness comentarioBusiness;
  /**
   * @generated
   */
  @Autowired
  @Qualifier("AbastecimentoBusiness")
  private AbastecimentoBusiness abastecimentoBusiness;
  /**
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
  public Posto post(@Validated @RequestBody final Posto entity) throws Exception {
    return postoBusiness.post(entity);
  }

  /**
   * Serviço exposto para salvar alterações de acordo com a entidade fornecida
   *
   * @generated
   */
  @RequestMapping(method = RequestMethod.PUT)
  public Posto put(@Validated @RequestBody final Posto entity) throws Exception {
    return postoBusiness.put(entity);
  }

  /**
   * Serviço exposto para salvar alterações de acordo com a entidade e id fornecidos
   * 
   * @generated
   */
  @RequestMapping(method = RequestMethod.PUT, value = "/{postoId}")
  public Posto put(@Validated @RequestBody final Posto entity, @PathVariable("postoId") java.lang.String postoId) throws Exception {
    return postoBusiness.put(entity);
  }  

  /**
   * Serviço exposto para remover a entidade de acordo com o id fornecido
   * 
   * @generated
   */
  @RequestMapping(method = RequestMethod.DELETE, value = "/{postoId}")
  public void delete(@PathVariable("postoId") java.lang.String postoId) throws Exception {
    postoBusiness.delete(postoId);
  }

  /**
   * NamedQuery list
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET
  )
  public HttpEntity<PagedResources<Posto>> listParams (Pageable pageable, PagedResourcesAssembler assembler){
    return new ResponseEntity<>(assembler.toResource(postoBusiness.list(pageable)), HttpStatus.OK);
  }

  /**
   * OneToMany Relationship GET - Searchable fields - General search (Only strings fields)
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET, value="/{instanceId}/Comentario/generalSearch")
  public HttpEntity<PagedResources<Comentario>> findComentarioGeneralSearch(java.lang.String search, @PathVariable("instanceId") java.lang.String instanceId, Pageable pageable, PagedResourcesAssembler assembler) {
    return new ResponseEntity<>(assembler.toResource(postoBusiness.findComentarioGeneralSearch(search, instanceId, pageable)), HttpStatus.OK);
  }

  /**
   * OneToMany Relationship GET - Searchable fields - Specific search
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET
  , value="/{instanceId}/Comentario/specificSearch")
  public HttpEntity<PagedResources<Comentario>> findComentarioSpecificSearch(@PathVariable("instanceId") java.lang.String instanceId, java.lang.String data, java.lang.String texto, java.lang.Boolean moderado, Pageable pageable, PagedResourcesAssembler assembler) {
    return new ResponseEntity<>(assembler.toResource(postoBusiness.findComentarioSpecificSearch(instanceId, data, texto, moderado, pageable)), HttpStatus.OK);
  }

  /**
   * OneToMany Relationship GET
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET
  , value="/{instanceId}/Comentario")
  public HttpEntity<PagedResources<Comentario>> findComentario(@PathVariable("instanceId") java.lang.String instanceId, Pageable pageable, PagedResourcesAssembler assembler) {
    return new ResponseEntity<>(assembler.toResource(postoBusiness.findComentario(instanceId, pageable)), HttpStatus.OK);
  }

  /**
   * OneToMany Relationship DELETE
   * @generated
   */
  @RequestMapping(method = RequestMethod.DELETE
  , value="/{instanceId}/Comentario/{relationId}")
  public void deleteComentario(@PathVariable("relationId") java.lang.String relationId) throws Exception {
    this.comentarioBusiness.delete(relationId);
  }

  /**
   * OneToMany Relationship PUT
   * @generated
   */
  @RequestMapping(method = RequestMethod.PUT
  , value="/{instanceId}/Comentario/{relationId}")
  public Comentario putComentario(@Validated @RequestBody final Comentario entity, @PathVariable("relationId") java.lang.String relationId) throws Exception {
    return this.comentarioBusiness.put(entity);
  }

  /**
   * OneToMany Relationship POST
   * @generated
   */
  @RequestMapping(method = RequestMethod.POST
  , value="/{instanceId}/Comentario")
  public Comentario postComentario(@Validated @RequestBody final Comentario entity, @PathVariable("instanceId") java.lang.String instanceId) throws Exception {
  Posto posto = this.postoBusiness.get(instanceId);
  entity.setPosto(posto);
    return this.comentarioBusiness.post(entity);
  }


  /**
   * OneToMany Relationship GET
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET
  , value="/{instanceId}/Abastecimento")
  public HttpEntity<PagedResources<Abastecimento>> findAbastecimento(@PathVariable("instanceId") java.lang.String instanceId, Pageable pageable, PagedResourcesAssembler assembler) {
    return new ResponseEntity<>(assembler.toResource(postoBusiness.findAbastecimento(instanceId, pageable)), HttpStatus.OK);
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
  Posto posto = this.postoBusiness.get(instanceId);
  entity.setPosto(posto);
    return this.abastecimentoBusiness.post(entity);
  }


  /**
   * OneToMany Relationship GET
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET
  , value="/{instanceId}/Combustivel")
  public HttpEntity<PagedResources<Combustivel>> findCombustivel(@PathVariable("instanceId") java.lang.String instanceId, Pageable pageable, PagedResourcesAssembler assembler) {
    return new ResponseEntity<>(assembler.toResource(postoBusiness.findCombustivel(instanceId, pageable)), HttpStatus.OK);
  }

  /**
   * OneToMany Relationship DELETE
   * @generated
   */
  @RequestMapping(method = RequestMethod.DELETE
  , value="/{instanceId}/Combustivel/{relationId}")
  public void deleteCombustivel(@PathVariable("relationId") java.lang.String relationId) throws Exception {
    this.combustivelBusiness.delete(relationId);
  }

  /**
   * OneToMany Relationship PUT
   * @generated
   */
  @RequestMapping(method = RequestMethod.PUT
  , value="/{instanceId}/Combustivel/{relationId}")
  public Combustivel putCombustivel(@Validated @RequestBody final Combustivel entity, @PathVariable("relationId") java.lang.String relationId) throws Exception {
    return this.combustivelBusiness.put(entity);
  }

  /**
   * OneToMany Relationship POST
   * @generated
   */
  @RequestMapping(method = RequestMethod.POST
  , value="/{instanceId}/Combustivel")
  public Combustivel postCombustivel(@Validated @RequestBody final Combustivel entity, @PathVariable("instanceId") java.lang.String instanceId) throws Exception {
  Posto posto = this.postoBusiness.get(instanceId);
  entity.setPosto(posto);
    return this.combustivelBusiness.post(entity);
  }

  /**
   * ManyToMany Relationship GET - Searchable fields - General search (Only strings fields)
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET
  ,value="/{instanceId}/User/generalSearch")
  public HttpEntity<PagedResources<User>> listUserGeneralSearch(java.lang.String search, @PathVariable("instanceId") java.lang.String instanceId, Pageable pageable, PagedResourcesAssembler assembler) {
    return new ResponseEntity<>(assembler.toResource(postoBusiness.listUserGeneralSearch(search, instanceId, pageable)), HttpStatus.OK);
  }

  /**
   * ManyToMany Relationship GET - Searchable fields - Specific search
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET
  ,value="/{instanceId}/User/specificSearch")
  public HttpEntity<PagedResources<User>> listUserSpecificSearch(@PathVariable("instanceId") java.lang.String instanceId, java.lang.String email, java.lang.String name, java.lang.String login, Pageable pageable, PagedResourcesAssembler assembler) {
    return new ResponseEntity<>(assembler.toResource(postoBusiness.listUserSpecificSearch(instanceId, email, name, login, pageable)), HttpStatus.OK);
  }

  /**
   * ManyToMany Relationship GET
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET
  ,value="/{instanceId}/User")
  public HttpEntity<PagedResources<User>> listUser(@PathVariable("instanceId") java.lang.String instanceId, Pageable pageable, PagedResourcesAssembler assembler) {
    return new ResponseEntity<>(assembler.toResource(postoBusiness.listUser(instanceId, pageable)), HttpStatus.OK);
  }

  /**
   * ManyToMany Relationship POST
   * @generated
   */
  @RequestMapping(method = RequestMethod.POST
  ,value="/{instanceId}/User")
  public Posto postUser(@Validated @RequestBody final User entity, @PathVariable("instanceId") java.lang.String instanceId) throws Exception {
    Comentario newComentario = new Comentario();

    Posto instance = this.postoBusiness.get(instanceId);

    newComentario.setUser(entity);
    newComentario.setPosto(instance);

    this.comentarioBusiness.post(newComentario);

    return newComentario.getPosto();
  }

  /**
   * ManyToMany Relationship DELETE
   * @generated
   */
  @RequestMapping(method = RequestMethod.DELETE
  ,value="/{instanceId}/User/{relationId}")
  public void deleteUser(@PathVariable("instanceId") java.lang.String instanceId, @PathVariable("relationId") java.lang.String relationId) {
    this.postoBusiness.deleteUser(instanceId, relationId);
  }

  /**
   * Searchable fields - General search (Only strings fields)
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET, value = "/generalSearch")
  public HttpEntity<PagedResources<Posto>> generalSearch(java.lang.String search, Pageable pageable, PagedResourcesAssembler assembler) {
    return new ResponseEntity<>(assembler.toResource(postoBusiness.generalSearch(search, pageable)), HttpStatus.OK);
  }

  /**
   * Searchable fields - Specific search
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET, value = "/specificSearch")
  public HttpEntity<PagedResources<Posto>> specificSearch(java.lang.String nome, Pageable pageable, PagedResourcesAssembler assembler) {
    return new ResponseEntity<>(assembler.toResource(postoBusiness.specificSearch(nome, pageable)), HttpStatus.OK);
  }

  /**
   * Serviço exposto para recuperar a entidade de acordo com o id fornecido
   *
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET, value = "/{id}")
  public Posto get(@PathVariable("id") java.lang.String id) throws Exception {
    return postoBusiness.get(id);
  }

}
