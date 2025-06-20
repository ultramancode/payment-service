package com.example.payment_service.payment.adapter.out.web.product.client

import com.example.payment_service.payment.domain.Product
import reactor.core.publisher.Flux
import java.math.BigDecimal

class MockProductClient : ProductClient {
    override fun getProducts(cartId: Long, productIds: List<Long>): Flux<Product> {
        return Flux.fromIterable(
                productIds.map {
                    Product(
                            id = it,
                            amount = BigDecimal(it * 10000),
                            quantity = 2,
                            name = "mock_product_$it",
                            sellerId = 1
                    )
                }
        )
    }
}