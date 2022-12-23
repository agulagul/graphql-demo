package com.bca.rest.graphqldemo.model.dto.maintenance;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import graphql.annotations.annotationTypes.GraphQLField;
import graphql.annotations.annotationTypes.GraphQLName;
import lombok.Data;

@Data
@GraphQLName("user_request")
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserRequestDto {

  @JsonProperty("user_id")
  @GraphQLField
  @GraphQLName("user_id")
  private String userId;

  @JsonProperty("user_name")
  @GraphQLField
  @GraphQLName("user_name")
  private String userName;
}
