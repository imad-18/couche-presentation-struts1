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

public class RechEtudiant extends Action {
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

        if (cin == null || cin.trim().isEmpty()) {
            request.setAttribute("error", "Veuillez saisir un CIN");
            return mapping.findForward("error");
        }

        Etudiant et = metier.searchEtudiantByCin(cin.trim());
        if (et != null) {
            request.setAttribute("etudiant", et);
            request.setAttribute("success", "Étudiant trouvé avec succès");
            System.out.println("✓ Étudiant trouvé: " + cin);
            return mapping.findForward("success");
        } else {
            request.setAttribute("error", "Aucun étudiant trouvé avec le CIN: " + cin);
            return mapping.findForward("error");
        }

    }
}
