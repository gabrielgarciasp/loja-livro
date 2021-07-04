package com.lojalivro.exception

class BookNotAvailabilityException(
    override val message: String,
    val errorCode: String
): Exception() {
}