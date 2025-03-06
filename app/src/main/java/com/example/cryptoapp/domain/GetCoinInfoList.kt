package com.example.cryptoapp.domain

class GetCoinInfoList(private val repository: CoinRepository) {
    operator fun invoke() = repository.getCoinInfoList()
}