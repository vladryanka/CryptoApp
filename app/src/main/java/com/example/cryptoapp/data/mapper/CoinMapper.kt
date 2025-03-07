package com.example.cryptoapp.data.mapper

import com.example.cryptoapp.data.database.CoinInfoDbModel
import com.example.cryptoapp.data.network.model.CoinInfoDtoJSONContainer
import com.example.cryptoapp.data.network.model.CoinNamesListDto
import com.example.cryptoapp.domain.CoinInfoDto
import com.google.gson.Gson

class CoinMapper {
    fun mapDbModelToDto(model: CoinInfoDbModel): CoinInfoDto {
        return CoinInfoDto(
            fromSymbol = model.fromSymbol,
            toSymbol = model.toSymbol,
            price = model.price,
            lastUpdate = model.lastUpdate,
            highDay = model.highDay,
            lowDay = model.lowDay,
            lastMarket = model.lastMarket,
            imageUrl = model.imageUrl
        )
    }

    fun mapDtoToDbModel(dto: CoinInfoDto): CoinInfoDbModel {
        return CoinInfoDbModel(
            fromSymbol = dto.fromSymbol,
            toSymbol = dto.toSymbol,
            price = dto.price,
            lastUpdate = dto.lastUpdate,
            highDay = dto.highDay,
            lowDay = dto.lowDay,
            lastMarket = dto.lastMarket,
            imageUrl = dto.imageUrl
        )
    }

    fun mapJSONContainerToListCoinInfo(json: CoinInfoDtoJSONContainer): List<CoinInfoDto> {
        val result = mutableListOf<CoinInfoDto>()
        val jsonObject = json.json ?: return result
        val coinKeySet = jsonObject.keySet()
        for (coinKey in coinKeySet) {
            val currencyJson = jsonObject.getAsJsonObject(coinKey)
            val currencyKeySet = currencyJson.keySet()
            for (currencyKey in currencyKeySet) {
                val priceInfo = Gson().fromJson(
                    currencyJson.getAsJsonObject(currencyKey),
                    CoinInfoDto::class.java
                )
                result.add(priceInfo)
            }
        }
        return result
    }

    fun mapNamesListToString(namesListDto: CoinNamesListDto): String {
        return namesListDto.names?.map { it.coinInfo?.name }?.joinToString(",") ?: ""
    }


}