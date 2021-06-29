package com.lojalivro.service

import com.lojalivro.controller.request.PostCustomerRequest
import com.lojalivro.controller.request.PutCustomerRequest
import com.lojalivro.model.CustomerModel
import org.springframework.stereotype.Service

@Service
class CustomerService {

    val customers = mutableListOf<CustomerModel>()

    fun getAll(name: String?): List<CustomerModel> {
        name?.let {
            return customers.filter { it.name.contains(name, true) }
        }
        return customers
    }

    fun getCustomer(id: String): CustomerModel {
        return customers.first { it.id == id }
    }

    fun create(customer: CustomerModel) {
        val id = if (customers.isEmpty()) {
            1
        } else  {
            customers.last().id!!.toInt() + 1
        }.toString()

        customer.id = id

        customers.add(customer)
    }

    fun update(customer: CustomerModel) {
        customers.first { it.id == customer.id }.let {
            it.name = customer.name
            it.email = customer.email
        }
    }

    fun delete(id: String) {
        customers.removeIf { it.id == id }
    }
}