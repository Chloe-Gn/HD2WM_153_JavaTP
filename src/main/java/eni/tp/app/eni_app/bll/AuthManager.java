package eni.tp.app.eni_app.bll;

import eni.tp.app.eni_app.bo.Member;
import eni.tp.app.eni_app.dao.IDAOAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthManager {

    @Autowired
    IDAOAuth idaoAuth;

    public EniManagerResponse<Member> authenticate(String email, String password) {

        // chercher si un membre a l'email et le mot de passe envoyés

        Member foundMember = idaoAuth.login(email, password);

        // si couple email/mdp incorrect : erreur code 756
    if (foundMember == null) {
        return EniManagerResponse.performResponse("756","Couple email/mdp incorrect", null);
    }


        // Sinon code 202
        return EniManagerResponse.performResponse("202","Vous êtes connecté(e) avec succès.", foundMember);
    }

}
