package com.example.unitedpoultry.AdminDashBoard.model

data class ReportResponseModel(
    val result: String?=null,
    val message: String?=null,
    val data: ReportData?=null,
)


data class ReportData(
    val report_type: String?=null,
    val pdf_url: String?=null,
)
