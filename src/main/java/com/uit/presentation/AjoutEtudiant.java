package com.uit.presentation;

import com.uit.metier.IEtudiantMetier;
import com.uit.model.Etudiant;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.rmi.Naming;


public class AjoutEtudiant extends Action {

    private IEtudiantMetier metier;


    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response)
            throws Exception {


        if (metier == null) {
            metier = (IEtudiantMetier) Naming.lookup("rmi://127.0.0.1:2023/etudiantService");
            System.out.println("✓ AjoutEtudiant: Connexion RMI établie");
        }


        EtudiantForm etudiantForm = (EtudiantForm) form;
        String cin = etudiantForm.getCin();
        String nom = etudiantForm.getNom();
        String prenom = etudiantForm.getPrenom();
        String email = etudiantForm.getEmail();


        if (cin == null || cin.trim().isEmpty() ||
                nom == null || nom.trim().isEmpty() ||
                prenom == null || prenom.trim().isEmpty() ||
                email == null || email.trim().isEmpty()) {

            request.setAttribute("error", "Tous les champs sont obligatoires");
            return mapping.findForward("error");
        }


        Etudiant etudiant = new Etudiant(
                cin.trim(),
                nom.trim(),
                prenom.trim(),
                email.trim()
        );


        boolean result = metier.addEtudiant(etudiant);

        if (result) {
            request.setAttribute("success", "Étudiant ajouté avec succès");
            System.out.println("Étudiant ajouté avec succès");
            request.setAttribute("etudiant", etudiant);

            return mapping.findForward("success");
        } else {
            request.setAttribute("error", "Échec de l'ajout de l'étudiant");
            return mapping.findForward("error");
        }
    }
}