package com.discom.springboot;

/*@Component
@Qualifier("mySsoLogoutHandler")*/
public class MySsoLogoutHandler { /*implements LogoutHandler {

    @Value("http://localhost:8080/sso-server/invalidateToken")
    String logoutUrl;

    @Override
    public void logout(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) {

        System.out.println("executing MySsoLogoutHandler.logout");
        Object details = authentication.getDetails();
        if (details.getClass().isAssignableFrom(OAuth2AuthenticationDetails.class)) {

            String accessToken = ((OAuth2AuthenticationDetails)details).getTokenValue();
            System.out.println("token: {}"+accessToken);

            RestTemplate restTemplate = new RestTemplate();

            MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
            params.add("access_token", accessToken);

            HttpHeaders headers = new HttpHeaders();
            headers.add("Authorization", "bearer " + accessToken);

            HttpEntity<String> request = new HttpEntity(params, headers);

            HttpMessageConverter formHttpMessageConverter = new FormHttpMessageConverter();
            HttpMessageConverter stringHttpMessageConverternew = new StringHttpMessageConverter();
            restTemplate.setMessageConverters(Arrays.asList(new HttpMessageConverter[]{formHttpMessageConverter, stringHttpMessageConverternew}));
            try {
                ResponseEntity<String> response = restTemplate.exchange(logoutUrl, HttpMethod.POST, request, String.class);
            } catch(HttpClientErrorException e) {
            	System.out.println("HttpClientErrorException invalidating token with SSO authorization server. response.status code: {}, server URL: {}"+ e.getStatusCode()+ logoutUrl);
            }
        }


    }*/
}