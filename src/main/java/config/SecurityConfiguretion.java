//package config;
//
////<editor-fold defaultstate="collapsed" desc="IMPORT">
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
////</editor-fold>
//
///**
// *
// * @author Huynh Pham Minh Quan
// * @email hpminhquan96@gmail.com
// */
//@Configuration
//@EnableWebSecurity
//public class SecurityConfiguretion extends WebSecurityConfigurerAdapter {
//
////    @Autowired
////    private BCryptPasswordEncoder bCryptPasswordEncoder;
////
////    @Autowired
////    private DataSource dataSource;
////
////    @Override
////    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////        auth.jdbcAuthentication().usersByUsernameQuery("").authoritiesByUsernameQuery("").dataSource(dataSource).passwordEncoder(bCryptPasswordEncoder);
////    }
////
////    @Override
////    protected void configure(HttpSecurity http) throws Exception {
////        http.authorizeRequests().antMatchers("/login", "/register").permitAll();
////        http.authorizeRequests().and().formLogin().loginProcessingUrl("/log-in")
////                .loginPage("/login")
////                .defaultSuccessUrl("/home")
////                .failureUrl("/login?error=true")
////                .usernameParameter("username")
////                .passwordParameter("password")
////                .and().logout().logoutUrl("/logout").logoutSuccessUrl("login");
////        http.authorizeRequests().and().rememberMe().tokenRepository(this.persistentTokenRepository()).tokenValiditySeconds(1 * 24 * 60 * 60);
////    }
////
////    @Bean
////    public PersistentTokenRepository persistentTokenRepository() {
//////        JdbcTokenRepositoryImpl db = new JdbcTokenRepositoryImpl();
//////        db.setDataSource(dataSource);
//////        return db;
////        InMemoryTokenRepositoryImpl memory = new InMemoryTokenRepositoryImpl();
////        return memory;
////    }
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .antMatchers("/login").permitAll()
//                .antMatchers("/register").permitAll()
//                //                .and()
//                //                .formLogin()
//                //                .loginPage("/login")
//                //                .usernameParameter("username")
//                //                .passwordParameter("password")
//                //                .defaultSuccessUrl("/")
//                //                .failureUrl("/login?error")
//                .and()
//                .exceptionHandling()
//                .accessDeniedPage("/403");
//        http.authorizeRequests().anyRequest().authenticated();
//        http.cors().and().csrf().disable();
//    }
//
//}
