package com.joycog.operate.api.license.model.entity

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
    val licenseKey : String,
    val agencyType : String,
    val licenseName : String,
    val licenseIssuedDate : String,
    val licenseExpiredDate : String,
    val agencyName : String,
    val useYn : String
)
