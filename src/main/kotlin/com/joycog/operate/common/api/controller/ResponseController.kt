package com.joycog.operate.common.api.controller

import com.joycog.operate.common.api.model.ResponseData
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

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
open class ResponseController {

    private fun <T> wrapResponseEntity(data: T): ResponseData<T> {
        return ResponseData(status = HttpStatus.OK.value(), data = data)
    }

    fun <T> getSuccessResponseEntity(data: T): ResponseEntity<ResponseData<T>> {
        return ResponseEntity.ok(wrapResponseEntity(data))
    }
}