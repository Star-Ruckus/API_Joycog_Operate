package com.joycog.operate.api.notice.model.enumer

/**
 * @fileName PlatformType
 * @author yunjeong
 * @since  2023/08/17
 * @version 1.0
 *
 * @Modification Information
 * @
 * @  DATE          AUTHOR         NOTE
 * @ -----------   ------------   -------------------------------
 * @ 2023/08/17        yunjeong        최초 작성
 */
enum class PlatformType(description : String) {
    ALL("전체"),
    AOS("안드로이드"),
    IOS("애플"),
    WEB("웹")
}