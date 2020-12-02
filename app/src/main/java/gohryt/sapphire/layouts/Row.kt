package gohryt.sapphire.layouts

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
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
object Row {
    @Composable
    fun default(
        modifier: Modifier = Modifier,
        horizontalArrangement: Arrangement.Horizontal = Arrangement.Start,
        verticalAlignment: Alignment.Vertical = Alignment.Top,
        children: @Composable RowScope.() -> Unit
    ) {
        Row(
            modifier = modifier,
            horizontalArrangement = horizontalArrangement,
            verticalAlignment = verticalAlignment,
            children = children
        )
    }

    @Composable
    fun scrollable(
        modifier: Modifier = Modifier,
        scrollState: ScrollState = rememberScrollState(0f),
        horizontalArrangement: Arrangement.Horizontal = Arrangement.Start,
        verticalAlignment: Alignment.Vertical = Alignment.Top,
        reverseScrollDirection: Boolean = false,
        isScrollEnabled: Boolean = true,
        contentPadding: PaddingValues = PaddingValues(0.dp),
        children: @Composable RowScope.() -> Unit
    ) {
        Row(
            modifier = modifier
                .horizontalScroll(
                    scrollState,
                    isScrollEnabled,
                    reverseScrolling = reverseScrollDirection
                )
                .clipToBounds()
                .padding(contentPadding),
            horizontalArrangement = horizontalArrangement,
            verticalAlignment = verticalAlignment,
            children = children
        )
    }
}