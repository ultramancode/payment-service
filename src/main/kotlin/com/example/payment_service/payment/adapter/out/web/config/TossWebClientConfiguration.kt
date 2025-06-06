package com.example.payment_service.payment.adapter.out.web.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpHeaders
import org.springframework.http.client.reactive.ClientHttpConnector
import org.springframework.http.client.reactive.ReactorClientHttpConnector
import org.springframework.web.reactive.function.client.WebClient
import reactor.netty.http.client.HttpClient
import reactor.netty.resources.ConnectionProvider
import java.util.*

@Configuration
class TossWebClientConfiguration(
        @Value("\${PSP.toss.url}")
        private val baseUrl: String,
        @Value("\${PSP.toss.secretKey}")
        private val secretKey: String
) {

    @Bean
    fun tossPaymentWebClient(): WebClient {
        val encodedSecretKey: String =
                Base64.getEncoder().encodeToString((secretKey + ":").toByteArray())

        return WebClient.builder()
                .baseUrl(baseUrl)
                .defaultHeader(HttpHeaders.AUTHORIZATION, "Basic $encodedSecretKey")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, "application/json")
                .clientConnector(reactorClientHttpConnector())
                .codecs {
                    it.defaultCodecs()
                }
                .build()
    }

    private fun reactorClientHttpConnector(): ClientHttpConnector {
        // TCP 커넥션을 재사용(커넥션 풀링) 하기 위한 설정 객체..
        // 이 Reactor Netty 커넥션 풀의 이름을 toss-payment로 지정한 것
        val provider = ConnectionProvider.builder("toss-payment")
                .build();

        return ReactorClientHttpConnector(HttpClient.create(provider))
    }
}