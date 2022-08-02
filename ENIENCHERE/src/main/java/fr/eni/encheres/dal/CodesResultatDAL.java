package fr.eni.encheres.dal;

/**
 * Les codes disponibles sont entre 10000 et 19999 
 */

public class CodesResultatDAL {

	/**
	 * Echec général quand tentative d'ajouter un objet null
	 */
	public static final int INSERT_OBJECT_NULL=10000;

	/**
	 * Echec général quand erreur non gérée à l'insertion
	 */
	public static final int INSERT_OBJECT_ECHEC=10001;

	/**
	 * Echec lors de la lecture
	 */
	public static final int LECTURE_ECHEC=10002;
	
	// Erreur technique
	public static final int CODE_ERREUR_TECHNIQUE=10003;
	
}
