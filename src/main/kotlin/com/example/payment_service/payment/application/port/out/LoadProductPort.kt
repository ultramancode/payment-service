package com.example.payment_service.payment.application.port.out

import com.example.payment_service.payment.domain.Product
import reactor.core.publisher.Flux

interface LoadProductPort {

    fun getProducts(cartId: Long, productIds: List<Long>): Flux<Product>
}