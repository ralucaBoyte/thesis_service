/*
 * This file is generated by jOOQ.
 */
package ro.ubbcluj.cs.ams.auth.model;


import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.Internal;

import ro.ubbcluj.cs.ams.auth.model.tables.FlywaySchemaHistory;
import ro.ubbcluj.cs.ams.auth.model.tables.OauthClientDetails;
import ro.ubbcluj.cs.ams.auth.model.tables.OauthUser;
import ro.ubbcluj.cs.ams.auth.model.tables.Permission;
import ro.ubbcluj.cs.ams.auth.model.tables.PermissionRole;
import ro.ubbcluj.cs.ams.auth.model.tables.Reviews;
import ro.ubbcluj.cs.ams.auth.model.tables.Role;
import ro.ubbcluj.cs.ams.auth.model.tables.RoleUser;
import ro.ubbcluj.cs.ams.auth.model.tables.UserKeyphrase;
import ro.ubbcluj.cs.ams.auth.model.tables.records.FlywaySchemaHistoryRecord;
import ro.ubbcluj.cs.ams.auth.model.tables.records.OauthClientDetailsRecord;
import ro.ubbcluj.cs.ams.auth.model.tables.records.OauthUserRecord;
import ro.ubbcluj.cs.ams.auth.model.tables.records.PermissionRecord;
import ro.ubbcluj.cs.ams.auth.model.tables.records.PermissionRoleRecord;
import ro.ubbcluj.cs.ams.auth.model.tables.records.ReviewsRecord;
import ro.ubbcluj.cs.ams.auth.model.tables.records.RoleRecord;
import ro.ubbcluj.cs.ams.auth.model.tables.records.RoleUserRecord;
import ro.ubbcluj.cs.ams.auth.model.tables.records.UserKeyphraseRecord;


