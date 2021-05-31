package com.example.fourart.service;

import com.example.fourart.entity.Member;
import com.example.fourart.entity.Role;
import com.example.fourart.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.convert.converter.Converter;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.http.OAuth2ErrorResponseErrorHandler;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequestEntityConverter;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.OAuth2AuthorizationException;
import org.springframework.security.oauth2.core.OAuth2Error;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2UserAuthority;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.util.*;

import static com.example.fourart.entity.Role.GUEST;
import static com.example.fourart.entity.SocialLoginType.KAKAO;

@Service
@Slf4j
@Transactional(readOnly = true)
public class SocialLoginService extends DefaultOAuth2UserService {

    @Autowired
    MemberRepository memberRepository;

    private String USER_INFO_URI_MISSING_ERROR = "user_info_uri_is_missed";
    private static final ParameterizedTypeReference<Map<String, Object>>
            PARAMETERIZED_TYPE_REFERENCE =
            new ParameterizedTypeReference<Map<String, Object>>() {};
    private Converter<OAuth2UserRequest, RequestEntity<?>> requestEntityConverter = new OAuth2UserRequestEntityConverter();
    private RestOperations restOperations;

    public SocialLoginService(){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setErrorHandler(new OAuth2ErrorResponseErrorHandler());
        this.restOperations = restTemplate;
    }

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException{
        Assert.notNull(userRequest,"userRequest is null");
        /**
         *
         */
        if(!StringUtils.hasText(userRequest.getClientRegistration().getProviderDetails().getUserInfoEndpoint().getUri())){
            OAuth2Error oAuth2Error = new OAuth2Error(
                    USER_INFO_URI_MISSING_ERROR,
                    userRequest.getClientRegistration().getRegistrationId(),
                    null
            );
            throw new OAuth2AuthenticationException(oAuth2Error,oAuth2Error.toString());
        }
        String userNameAttributeName = userRequest.getClientRegistration().getProviderDetails().getUserInfoEndpoint().getUserNameAttributeName();
        if(!StringUtils.hasText(userNameAttributeName)){
            OAuth2Error oAuth2Error = new OAuth2Error(
                    USER_INFO_URI_MISSING_ERROR,
                    userRequest.getClientRegistration().getRegistrationId(),
                    null
            );
            throw new OAuth2AuthenticationException(oAuth2Error,oAuth2Error.toString());
        }

        RequestEntity<?> requestEntity = this.requestEntityConverter.convert(userRequest);
        ResponseEntity<Map<String,Object>> responseEntity;
        try{
            responseEntity = this.restOperations.exchange(requestEntity,PARAMETERIZED_TYPE_REFERENCE);
        }catch(OAuth2AuthorizationException ex){
            OAuth2Error oAuth2Error = ex.getError();
            oAuth2Error = new OAuth2Error("invaild_user_info_response","userInfo Resource is invaild",null);
            throw new OAuth2AuthenticationException(oAuth2Error,oAuth2Error.toString(),ex);
        }catch (RestClientException ex){
            OAuth2Error oAuth2Error = new OAuth2Error("invaild_user_info_response","userInfo Resource is invaild",null);
            throw new OAuth2AuthenticationException(oAuth2Error,oAuth2Error.toString(),ex);
        }
        Map<String, Object> userAttributes = getUserAttributes(responseEntity);
        Set<GrantedAuthority> authorities = new LinkedHashSet<>();
        authorities.add(new OAuth2UserAuthority(userAttributes));
        OAuth2AccessToken token = userRequest.getAccessToken();
        for(String auth : token.getScopes()){
            authorities.add(new SimpleGrantedAuthority("SCOPE_"+auth));
        }

        return new DefaultOAuth2User(authorities,userAttributes,userNameAttributeName);
    }

    private Map<String, Object> getUserAttributes(ResponseEntity<Map<String,Object>> responseEntity){
        Map<String, Object> userAttributes = responseEntity.getBody();
        if(userAttributes.containsKey("response")){
            LinkedHashMap responseData = (LinkedHashMap)userAttributes.get("response");
            userAttributes.putAll(responseData);
            userAttributes.remove("response");
        }
        return userAttributes;
    }

    private void validateDuplicateMember(Member member){
        Optional<Member> findMembers = memberRepository.findByEmail(member.getEmail());
        if(!findMembers.isEmpty()){
            throw new IllegalStateException("이미 가입된 이메일입니다.");
        }
    }

}

