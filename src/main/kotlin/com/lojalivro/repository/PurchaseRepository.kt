package com.lojalivro.repository

import com.lojalivro.model.PurchaseModel
import org.springframework.data.repository.CrudRepository

interface PurchaseRepository: CrudRepository<PurchaseModel, Int> {

}
