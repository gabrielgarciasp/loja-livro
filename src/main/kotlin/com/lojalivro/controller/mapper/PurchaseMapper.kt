package com.lojalivro.controller.mapper

import com.lojalivro.controller.request.PostPurchaseRequest
import com.lojalivro.model.PurchaseModel
import com.lojalivro.service.BookService
import com.lojalivro.service.CustomerService
import org.springframework.stereotype.Component

@Component
class PurchaseMapper(
    private val bookService: BookService,
    private val customerService: CustomerService
) {

    fun toModel(request: PostPurchaseRequest): PurchaseModel {
        val customer = customerService.findById(request.customerId)
        val books = bookService.findAllByIds(request.bookIds)

        return PurchaseModel(
            customer = customer,
            books = books.toMutableList(),
            price = books.sumOf { it.price }
        )
    }
}