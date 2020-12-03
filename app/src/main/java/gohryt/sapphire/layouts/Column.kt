package gohryt.sapphire.layouts

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.node.ExperimentalLayoutNodeApi
import androidx.compose.ui.unit.dp

@Immutable
@OptIn(
    ExperimentalLayoutNodeApi::class,
    ExperimentalLayout::class,
    InternalLayoutApi::class,
    ExperimentalUnsignedTypes::class
)
@RequiresApi(Build.VERSION_CODES.R)
object Column {
    @Composable
    fun default(
        modifier: Modifier = Modifier,
        verticalArrangement: Arrangement.Vertical = Arrangement.Top,
        horizontalAlignment: Alignment.Horizontal = Alignment.Start,
        content: @Composable ColumnScope.() -> Unit
    ) {
        Column(
            modifier = modifier,
            verticalArrangement = verticalArrangement,
            horizontalAlignment = horizontalAlignment,
            content = content
        )
    }

    @Composable
    fun scrollable(
        modifier: Modifier = Modifier,
        scrollState: ScrollState = rememberScrollState(0f),
        verticalArrangement: Arrangement.Vertical = Arrangement.Top,
        horizontalAlignment: Alignment.Horizontal = Alignment.Start,
        reverseScrollDirection: Boolean = false,
        isScrollEnabled: Boolean = true,
        contentPadding: PaddingValues = PaddingValues(0.dp),
        content: @Composable ColumnScope.() -> Unit
    ) {
        Column(
            modifier = modifier
                .verticalScroll(
                    scrollState,
                    isScrollEnabled,
                    reverseScrolling = reverseScrollDirection
                )
                .clipToBounds()
                .padding(contentPadding),
            verticalArrangement = verticalArrangement,
            horizontalAlignment = horizontalAlignment,
            content = content
        )
    }
}