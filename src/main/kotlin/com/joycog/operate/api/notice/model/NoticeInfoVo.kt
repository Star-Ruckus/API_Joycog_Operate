package com.joycog.operate.api.notice.model

import com.joycog.operate.api.notice.model.enumer.LanguageCode
import com.joycog.operate.api.notice.model.enumer.PlatformType
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * @fileName NoticeInfoVo
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
data class NoticeInfoVo(
    @ApiModelProperty(value = "공지 제목", example = "공지 제목", required = true)
    val noticeTitle : String,
    @ApiModelProperty(value = "공지 내용", example = "공지 내용", required = true)
    val noticeContent : String,
    @ApiModelProperty(value = "언어 코드", example = "KR : 한국 , EN : 영어", required = true)
    val languageCode : LanguageCode,
    @ApiModelProperty(value = "사용 플랫폼", example = "ALL : 전체, AOS : 안드로이드, IOS : 애플, WEB : 웹", required = true)
    val usePlatform : PlatformType
)
