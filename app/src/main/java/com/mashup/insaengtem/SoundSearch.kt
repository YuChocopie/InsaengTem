package com.mashup.insaengtem

import android.util.Log

/**
 * 생성자.
 */
class SoundSearch {
    companion object {
        private val HANGUL_BEGIN_UNICODE: Char = 44032.toChar()
        // 가
        private val HANGUL_LAST_UNICODE: Char = 55203.toChar()
        private val HANGUL_BASE_UNIT: Char = 588.toChar()
        private val INITIAL_SOUND =
            charArrayOf('ㄱ', 'ㄲ', 'ㄴ', 'ㄷ', 'ㄸ', 'ㄹ', 'ㅁ', 'ㅂ', 'ㅃ', 'ㅅ', 'ㅆ', 'ㅇ', 'ㅈ', 'ㅉ', 'ㅊ', 'ㅋ', 'ㅌ', 'ㅍ', 'ㅎ','a','b','c')

        /**
         * 해당 문자가 INITIAL_SOUND인지 검사. * @param searchar * @return
         */
        private fun isInitialSound(searchar: Char): Boolean {
            for (c in INITIAL_SOUND) {
                if (c == searchar) {
                    return true
                }
            }
            return false
        }

        /**
         * 해당 문자의 자음을 얻는다. * * @param c 검사할 문자 * @return
         */
        private fun getInitialSound(c: Char): Char {
            val hanBegin = c - HANGUL_BEGIN_UNICODE
            val index = hanBegin / HANGUL_BASE_UNIT.toInt()
            return INITIAL_SOUND[index]
        }

        /**
         * 해당 문자가 한글인지 검사 * @param c 문자 하나 * @return
         */
        private fun isHangul(c: Char): Boolean {
            return HANGUL_BEGIN_UNICODE <= c && c <= HANGUL_LAST_UNICODE
        }

        /**
         * 검색을 한다. 초성 검색 완벽 지원함. * @param value : 검색 대상 ex> 초성검색합니다 * @param search : 검색어 ex> ㅅ검ㅅ합ㄴ * @return 매칭 되는거 찾으면 true 못찾으면 false.
         */
        fun matchString(value: String, search: String): Boolean {
            var t = 0
            val seof = value.length - search.length
            val slen = search.length
            if (seof < 0)
                return false
            //검색어가 더 길면 false를 리턴한다.
            for (i in 0..seof) {
                t = 0
                while (t < slen) {
                    if (isInitialSound(search[t]) && isHangul(value[i + t])) {
                        if (getInitialSound(value[i + t]) == search[t]) {
                            t++
                            Log.e("123123","여기야 여기")
                        }
                        else
                            break
                    } else {
                        Log.e("123123","여기야 여222기")

                        if (value[i + t] == search[t])
                            t++
                        else
                            break
                    }
                }
                if (t == slen)
                    return true
            }
            Log.e("123123","여기야 여기33")
            return false

        }
    }
}


