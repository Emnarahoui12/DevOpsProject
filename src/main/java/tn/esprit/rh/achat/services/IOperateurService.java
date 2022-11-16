package tn.esprit.rh.achat.services;

import java.util.List;

import tn.esprit.rh.achat.entities.Operateur;


public interface IOperateurService {

	List<Operateur> retrieveAllOperateurs();

	void addOperateur(Operateur o);

	void deleteOperateur(Long id);

	Operateur updatesOperateurs(Operateur o);

	Operateur retrieveOperateur(Long id);

}
