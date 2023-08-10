package com.joycog.operate.common.config.exception

/**
 * @fileName ErrorCode
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
enum class ErrorCode(private val code: Int, private val msg : String) {
    TEST_01(ErrorConst.TEST_01_CODE , ErrorConst.TEST_01_MSG);

    fun getCode() = code
    fun getMessage() = msg
}