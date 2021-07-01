package com.lojalivro.validation

import javax.validation.Constraint
import kotlin.reflect.KClass

@Constraint(validatedBy = [EmailAvailableValidator::class])
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FIELD)
annotation class EmailAvailable(
    val message: String = "E-mail já cadastrado",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<*>> = []
)
