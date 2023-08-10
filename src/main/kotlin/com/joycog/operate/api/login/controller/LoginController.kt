package com.joycog.operate.api.login.controller

import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


/**
 * @fileName LoginController
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
@Tag(name = "인증", description = "인증 관련 api 입니다.")
@RestController
@RequestMapping("/test")
class LoginController {

    @Tag(name = "인증")
    @ApiOperation(value = "로드 밸런스 연결 상태 확인 API", hidden = true)
    @ApiResponses(
        ApiResponse(code = 200, message = "서버 정상작동"),
        ApiResponse(code = 500, message = "서버 오류")
    )
    @GetMapping("/healthyCheck")
    fun loadBalancerHealthyCheck(): String {
        return "hello loadBalancer"
    }

}