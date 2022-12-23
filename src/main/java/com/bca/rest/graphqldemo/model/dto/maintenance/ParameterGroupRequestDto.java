package com.bca.rest.graphqldemo.model.dto.maintenance;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import graphql.annotations.annotationTypes.GraphQLField;
import graphql.annotations.annotationTypes.GraphQLName;
import lombok.Data;

@Data
@GraphQLName("parameter_group")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ParameterGroupRequestDto {

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

  @JsonProperty("created_by")
  @GraphQLField
  @GraphQLName("created_by")
  private String createdBy;

  @JsonProperty("updated_by")
  @GraphQLField
  @GraphQLName("updated_by")
  private String updatedBy;
}
