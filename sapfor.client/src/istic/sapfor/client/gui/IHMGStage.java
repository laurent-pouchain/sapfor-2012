package istic.sapfor.client.gui;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface IHMGStage {

public void displayStageDir(HashMap<Long,String> stDir);	
public void displayStageDispo(HashMap<Long, String> st);
public void displayUvDispo(HashMap<Long, String> uv,HashMap<Long, String> uvDispoInscrit);
public void displayAccueilAgentSuccessfull(String nameA,String fNameA, long typeAg);
public void errorLogin();
public void displayAgent(Map<Long, String> nomAgent);





}
