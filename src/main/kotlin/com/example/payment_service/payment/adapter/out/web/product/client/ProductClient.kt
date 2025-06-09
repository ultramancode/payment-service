package com.example.payment_service.payment.adapter.out.web.product.client

import com.example.payment_service.payment.domain.Product
import reactor.core.publisher.Flux

interface ProductClient {

    fun getProducts(cartId: Long, productIds: List<Long>): Flux<Product>
}