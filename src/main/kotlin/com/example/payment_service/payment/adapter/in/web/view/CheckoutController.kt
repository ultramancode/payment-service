package com.example.payment_service.payment.adapter.`in`.web.view

import com.example.payment_service.common.WebAdapter
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import reactor.core.publisher.Mono

@WebAdapter
@Controller
class CheckoutController {

    @GetMapping("/")
    fun checkout(): Mono<String> {
        return Mono.just("payment/checkout")
    }
}