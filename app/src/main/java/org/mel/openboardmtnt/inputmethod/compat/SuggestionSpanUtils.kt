package org.mel.openboardmtnt.inputmethod.compat

import android.content.Context
import android.text.Spannable
import android.text.SpannableString
import android.text.Spanned
import android.text.TextUtils
import android.text.style.SuggestionSpan
import org.mel.openboardmtnt.inputmethod.annotations.UsedForTesting
import org.mel.openboardmtnt.inputmethod.latin.SuggestedWords
import org.mel.openboardmtnt.inputmethod.latin.SuggestedWords.SuggestedWordInfo
import org.mel.openboardmtnt.inputmethod.latin.common.LocaleUtils
import org.mel.openboardmtnt.inputmethod.latin.define.DebugFlags
import java.util.*

object SuggestionSpanUtils {
    // Note that SuggestionSpan.FLAG_AUTO_CORRECTION has been introduced
// in API level 15 (Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1).
    private val FIELD_FLAG_AUTO_CORRECTION = CompatUtils.getField(
            SuggestionSpan::class.java, "FLAG_AUTO_CORRECTION")
    private val OBJ_FLAG_AUTO_CORRECTION: Int? = CompatUtils.getFieldValue(
            null /* receiver */, null /* defaultValue */, FIELD_FLAG_AUTO_CORRECTION) as Int

    @kotlin.jvm.JvmStatic
    @UsedForTesting
    fun getTextWithAutoCorrectionIndicatorUnderline(
            context: Context?, text: String,locale: Locale?): CharSequence {
        if (TextUtils.isEmpty(text) || OBJ_FLAG_AUTO_CORRECTION == null) {
            return text
        }
        val spannable: Spannable = SpannableString(text)
        val suggestionSpan = SuggestionSpan(context, locale, arrayOf(), OBJ_FLAG_AUTO_CORRECTION, null)
        spannable.setSpan(suggestionSpan, 0, text.length,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE or Spanned.SPAN_COMPOSING)
        return spannable
    }

    init {
        if (DebugFlags.DEBUG_ENABLED) {
            if (OBJ_FLAG_AUTO_CORRECTION == null) {
                throw RuntimeException("Field is accidentially null.")
            }
        }
    }
}