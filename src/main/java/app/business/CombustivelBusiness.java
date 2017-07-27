package app.business;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.*;
import app.dao.*;
import app.entity.*;

/**
 * Classe que representa a camada de negócios de CombustivelBusiness
 * 
 * @generated
 **/
@Service("CombustivelBusiness")
public class CombustivelBusiness {

  private static final Logger log = LoggerFactory.getLogger(CombustivelBusiness.class);


  /**
   * Instância da classe CombustivelDAO que faz o acesso ao banco de dados
   * 
   * @generated
   */
  @Autowired
  @Qualifier("CombustivelDAO")
  protected CombustivelDAO repository;

  // CRUD

  /**
   * Serviço exposto para novo registro de acordo com a entidade fornecida
   * 
   * @generated
   */
  public Combustivel post(final Combustivel entity) throws Exception {
    // begin-user-code  
    // end-user-code  
    Combustivel result = null;
    result = repository.save(entity);
    // begin-user-code
    // end-user-code
    return result;
  }

  /**
   * Serviço exposto para salvar alterações de acordo com a entidade fornecida
   * 
   * @generated
   */
  public Combustivel put(final Combustivel entity) throws Exception {
    // begin-user-code  
    // end-user-code
    Combustivel result = null;
    result = repository.saveAndFlush(entity);
    // begin-user-code
    // end-user-code
    return result;
  }

  /**
   * Serviço exposto para remover a entidade de acordo com o id fornecido
   * 
   * @generated
   */
  public void delete(java.lang.String id) throws Exception {
    // begin-user-code  
    // end-user-code
    Combustivel entity = this.get(id);
    this.repository.delete(entity);
    // begin-user-code  
    // end-user-code        
  }
  
  /**
   * Serviço exposto para recuperar a entidade de acordo com o id fornecido
   * 
   * @generated
   */
  public Combustivel get(java.lang.String id) throws Exception {
    // begin-user-code  
    // end-user-code
    Combustivel result = repository.findOne(id);
    // begin-user-code
    // end-user-code
    return result;
  }

  // CRUD
  
  /**
   * Lista com paginação de acordo com a NamedQuery
   * 
   * @generated
   */
  public Page<Combustivel> list(Pageable pageable){
    // begin-user-code
    // end-user-code
    Page<Combustivel> result = repository.list(pageable);
    // begin-user-code
    // end-user-code
    return result;
  }
}