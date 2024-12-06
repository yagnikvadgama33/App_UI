package com


import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appui.R

val Int.sdp: Dp
    @Composable
    get() = this.sdpGet()

val Int.ssp: TextUnit
    @Composable get() = this.textSdp(density = LocalDensity.current)

@Composable
private fun Int.textSdp(density: Density): TextUnit = with(density) {
    this@textSdp.sdp.toSp()
}

@Composable
private fun Int.sdpGet(): Dp {

    val id = when (this) {
        in 1..600 -> "_${this}sdp"
        in (-60..-1) -> "_minus${this}sdp"
        else -> return this.dp
    }

    val resourceField = getFieldId(id)
    return if (resourceField != 0) dimensionResource(id = resourceField) else this.dp

}

@Composable
private fun getFieldId(id: String): Int {
    val context = LocalContext.current
    return context.resources.getIdentifier(id, "dimen", context.packageName)

}

enum class TransactionType {
    CREDIT, DEBIT
}

var sfProDisplayRegular = TextStyle(
    fontFamily = FontFamily(Font(R.font.sf_pro_display_regular)),
    fontSize = 12.sp,
)

var sfProDisplayBold = TextStyle(
    fontFamily = FontFamily(Font(R.font.sf_pro_display_bold)),
    fontSize = 16.sp,
)

var robotoRegular = TextStyle(
    fontFamily =FontFamily(Font(R.font.roboto_regular)),
    fontSize = 14.sp,
)

var productSansRegular = TextStyle(
    fontSize = 13.sp,
    fontFamily = FontFamily(Font(R.font.new_product_sans_regular))
)

var productSansMedium = TextStyle(
    fontFamily = FontFamily(Font(R.font.product_sans_medium)),
    fontSize = 14.sp
)