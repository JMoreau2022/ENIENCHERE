package fr.eni.encheres.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.encheres.messages.BusinessException;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.CodesResultatDAL;


public class UtilisateurDAOJdbcImpl implements UtilisateurDAO {

	
	private static final String INSERT_TEST="INSERT INTO CATEGORIES(libelle) VALUES(?);";
	private static final String INSERT_UTILISATEUR="INSERT INTO UTILISATEURS(pseudo,nom,prenom,email,telephone,rue,code_postal,ville,mot_de_passe,credit,administrateur) values (?,?,?,?,?,?,?,?,?,?,?)";
		
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

	

}
