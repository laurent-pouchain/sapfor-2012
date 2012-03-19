package istic.sapfor.client.gui;


import java.util.HashMap;
import java.util.List;

public interface IHMAdmin {
	

	//public boolean setStatut(Long idUv, Long idCandidat, EtatCandidatureDTO nouvelEtat, EtatCandidatureDTO ancienEtat);
	void GererInscriptionUvDir(HashMap<Long, String> st);
	void DisplayCandidat(String idTemp, HashMap<Long, String> cand);
	void DisplayRetenu(String idTemp, HashMap<Long, String> cand);
	void DisplayNonRetenu(String idTemp, HashMap<Long, String> cand);
	void DisplayListA(String idTemp, HashMap<Long, String> cand);
	void Rafraichir();
	
}