/**
 * A class modelling foreign key relationships and constraints of tables of 
 * the <code>public</code> schema.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // IDENTITY definitions
    // -------------------------------------------------------------------------

    public static final Identity<OauthUserRecord, Integer> IDENTITY_OAUTH_USER = Identities0.IDENTITY_OAUTH_USER;
    public static final Identity<PermissionRecord, Integer> IDENTITY_PERMISSION = Identities0.IDENTITY_PERMISSION;
    public static final Identity<PermissionRoleRecord, Integer> IDENTITY_PERMISSION_ROLE = Identities0.IDENTITY_PERMISSION_ROLE;
    public static final Identity<ReviewsRecord, Integer> IDENTITY_REVIEWS = Identities0.IDENTITY_REVIEWS;
    public static final Identity<RoleRecord, Integer> IDENTITY_ROLE = Identities0.IDENTITY_ROLE;
    public static final Identity<RoleUserRecord, Integer> IDENTITY_ROLE_USER = Identities0.IDENTITY_ROLE_USER;
    public static final Identity<UserKeyphraseRecord, Integer> IDENTITY_USER_KEYPHRASE = Identities0.IDENTITY_USER_KEYPHRASE;

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<FlywaySchemaHistoryRecord> FLYWAY_SCHEMA_HISTORY_PK = UniqueKeys0.FLYWAY_SCHEMA_HISTORY_PK;
    public static final UniqueKey<OauthClientDetailsRecord> PK_OAUTH_CLIENT_DETAILS = UniqueKeys0.PK_OAUTH_CLIENT_DETAILS;
    public static final UniqueKey<OauthUserRecord> PK_USER = UniqueKeys0.PK_USER;
    public static final UniqueKey<OauthUserRecord> UK_USER = UniqueKeys0.UK_USER;
    public static final UniqueKey<PermissionRecord> PK_PERMISSION = UniqueKeys0.PK_PERMISSION;
    public static final UniqueKey<PermissionRecord> UK_PERMISSION = UniqueKeys0.UK_PERMISSION;
    public static final UniqueKey<PermissionRoleRecord> PK_PERMISSION_ROLE = UniqueKeys0.PK_PERMISSION_ROLE;
    public static final UniqueKey<ReviewsRecord> PK_REVIEWS = UniqueKeys0.PK_REVIEWS;
    public static final UniqueKey<RoleRecord> PK_ROLE = UniqueKeys0.PK_ROLE;
    public static final UniqueKey<RoleRecord> UK_ROLE = UniqueKeys0.UK_ROLE;
    public static final UniqueKey<RoleUserRecord> PK_ROLE_USER = UniqueKeys0.PK_ROLE_USER;
    public static final UniqueKey<UserKeyphraseRecord> PK_USER_KEYPHRASE = UniqueKeys0.PK_USER_KEYPHRASE;
    public static final UniqueKey<UserKeyphraseRecord> PK_USER_UNIQUES = UniqueKeys0.PK_USER_UNIQUES;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------

    public static final ForeignKey<PermissionRoleRecord, PermissionRecord> PERMISSION_ROLE__FK1_PERMISSION_ROLE = ForeignKeys0.PERMISSION_ROLE__FK1_PERMISSION_ROLE;
    public static final ForeignKey<PermissionRoleRecord, RoleRecord> PERMISSION_ROLE__FK2_PERMISSION_ROLE = ForeignKeys0.PERMISSION_ROLE__FK2_PERMISSION_ROLE;
    public static final ForeignKey<ReviewsRecord, OauthUserRecord> REVIEWS__FK1_REVIEW_PROFESSOR = ForeignKeys0.REVIEWS__FK1_REVIEW_PROFESSOR;
    public static final ForeignKey<ReviewsRecord, OauthUserRecord> REVIEWS__FK1_REVIEW_STUDENT = ForeignKeys0.REVIEWS__FK1_REVIEW_STUDENT;
    public static final ForeignKey<RoleUserRecord, RoleRecord> ROLE_USER__FK1_ROLE_USER = ForeignKeys0.ROLE_USER__FK1_ROLE_USER;
    public static final ForeignKey<RoleUserRecord, OauthUserRecord> ROLE_USER__FK2_ROLE_USER = ForeignKeys0.ROLE_USER__FK2_ROLE_USER;
    public static final ForeignKey<UserKeyphraseRecord, OauthUserRecord> USER_KEYPHRASE__FK_USERNAME = ForeignKeys0.USER_KEYPHRASE__FK_USERNAME;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Identities0 {
        public static Identity<OauthUserRecord, Integer> IDENTITY_OAUTH_USER = Internal.createIdentity(OauthUser.OAUTH_USER, OauthUser.OAUTH_USER.ID);
        public static Identity<PermissionRecord, Integer> IDENTITY_PERMISSION = Internal.createIdentity(Permission.PERMISSION, Permission.PERMISSION.ID);
        public static Identity<PermissionRoleRecord, Integer> IDENTITY_PERMISSION_ROLE = Internal.createIdentity(PermissionRole.PERMISSION_ROLE, PermissionRole.PERMISSION_ROLE.PERMISSION_ID);
        public static Identity<ReviewsRecord, Integer> IDENTITY_REVIEWS = Internal.createIdentity(Reviews.REVIEWS, Reviews.REVIEWS.ID);
        public static Identity<RoleRecord, Integer> IDENTITY_ROLE = Internal.createIdentity(Role.ROLE, Role.ROLE.ID);
        public static Identity<RoleUserRecord, Integer> IDENTITY_ROLE_USER = Internal.createIdentity(RoleUser.ROLE_USER, RoleUser.ROLE_USER.ROLE_ID);
        public static Identity<UserKeyphraseRecord, Integer> IDENTITY_USER_KEYPHRASE = Internal.createIdentity(UserKeyphrase.USER_KEYPHRASE, UserKeyphrase.USER_KEYPHRASE.ID);
    }

    private static class UniqueKeys0 {
        public static final UniqueKey<FlywaySchemaHistoryRecord> FLYWAY_SCHEMA_HISTORY_PK = Internal.createUniqueKey(FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY, "flyway_schema_history_pk", new TableField[] { FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY.INSTALLED_RANK }, true);
        public static final UniqueKey<OauthClientDetailsRecord> PK_OAUTH_CLIENT_DETAILS = Internal.createUniqueKey(OauthClientDetails.OAUTH_CLIENT_DETAILS, "pk_oauth_client_details", new TableField[] { OauthClientDetails.OAUTH_CLIENT_DETAILS.CLIENT_ID }, true);
        public static final UniqueKey<OauthUserRecord> PK_USER = Internal.createUniqueKey(OauthUser.OAUTH_USER, "pk_user", new TableField[] { OauthUser.OAUTH_USER.ID }, true);
        public static final UniqueKey<OauthUserRecord> UK_USER = Internal.createUniqueKey(OauthUser.OAUTH_USER, "uk_user", new TableField[] { OauthUser.OAUTH_USER.USERNAME }, true);
        public static final UniqueKey<PermissionRecord> PK_PERMISSION = Internal.createUniqueKey(Permission.PERMISSION, "pk_permission", new TableField[] { Permission.PERMISSION.ID }, true);
        public static final UniqueKey<PermissionRecord> UK_PERMISSION = Internal.createUniqueKey(Permission.PERMISSION, "uk_permission", new TableField[] { Permission.PERMISSION.NAME }, true);
        public static final UniqueKey<PermissionRoleRecord> PK_PERMISSION_ROLE = Internal.createUniqueKey(PermissionRole.PERMISSION_ROLE, "pk_permission_role", new TableField[] { PermissionRole.PERMISSION_ROLE.PERMISSION_ID, PermissionRole.PERMISSION_ROLE.ROLE_ID }, true);
        public static final UniqueKey<ReviewsRecord> PK_REVIEWS = Internal.createUniqueKey(Reviews.REVIEWS, "pk_reviews", new TableField[] { Reviews.REVIEWS.ID }, true);
        public static final UniqueKey<RoleRecord> PK_ROLE = Internal.createUniqueKey(Role.ROLE, "pk_role", new TableField[] { Role.ROLE.ID }, true);
        public static final UniqueKey<RoleRecord> UK_ROLE = Internal.createUniqueKey(Role.ROLE, "uk_role", new TableField[] { Role.ROLE.NAME }, true);
        public static final UniqueKey<RoleUserRecord> PK_ROLE_USER = Internal.createUniqueKey(RoleUser.ROLE_USER, "pk_role_user", new TableField[] { RoleUser.ROLE_USER.ROLE_ID, RoleUser.ROLE_USER.USER_ID }, true);
        public static final UniqueKey<UserKeyphraseRecord> PK_USER_KEYPHRASE = Internal.createUniqueKey(UserKeyphrase.USER_KEYPHRASE, "pk_user_keyphrase", new TableField[] { UserKeyphrase.USER_KEYPHRASE.ID }, true);
        public static final UniqueKey<UserKeyphraseRecord> PK_USER_UNIQUES = Internal.createUniqueKey(UserKeyphrase.USER_KEYPHRASE, "pk_user_uniques", new TableField[] { UserKeyphrase.USER_KEYPHRASE.USERNAME }, true);
    }

    private static class ForeignKeys0 {
        public static final ForeignKey<PermissionRoleRecord, PermissionRecord> PERMISSION_ROLE__FK1_PERMISSION_ROLE = Internal.createForeignKey(Keys.PK_PERMISSION, PermissionRole.PERMISSION_ROLE, "fk1_permission_role", new TableField[] { PermissionRole.PERMISSION_ROLE.PERMISSION_ID }, true);
        public static final ForeignKey<PermissionRoleRecord, RoleRecord> PERMISSION_ROLE__FK2_PERMISSION_ROLE = Internal.createForeignKey(Keys.PK_ROLE, PermissionRole.PERMISSION_ROLE, "fk2_permission_role", new TableField[] { PermissionRole.PERMISSION_ROLE.ROLE_ID }, true);
        public static final ForeignKey<ReviewsRecord, OauthUserRecord> REVIEWS__FK1_REVIEW_PROFESSOR = Internal.createForeignKey(Keys.UK_USER, Reviews.REVIEWS, "fk1_review_professor", new TableField[] { Reviews.REVIEWS.PROFESSOR }, true);
        public static final ForeignKey<ReviewsRecord, OauthUserRecord> REVIEWS__FK1_REVIEW_STUDENT = Internal.createForeignKey(Keys.UK_USER, Reviews.REVIEWS, "fk1_review_student", new TableField[] { Reviews.REVIEWS.STUDENT }, true);
        public static final ForeignKey<RoleUserRecord, RoleRecord> ROLE_USER__FK1_ROLE_USER = Internal.createForeignKey(Keys.PK_ROLE, RoleUser.ROLE_USER, "fk1_role_user", new TableField[] { RoleUser.ROLE_USER.ROLE_ID }, true);
        public static final ForeignKey<RoleUserRecord, OauthUserRecord> ROLE_USER__FK2_ROLE_USER = Internal.createForeignKey(Keys.PK_USER, RoleUser.ROLE_USER, "fk2_role_user", new TableField[] { RoleUser.ROLE_USER.USER_ID }, true);
        public static final ForeignKey<UserKeyphraseRecord, OauthUserRecord> USER_KEYPHRASE__FK_USERNAME = Internal.createForeignKey(Keys.UK_USER, UserKeyphrase.USER_KEYPHRASE, "fk_username", new TableField[] { UserKeyphrase.USER_KEYPHRASE.USERNAME }, true);
    }
}
