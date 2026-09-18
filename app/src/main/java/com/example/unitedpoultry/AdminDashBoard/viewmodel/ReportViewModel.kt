package com.example.unitedpoultry.AdminDashBoard.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.unitedpoultry.AdminDashBoard.model.ReportData
import com.example.unitedpoultry.AdminDashBoard.model.ReportResponseModel
import com.example.unitedpoultry.network.NetworkStates
import com.example.unitedpoultry.network.repo.Repository
import com.example.unitedpoultry.network.retrofit.BaseResponse
import com.example.unitedpoultry.rider_home.model.DailyPaymentStatsData
import kotlinx.coroutines.Dispatchers
import retrofit2.Response

class ReportViewModel (private val repository: Repository) : ViewModel(){

    fun getInventoryReport(fromDate: String,toDate: String): LiveData<NetworkStates<Response<BaseResponse<ReportData>>>> =
        liveData(Dispatchers.IO) {
            emit(NetworkStates.loading(null))
            try {
                val response = repository.getInventoryReport(fromDate,toDate)
                emit(NetworkStates.success(response))
            } catch (e: Exception) {
                emit(NetworkStates.error(null, e.message ?: "Something went wrong"))
            }
        }

    fun getSalesReport(fromDate: String,toDate: String): LiveData<NetworkStates<Response<BaseResponse<ReportData>>>> =
        liveData(Dispatchers.IO) {
            emit(NetworkStates.loading(null))
            try {
                val response = repository.getSalesReport(fromDate,toDate)
                emit(NetworkStates.success(response))
            } catch (e: Exception) {
                Log.v("SALE_REPORT", "getSalesReport Exception: "+e.message)
                emit(NetworkStates.error(null, e.message ?: "Something went wrong"))
            }
        }

    fun getShopWiseReport(fromDate: String,toDate: String): LiveData<NetworkStates<Response<BaseResponse<ReportData>>>> =
        liveData(Dispatchers.IO) {
            emit(NetworkStates.loading(null))
            try {
                val response = repository.getShopWiseReport(fromDate,toDate)
                emit(NetworkStates.success(response))
            } catch (e: Exception) {
                emit(NetworkStates.error(null, e.message ?: "Something went wrong"))
            }
        }
}