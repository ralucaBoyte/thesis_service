/*
 * This file is generated by jOOQ.
 */
package ro.ubbcluj.cs.ams.auth.model;


import ro.ubbcluj.cs.ams.auth.model.tables.FlywaySchemaHistory;
import ro.ubbcluj.cs.ams.auth.model.tables.OauthAccessToken;
import ro.ubbcluj.cs.ams.auth.model.tables.OauthApprovals;
import ro.ubbcluj.cs.ams.auth.model.tables.OauthClientDetails;
import ro.ubbcluj.cs.ams.auth.model.tables.OauthClientToken;
import ro.ubbcluj.cs.ams.auth.model.tables.OauthCode;
import ro.ubbcluj.cs.ams.auth.model.tables.OauthRefreshToken;
import ro.ubbcluj.cs.ams.auth.model.tables.OauthUser;
import ro.ubbcluj.cs.ams.auth.model.tables.Permission;
import ro.ubbcluj.cs.ams.auth.model.tables.PermissionRole;
import ro.ubbcluj.cs.ams.auth.model.tables.Reviews;
import ro.ubbcluj.cs.ams.auth.model.tables.Role;
import ro.ubbcluj.cs.ams.auth.model.tables.RoleUser;
import ro.ubbcluj.cs.ams.auth.model.tables.UserKeyphrase;


/**
 * Convenience access to all tables in public
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Tables {

    /**
     * The table <code>public.flyway_schema_history</code>.
     */
    public static final FlywaySchemaHistory FLYWAY_SCHEMA_HISTORY = FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY;

    /**
     * The table <code>public.oauth_access_token</code>.
     */
    public static final OauthAccessToken OAUTH_ACCESS_TOKEN = OauthAccessToken.OAUTH_ACCESS_TOKEN;

    /**
     * The table <code>public.oauth_approvals</code>.
     */
    public static final OauthApprovals OAUTH_APPROVALS = OauthApprovals.OAUTH_APPROVALS;

    /**
     * The table <code>public.oauth_client_details</code>.
     */
    public static final OauthClientDetails OAUTH_CLIENT_DETAILS = OauthClientDetails.OAUTH_CLIENT_DETAILS;

    /**
     * The table <code>public.oauth_client_token</code>.
     */
    public static final OauthClientToken OAUTH_CLIENT_TOKEN = OauthClientToken.OAUTH_CLIENT_TOKEN;

    /**
     * The table <code>public.oauth_code</code>.
     */
    public static final OauthCode OAUTH_CODE = OauthCode.OAUTH_CODE;

    /**
     * The table <code>public.oauth_refresh_token</code>.
     */
    public static final OauthRefreshToken OAUTH_REFRESH_TOKEN = OauthRefreshToken.OAUTH_REFRESH_TOKEN;

    /**
     * The table <code>public.oauth_user</code>.
     */
    public static final OauthUser OAUTH_USER = OauthUser.OAUTH_USER;

    /**
     * The table <code>public.permission</code>.
     */
    public static final Permission PERMISSION = Permission.PERMISSION;

    /**
     * The table <code>public.permission_role</code>.
     */
    public static final PermissionRole PERMISSION_ROLE = PermissionRole.PERMISSION_ROLE;

    /**
     * The table <code>public.reviews</code>.
     */
    public static final Reviews REVIEWS = Reviews.REVIEWS;

    /**
     * The table <code>public.role</code>.
     */
    public static final Role ROLE = Role.ROLE;

    /**
     * The table <code>public.role_user</code>.
     */
    public static final RoleUser ROLE_USER = RoleUser.ROLE_USER;

    /**
     * The table <code>public.user_keyphrase</code>.
     */
    public static final UserKeyphrase USER_KEYPHRASE = UserKeyphrase.USER_KEYPHRASE;
}
