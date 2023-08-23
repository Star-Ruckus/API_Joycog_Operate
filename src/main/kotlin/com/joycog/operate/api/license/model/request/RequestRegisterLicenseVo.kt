package com.joycog.operate.api.license.model.request

import com.joycog.operate.api.license.model.enumer.AgencyType
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * @fileName RequestRegisterLicenseVo
 * @author yunjeong
 * @since  2023/08/21
 * @version 1.0
 *
 * @Modification Information
 * @
 * @  DATE          AUTHOR         NOTE
 * @ -----------   ------------   -------------------------------
 * @ 2023/08/21        yunjeong        최초 작성
 */
@ApiModel(value = "라이센스 등록", description = "기관 타입, 라이센스 명, 라이센스 생성 가능 아동 수, 라이센스 시작일, 라이센스 종료일, 기관명")
data class RequestRegisterLicenseVo(
    @ApiModelProperty(value = "기관 타입", example = "S : 학교, C : 회사, E : 보육원", required = true)
    val agencyType : AgencyType,
    @ApiModelProperty(value = "라이센스 명", example = "이모티브", required = true)
    val licenseName : String,
    @ApiModelProperty(value = "라이센스 생성 가능 아동 수", example = "100", required = true)
    val licenseCount : Int,
    @ApiModelProperty(value = "라이센스 시작일", example = "2023-02-06", required = true)
    val licenseIssuedDate : String,
    @ApiModelProperty(value = "라이센스 종료일", example = "2024-02-06", required = true)
    val licenseExpiredDate : String,
    @ApiModelProperty(value = "기관명", example = "우리 초등학교", required = true)
    val agencyName : String
)
