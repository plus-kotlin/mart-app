package com.example.martapp.shared.config.util

import com.fasterxml.jackson.core.SerializableString
import com.fasterxml.jackson.core.io.CharacterEscapes
import com.fasterxml.jackson.core.io.SerializedString
import org.apache.commons.text.StringEscapeUtils


class HtmlCharacterEscapes : CharacterEscapes() {
    private val asciiEscapes: IntArray

    init {
        // 1. XSS 방지 처리할 특수 문자 지정
        asciiEscapes = standardAsciiEscapesForJSON()
        asciiEscapes['<'.code] = ESCAPE_CUSTOM
        asciiEscapes['>'.code] = ESCAPE_CUSTOM
        asciiEscapes['\"'.code] = ESCAPE_CUSTOM
        asciiEscapes['('.code] = ESCAPE_CUSTOM
        asciiEscapes[')'.code] = ESCAPE_CUSTOM
        asciiEscapes['#'.code] = ESCAPE_CUSTOM
        asciiEscapes['\"'.code] = ESCAPE_CUSTOM
    }

    override fun getEscapeCodesForAscii(): IntArray {
        return asciiEscapes
    }

    // 이모지 파싱 중 에러 발생 부분 해결
    override fun getEscapeSequence(ch: Int): SerializableString {
        val serializedString: SerializedString
        val charAt = ch.toChar()
        serializedString = if (Character.isHighSurrogate(charAt) || Character.isLowSurrogate(charAt)) {
            val sb = StringBuilder()
            sb.append("\\u")
            sb.append(String.format("%04x", ch))
            SerializedString(sb.toString())
        } else {
            SerializedString(
                StringEscapeUtils.escapeHtml4(
                    Character.toString(charAt)
                )
            )
        }
        return serializedString
    }
}
