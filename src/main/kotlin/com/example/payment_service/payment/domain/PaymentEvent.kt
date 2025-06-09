package com.example.payment_service.payment.domain

import java.time.LocalDateTime

data class PaymentEvent(
        val id: Long? = null,
        val buyerId: Long,
        val orderName: String,
        val orderId: String,
        val paymentKey: String? = null,
        val paymentType: PaymentType? = null,
        val approvedAt: LocalDateTime? = null,
        val paymentOrders: List<PaymentOrder> = emptyList(),
        private var isPaymentDone: Boolean = false
) {

    fun totalAmount(): Long {
        return this.paymentOrders.sumOf {
            it.amount
        }.toLong()
    }
}
