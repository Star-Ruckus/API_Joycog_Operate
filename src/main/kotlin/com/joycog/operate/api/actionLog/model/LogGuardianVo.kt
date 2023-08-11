

/**
 * @fileName logGuardianVo
 * @author yunjeong
 * @since  2023/06/02
 * @version 1.0
 *
 * @Modification Information
 * @
 * @  DATE          AUTHOR         NOTE
 * @ -----------   ------------   -------------------------------
 * @ 2023/06/02        yunjeong        최초 작성
 */
data class LogGuardianVo(
    val guardianId: Int,
    val logCode: String,
    val resultCode: Any? = null,
    val value1: String? = null,
    val value2: String? = null,
    val value3: String? = null
)
