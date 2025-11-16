package io.github.timely.timelyapi.menu.dto

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime

class MenuDto {
    /**
     * 단건 조회 / 상세 조회용 응답
     */
    data class Response(
        val menuSn: Long,
        val menuNm: String,
        val menuUrl: String?,
        val upMenuSn: Long?,
        val menuLvl: Int,
        val sortOrd: Int,
        val useYn: String,
        val createDt: LocalDateTime?,
        val updateDt: LocalDateTime?
    ) {
        @JsonIgnore
        val rawUseYn: String = useYn

        @get:JsonProperty("isUsed")
        val isUsed: Boolean
            get() = rawUseYn == "Y"
    }

    /**
     * 리스트 응답(필요한 값만)
     */
    data class SimpleResponse(
        val menuSn: Long,
        val menuNm: String,
        var menuUrl: String?,
    )

    /**
     * 트리 구조 응답이 필요할 경우
     */
    data class TreeResponse(
        val menuSn: Long,
        val menuNm: String,
        val menuUrl: String?,
        val children: List<TreeResponse> = emptyList()
    )
}