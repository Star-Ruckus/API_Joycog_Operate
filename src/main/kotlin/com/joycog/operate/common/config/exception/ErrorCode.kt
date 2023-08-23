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
    INSERT(ErrorConst.INSERT_CODE , ErrorConst.INSERT_MSG),
    UPDATE(ErrorConst.UPDATE_CODE , ErrorConst.UPDATE_MSG),
    SELECT(ErrorConst.SELECT_CODE , ErrorConst.SELECT_MSG),
    INCORRECT_FORMAT(ErrorConst.INCORRECT_FORMAT_CODE , ErrorConst.INCORRECT_FORMAT_MSG),
    NOT_WORKING(ErrorConst.NOT_WORKING_CODE , ErrorConst.NOT_WORKING_MSG);

    fun getCode() = code
    fun getMessage() = msg
}