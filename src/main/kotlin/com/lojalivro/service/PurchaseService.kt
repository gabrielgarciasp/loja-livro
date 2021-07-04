package com.lojalivro.service

import com.lojalivro.events.PurchaseEvent
import com.lojalivro.model.PurchaseModel
import com.lojalivro.repository.PurchaseRepository
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service

@Service
class PurchaseService(
    private val purchaseRepository: PurchaseRepository,
    private val applicationEventPublisher: ApplicationEventPublisher,
    private val bookService: BookService
) {

    fun create(purchaseModel: PurchaseModel) {
        bookService.checkAvailabilityBooks(purchaseModel.books)
        purchaseRepository.save(purchaseModel)
        applicationEventPublisher.publishEvent(PurchaseEvent(this, purchaseModel))
    }

    fun update(purchaseModel: PurchaseModel) {
        purchaseRepository.save(purchaseModel)
    }
}
