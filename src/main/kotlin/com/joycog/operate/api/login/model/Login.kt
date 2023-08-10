package com.joycog.operate.api.login.model


import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import javax.validation.constraints.NotBlank

/**
 * @fileName Login
 * @author yunjeong
 * @since  2023/08/04
 * @version 1.0
 *
 * @Modification Information
 * @
 * @  DATE          AUTHOR         NOTE
 * @ -----------   ------------   -------------------------------
 * @ 2023/08/04        yunjeong        최초 작성
 */

@ApiModel(value = "로그인", description = "아이디")
data class Login(
    @field:NotBlank(message = "childId 데이터는 null 일 수 없습니다.")
    @ApiModelProperty(value = "아이디", example = "test", required = true)
    val id : String
)
