package com.joycog.operate.common.api.model

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * @fileName ResponseController
 * @author yunjeong
 * @since  2023/08/07
 * @version 1.0
 *
 * @Modification Information
 * @
 * @  DATE          AUTHOR         NOTE
 * @ -----------   ------------   -------------------------------
 * @ 2023/08/07        yunjeong        최초 작성
 */
@ApiModel(description = "오류 모델")
data class ResponseError(
    @ApiModelProperty(example = "10000")
    val status: Int? = null,
    @ApiModelProperty(example = "로그인 방식이 존재하지 않습니다.")
    val message: String? = null,
)
