package gohryt.sapphire.elements

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.ExperimentalLayout
import androidx.compose.foundation.layout.InternalLayoutApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.DefaultAlpha
import androidx.compose.ui.graphics.vector.VectorAsset
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.*
import androidx.compose.ui.node.ExperimentalLayoutNodeApi
import kotlin.math.min

@Immutable
@OptIn(
    ExperimentalLayoutNodeApi::class,
    ExperimentalLayout::class,
    InternalLayoutApi::class,
    ExperimentalUnsignedTypes::class
)
@RequiresApi(Build.VERSION_CODES.R)
object Icon {
    @Composable
    fun default(
        asset: VectorAsset,
        modifier: Modifier,
        scale: Float = 0.8f
    ) {
        Image(
            painter = rememberVectorPainter(asset),
            modifier = modifier,
            alignment = Alignment.Center,
            contentScale = object : ContentScale {
                override fun computeScaleFactor(srcSize: Size, dstSize: Size): ScaleFactor {
                    return min(
                        a = (dstSize.width / srcSize.width),
                        b = (dstSize.height / srcSize.height)
                    ).let {
                        ScaleFactor(it * scale, it * scale)
                    }
                }
            },
            alpha = DefaultAlpha,
            colorFilter = null
        )
    }
}