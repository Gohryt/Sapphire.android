package gohryt.sapphire.elements

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.ExperimentalLayout
import androidx.compose.foundation.layout.InternalLayoutApi
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.OutlinedTextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.node.ExperimentalLayoutNodeApi
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.InternalTextApi
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
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
object Input {
    @Composable
    fun default(
        modifier: Modifier = Modifier,
        target: MutableState<TextFieldValue>,
        backgroundColor: Color,
        shape: Shape,
        color: Color,
        style: TextStyle = TextStyle.Default
    ) {
        BasicTextField(
            modifier = modifier
                .background(
                    color = backgroundColor,
                    shape = shape
                )
                .clip(shape = shape)
                .padding(all = 8.dp),
            textStyle = style.merge(other = TextStyle(color = color)),
            singleLine = true,
            maxLines = 1,
            value = target.value,
            onValueChange = {target.value = it}
        )
    }
}