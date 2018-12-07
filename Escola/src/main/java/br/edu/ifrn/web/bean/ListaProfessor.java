/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.web.bean;

import br.edu.ifrn.web.controle.ProfessorControle;
import br.edu.ifrn.web.modelo.Professor;
import java.util.List;
import javax.enterprise.inject.Model;

/**
 *
 * @author anezionetto
 */
@Model
public class ListaProfessor {
    private ProfessorControle professorControl;
    private List<Professor> professorList;

    public List<Professor> listar() {
        if (professorList == null) {
            professorList = professorControl.listar();
        }
        return professorList;
    }

    
     public void excluir(Professor professor){
        professorControl.excluir(professor);
        professorList = null;
    }
    
     
     
     public String atualizar(Integer id){
        return "professor.xhtml?id=" + String.valueOf(id);
    }
     
     public String novo(){
        return "professor.xhtml?faces-redirect=true";
    }
}
