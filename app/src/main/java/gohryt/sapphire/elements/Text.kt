package gohryt.sapphire.elements

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.ExperimentalLayout
import androidx.compose.foundation.layout.InternalLayoutApi
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.CoreText
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.node.ExperimentalLayoutNodeApi
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.text
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.InternalTextApi
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow

@Immutable
@OptIn(
    ExperimentalLayoutNodeApi::class,
    ExperimentalLayout::class,
    InternalTextApi::class,
    InternalLayoutApi::class,
    ExperimentalUnsignedTypes::class
)
@RequiresApi(Build.VERSION_CODES.R)
object Text {
    @Composable
    fun default(
        text: String,
        color: Color,
        modifier: Modifier = Modifier,
        style: TextStyle = TextStyle.Default
    ) {
        BasicText(
            AnnotatedString(text = text),
            modifier,
            style.merge(other = TextStyle(color = color)),
            onTextLayout = {},
            overflow = TextOverflow.Clip,
            softWrap = true,
            maxLines = Int.MAX_VALUE
        )
    }
}