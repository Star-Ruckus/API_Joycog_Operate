package com.joycog.operate.common.config.exception

/**
 * @fileName ErrorConst
 * @author yunjeong
 * @since  2023/08/09
 * @version 1.0
 *
 * @Modification Information
 * @
 * @  DATE          AUTHOR         NOTE
 * @ -----------   ------------   -------------------------------
 * @ 2023/08/09        yunjeong        최초 작성
 */
object ErrorConst {

    /**
     * validation check
     *
     */
    const val LICENSE_ID_NOT_NULL_CODE = 1000
    const val LICENSE_ID_NOT_NULL_MSG = "[$LICENSE_ID_NOT_NULL_CODE] 라이센스 아이디는 필수 값입니다."

    const val INSERT_CODE = 1
    const val INSERT_MSG = "데이터 삽입에 실패했습니다."

    const val UPDATE_CODE = 2
    const val UPDATE_MSG = "데이터 수정에 실패했습니다."

    const val SELECT_CODE = 3
    const val SELECT_MSG = "데이터 조회에 실패했습니다."

    const val INCORRECT_FORMAT_CODE = 4
    const val INCORRECT_FORMAT_MSG = "데이터 형식을 다시 확인해주세요."

    const val NOT_WORKING_CODE = 5
    const val NOT_WORKING_MSG = "정상 처리 되지 않았습니다."

}