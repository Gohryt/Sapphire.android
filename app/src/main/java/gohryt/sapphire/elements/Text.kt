package gohryt.sapphire.elements

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.ExperimentalLayout
import androidx.compose.foundation.layout.InternalLayoutApi
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.node.ExperimentalLayoutNodeApi
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow

@Immutable
@OptIn(
    ExperimentalLayoutNodeApi::class,
    ExperimentalLayout::class,
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
        style: TextStyle = TextStyle.Default,
        onTextLayout: (TextLayoutResult) -> Unit = {},
        overflow: TextOverflow = TextOverflow.Clip,
        softWrap: Boolean = true,
        maxLines: Int = Int.MAX_VALUE,
    ) {
        BasicText(
            AnnotatedString(text = text),
            modifier,
            style.merge(other = TextStyle(color = color)),
            onTextLayout,
            overflow,
            softWrap,
            maxLines
        )
    }
}