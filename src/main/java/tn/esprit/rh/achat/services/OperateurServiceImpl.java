package tn.esprit.rh.achat.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.rh.achat.entities.Operateur;
import tn.esprit.rh.achat.repositories.OperateurRepository;


@Service
public class OperateurServiceImpl implements IOperateurService {

	@Autowired
	OperateurRepository operateurRepository;
	@Override
	public List<Operateur> retrieveAllOperateurs() {
		return (List<Operateur>) operateurRepository.findAll();
	}

	@Override
	public void addOperateur(Operateur o) {
		operateurRepository.save(o);
	}

	@Override
	public void deleteOperateur(Long id) {
		operateurRepository.deleteById(id);
		
	}

	@Override
	public Operateur updatesOperateurs(Operateur o) {
		operateurRepository.save(o);
		return o;
	}

	@Override
	public Operateur retrieveOperateur(Long id) {
		
		return operateurRepository.findById(id).orElse(null);
	}

}
