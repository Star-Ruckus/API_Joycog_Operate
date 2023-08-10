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
@ApiModel(value = "응답 모델")
data class ResponseData<T> (
    @ApiModelProperty(value = "상태값")
    val status: Int,
    @ApiModelProperty(value = "데이터")
    val data: T
)

