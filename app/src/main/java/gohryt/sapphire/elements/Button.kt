package gohryt.sapphire.elements

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.ExperimentalLayout
import androidx.compose.foundation.layout.InternalLayoutApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.node.ExperimentalLayoutNodeApi
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.InternalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

@Immutable
@OptIn(
    ExperimentalLayoutNodeApi::class,
    ExperimentalLayout::class,
    InternalTextApi::class,
    InternalLayoutApi::class,
    ExperimentalUnsignedTypes::class
)
@RequiresApi(Build.VERSION_CODES.R)
object Button {
    @Composable
    fun default(
        modifier: Modifier = Modifier,
        backgroundColor: Color,
        shape: Shape,
        text: String,
        onclick: () -> Unit,
        color: Color,
        style: TextStyle = TextStyle.Default
    ) {
        Row(
            modifier = modifier
                .background(
                    color = backgroundColor,
                    shape = shape
                )
                .clip(shape = shape)
                .clickable(onClick = onclick)
        ) {
            BasicText(
                AnnotatedString(text = text),
                modifier = Modifier
                    .padding(all = 8.dp),
                style.merge(other = TextStyle(color = color)),
                onTextLayout = {},
                overflow = TextOverflow.Clip,
                softWrap = true,
                maxLines = Int.MAX_VALUE
            )
        }
    }
}