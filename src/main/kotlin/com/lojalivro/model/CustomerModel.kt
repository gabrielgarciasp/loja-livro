package com.lojalivro.model

import com.lojalivro.enums.CustomerStatus
import javax.persistence.*

@Entity(name = "customer")
data class CustomerModel(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    var name: String,
    var email: String,

    @Enumerated(EnumType.STRING)
    var status: CustomerStatus
)