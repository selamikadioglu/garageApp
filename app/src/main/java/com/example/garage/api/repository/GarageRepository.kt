package com.example.garage.api.repository

import com.example.garage.api.GarageService
import javax.inject.Inject

open class GarageRepository @Inject constructor(private val garageApi: GarageService) :
    GarageServiceRepository {
}


