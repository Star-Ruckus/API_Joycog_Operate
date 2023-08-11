package com.emotiv.api.api_BlueEnter.api.actionLog.model

import com.emotiv.api.api_BlueEnter.common.api.model.enumer.LogCode
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import javax.validation.constraints.NotBlank

/**
 * @fileName logAnonymousVo
 * @author yunjeong
 * @since  2023/06/02
 * @version 1.0
 *
 * @Modification Information
 * @
 * @  DATE          AUTHOR         NOTE
 * @ -----------   ------------   -------------------------------
 * @ 2023/06/02        yunjeong        최초 작성
 */
@ApiModel(value = "익명 행동로그", description = "접근위치, 로그 코드, 결과 코드, value1, value2")
data class LogAnonymousVo(
    @field:NotBlank(message = "anonymousAccess 데이터는 null 일 수 없습니다.")
    @ApiModelProperty(value = "접근위치", example = "WEB : 웹인 경우 , 기기식별 값 : 앱인 경우", required = true)
    val anonymousAccess: String?,
    @field:NotBlank(message = "logCode 데이터는 null 일 수 없습니다.")
    @ApiModelProperty(value = "로그 코드", example = "1", required = true)
    val logCode: LogCode?,
    @ApiModelProperty(value = "결과 코드", example = "200", required = false)
    val resultCode: Any? = null,
    @ApiModelProperty(value = "value1", example = "", required = false)
    val value1: String? = null,
    @ApiModelProperty(value = "value2", example = "", required = false)
    val value2: String? = null
)
