package com.emotiv.api.api_BlueEnter.api.actionLog.model

import com.emotiv.api.api_BlueEnter.common.api.model.enumer.LogCode
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

/**
 * @fileName logManagerVo
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
@ApiModel(
    value = "아동 행동로그", description = "아동 일련번호, 보호자 일련번호, 로그 코드, 결과 코드," +
            "골드 수량, 다이아 수량, 스크리닝 이용권 수량, value1, value2, value3, value4, value5"
)
data class LogManagerVo(
    @field:NotNull(message = "managerId 데이터는 null 일 수 없습니다.")
    @ApiModelProperty(value = "관리자 일련번호", example = "1", required = true)
    val managerId: Int?,

    @field:NotBlank(message = "logCode 데이터는 null 일 수 없습니다.")
    @ApiModelProperty(value = "로그 코드", example = "C10001", required = true)
    val logCode: LogCode?,

    @ApiModelProperty(value = "결과 코드", example = "200", required = false)
    val resultCode: Any? = null,
    @ApiModelProperty(value = "골드 수량", example = "0", required = false)
    val gold: Int? = 0,
    @ApiModelProperty(value = "다이아 수량", example = "0", required = false)
    val dia: Int? = 0,
    @ApiModelProperty(value = "스크리닝 이용권 수량", example = "0", required = false)
    val screening: Int? = 0,
    @ApiModelProperty(value = "value1", example = "", required = false)
    val value1: String? = null,
    @ApiModelProperty(value = "value2", example = "", required = false)
    val value2: String? = null,
    @ApiModelProperty(value = "value3", example = "", required = false)
    val value3: String? = null
)
