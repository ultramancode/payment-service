package com.example.payment_service.payment.adapter.out.web.toss.executor

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono
import java.lang.RuntimeException

@Component
class TossPaymentExecutor(
        private val tossPaymentWebClient: WebClient,
        private val uri: String = "/v1/payments/confirm"

) {
    private val log = LoggerFactory.getLogger(TossPaymentExecutor::class.java)

    fun execute(paymentKey: String, orderId: String, amount: String): Mono<String> {
        return tossPaymentWebClient.post()
                .uri(uri)
                .bodyValue(
                        """
                            {
                                "paymentKey" : "${paymentKey}",
                                "orderId" : "${orderId}",
                                "amount" : $amount
                            }
                        """.trimIndent())
                .retrieve()
                .onStatus({ it.isError }) { response ->
                    response.bodyToMono(String::class.java).flatMap { errorBody ->
                        log.error("Toss API ERROR Response Body {}", errorBody)
                        Mono.error(RuntimeException("Toss API ERROR : $errorBody"))
                    }
                }
                .bodyToMono(String::class.java)
    }
}
