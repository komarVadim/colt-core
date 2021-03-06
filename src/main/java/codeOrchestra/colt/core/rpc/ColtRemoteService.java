package codeOrchestra.colt.core.rpc;

import codeOrchestra.colt.core.ColtService;
import codeOrchestra.colt.core.model.Project;
import codeOrchestra.colt.core.rpc.model.ColtRemoteProject;
import codeOrchestra.colt.core.rpc.model.ColtState;
import codeOrchestra.colt.core.rpc.security.InvalidAuthTokenException;
import codeOrchestra.colt.core.rpc.security.InvalidShortCodeException;
import codeOrchestra.colt.core.rpc.security.TooManyFailedCodeTypeAttemptsException;

/**
 * @author Alexander Eliseyev
 */
public interface ColtRemoteService<P extends Project> extends ColtService {

    ColtState getState();

    int ping();

    // Project create/load methods

    void createProject(String securityToken, ColtRemoteProject<P> project) throws ColtRemoteTransferableException;

    void loadProject(String securityToken, String path) throws ColtRemoteTransferableException;

    // Authorization methods

    void requestShortCode(String requestor) throws ColtRemoteTransferableException;

    String obtainAuthToken(String shortCode) throws TooManyFailedCodeTypeAttemptsException, InvalidShortCodeException;

    void checkAuth(String securityToken) throws InvalidAuthTokenException;

}
