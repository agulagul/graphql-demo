package com.bca.rest.graphqldemo.model.dto.maintenance;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import graphql.annotations.annotationTypes.GraphQLField;
import graphql.annotations.annotationTypes.GraphQLName;
import lombok.Data;

@Data
@GraphQLName("user")
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserResponseDto {

  @JsonProperty("user_id")
  @GraphQLField
  @GraphQLName("user_id")
  private String userId;

  @JsonProperty("user_name")
  @GraphQLField
  @GraphQLName("user_name")
  private String userName;

  @JsonProperty("created_date")
  @GraphQLField
  @GraphQLName("created_date")
  private Long createdDate;

  @JsonProperty("created_by")
  @GraphQLField
  @GraphQLName("created_by")
  private String createdBy;

  @JsonProperty("updated_date")
  @GraphQLField
  @GraphQLName("updated_date")
  private Long updatedDate;

  @JsonProperty("updated_by")
  @GraphQLField
  @GraphQLName("updated_by")
  private String updatedBy;

  @JsonProperty("version")
  @GraphQLField
  @GraphQLName("version")
  private Integer version;

  @JsonProperty("is_active")
  @GraphQLField
  @GraphQLName("is_active")
  private Boolean isActive;

}
