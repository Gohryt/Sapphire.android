package gohryt.sapphire.elements

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.ExperimentalLayout
import androidx.compose.foundation.layout.InternalLayoutApi
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.node.ExperimentalLayoutNodeApi
import androidx.compose.ui.text.input.TextFieldValue
import gohryt.sapphire.resources.Strings

@Immutable
@OptIn(
    ExperimentalLayoutNodeApi::class,
    ExperimentalLayout::class,
    InternalLayoutApi::class,
    ExperimentalUnsignedTypes::class
)
@RequiresApi(Build.VERSION_CODES.R)
object Input {
    @Composable
    fun default(
        text: String
    ) {
        val textState = remember { mutableStateOf(TextFieldValue(text)) }
        BasicTextField(
            value = textState.value,
            onValueChange = { textState.value = it }
        )
        BasicText(textState.value.text)
    }
}