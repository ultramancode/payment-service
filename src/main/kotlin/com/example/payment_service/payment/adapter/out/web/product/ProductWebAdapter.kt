package com.example.payment_service.payment.adapter.out.web.product

import com.example.payment_service.common.WebAdapter
import com.example.payment_service.payment.application.port.out.LoadProductPort
import com.example.payment_service.payment.domain.Product
import reactor.core.publisher.Flux


@WebAdapter
class ProductWebAdapter : LoadProductPort {
    override fun getProducts(cartId: Long, productIds: List<Long>): Flux<Product> {
        TODO("Not yet implemented")
    }
}