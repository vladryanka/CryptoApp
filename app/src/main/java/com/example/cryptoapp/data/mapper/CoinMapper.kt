package com.example.cryptoapp.data.mapper

import com.example.cryptoapp.data.database.CoinInfoDbModel
import com.example.cryptoapp.data.network.model.CoinInfoDtoJSONContainer
import com.example.cryptoapp.domain.CoinInfoDto

class CoinMapper {
    fun dbModelToDto(model: CoinInfoDbModel): CoinInfoDto {
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
    fun mapJSONContainerToListCoinInfo(json:CoinInfoDtoJSONContainer): List<CoinInfoDto>{
        return ArrayList<CoinInfoDto>(

        )
    }


}