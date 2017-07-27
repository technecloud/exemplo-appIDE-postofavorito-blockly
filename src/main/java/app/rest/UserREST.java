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
 * Controller para expor serviços REST de User
 *
 * @generated
 **/
@RestController
@RequestMapping(value = "/api/security/User")
public class UserREST {

  /**
   * Classe de negócio para manipulação de dados
   *
   * @generated
   */
  @Autowired
  @Qualifier("UserBusiness")
  private UserBusiness userBusiness;

  /**
   * @generated
   */
  @Autowired
  @Qualifier("PostoBusiness")
  private PostoBusiness postoBusiness;
  /**
   * @generated
   */
  @Autowired
  @Qualifier("CarroBusiness")
  private CarroBusiness carroBusiness;
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
   * Serviço exposto para novo registro de acordo com a entidade fornecida
   *
   * @generated
   */
  @RequestMapping(method = RequestMethod.POST)
  public User post(@Validated @RequestBody final User entity) throws Exception {
    return userBusiness.post(entity);
  }

  /**
   * Serviço exposto para salvar alterações de acordo com a entidade fornecida
   *
   * @generated
   */
  @RequestMapping(method = RequestMethod.PUT)
  public User put(@Validated @RequestBody final User entity) throws Exception {
    return userBusiness.put(entity);
  }

  /**
   * Serviço exposto para salvar alterações de acordo com a entidade e id fornecidos
   * 
   * @generated
   */
  @RequestMapping(method = RequestMethod.PUT, value = "/{userId}")
  public User put(@Validated @RequestBody final User entity, @PathVariable("userId") java.lang.String userId) throws Exception {
    return userBusiness.put(entity);
  }  

  /**
   * Serviço exposto para remover a entidade de acordo com o id fornecido
   * 
   * @generated
   */
  @RequestMapping(method = RequestMethod.DELETE, value = "/{userId}")
  public void delete(@PathVariable("userId") java.lang.String userId) throws Exception {
    userBusiness.delete(userId);
  }

  /**
   * NamedQuery list
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET
  )
  public HttpEntity<PagedResources<User>> listParams (Pageable pageable, PagedResourcesAssembler assembler){
    return new ResponseEntity<>(assembler.toResource(userBusiness.list(pageable)), HttpStatus.OK);
  }
  /**
   * NamedQuery findByRole
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET
  , value="/findByRole/{roleid}")
  public HttpEntity<PagedResources<User>> findByRoleParams (@PathVariable("roleid") java.lang.String roleid, Pageable pageable, PagedResourcesAssembler assembler){
    return new ResponseEntity<>(assembler.toResource(userBusiness.findByRole(roleid, pageable)), HttpStatus.OK);
  }
  /**
   * NamedQuery findByLogin
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET
  , value="/findByLogin/{login}")
  public HttpEntity<PagedResources<User>> findByLoginParams (@PathVariable("login") java.lang.String login, Pageable pageable, PagedResourcesAssembler assembler){
    return new ResponseEntity<>(assembler.toResource(userBusiness.findByLogin(login, pageable)), HttpStatus.OK);
  }


  /**
   * OneToMany Relationship GET
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET
  , value="/{instanceId}/Carro")
  public HttpEntity<PagedResources<Carro>> findCarro(@PathVariable("instanceId") java.lang.String instanceId, Pageable pageable, PagedResourcesAssembler assembler) {
    return new ResponseEntity<>(assembler.toResource(userBusiness.findCarro(instanceId, pageable)), HttpStatus.OK);
  }

  /**
   * OneToMany Relationship DELETE
   * @generated
   */
  @RequestMapping(method = RequestMethod.DELETE
  , value="/{instanceId}/Carro/{relationId}")
  public void deleteCarro(@PathVariable("relationId") java.lang.String relationId) throws Exception {
    this.carroBusiness.delete(relationId);
  }

  /**
   * OneToMany Relationship PUT
   * @generated
   */
  @RequestMapping(method = RequestMethod.PUT
  , value="/{instanceId}/Carro/{relationId}")
  public Carro putCarro(@Validated @RequestBody final Carro entity, @PathVariable("relationId") java.lang.String relationId) throws Exception {
    return this.carroBusiness.put(entity);
  }

  /**
   * OneToMany Relationship POST
   * @generated
   */
  @RequestMapping(method = RequestMethod.POST
  , value="/{instanceId}/Carro")
  public Carro postCarro(@Validated @RequestBody final Carro entity, @PathVariable("instanceId") java.lang.String instanceId) throws Exception {
  User user = this.userBusiness.get(instanceId);
  entity.setUser(user);
    return this.carroBusiness.post(entity);
  }

