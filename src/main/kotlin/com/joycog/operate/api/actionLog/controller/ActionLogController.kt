
import com.emotiv.api.api_BlueEnter.api.actionLog.model.LogCodeEntity
import com.joycog.operate.common.api.controller.ResponseController
import com.joycog.operate.common.api.model.ResponseData
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import io.swagger.v3.oas.annotations.tags.Tags
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

/**
 * @fileName ActionLogController
 * @author yunjeong
 * @since  2023/07/04
 * @version 1.0
 *
 * @Modification Information
 * @
 * @  DATE          AUTHOR         NOTE
 * @ -----------   ------------   -------------------------------
 * @ 2023/07/04        yunjeong        최초 작성
 */
@RestController
@RequestMapping("/api/v1/log/action")
@Tags(Tag(name = "행동로그", description = "서버에서 알기 어려운 행동로그 시 클라에서 사용한다.예) 꾸미기샵 진입"))
class ActionLogController @Autowired constructor(
    private val actionLogService: ActionLogService
) : ResponseController() {
    @Tag(name = "행동로그")
    @ApiResponses(
        ApiResponse(code = 200, message = "OK"),
        ApiResponse(code = 403, message = "UNAUTHORIZED"),
        ApiResponse(code = 404, message = "NOT FOUND"),
        ApiResponse(code = 500, message = "INTERNAL SERVER ERROR")
    )
    @ApiOperation(value = "아동", notes = "아동유저의 행동로그를 남긴다.")
    @PostMapping("/register/child")
    fun childLog(@Valid @RequestBody child: LogChildVo): ResponseEntity<ResponseData<Boolean>> {
        val result = actionLogService.insertLogChild(child)
        return getSuccessResponseEntity(result)
    }

    @Tag(name = "행동로그")
    @ApiResponses(
        ApiResponse(code = 200, message = "OK"),
        ApiResponse(code = 403, message = "UNAUTHORIZED"),
        ApiResponse(code = 404, message = "NOT FOUND"),
        ApiResponse(code = 500, message = "INTERNAL SERVER ERROR")
    )
    @ApiOperation(value = "익명", notes = "익명유저의 행동로그를 남긴다.")
    @PostMapping("/register/anonymous")
    fun anonymousLog(@Valid @RequestBody anonymous: LogAnonymousVo): ResponseEntity<ResponseData<Boolean>> {
        val result = actionLogService.insertLogAnonymous(anonymous)
        return getSuccessResponseEntity(result)
    }

    @Tag(name = "행동로그")
    @ApiResponses(
        ApiResponse(code = 200, message = "OK"),
        ApiResponse(code = 403, message = "UNAUTHORIZED"),
        ApiResponse(code = 404, message = "NOT FOUND"),
        ApiResponse(code = 500, message = "INTERNAL SERVER ERROR")
    )
    @ApiOperation(value = "관리자", notes = "관리자유저의 행동로그를 남긴다.")
    @PostMapping("/register/manager")
    fun managerLog(@Valid @RequestBody manager: LogManagerVo): ResponseEntity<ResponseData<Boolean>> {
        val result = actionLogService.insertLogManager(manager)
        return getSuccessResponseEntity(result)
    }

    @Tag(name = "행동로그")
    @ApiResponses(
        ApiResponse(code = 200, message = "OK"),
        ApiResponse(code = 403, message = "UNAUTHORIZED"),
        ApiResponse(code = 404, message = "NOT FOUND"),
        ApiResponse(code = 500, message = "INTERNAL SERVER ERROR")
    )
    @ApiOperation(value = "운영자", notes = "운영자유저의 행동로그를 남긴다.")
    @PostMapping("/register/admin")
    fun adminLog(@Valid @RequestBody admin: LogAdminVo): ResponseEntity<ResponseData<Boolean>> {
        val result = actionLogService.insertLogAdmin(admin)
        return getSuccessResponseEntity(result)
    }

    @Tag(name = "서버 테스트용")
    @ApiResponses(
        ApiResponse(code = 200, message = "OK"),
        ApiResponse(code = 403, message = "UNAUTHORIZED"),
        ApiResponse(code = 404, message = "NOT FOUND"),
        ApiResponse(code = 500, message = "INTERNAL SERVER ERROR")
    )
    @ApiOperation(value = "로그 코드 테이블 삽입", notes = "로그 코드 삽입")
    @PostMapping("/register/logCode")
    fun registerLogCode(@Valid @RequestBody logCodeEntity: LogCodeEntity): ResponseEntity<ResponseData<Boolean>> {
        val result = actionLogService.registerLogCode(logCodeEntity)
        return getSuccessResponseEntity(result)
    }
}