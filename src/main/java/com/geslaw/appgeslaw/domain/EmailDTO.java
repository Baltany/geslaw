package com.geslaw.appgeslaw.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmailDTO {
    private String[] destinatario;
    private String asunto;
    private String mensaje;
}
