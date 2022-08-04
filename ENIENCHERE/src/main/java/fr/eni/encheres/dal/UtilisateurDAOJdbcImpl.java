package fr.eni.encheres.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.encheres.messages.BusinessException;
import fr.eni.encheres.bo.Utilisateur;


public class UtilisateurDAOJdbcImpl implements UtilisateurDAO {

	
	private static final String INSERT_TEST="INSERT INTO CATEGORIES(libelle) VALUES(?);";
	private static final String INSERT_UTILISATEUR="INSERT INTO UTILISATEURS(pseudo,nom,prenom,email,telephone,rue,code_postal,ville,mot_de_passe,credit,administrateur) values (?,?,?,?,?,?,?,?,?,?,?)";
	private static final String SELECT_UTILISATEUR_BY_PSEUDO="SELECT no_utilisateur,pseudo,nom,prenom,email,telephone,rue,code_postal,ville,mot_de_passe,credit,administrateur FROM UTILISATEURS WHERE PSEUDO=?";
	private static final String SELECT_UTILISATEUR_BY_EMAIL="SELECT no_utilisateur,pseudo,nom,prenom,email,telephone,rue,code_postal,ville,mot_de_passe,credit,administrateur FROM UTILISATEURS WHERE email=?";
	private static final String UPDATE_UTILISATEUR="UPDATE UTILISATEURS SET PSEUDO=?,NOM=?,PRENOM=?,EMAIL=?,TELEPHONE=?,RUE=?,CODE_POSTAL=?,VILLE=?,MOT_DE_PASSE=? WHERE PSEUDO=?";
	private static final String SELECT_UTILISATEUR_BY_ID="SELECT no_utilisateur,pseudo,nom,prenom,email,telephone,rue,code_postal,ville,mot_de_passe,credit,administrateur FROM UTILISATEURS WHERE no_utilisateur=?";
		
	@Override
	public void testConnexion() {
		try
		{
		Connection cnx = ConnectionProvider.getConnection();
		
			PreparedStatement pstmt = cnx.prepareStatement(INSERT_TEST, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, "JULIEN");
			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			if(rs.next())
			{
				//repas.setIdRepas(rs.getInt(1));
			}
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void ajouterUtilisateur(Utilisateur utilisateur) throws BusinessException {
		try (Connection cnx = ConnectionProvider.getConnection();
				PreparedStatement pstmt = cnx.prepareStatement(INSERT_UTILISATEUR,PreparedStatement.RETURN_GENERATED_KEYS);) {
			pstmt.setString(1, utilisateur.getPseudo());
			pstmt.setString(2, utilisateur.getNom());
			pstmt.setString(3, utilisateur.getPrenom());
			pstmt.setString(4, utilisateur.getEmail());
			pstmt.setString(5, utilisateur.getTelephone());
			pstmt.setString(6, utilisateur.getRue());
			pstmt.setString(7, utilisateur.getCode_postal());
			pstmt.setString(8, utilisateur.getVille());
			pstmt.setString(9, utilisateur.getMot_de_passe());
			pstmt.setInt(  10, utilisateur.getCredit());
			pstmt.setInt(  11, utilisateur.getAdministrateur());

			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				utilisateur.setNo_utilisateur(rs.getInt(1));
			}
		} catch (SQLException e) {
			BusinessException be = new BusinessException();
			be.ajouterErreur(CodesResultatDAL.CODE_ERREUR_TECHNIQUE);
			try {
				e.printStackTrace();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			throw be;
		}

		//return utilisateur;
		
	}

	@Override
	/**
	 * Renvoi un utilisateur si le pseudo passé en paramêtre existe en BDD
	 */
	public Utilisateur selectUserByPseudo(String pseudo) throws BusinessException {
		Utilisateur utilisateur = null;
		try (Connection cnx = ConnectionProvider.getConnection();
				PreparedStatement pstmt = cnx.prepareStatement(SELECT_UTILISATEUR_BY_PSEUDO);) {
			pstmt.setString(1, pseudo);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					utilisateur = new Utilisateur(rs.getInt("no_utilisateur"), rs.getString("pseudo"),
							rs.getString("nom"), rs.getString("prenom"), rs.getString("email"),
							rs.getString("telephone"), rs.getString("rue"), rs.getString("code_postal"),
							rs.getString("ville"), rs.getString("mot_de_passe"), rs.getInt("credit"),
							rs.getInt("administrateur"));
				
				} 
				return utilisateur;	
			} catch (Exception e) {
				BusinessException be = new BusinessException();
				be.ajouterErreur(CodesResultatDAL.CODE_ERREUR_TECHNIQUE);
				throw be;
			}
		} catch (Exception e) {
			BusinessException be = new BusinessException();
			be.ajouterErreur(CodesResultatDAL.CODE_ERREUR_TECHNIQUE);
			throw be;
		}
	}

