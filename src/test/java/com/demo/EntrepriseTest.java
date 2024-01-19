package com.demo;

import com.demo.tpEntreprises.Employe;
import com.demo.tpEntreprises.Entreprise;
import com.demo.tpEntreprises.GenericDAO;
import com.demo.tpEntreprises.Projet;
import com.demo.tpVoiture.Voiture;
import com.demo.tpVoiture.VoitureDAO;
import org.junit.jupiter.api.Test;

public class EntrepriseTest
{
    GenericDAO<Employe> employeDAO = new GenericDAO<>(Employe.class);
    GenericDAO<Entreprise> entrepriseDAO = new GenericDAO<>(Entreprise.class);
    GenericDAO<Projet> projetDAO = new GenericDAO<>(Projet.class);

    @Test
    public void testEntreprise(){

        Employe employe1 = new Employe("JC", "Dominguez");
        employeDAO.save(employe1);

        Employe employe2 = new Employe("Marie", "Durand");
        employeDAO.save(employe2);

        Employe employe3 = new Employe("Alex", "Dupont");
        employeDAO.save(employe3);

        Employe employe4 = new Employe("Eric", "Larremdy");
        employeDAO.save(employe4);

        Entreprise google = new Entreprise("Google");
        google.addEmploye(employe1);
        google.addEmploye(employe2);
        entrepriseDAO.save(google);

        Entreprise facebook = new Entreprise("Facebook");
        facebook.addEmploye(employe3);
        entrepriseDAO.save(facebook);

        Projet projet1 = new Projet("CRM");
        projet1.addEmploye(employe1);
        projetDAO.save(projet1);

        Projet projet2 = new Projet("Slack");
        projet2.addEmploye(employe2);
        projet2.addEmploye(employe3);
        projetDAO.save(projet2);
    }

    @Test
    void testSuppressionCascade(){
        Entreprise entreprise = entrepriseDAO.findById(1);
        entrepriseDAO.delete(entreprise);
    }

}
