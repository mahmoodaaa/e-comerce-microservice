package com.e_cmmerce.Order_Service.model.enums;

import jakarta.validation.Payload;

public @interface  ValidEnum {

    Class<? extends Enum<?>> value();
    String message() default "Invalid value for enum";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};


}
