package com.base.newPeaceSystemBuild.vo.vendor

data class Order (
    val id: Int,
    val regDate: String,
    var updateDate: String,
    var vendorMemberId: Int,
    val clientId: Int,
    val directorMemberId: Int,
    val roleCategoryId: Int,
    val standardId: Int,
    var orderStatus: Boolean,
    var completionStatus: Boolean
) {
    var extra__clientId: Int? = null
    var extra__clientRegDate: String? = null
    var extra__clientUpdateDate: String? = null
    var extra__deceasedName: String? = null
    var extra__relatedName: String? = null
    var extra__cellphoneNo: String? = null
    var extra__location: String? = null
    var extra__address: String? = null
    var extra__bank: String? = null
    var extra__accountNum: String? = null
    var extra__directorName: String? = null
    var extra__directorCellphoneNo: String? = null
    var extra__name: String? = null
    var extra__retailPrice: String? = null
    // 헌화 주문정보 관련 데이터
    var extra__bunchCnt: Int? = null
    var extra__packing: Boolean? = null
}