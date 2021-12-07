
package org.sanaa.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class JWtAuthorizationFilter extends BasicAuthenticationFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Request-Methods", "GET, PUT, POST, DELETE");
		response.addHeader("Access-Control-Allow-Headers",
				"Origin,Accept, X-Requested-With,Content-Type," + "Access-Control-Request-Headers ," + "Authorization");
		response.addHeader("Access-Control-Expose-Headers",
				"Access-Control-Allow-Origin ," + "Access-Control-Allow-Credentials, Authorization");
		String jwt = request.getHeader(SecurityConstant.HEADER_STRING);
		if (request.getMethod().equals("OPTIONS")) {
			response.setStatus(HttpServletResponse.SC_OK);
		} else {
			System.out.println("**************************** jwt " + jwt);
			if (jwt == null || !jwt.startsWith(SecurityConstant.TPEKN_PREFIX)) {
				filterChain.doFilter(request, response);
				return;
			}
			Claims claims = Jwts.parser().setSigningKey(SecurityConstant.SECRET)
					.parseClaimsJws(jwt.replace(SecurityConstant.TPEKN_PREFIX, "")).getBody();
			String username = claims.getSubject();
			ArrayList<Map<String, String>> roles = (ArrayList<Map<String, String>>) claims.get("roles");
			Collection<GrantedAuthority> authorities = new ArrayList<>();
			roles.forEach(r -> {
				authorities.add(new SimpleGrantedAuthority(r.get("authority")));
			});
			UsernamePasswordAuthenticationToken authenticationUser = new UsernamePasswordAuthenticationToken(username,
					null, authorities);
			SecurityContextHolder.getContext().setAuthentication(authenticationUser);
			filterChain.doFilter(request, response);
		}

	}

    public JWtAuthorizationFilter(AuthenticationManager authenticationManager) {
		super(authenticationManager);
	}

	

//    @Override
//    protected void doFilterInternal(HttpServletRequest req,
//                                    HttpServletResponse res,
//                                    FilterChain chain) throws IOException, ServletException {
//        String header = req.getHeader(SecurityConstant.HEADER_STRING);
//
//        if (header == null || !header.startsWith(SecurityConstant.TPEKN_PREFIX)) {
//            chain.doFilter(req, res);
//            return;
//        }
//
//        UsernamePasswordAuthenticationToken authentication = getAuthentication(req);
//
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        chain.doFilter(req, res);
//    }
//
//    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
//        String token = request.getHeader(SecurityConstant.HEADER_STRING);
//        if (token != null) {
//            // parse the token.
//            String user = JWT.require(Algorithm.HMAC512(SecurityConstant.SECRET.getBytes()))
//                    .build()
//                    .verify(token.replace(SecurityConstant.TPEKN_PREFIX, ""))
//                    .getSubject();
//
//            if (user != null) {
//                return new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());
//            }
//            return null;
//        }
//        return null;
//    }

}
