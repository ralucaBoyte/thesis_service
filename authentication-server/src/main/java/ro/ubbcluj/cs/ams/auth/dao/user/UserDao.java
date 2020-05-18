package ro.ubbcluj.cs.ams.auth.dao.user;

import org.jooq.Record;
import ro.ubbcluj.cs.ams.auth.dto.UserDto;
import ro.ubbcluj.cs.ams.auth.model.tables.records.OauthUserRecord;
import ro.ubbcluj.cs.ams.auth.model.tables.records.UserKeyphraseRecord;

import java.util.List;


public interface UserDao {
    OauthUserRecord getUser(String username);
    Integer getUserKeyphraseForUsername(String username);
    Integer saveUserKeyphrase(UserDto userDto);
    UserKeyphraseRecord getUserKeyphraseForUser(String username);
    List<OauthUserRecord> getAllProfessors();
}
