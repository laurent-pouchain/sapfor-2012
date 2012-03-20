package istic.sapfor.client.gui;

import java.util.HashMap;

public interface IHMAdmin {

	void GererInscriptionUvDir(HashMap<Long, String> st);

	void DisplayCandidat(String idTemp, HashMap<Long, String> cand);

	void DisplayRetenu(String idTemp, HashMap<Long, String> cand);

	void DisplayNonRetenu(String idTemp, HashMap<Long, String> cand);

	void DisplayListA(String idTemp, HashMap<Long, String> cand);

	void Rafraichir();

}
