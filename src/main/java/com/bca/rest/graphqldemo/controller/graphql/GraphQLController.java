package com.bca.rest.graphqldemo.controller.graphql;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bca.rest.graphqldemo.controller.BaseController;
import com.bca.rest.graphqldemo.model.dto.GraphqlRequestDto;
import com.bca.rest.graphqldemo.model.dto.eai.EaiResponseDto;
import com.bca.rest.graphqldemo.util.constant.ApplicationProperties;
import com.bca.rest.graphqldemo.util.http.HttpResponseMapping;

@RestController
@RequestMapping(BaseController.API_BASE_PATH + "/graphql")
public class GraphQLController extends BaseController {

    @Autowired
    ApplicationProperties applicationProperties;

    @PostMapping
    public ResponseEntity<EaiResponseDto<Map<String, Object>>> getGraphQLResponse(
            @RequestBody GraphqlRequestDto graphqlRequestDto) {

        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<GraphqlRequestDto> entity = new HttpEntity<GraphqlRequestDto>(graphqlRequestDto);

        ParameterizedTypeReference<Map<String, Object>> responseType = new ParameterizedTypeReference<Map<String, Object>>() {
        };
        ResponseEntity<Map<String, Object>> result = restTemplate.exchange(applicationProperties.getGraphqlUrl(), HttpMethod.POST, entity, responseType);

        HttpResponseMapping responseMap;
        if (result.getStatusCode() == HttpStatus.OK) {
            responseMap = HttpResponseMapping.OK;
        } else {
            responseMap = HttpResponseMapping.INTERNAL_SERVER_ERROR;
        }
        EaiResponseDto<Map<String, Object>> response = new EaiResponseDto<>(responseMap, result.getBody());
        return new ResponseEntity<>(response, response.getHttpStatus());
    }

}
