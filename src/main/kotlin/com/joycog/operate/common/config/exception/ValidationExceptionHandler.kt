package com.joycog.operate.common.config.exception

import com.joycog.operate.common.api.model.ResponseError
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.util.stream.Collectors

/**
 * @fileName ValidationExceptionHandler
 * @author yunjeong
 * @since  2023/08/09
 * @version 1.0
 *
 * @Modification Information
 * @
 * @  DATE          AUTHOR         NOTE
 * @ -----------   ------------   -------------------------------
 * @ 2023/08/09         yunjeong         최초 작성
 */
@RestControllerAdvice // 전역 예외 처리
class ValidationExceptionHandler : ResponseEntityExceptionHandler() {

    // 한 프로젝트 당 하나의 ControllerAdivce 만 관리하는 것이 좋다.
    // 만약 여러 ControllerAdvice가 필요하다면 basePackages나 annotations 등을 지정해야한다.
    @ResponseStatus(HttpStatus.OK)
    override fun handleMethodArgumentNotValid(
        ex: MethodArgumentNotValidException, // MethodArgumentNotValidException 발생 시 에러 처리
        headers: HttpHeaders,
        status: HttpStatus,
        request: WebRequest
    ): ResponseEntity<Any> {

        val errors = ex.bindingResult.fieldErrors.stream().map {
            it.defaultMessage
        }.collect(Collectors.toList())

        var errorBody = ResponseError()

        for (error in errors) {
            val body = splitResponseMessage(error!!)
            if (body != null) {
                val (code, message) = body
                errorBody = ResponseError(
                    status = code,
                    message = message
                )
            } else {
                errorBody = ResponseError(
                    status = status.value(),
                    message = errors[0].toString()
                )
                return ResponseEntity.status(HttpStatus.OK).body(errorBody)
            }
        }

        return ResponseEntity.status(HttpStatus.OK).body(errorBody)
    }

    fun splitResponseMessage(input: String): Pair<Int, String>? {
        val regex = "\\[(.*?)\\]".toRegex()
        val result = regex.find(input)
        return if (result != null) {
            val code = result.destructured.match.value
            val cleanCode = code.replace("[", "").replace("]", "").toInt()
            val message = input.split("] ")[1]
            Pair(cleanCode, message)
        } else {
            null
        }
    }
}