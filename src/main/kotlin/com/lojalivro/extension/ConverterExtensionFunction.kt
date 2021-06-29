package com.lojalivro.extension

import com.lojalivro.controller.request.PostCustomerRequest
import com.lojalivro.controller.request.PutCustomerRequest
import com.lojalivro.model.CustomerModel

fun PostCustomerRequest.toCustomerModel(): CustomerModel {
    return CustomerModel(name = this.name, email = this.email)
}

fun PutCustomerRequest.toCustomerModel(id: String): CustomerModel {
    return CustomerModel(id= id, name = this.name, email = this.email)
}