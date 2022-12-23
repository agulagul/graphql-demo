package com.bca.rest.graphqldemo.resolver.annotation;

import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import com.bca.rest.graphqldemo.model.dto.maintenance.ParameterDetailResponseDto;
import com.bca.rest.graphqldemo.model.dto.maintenance.UserRequestDto;
import com.bca.rest.graphqldemo.model.dto.maintenance.UserResponseDto;
import com.bca.rest.graphqldemo.service.maintenance.ParameterDetailService;
import com.bca.rest.graphqldemo.service.maintenance.UserService;

import graphql.annotations.annotationTypes.GraphQLDescription;
import graphql.annotations.annotationTypes.GraphQLField;
import graphql.annotations.annotationTypes.GraphQLName;
import graphql.annotations.annotationTypes.GraphQLNonNull;
import graphql.kickstart.annotations.GraphQLQueryResolver;

@Service
@GraphQLQueryResolver
public class AnnotationQueryResolver implements ApplicationContextAware {

    private static UserService userService;
    private static ParameterDetailService parameterDetailService;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        userService = applicationContext.getBean(UserService.class);
        parameterDetailService = applicationContext.getBean(ParameterDetailService.class);
    }

    @GraphQLField
    @GraphQLDescription("Get All registered user(s)")
    @GraphQLName("get_all_users")
    public static List<UserResponseDto> getAllUsers() {
        return userService.getAllUsers();
    }
    
    @GraphQLField
    @GraphQLDescription("Get All registered user(s) by user_name")
    @GraphQLName("get_all_users_by_username")
    public static List<UserResponseDto> getAllUsersByUserName(@GraphQLNonNull UserRequestDto userRequestDto) {
        return userService.getAllUsersByUserName(userRequestDto);
    }

    @GraphQLField
    @GraphQLDescription("Get All created parameter(s)")
    @GraphQLName("get_all_parameters")
    public static List<ParameterDetailResponseDto> getAllParameters() {
        return parameterDetailService.getAllParameterDetail();
    }
}
