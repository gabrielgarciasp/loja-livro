package com.lojalivro.controller.request

import com.lojalivro.validation.EmailAvailable
import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty

data class PostCustomerRequest (
    @field:NotEmpty(message = "Nome deve ser informado")
    var name: String,

    @field:Email(message = "E-mail deve ser válido")
    @EmailAvailable
    var email: String
)