  /**
   * OneToMany Relationship GET - Searchable fields - General search (Only strings fields)
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET, value="/{instanceId}/Comentario/generalSearch")
  public HttpEntity<PagedResources<Comentario>> findComentarioGeneralSearch(java.lang.String search, @PathVariable("instanceId") java.lang.String instanceId, Pageable pageable, PagedResourcesAssembler assembler) {
    return new ResponseEntity<>(assembler.toResource(userBusiness.findComentarioGeneralSearch(search, instanceId, pageable)), HttpStatus.OK);
  }

  /**
   * OneToMany Relationship GET - Searchable fields - Specific search
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET
  , value="/{instanceId}/Comentario/specificSearch")
  public HttpEntity<PagedResources<Comentario>> findComentarioSpecificSearch(@PathVariable("instanceId") java.lang.String instanceId, java.lang.String data, java.lang.String texto, java.lang.Boolean moderado, Pageable pageable, PagedResourcesAssembler assembler) {
    return new ResponseEntity<>(assembler.toResource(userBusiness.findComentarioSpecificSearch(instanceId, data, texto, moderado, pageable)), HttpStatus.OK);
  }

  /**
   * OneToMany Relationship GET
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET
  , value="/{instanceId}/Comentario")
  public HttpEntity<PagedResources<Comentario>> findComentario(@PathVariable("instanceId") java.lang.String instanceId, Pageable pageable, PagedResourcesAssembler assembler) {
    return new ResponseEntity<>(assembler.toResource(userBusiness.findComentario(instanceId, pageable)), HttpStatus.OK);
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
  User user = this.userBusiness.get(instanceId);
  entity.setUser(user);
    return this.comentarioBusiness.post(entity);
  }


  /**
   * OneToMany Relationship GET
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET
  , value="/{instanceId}/Abastecimento")
  public HttpEntity<PagedResources<Abastecimento>> findAbastecimento(@PathVariable("instanceId") java.lang.String instanceId, Pageable pageable, PagedResourcesAssembler assembler) {
    return new ResponseEntity<>(assembler.toResource(userBusiness.findAbastecimento(instanceId, pageable)), HttpStatus.OK);
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
  User user = this.userBusiness.get(instanceId);
  entity.setUser(user);
    return this.abastecimentoBusiness.post(entity);
  }

  /**
   * ManyToMany Relationship GET - Searchable fields - General search (Only strings fields)
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET
  ,value="/{instanceId}/Posto/generalSearch")
  public HttpEntity<PagedResources<Posto>> listPostoGeneralSearch(java.lang.String search, @PathVariable("instanceId") java.lang.String instanceId, Pageable pageable, PagedResourcesAssembler assembler) {
    return new ResponseEntity<>(assembler.toResource(userBusiness.listPostoGeneralSearch(search, instanceId, pageable)), HttpStatus.OK);
  }

  /**
   * ManyToMany Relationship GET - Searchable fields - Specific search
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET
  ,value="/{instanceId}/Posto/specificSearch")
  public HttpEntity<PagedResources<Posto>> listPostoSpecificSearch(@PathVariable("instanceId") java.lang.String instanceId, java.lang.String nome, Pageable pageable, PagedResourcesAssembler assembler) {
    return new ResponseEntity<>(assembler.toResource(userBusiness.listPostoSpecificSearch(instanceId, nome, pageable)), HttpStatus.OK);
  }

  /**
   * ManyToMany Relationship GET
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET
  ,value="/{instanceId}/Posto")
  public HttpEntity<PagedResources<Posto>> listPosto(@PathVariable("instanceId") java.lang.String instanceId, Pageable pageable, PagedResourcesAssembler assembler) {
    return new ResponseEntity<>(assembler.toResource(userBusiness.listPosto(instanceId, pageable)), HttpStatus.OK);
  }

  /**
   * ManyToMany Relationship POST
   * @generated
   */
  @RequestMapping(method = RequestMethod.POST
  ,value="/{instanceId}/Posto")
  public User postPosto(@Validated @RequestBody final Posto entity, @PathVariable("instanceId") java.lang.String instanceId) throws Exception {
    Comentario newComentario = new Comentario();

    User instance = this.userBusiness.get(instanceId);

    newComentario.setPosto(entity);
    newComentario.setUser(instance);

    this.comentarioBusiness.post(newComentario);

    return newComentario.getUser();
  }

  /**
   * ManyToMany Relationship DELETE
   * @generated
   */
  @RequestMapping(method = RequestMethod.DELETE
  ,value="/{instanceId}/Posto/{relationId}")
  public void deletePosto(@PathVariable("instanceId") java.lang.String instanceId, @PathVariable("relationId") java.lang.String relationId) {
    this.userBusiness.deletePosto(instanceId, relationId);
  }

  /**
   * Searchable fields - General search (Only strings fields)
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET, value = "/generalSearch")
  public HttpEntity<PagedResources<User>> generalSearch(java.lang.String search, Pageable pageable, PagedResourcesAssembler assembler) {
    return new ResponseEntity<>(assembler.toResource(userBusiness.generalSearch(search, pageable)), HttpStatus.OK);
  }

  /**
   * Searchable fields - Specific search
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET, value = "/specificSearch")
  public HttpEntity<PagedResources<User>> specificSearch(java.lang.String email, java.lang.String name, java.lang.String login, Pageable pageable, PagedResourcesAssembler assembler) {
    return new ResponseEntity<>(assembler.toResource(userBusiness.specificSearch(email, name, login, pageable)), HttpStatus.OK);
  }

  /**
   * Serviço exposto para recuperar a entidade de acordo com o id fornecido
   *
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET, value = "/{id}")
  public User get(@PathVariable("id") java.lang.String id) throws Exception {
    return userBusiness.get(id);
  }

}
