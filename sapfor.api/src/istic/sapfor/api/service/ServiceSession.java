package istic.sapfor.api.service;

import javax.jws.WebService;

import istic.sapfor.api.dto.SessionDTO;

@WebService
public interface ServiceSession {
	
	/**
	 * Renvois une session liée à un identificateur d'agent afin de reconnaitre
	 * les communications entre le serveur et le client
	 * @param user      nom d'utilisateur de l'agent (peut être différent de son nom et son prénom)
	 * @param password  mot de passe permettant d'identifier l'utilisateur
	 * @return un objet de type SessionDTO contenant l'identificateur de l'agent
	 */
	SessionDTO login(String user, String password);
	
	/**
	 * Permet la déconnexion d'un agent en renvoyant sa session en tant qu'utilisateur.
	 * @param session
	 * @return un boolean qui permet de statuer sur la réussite de la déconnexion.
	 */
	boolean logout(SessionDTO session);

}
