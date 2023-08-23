package com.joycog.operate.api.license.repository

import com.joycog.operate.api.license.model.entity.LicenseEntity
import org.apache.ibatis.annotations.Mapper
import org.springframework.stereotype.Repository

/**
 * @fileName LicenseRepository
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
@Mapper
@Repository
interface LicenseRepository {
    fun insertLicense(licenseEntity: LicenseEntity) : Int

    fun updateLicense(licenseEntity: LicenseEntity) : Int

    fun isDuplicateKey(licenseKey: String): String?
}