package com.joycog.operate.common.config.exception

import com.joycog.operate.common.api.model.ResponseError
import com.joycog.operate.common.config.logger.LoggerFactory
import org.apache.ibatis.javassist.NotFoundException
import org.mybatis.spring.MyBatisSystemException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.bind.MissingServletRequestParameterException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.sql.SQLException

/**
 * @fileName ExceptionHandler
 * @author yunjeong
 * @since  2023/08/08
 * @version 1.0
 *
 * @Modification Information
 * @
 * @  DATE          AUTHOR         NOTE
 * @ -----------   ------------   -------------------------------
 * @ 2023/08/08        yunjeong        최초 작성
 */
@RestController
class ExceptionHandler {

    companion object : LoggerFactory()

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(ErrorException::class)
    protected fun handleBaseException(e: ErrorException): ResponseEntity<Any> {
        log.debug("[오류] code : ${e.error.getCode()} , msg : ${e.error.getMessage()}")
        return ResponseEntity.status(HttpStatus.OK)
            .body(ResponseError(e.error.getCode(), e.error.getMessage()))
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MissingServletRequestParameterException::class)
    fun missingServletRequestParameterException(e: MissingServletRequestParameterException): ResponseEntity<Any> {
        log.error("MissingServletRequestParameterException :: ${e.printStackTrace()}")
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .body(ResponseError(HttpStatus.BAD_REQUEST.value(), "잘못된 요청입니다."))
    }

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(RuntimeException::class)
    fun runtimeExceptionHandler(e: RuntimeException): ResponseEntity<*> {
        log.error("RuntimeException:: ${e.printStackTrace()}")
        return ResponseEntity.status(HttpStatus.OK).body(ResponseError(HttpStatus.OK.value(), e.message!!))
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException::class)
    fun httpMessageNotReadableException(e: HttpMessageNotReadableException): ResponseEntity<Any> {
        log.error("HttpMessageNotReadableException :: ${e.printStackTrace()}")
        return ResponseEntity.status(HttpStatus.OK).body(ResponseError(status = 443, message = "허용되지 않는 값이 요청되었습니다."))
    }

//    @ResponseStatus(HttpStatus.FORBIDDEN)
//    @ExceptionHandler(AccessDeniedException::class)
//    fun unauthenticatedException(e: AccessDeniedException): ResponseEntity<Any> {
//        val authentication: Authentication? = SecurityContextHolder.getContext().authentication
//        return if (authentication != null) {
//            log.error("AccessDeniedException :: ${e.printStackTrace()}")
//            ResponseEntity.status(HttpStatus.FORBIDDEN)
//                .body(ResponseErrorVo(HttpStatus.FORBIDDEN.value(), "접근 권한이 없습니다."))
//        } else {
//            log.error("AccessDeniedException :: ${e.printStackTrace()}")
//            ResponseEntity.status(HttpStatus.UNAUTHORIZED)
//                .body(ResponseErrorVo(HttpStatus.UNAUTHORIZED.value(), "로그인이 필요한 사용자 입니다."))
//        }
//    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(SecurityException::class)
    fun securityExceptionHandler(e: SecurityException): ResponseEntity<Any> {
        log.error("SecurityExceptionHandler :::: ${e.printStackTrace()}")
        return ResponseEntity.status(HttpStatus.FORBIDDEN)
            .body(ResponseError(HttpStatus.FORBIDDEN.value(), e.message!!))
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException::class)
    fun notFoundException(e: NotFoundException): ResponseEntity<Any> {
        log.error("NotFoundException = ${e.printStackTrace()}")
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body(ResponseError(HttpStatus.NOT_FOUND.value(), "해당 리소스 정보를 찾을 수 없습니다."))
    }

//    @ResponseStatus(HttpStatus.OK)
//    @ExceptionHandler(UsernameNotFoundException::class)
//    fun notFoundException(e: UsernameNotFoundException): ResponseEntity<Any> {
//        log.error("NotFoundException = ${e.printStackTrace()}")
//        return ResponseEntity.status(HttpStatus.FORBIDDEN)
//            .body(ResponseErrorVo(HttpStatus.FORBIDDEN.value(), e.message!!))
//    }

    @ExceptionHandler(SQLException::class)
    fun sqlExceptionHandler(e: SQLException): ResponseEntity<Any> {
        log.error("SQL Exception = ${e.printStackTrace()}")
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(ResponseError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "데이터 베이스 SQL을 확인해 보시기 바랍니다."))
    }

    @ExceptionHandler(MyBatisSystemException::class)
    fun mybatisExceptionHandler(e: MyBatisSystemException): ResponseEntity<Any> {
        log.error("Mybatis System Exception = ${e.printStackTrace()}")
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(ResponseError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "서버의 마이바티스 쿼리가 동작하지 않습니다."))
    }
}