/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.web.bean;

import br.edu.ifrn.web.controle.ProfessorControle;
import br.edu.ifrn.web.modelo.Professor;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.Part;

/**
 *
 * @author anezionetto
 */
@Model
public class ProfessorBean {

    @Inject
    private ProfessorControle professorDao;
    @Inject
    private Professor professorModel;
    @Inject
    private FacesContext facesContext;

    private Part fotoProfessor;

    private int idBean;

    public ProfessorControle getProfessorDao() {
        return professorDao;
    }

    public void setProfessorDao(ProfessorControle professorDao) {
        this.professorDao = professorDao;
    }

    public Professor getProfessorModel() {
        return professorModel;
    }

    public void setProfessorModel(Professor professorModel) {
        this.professorModel = professorModel;
    }

    public Part getFotoProfessor() {
        return fotoProfessor;
    }

    public void setFotoProfessor(Part fotoProfessor) {
        this.fotoProfessor = fotoProfessor;
    }

    public int getIdBean() {
        return idBean;
    }

    public void setIdBean(int idBean) {
        this.idBean = idBean;
    }

    public FacesContext getFacesContext() {
        return facesContext;
    }

    public void setFacesContext(FacesContext facesContext) {
        this.facesContext = facesContext;
    }

    public String salvarProfessor() {
        String path = "/professor/";
        String mensagem;
        if (professorModel.getId() != 0) {
            professorDao.atualizar(professorModel);
            mensagem = "Professor Atualizado com sucesso";
        } else {
            professorDao.salvar(professorModel);
            mensagem = "Professor salvo com sucesso";
        }

        professorModel = new Professor();
        facesContext.getExternalContext().getFlash().setKeepMessages(true);
        facesContext.addMessage(null, new FacesMessage(mensagem));

        return "professor.xhtml";

    }
}
