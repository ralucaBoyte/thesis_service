/*
 * This file is generated by jOOQ.
 */
package ro.ubbcluj.cs.ams.auth.model.tables.pojos;


import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class OauthApprovals implements Serializable {

    private static final long serialVersionUID = 1543466604;

    private String        userId;
    private String        clientId;
    private String        scope;
    private String        status;
    private LocalDateTime expiresAt;
    private LocalDateTime lastModifiedAt;

    public OauthApprovals() {}

    public OauthApprovals(OauthApprovals value) {
        this.userId = value.userId;
        this.clientId = value.clientId;
        this.scope = value.scope;
        this.status = value.status;
        this.expiresAt = value.expiresAt;
        this.lastModifiedAt = value.lastModifiedAt;
    }

    public OauthApprovals(
        String        userId,
        String        clientId,
        String        scope,
        String        status,
        LocalDateTime expiresAt,
        LocalDateTime lastModifiedAt
    ) {
        this.userId = userId;
        this.clientId = clientId;
        this.scope = scope;
        this.status = status;
        this.expiresAt = expiresAt;
        this.lastModifiedAt = lastModifiedAt;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getClientId() {
        return this.clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getScope() {
        return this.scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getExpiresAt() {
        return this.expiresAt;
    }

    public void setExpiresAt(LocalDateTime expiresAt) {
        this.expiresAt = expiresAt;
    }

    public LocalDateTime getLastModifiedAt() {
        return this.lastModifiedAt;
    }

    public void setLastModifiedAt(LocalDateTime lastModifiedAt) {
        this.lastModifiedAt = lastModifiedAt;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("OauthApprovals (");

        sb.append(userId);
        sb.append(", ").append(clientId);
        sb.append(", ").append(scope);
        sb.append(", ").append(status);
        sb.append(", ").append(expiresAt);
        sb.append(", ").append(lastModifiedAt);

        sb.append(")");
        return sb.toString();
    }
}
