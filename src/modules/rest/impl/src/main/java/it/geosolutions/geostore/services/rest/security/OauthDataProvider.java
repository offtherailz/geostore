package it.geosolutions.geostore.services.rest.security;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.cxf.rs.security.oauth2.common.AccessTokenRegistration;
import org.apache.cxf.rs.security.oauth2.common.Client;
import org.apache.cxf.rs.security.oauth2.common.OAuthPermission;
import org.apache.cxf.rs.security.oauth2.common.ServerAccessToken;
import org.apache.cxf.rs.security.oauth2.common.UserSubject;
import org.apache.cxf.rs.security.oauth2.provider.OAuthDataProvider;
import org.apache.cxf.rs.security.oauth2.provider.OAuthServiceException;
import org.apache.cxf.rs.security.oauth2.tokens.bearer.BearerAccessToken;
import org.springframework.beans.factory.annotation.Autowired;

import it.geosolutions.geostore.core.model.User;
import it.geosolutions.geostore.services.UserSessionService;
import it.geosolutions.geostore.services.dto.UserSession;
import it.geosolutions.geostore.services.dto.UserSessionImpl;

public class OauthDataProvider implements OAuthDataProvider{
	@Autowired
	UserSessionService userSessionService;
	
	@Override
	public List<OAuthPermission> convertScopeToPermissions(Client client, List<String> scopes) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServerAccessToken createAccessToken(AccessTokenRegistration reg) throws OAuthServiceException {
		Calendar c = new GregorianCalendar();
		c.add(Calendar.SECOND, 3600);
		UserSession session = new UserSessionImpl(new User(), c);
		
		String tokenString = userSessionService.registerNewSession(session);
		ServerAccessToken token = new BearerAccessToken(reg.getClient(), 3600L);
        
        List<String> scope = reg.getApprovedScope().isEmpty() ? reg.getRequestedScope() 
                                                        : reg.getApprovedScope();
        token.setScopes(convertScopeToPermissions(reg.getClient(), scope));
        token.setSubject(reg.getSubject());
        token.setGrantType(reg.getGrantType());
        
        
        // persist or encrypt and return
 
        return token;
	}

	@Override
	public ServerAccessToken getAccessToken(String arg0) throws OAuthServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Client getClient(String arg0) throws OAuthServiceException {
		// TODO Auto-generated method stub
		return new Client(arg0);
	}

	@Override
	public ServerAccessToken getPreauthorizedToken(Client arg0, List<String> arg1, UserSubject arg2, String arg3)
			throws OAuthServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServerAccessToken refreshAccessToken(Client arg0, String arg1, List<String> arg2)
			throws OAuthServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeAccessToken(ServerAccessToken arg0) throws OAuthServiceException {
		// TODO Auto-generated method stub
		
	}

	

	
}
