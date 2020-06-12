package ro.ubbcluj.cs.ams.auth.dao.user.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.ubbcluj.cs.ams.auth.dao.review.impl.ReviewDaoImpl;
import ro.ubbcluj.cs.ams.auth.dao.user.UserDao;
import ro.ubbcluj.cs.ams.auth.dto.UserDto;
import ro.ubbcluj.cs.ams.auth.model.Tables;
import ro.ubbcluj.cs.ams.auth.model.tables.records.OauthUserRecord;
import ro.ubbcluj.cs.ams.auth.model.tables.records.UserKeyphraseRecord;

import java.util.List;

import static org.jooq.impl.DSL.count;

@Component
public class UserDaoImpl implements UserDao {
    @Autowired
    private DSLContext dsl;

    private final Logger logger = LogManager.getLogger(UserDaoImpl.class);


    @Override
    public OauthUserRecord getUser(String username) {
        logger.info("++++++++++++GET USER +++++++");

        OauthUserRecord user = dsl.selectFrom(Tables.OAUTH_USER)
                .where(Tables.OAUTH_USER.USERNAME.eq(username))
                .fetchOne();

        return user;
    }

    @Override
    public Integer getUserKeyphraseForUsername(String username) {
        logger.info("++++++++++++CHECK IF USER_KEYPHRASE EXISTS+++++++");

        Integer existsUserKeyphraseRecord = dsl.selectFrom(Tables.USER_KEYPHRASE)
                .where(Tables.USER_KEYPHRASE.USERNAME.eq(username))
                .fetch().size();

        return existsUserKeyphraseRecord;
    }

    @Override
    public Integer saveUserKeyphrase(UserDto userDto) {
        logger.info("++++++++++++ADD USER_KEYPHRASE+++++++");

        Integer existsUserKeyphraseRecord = dsl.insertInto(Tables.USER_KEYPHRASE,
                Tables.USER_KEYPHRASE.USERNAME, Tables.USER_KEYPHRASE.MESSAGE, Tables.USER_KEYPHRASE.KEYPHRASE)
                .values(userDto.getUsername(), userDto.getMessage(), userDto.getKeyphrase())
                .execute();

        return existsUserKeyphraseRecord;
    }

    @Override
    public UserKeyphraseRecord getUserKeyphraseForUser(String username) {
        logger.info("++++++++++++GET USER_KEYPHRASE+++++++");

        UserKeyphraseRecord userKeyphraseRecord = dsl.selectFrom(Tables.USER_KEYPHRASE)
                .where(Tables.USER_KEYPHRASE.USERNAME.eq(username))
                .fetchOne();

        return userKeyphraseRecord;
    }

    @Override
    public List<OauthUserRecord> getAllProfessors() {
        List<OauthUserRecord> professors = dsl.select()
                .from(Tables.OAUTH_USER)
                .leftOuterJoin(Tables.ROLE_USER)
                .on(Tables.OAUTH_USER.ID.eq(Tables.ROLE_USER.USER_ID))
                .leftOuterJoin(Tables.ROLE)
                .on(Tables.ROLE_USER.ROLE_ID.eq(Tables.ROLE.ID))
                .where(Tables.ROLE.NAME.eq("PROFESSOR"))
                .fetchInto(Tables.OAUTH_USER);
        return professors;
    }

    @Override
    public Integer checkIfKeyphraseExists(String keyphrase) {
        Integer exists = dsl.selectFrom(Tables.USER_KEYPHRASE)
                .where(Tables.USER_KEYPHRASE.KEYPHRASE.eq(keyphrase))
                .fetch().size();
        return exists;
    }
}
