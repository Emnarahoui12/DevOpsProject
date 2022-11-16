package tn.esprit.rh.achat.services;

import java.util.List;

import tn.esprit.rh.achat.entities.CategorieProduit;


public interface ICategorieProduitService {

	List<CategorieProduit> retrieveAllCategorieProduits();

	void addsCategoriesProduits(CategorieProduit cp);

	void deleteCategorieProduit(Long id);

	CategorieProduit updatesCategoriesProduits(CategorieProduit cp);

	CategorieProduit retrieveCategorieProduit(Long id);

}
