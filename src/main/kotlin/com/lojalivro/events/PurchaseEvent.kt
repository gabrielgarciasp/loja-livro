package com.lojalivro.events

import com.lojalivro.model.PurchaseModel
import org.springframework.context.ApplicationEvent

class PurchaseEvent (
    source: Any,
    val purchaseModel: PurchaseModel
): ApplicationEvent(source)