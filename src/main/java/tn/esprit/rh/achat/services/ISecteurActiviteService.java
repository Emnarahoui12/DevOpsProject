package tn.esprit.rh.achat.services;

import java.util.List;

import tn.esprit.rh.achat.entities.SecteurActivite;

public interface ISecteurActiviteService {

	List<SecteurActivite> retrieveAllSecteurActivite();

	void addSecteurActivite(SecteurActivite sa);

	void deleteSecteurActivite(Long id);

	SecteurActivite editSecteur1(SecteurActivite sa);

	SecteurActivite retrieveSecteurActivite(Long id);

}
