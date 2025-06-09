package com.example.payment_service.payment.domain

enum class PaymentStatus(description: String) {
    NOT_STARTED("결제 승인 시작 전"),
    EXECUTION("결제 승인 중"),
    SUCCESS("결제 승인 성공"),
    FAILURE("결제 승인 실패"),
    UNKNOWN("결제 승인 알 수 없음")
}