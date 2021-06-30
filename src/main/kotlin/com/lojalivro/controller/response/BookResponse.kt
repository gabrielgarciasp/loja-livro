package com.lojalivro.controller.response

import com.lojalivro.enums.BookStatus
import com.lojalivro.model.CustomerModel
import java.math.BigDecimal

data class BookResponse(
    var id: Int? = null,
    var name: String,
    var price: BigDecimal,
    var customer: CustomerModel? = null,
    var status: BookStatus? = null
)
