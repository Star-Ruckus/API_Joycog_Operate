package com.joycog.operate.api.license.model.entity

import com.joycog.operate.api.license.model.enumer.AgencyType

/**
 * @fileName LicenseEntity
 * @author yunjeong
 * @since  2023/08/10
 * @version 1.0
 *
 * @Modification Information
 * @
 * @  DATE          AUTHOR         NOTE
 * @ -----------   ------------   -------------------------------
 * @ 2023/08/10        yunjeong        최초 작성
 */
data class LicenseEntity(
    val licenseId : Int?=null,
    val licenseKey : String?=null,
    val agencyType : AgencyType?=null,
    val licenseName : String?=null,
    val licenseCount : Int?=null,
    val licenseIssuedDate : String?=null,
    val licenseExpiredDate : String?=null,
    val agencyName : String?=null,
    val useYn : String?=null
)
