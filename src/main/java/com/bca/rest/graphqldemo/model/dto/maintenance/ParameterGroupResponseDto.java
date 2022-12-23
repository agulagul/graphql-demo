package com.bca.rest.graphqldemo.model.dto.maintenance;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import graphql.annotations.annotationTypes.GraphQLField;
import graphql.annotations.annotationTypes.GraphQLName;
import lombok.Data;

@Data
@GraphQLName("parameter_group")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ParameterGroupResponseDto {
  @JsonProperty("param_group_id")
  @GraphQLField
  @GraphQLName("param_group_id")
  private String paramGroupId;

  @JsonProperty("param_group_code")
  @GraphQLField
  @GraphQLName("param_group_code")
  private String paramGroupCode;

  @JsonProperty("param_group_name")
  @GraphQLField
  @GraphQLName("param_group_name")
  private String paramGroupName;

  @JsonProperty("param_group_desc")
  @GraphQLField
  @GraphQLName("param_group_desc")
  private String paramGroupDesc;

  @JsonProperty("parent_id")
  @GraphQLField
  @GraphQLName("parent_id")
  private String parentId;

  @JsonProperty("created_date")
  @GraphQLField
  @GraphQLName("created_date")
  private Long createdDate;

  @JsonProperty("created_by")
  @GraphQLField
  @GraphQLName("created_by")
  private UserResponseDto createdBy;

  @JsonProperty("updated_date")
  @GraphQLField
  @GraphQLName("updated_date")
  private Long updatedDate;

  @JsonProperty("updated_by")
  @GraphQLField
  @GraphQLName("updated_by")
  private UserResponseDto updatedBy;

  @JsonProperty("version")
  @GraphQLField
  @GraphQLName("version")
  private Integer version;

  @JsonProperty("is_active")
  @GraphQLField
  @GraphQLName("is_active")
  private Boolean isActive;
}
