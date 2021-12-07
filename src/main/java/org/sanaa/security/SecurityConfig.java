
package org.sanaa.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})

@Configuration
@EnableWebSecurity

public class SecurityConfig extends WebSecurityConfigurerAdapter  {
	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;
	@Autowired
	private UserDetailsService userDetailsService;
	
	

 @Override
protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	 auth.userDetailsService(userDetailsService).passwordEncoder(bcryptPasswordEncoder);
}
 @Override
	protected void configure(HttpSecurity http) throws Exception {
		http.
		csrf().disable()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.authorizeRequests().antMatchers("/login/**","/registrer/**","/images/**","/offres").permitAll();
		http.authorizeRequests().antMatchers(HttpMethod.GET,"/offres/**").hasAnyAuthority("ADMIN","USER","PROPRIETAIRE");
		http.authorizeRequests().anyRequest().authenticated();		
		http.addFilter(new JWTAuthenticationFilter(authenticationManager()))
		.addFilterBefore(new JWtAuthorizationFilter(authenticationManager()),UsernamePasswordAuthenticationFilter.class);
}
	
	
	
//	
//	private UserDetailsService userDetailsService;
//    private BCryptPasswordEncoder bCryptPasswordEncoder;
//
//    public SecurityConfig(UserDetailsService userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder) {
//        this.userDetailsService = userDetailsService;
//        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.cors().and().csrf().disable().authorizeRequests()
//                .antMatchers(HttpMethod.POST, "/registrer").permitAll()
//                .antMatchers(HttpMethod.POST, "/offres").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .addFilter(new JWTAuthenticationFilter(authenticationManager()))
//                .addFilter(new JWtAuthorizationFilter(authenticationManager()))
//                // this disables session creation on Spring Security
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//       
//    }
//
//    @Override
//    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
//    }
//
//  @Bean
//  CorsConfigurationSource corsConfigurationSource() {
//    final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//    source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
//    return source;
//  }
}