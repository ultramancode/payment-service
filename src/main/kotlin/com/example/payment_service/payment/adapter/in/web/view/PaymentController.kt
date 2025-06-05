package com.example.payment_service.payment.adapter.`in`.web.view

import com.example.payment_service.common.WebAdapter
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import reactor.core.publisher.Mono

@Controller
@WebAdapter
@RequestMapping("/v1/toss")
class PaymentController {

    @GetMapping("/success")
    fun successPage(): Mono<String> {
        return Mono.just("payment/success")
    }

    @GetMapping("/failure")
    fun failPage(): Mono<String> {
        return Mono.just("fail")
    }
}