package eni.tp.app.eni_app.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.HeaderWriterLogoutHandler;
import org.springframework.security.web.header.writers.ClearSiteDataHeaderWriter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {

        JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);

        userDetailsManager.setUsersByUsernameQuery("SELECT email, password, 1 FROM membre where email=?");
        userDetailsManager.setAuthoritiesByUsernameQuery("SELECT membre.email, roles.ROLE FROM membre INNER JOIN roles ON membre.admin = roles.IS_ADMIN WHERE email=?");

        return userDetailsManager;

    }


    //@Bean
    public SecurityFilterChain web(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authorize) -> authorize
                        .requestMatchers("/").permitAll()
                        .requestMatchers("/vendor/**").permitAll()
                                .requestMatchers("/images/**").permitAll()
                                .requestMatchers("/css/**").permitAll()
                                .requestMatchers("/js/**").permitAll()
                                .requestMatchers("/movies").permitAll()
                                .requestMatchers("/change-lang/").permitAll()


                        .requestMatchers("/login").permitAll()
                      //  .requestMatchers("/logout").authenticated()
                                .requestMatchers(HttpMethod.GET, "/add-movie").hasAnyAuthority("ROLE_FORMATEUR", "ROLE_EMPLOYE")
                                .requestMatchers(HttpMethod.POST, "/add-movie").hasAnyAuthority("ROLE_FORMATEUR", "ROLE_EMPLOYE")
                                .requestMatchers(HttpMethod.GET, "/add-movie/{id}").hasAnyAuthority("ROLE_FORMATEUR", "ROLE_EMPLOYE")
                                .requestMatchers(HttpMethod.POST, "/add-movie/{id}").hasAnyAuthority("ROLE_FORMATEUR", "ROLE_EMPLOYE")


                        );

        HeaderWriterLogoutHandler clearSiteData = new HeaderWriterLogoutHandler(new ClearSiteDataHeaderWriter(ClearSiteDataHeaderWriter.Directive.ALL));


//        http.formLogin(form ->
//                form.loginPage("/login")
//                        .defaultSuccessUrl("/"));
//
//
//        http.logout((logout) -> logout.logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET"))
//                .logoutSuccessUrl("/login?logout")
//                .addLogoutHandler(clearSiteData));


        return http.build();

    }

}
