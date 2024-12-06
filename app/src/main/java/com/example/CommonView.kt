package com.example

import android.util.Size
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.example.appui.R
import com.example.appui.ui.theme.txtNameColor
import com.sdp
import com.sfProDisplayRegular
import com.ssp

@Composable
fun CvIconButton(iconPath: Int, iconDescription: String, modifier: Modifier, onClick: () -> Unit) {
    androidx.compose.material3.IconButton(modifier = modifier,
        content = {
            Image(painterResource(iconPath), contentDescription = iconDescription)
        },
        onClick = {
            onClick.invoke()
        })
}

@Composable
fun CircularImageView(
    imgRes: Int,
    imageDesc: String = "avatar",
    size: Dp = 64.sdp,
    borderColor: Color = Color.Gray,
    borderSize: Dp = 2.sdp,
    contentScale: ContentScale = ContentScale.Crop,
    modifier: Modifier
) {
    Image(
        painter = painterResource(imgRes),
        contentDescription = imageDesc,
        contentScale = contentScale,
        modifier = modifier
            .size(size)
            .border(borderSize, borderColor, CircleShape)

    )
}

@Composable
fun CvImageView(resId: Int, contentDes: String, modifier: Modifier) {
    Image(
        painter = painterResource(resId),
        contentDes,
        modifier = modifier
    )
}

@Composable
fun CvTextView(
    txt: String = "hello",
    modifier: Modifier = Modifier.padding(0.sdp),
    style: TextStyle = sfProDisplayRegular,
    fontSize: TextUnit = 12.sp,
    fontWeight: FontWeight = FontWeight.Normal,
    textColor: Color = txtNameColor
) {

    Text(
        text = txt,
        modifier = modifier,
        style = style,
        fontSize = fontSize,
        fontWeight = fontWeight,
        color = textColor,
        overflow = TextOverflow.Visible
    )
}

@Composable
fun XifiPayView(
    modifier: Modifier,
    isVisible: Boolean
) {
    if(isVisible)
        Image(painter = painterResource(R.drawable.ic_xifi_pay), "Xifi Pay", modifier = modifier)
}