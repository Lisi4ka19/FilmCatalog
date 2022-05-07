package filmcatalog.filmcatalog.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.filter.GenericFilterBean;

import javax.sql.DataSource;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource);

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").hasAnyRole("all", "user")
                .antMatchers("/admin").hasRole("all")
                .antMatchers("/allFilms").hasAnyRole("all", "user")
                .antMatchers("/addFilm").hasAnyRole("all", "user")
                .antMatchers("/saveFilm").hasAnyRole("all", "user")
                .antMatchers("/updateFilm").hasAnyRole("all", "user")
                .antMatchers("/deleteFilm").hasRole("all")
                .and().formLogin().permitAll();
    }


}
