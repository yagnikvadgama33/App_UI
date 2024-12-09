package com.example.appui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.LocalTextSelectionColors
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.CircularImageView
import com.example.CvTextView
import com.example.appui.ui.theme.AppUITheme
import com.example.appui.ui.theme.txtGreen
import com.example.appui.ui.theme.txtNameColor
import com.example.appui.ui.theme.txtOrange
import com.example.appui.ui.theme.vpaIdColor
import com.robotoRegular
import com.sdp
import com.sfProDisplayBold
import com.ssp

class MainActivityDemo : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppUITheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
                    CurvedCardPreview()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Canvas(
        modifier = Modifier
            .background(
                color = Color.Yellow
            )
            .paint(
                painter = painterResource(id = R.drawable.ic_box_border)
            )
            .fillMaxSize()
        // .padding(8.dp)
    ) {
        val height = size.height
        val width = size.width

        val topCurveLinePath = Path().apply {
            moveTo(100f, 500f) // Start point of the line
            quadraticBezierTo(
                500f, 480f, // Control point for the curve (adjust y to add curvature)
                1000f, 500f  // End point of the line (extended line length)
            )
        }

        drawPath(
            path = topCurveLinePath,
            color = Color.DarkGray,
            style = Stroke(width = 1.dp.toPx()) // Line width
        )

        val bottomCurveLinePath = Path().apply {
            moveTo(100f, 500f) // Start point of the line
            quadraticBezierTo(
                500f, 520f, // Control point for the curve (adjust y to create downward curvature)
                1000f, 500f  // End point of the line (extended line length)
            )
        }

        drawPath(
            path = bottomCurveLinePath,
            color = Color.DarkGray,
            style = Stroke(width = 1.dp.toPx()) // Line width
        )
    }
}

@Preview(showBackground = true, showSystemUi = true, device = Devices.PIXEL_7)
@Composable
fun GreetingPreview() {
    AppUITheme {
//        Greeting("Android")
        CurvedCardPreview()
    }
}

/*@Composable
fun CurvedCard() {
    Canvas(modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 100.dp)
        .height(70.dp)) {

        val path = Path().apply {
            val curveHeight = 30f
            moveTo(0f, curveHeight) // Start at top-left corner
            quadraticBezierTo(
                size.width / 2, // Control point X
                0f, // Control point Y (peak of curve)
                size.width, // End point X
                curveHeight // End point Y
            )
            lineTo(size.width, size.height - curveHeight) // Move to bottom-right corner
            quadraticBezierTo(
                size.width / 2, // Control point X
                size.height, // Control point Y (dip of curve)
                0f, // End point X
                size.height - curveHeight // End point Y
            )
            close() // Close the path
        }

        // Draw the path with a border and fill color
        drawPath(
            path = path,
            color = Color.White
        )
        drawPath(
            path = path,
            color = Color(0xFF6200EE), // Border color
            style = Stroke(width = 6f) // Border width
        )
    }
}*/

@Composable
fun CurvedCard() {
    Box(
        modifier = Modifier
            .background(Color.LightGray)
            .padding(vertical = 100.dp)
            .paint(painterResource(R.drawable.ic_box_border))
            .scale(0.93f)
    ) {

        Canvas(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp)
                .height(60.dp)
        ) {

            val path = Path().apply {
                val curveHeight = 30f
                val cornerRadius = 12.dp.toPx() // Convert dp to pixels

                // Start at the top-left corner with a rounded corner
                moveTo(0f, cornerRadius) // Move to the top-left point
                arcTo(
                    rect = Rect(0f, 0f, cornerRadius * 2, cornerRadius * 2),
                    startAngleDegrees = 180f,
                    sweepAngleDegrees = 90f,
                    forceMoveTo = false
                )

                // Top curve
                quadraticBezierTo(
                    size.width / 2, // Control point X
                    -17f, // Control point Y (peak of curve)
                    size.width - cornerRadius, // End point X
                    0f // End point Y
                )

                // Top-right corner
                arcTo(
                    rect = Rect(
                        size.width - cornerRadius * 2,
                        0f,
                        size.width,
                        cornerRadius * 2
                    ),
                    startAngleDegrees = 270f,
                    sweepAngleDegrees = 90f,
                    forceMoveTo = false
                )

                // Right side
                lineTo(size.width, size.height - curveHeight - cornerRadius)

                // Bottom-right corner
                arcTo(
                    rect = Rect(
                        size.width - cornerRadius * 2,
                        size.height - curveHeight - cornerRadius * 2,
                        size.width,
                        size.height - curveHeight
                    ),
                    startAngleDegrees = 0f,
                    sweepAngleDegrees = 90f,
                    forceMoveTo = false
                )

                // Bottom curve
                quadraticBezierTo(
                    size.width / 2, // Control point X
                    140f, // Control point Y (dip of curve)
                    cornerRadius, // End point X
                    size.height - curveHeight // End point Y
                )

                // Bottom-left corner
                arcTo(
                    rect = Rect(
                        0f,
                        size.height - curveHeight - cornerRadius * 2,
                        cornerRadius * 2,
                        size.height - curveHeight
                    ),
                    startAngleDegrees = 90f,
                    sweepAngleDegrees = 90f,
                    forceMoveTo = false
                )

                // Left side
                lineTo(0f, curveHeight + cornerRadius)

                close() // Close the path
            }

            // Draw the path with a border and fill color
            drawPath(
                path = path,
                color = Color.White
            )
            drawPath(
                path = path,
                color = Color.Transparent, // Border color
                style = Stroke(width = 6f) // Border width
            )
        }
    }
}


@Preview(showSystemUi = true, device = Devices.PIXEL_7)
@Composable
fun CurvedCardPreview() {
    Box(
        modifier = Modifier
//            .fillMaxSize(),
    ) {
        CurvedCard()
    }
}
