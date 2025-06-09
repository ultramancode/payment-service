package com.example.payment_service.common

import org.springframework.stereotype.Component

@Target(AnnotationTarget.CLASS)
// 런타임에도 리플렉션으로 접근 가능 -> 런타임에 어노테이션이 붙은 클래스를 동적으로 탐지 가능
@Retention(AnnotationRetention.RUNTIME)
@Component
annotation class PersistentAdapter()
