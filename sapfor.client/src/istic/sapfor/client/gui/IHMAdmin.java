package istic.sapfor.client.gui;


import java.util.HashMap;

public interface IHMAdmin {
	

	//public boolean setStatut(Long idUv, Long idCandidat, EtatCandidatureDTO nouvelEtat, EtatCandidatureDTO ancienEtat);
	void GererInscriptionUvDir(HashMap<Long, String> st);
	void DisplayCandidat(HashMap<Long, String> cand);
	void DisplayRetenu(HashMap<Long, String> cand);
	void DisplayNonRetenu(HashMap<Long, String> cand);
	void DisplayListA(HashMap<Long, String> cand);
}
