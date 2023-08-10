package com.joycog.operate.common.config.exception


/**
 * @fileName RestApiException
 * @author yunjeong
 * @since  2023/05/11
 * @version 1.0
 *
 * @Modification Information
 * @
 * @  DATE          AUTHOR         NOTE
 * @ -----------   ------------   -------------------------------
 * @ 2023/05/11        yunjeong        최초 작성
 */

class ErrorException(errorCode: ErrorCode) : RuntimeException() {
    val error: ErrorCode = errorCode
}
