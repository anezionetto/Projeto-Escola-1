/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.web.controle;

import br.edu.ifrn.web.modelo.Professor;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 *
 * @author anezionetto
 */
public class ProfessorControle {

    @PersistenceContext
    private EntityManager entityManeger;

    @Transactional
    public void salvar(Professor professor) {
        entityManeger.persist(professor);
    }
    @Transactional
    public void atualizar(Professor professor) {
        entityManeger.merge(professor);
    }


     public List<Professor> listar(){
        
        return entityManeger.createQuery("from professor").getResultList();
    }
   /* public void buscar(Integer id){
        entityManeger.find(type, aluno)
    }*/

    public void excluir(Professor professor){
        entityManeger.remove(professor);
    } 
}
