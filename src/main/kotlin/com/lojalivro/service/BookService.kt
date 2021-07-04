package com.lojalivro.service

import com.lojalivro.enums.BookStatus
import com.lojalivro.enums.Errors
import com.lojalivro.exception.BookNotAvailabilityException
import com.lojalivro.exception.NotFoundException
import com.lojalivro.model.BookModel
import com.lojalivro.model.CustomerModel
import com.lojalivro.repository.BookRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class BookService(
    val bookRepository: BookRepository
) {

    fun create(book: BookModel) {
        bookRepository.save(book)
    }

    fun findAll(pageable: Pageable): Page<BookModel> {
        return bookRepository.findAll(pageable)
    }

    fun findActives(pageable: Pageable): Page<BookModel> {
        return bookRepository.findByStatus(BookStatus.ATIVO, pageable)
    }

    fun findById(id: Int): BookModel {
        return bookRepository.findById(id)
            .orElseThrow{ NotFoundException(Errors.ML101.message.format(id), Errors.ML101.code) }
    }

    fun update(book: BookModel) {
        bookRepository.save(book)
    }

    fun delete(id: Int) {
        val book = findById(id)
        book.status = BookStatus.CANCELADO
        bookRepository.save(book)
    }

    fun deleteByCustomer(customer: CustomerModel) {
        val books = bookRepository.findByCustomer(customer)
        for (book in books) {
            book.status = BookStatus.DELETADO
        }
        bookRepository.saveAll(books)
    }

    fun findAllByIds(bookIds: Set<Int>): List<BookModel> {
        return bookRepository.findAllById(bookIds).toList()
    }

    fun purchase(books: MutableList<BookModel>) {
        books.map { it.status = BookStatus.VENDIDO }
        bookRepository.saveAll(books)
    }

    fun checkAvailabilityBooks(books: MutableList<BookModel>) {
        val booksNotAvailability = mutableListOf<Int>()
        books.forEach {
            if (it.status != BookStatus.ATIVO) {
                booksNotAvailability.add(it.id!!)
            }
        }

        if (booksNotAvailability.size > 0) {
            throw BookNotAvailabilityException(
                Errors.ML103.message.format(booksNotAvailability.joinToString(",")),
                Errors.ML103.code
            )
        }
    }
}