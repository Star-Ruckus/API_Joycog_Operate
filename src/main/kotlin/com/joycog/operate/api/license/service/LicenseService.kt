package com.joycog.operate.api.license.service

import com.joycog.operate.api.license.model.entity.LicenseEntity
import com.joycog.operate.api.license.model.enumer.AgencyType
import com.joycog.operate.api.license.model.request.RequestModifyLicenseVo
import com.joycog.operate.api.license.model.request.RequestRegisterLicenseVo
import com.joycog.operate.api.license.repository.LicenseRepository
import com.joycog.operate.api.notice.model.response.ResponseEnrollNoticeVo
import com.joycog.operate.common.api.model.ResponseBoolean
import com.joycog.operate.common.config.exception.ErrorCode
import com.joycog.operate.common.config.exception.ErrorException
import com.joycog.operate.common.util.TimezoneUtil
import org.apache.commons.lang3.RandomStringUtils
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

/**
 * @fileName LicenseService
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
@Service
class LicenseService(
    private val licenseRepository: LicenseRepository
) {
    fun registerLicense(requestRegisterLicenseVo: RequestRegisterLicenseVo): ResponseBoolean {
        val licenseKey = createLicenseKey(requestRegisterLicenseVo.agencyType)
        val licenseEntity = LicenseEntity(
            licenseKey = licenseKey,
            agencyType = requestRegisterLicenseVo.agencyType,
            licenseName = requestRegisterLicenseVo.licenseName,
            licenseCount = requestRegisterLicenseVo.licenseCount,
            licenseIssuedDate = TimezoneUtil().getDown0UTC(requestRegisterLicenseVo.licenseIssuedDate, "+09:00",0),
            licenseExpiredDate = TimezoneUtil().getDown0UTC(requestRegisterLicenseVo.licenseExpiredDate, "+09:00",1),
            agencyName = requestRegisterLicenseVo.agencyName,
            useYn = "Y"
        )

        val insert = licenseRepository.insertLicense(licenseEntity)
        if (insert != 1){
            throw ErrorException(ErrorCode.INSERT)
        }
        return ResponseBoolean(isValid = true)
    }

    fun createLicenseKey(agencyType : AgencyType) : String {
        // yyMMdd + agencyType + 랜덤5자리 를 조합하여 라이센스 코드를 발급한다.
        val formatter = DateTimeFormatter.ofPattern("yyMMdd")
        val localDateTime = LocalDateTime.now()
        val formattedDate = localDateTime.format(formatter)
        var randomCode = RandomStringUtils.randomAlphanumeric(5)
        var licenseKey = formattedDate + agencyType.toString() + randomCode
        while (true) {
            val isValidLicenseKey = licenseRepository.isDuplicateKey(licenseKey)
            if (isValidLicenseKey != null) { // 중복된 코드가 있다면
                randomCode = RandomStringUtils.randomAlphanumeric(5)
                licenseKey = formattedDate + agencyType.toString() + randomCode
            } else {
                break
            }
        }
        return licenseKey
    }

    fun modifyLicense(requestModifyLicenseVo: RequestModifyLicenseVo): ResponseBoolean {
        val licenseEntity = LicenseEntity(
            licenseId = requestModifyLicenseVo.licenseId,
            licenseName = requestModifyLicenseVo.licenseName,
            licenseCount = requestModifyLicenseVo.licenseCount,
            licenseIssuedDate = requestModifyLicenseVo.licenseIssuedDate?.let { TimezoneUtil().getDown0UTC(it,"+09:00",0) },
            licenseExpiredDate = requestModifyLicenseVo.licenseExpiredDate?.let { TimezoneUtil().getDown0UTC(it,"+09:00",1) },
            agencyName = requestModifyLicenseVo.agencyName,
            useYn = requestModifyLicenseVo.useYn
        )
        val update = licenseRepository.updateLicense(licenseEntity)
        if (update != 1) {
            throw ErrorException(ErrorCode.UPDATE)
        }
        return ResponseBoolean(isValid = true)
    }

}