package com.lojalivro.events.listener

import com.lojalivro.events.PurchaseEvent
import com.lojalivro.service.BookService
import com.lojalivro.service.PurchaseService
import org.springframework.context.event.EventListener
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component
import java.util.*

@Component
class UpdateSoldBookListener(
    private val bookService: BookService
) {

    @Async
    @EventListener
    fun listen(purchaseEvent: PurchaseEvent) {
        bookService.purchase(purchaseEvent.purchaseModel.books)
    }
}