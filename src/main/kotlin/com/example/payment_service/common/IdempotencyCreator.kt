package com.example.payment_service.common

import java.util.UUID


object IdempotencyCreator {
    fun create(data : Any) : String {
        // 입력된 데이터의 바이트 배열이 같으면 항상 동일한 UUID를 생성
        return UUID.nameUUIDFromBytes(data.toString().toByteArray()).toString();
    }
}