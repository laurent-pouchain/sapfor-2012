package istic.sapfor.client.gui;


import java.util.HashMap;

public interface IHMGStage {

	
public void displayStageDispo(HashMap<Long, String> st);
public void displayUvDispo(HashMap<Long, String> uv);
public void displayAccueilAgentSuccessfull(String nameA,String fNameA, long typeAg);
public void errorLogin();



}
