package com.joycog.operate.api.license.controller

import com.joycog.operate.api.license.model.request.RequestModifyLicenseVo
import com.joycog.operate.api.license.model.request.RequestRegisterLicenseVo
import com.joycog.operate.api.license.service.LicenseService
import com.joycog.operate.api.notice.model.response.ResponseEnrollNoticeVo
import com.joycog.operate.common.api.controller.ResponseController
import com.joycog.operate.common.api.model.ResponseBoolean
import com.joycog.operate.common.api.model.ResponseData
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import io.swagger.v3.oas.annotations.tags.Tags
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

/**
 * @fileName LicenseController
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
@RestController
@RequestMapping("/api/v1/license")
@Tags(Tag(name="라이센스",description = "운영자 라이센스"))
class LicenseController @Autowired constructor (
    private val licenseService: LicenseService
) : ResponseController() {

    @Tag(name = "라이센스")
    @ApiResponses(
        ApiResponse(code = 200, message = "OK"),
        ApiResponse(code = 500, message = "INTERNAL SERVER ERROR")
    )
    @ApiOperation(value = "라이센스 등록", notes = "라이센스를 등록한다.")
    @ResponseBody
    @PostMapping("/register")
    fun registerLicense(@RequestBody @Valid requestRegisterLicenseVo : RequestRegisterLicenseVo): ResponseEntity<ResponseData<ResponseBoolean>> {
        val url = licenseService.registerLicense(requestRegisterLicenseVo)
        return getSuccessResponseEntity(url)
    }

    @Tag(name = "라이센스")
    @ApiResponses(
        ApiResponse(code = 200, message = "OK"),
        ApiResponse(code = 500, message = "INTERNAL SERVER ERROR")
    )
    @ApiOperation(value = "라이센스 수정", notes = "라이센스를 수정한다.")
    @ResponseBody
    @PostMapping("/modify")
    fun modifyLicense(@RequestBody @Valid requestModifyLicenseVo : RequestModifyLicenseVo): ResponseEntity<ResponseData<ResponseBoolean>> {
        val url = licenseService.modifyLicense(requestModifyLicenseVo)
        return getSuccessResponseEntity(url)
    }

}