package com.bca.rest.graphqldemo.util.exception;

import com.bca.rest.graphqldemo.model.dto.eai.EaiResponseDto;
import com.bca.rest.graphqldemo.util.http.HttpResponseMapping;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class CustomException extends RuntimeException {

    private EaiResponseDto<Object> eaiResponseDto;

    public CustomException() {
        super();
    }

    public CustomException(HttpResponseMapping httpResponseMapping, Object content) {
        super(httpResponseMapping.eaiErrorSchemeDto().getEaiErrorMessageDto().getEnglish());
        this.eaiResponseDto = new EaiResponseDto<>(httpResponseMapping, content);
    }
}
