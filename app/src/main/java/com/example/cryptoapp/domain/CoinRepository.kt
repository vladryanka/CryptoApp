package com.example.cryptoapp.domain

import androidx.lifecycle.LiveData

interface CoinRepository {
    fun getCoinInfoList(): LiveData<List<CoinInfoDto>>
    fun getCoinInfo(fromSymbol: String): LiveData<CoinInfoDto>
}