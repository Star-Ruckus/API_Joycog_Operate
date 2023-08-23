package com.joycog.operate.api.license.model.request

import com.joycog.operate.common.config.exception.ErrorConst
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import javax.validation.constraints.NotNull

/**
 * @fileName RequestModifyLienseVo
 * @author yunjeong
 * @since  2023/08/23
 * @version 1.0
 *
 * @Modification Information
 * @
 * @  DATE          AUTHOR         NOTE
 * @ -----------   ------------   -------------------------------
 * @ 2023/08/23        yunjeong        최초 작성
 */
@ApiModel(value="라이센스 수정", description = "라이센스 일련번호, 라이센스 명, 라이센스 생성 가능 아동수, 라이센스 시작일, 라이센스 종료일, 기관명, 사용 유무" +
        "(수정하고 싶지 않은 정보는 null 로 두어야함)")
data class RequestModifyLicenseVo(
    @field:NotNull(message = ErrorConst.LICENSE_ID_NOT_NULL_MSG)
    @ApiModelProperty(value = "라이센스 일련번호", example = "1", required = true)
    val licenseId : Int?,
    @ApiModelProperty(value = "라이센스 명", example = "전용 라이센스", required = false)
    val licenseName : String?=null,
    @ApiModelProperty(value = "라이센스 생성 가능 아동 수", example = "100", required = false)
    val licenseCount : Int?=null,
    @ApiModelProperty(value = "라이센스 시작일", example = "2023-02-06", required = false)
    val licenseIssuedDate : String?=null,
    @ApiModelProperty(value = "라이센스 종료일", example = "2024-02-06", required = false)
    val licenseExpiredDate : String?=null,
    @ApiModelProperty(value = "기관명", example = "우리 초등학교", required = false)
    val agencyName : String?=null,
    @ApiModelProperty(value = "사용 유무", example = "Y : 사용 N : 사용안함", required = false)
    val useYn : String?=null
)