	@Override
	public Utilisateur selectUserByMail(String email) throws BusinessException {
		Utilisateur utilisateur = null;
		try (Connection cnx = ConnectionProvider.getConnection();
				PreparedStatement pstmt = cnx.prepareStatement(SELECT_UTILISATEUR_BY_EMAIL);) {
			pstmt.setString(1, email);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					utilisateur = new Utilisateur(rs.getInt("no_utilisateur"), rs.getString("pseudo"),
							rs.getString("nom"), rs.getString("prenom"), rs.getString("email"),
							rs.getString("telephone"), rs.getString("rue"), rs.getString("code_postal"),
							rs.getString("ville"), rs.getString("mot_de_passe"), rs.getInt("credit"),
							rs.getInt("administrateur"));
				
				} 
				return utilisateur;	
			} catch (Exception e) {
				BusinessException be = new BusinessException();
				be.ajouterErreur(CodesResultatDAL.CODE_ERREUR_TECHNIQUE);
				throw be;
			}
		} catch (Exception e) {
			BusinessException be = new BusinessException();
			be.ajouterErreur(CodesResultatDAL.CODE_ERREUR_TECHNIQUE);
			throw be;
		}
	}


	/**
	 * Modification de l'utilisateur par le pseudo vu que celui-ci est unique (on aurait pu aussi prendre l'id)
	 * @throws BusinessException 
	 */
	@Override
	public void ModifierUtilisateur(Utilisateur utilisateur) throws BusinessException {
		try (Connection cnx = ConnectionProvider.getConnection();
				PreparedStatement pstmt = cnx.prepareStatement(UPDATE_UTILISATEUR);) {
			pstmt.setString(1, utilisateur.getPseudo());
			pstmt.setString(2, utilisateur.getNom());
			pstmt.setString(3, utilisateur.getPrenom());
			pstmt.setString(4, utilisateur.getEmail());
			pstmt.setString(5, utilisateur.getTelephone());
			pstmt.setString(6, utilisateur.getRue());
			pstmt.setString(7, utilisateur.getTelephone());
			pstmt.setString(8, utilisateur.getVille());
			pstmt.setString(9, utilisateur.getMot_de_passe());
			pstmt.setString(10, utilisateur.getPseudo());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			BusinessException be = new BusinessException();
			be.ajouterErreur(CodesResultatDAL.CODE_ERREUR_TECHNIQUE);
			e.printStackTrace();
			throw be;
		}
		
	}

	@Override
	public Utilisateur recupererUtilisateurParId(Integer id) throws BusinessException {
		Utilisateur utilisateur = null;
		try (Connection cnx = ConnectionProvider.getConnection();
				PreparedStatement pstmt = cnx.prepareStatement(SELECT_UTILISATEUR_BY_ID);) {
			pstmt.setInt(1, id);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					utilisateur = new Utilisateur(rs.getInt("no_utilisateur"), rs.getString("pseudo"),
							rs.getString("nom"), rs.getString("prenom"), rs.getString("email"),
							rs.getString("telephone"), rs.getString("rue"), rs.getString("code_postal"),
							rs.getString("ville"), rs.getString("mot_de_passe"), rs.getInt("credit"),
							rs.getInt("administrateur"));
				
				} 
				return utilisateur;	
			} catch (Exception e) {
				BusinessException be = new BusinessException();
				be.ajouterErreur(CodesResultatDAL.CODE_ERREUR_TECHNIQUE);
				throw be;
			}
		} catch (Exception e) {
			BusinessException be = new BusinessException();
			be.ajouterErreur(CodesResultatDAL.CODE_ERREUR_TECHNIQUE);
			throw be;
		}
	}

	

}
