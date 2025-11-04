package com.uit.presentation;


import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;


public class EtudiantForm extends ActionForm {


    private String cin;
    private String nom;
    private String prenom;
    private String email;


    public EtudiantForm() {
    }

    // Getters et Setters
    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request){
        // TODO Auto-generated method stub
        return  super.validate(mapping, request);
    }


    @Override
    public void reset(org.apache.struts.action.ActionMapping mapping,
                      javax.servlet.http.HttpServletRequest request) {
        this.cin = null;
        this.nom = null;
        this.prenom = null;
        this.email = null;
    }

}