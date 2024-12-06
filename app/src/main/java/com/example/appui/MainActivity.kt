package com.example.appui

import android.bluetooth.BluetoothClass.Device
import android.os.Bundle
import android.provider.CalendarContract.Colors
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.LocalTextSelectionColors
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.TransactionType
import com.example.CircularImageView
import com.example.CvIconButton
import com.example.CvImageView
import com.example.CvTextView
import com.example.XifiPayView
import com.example.appui.ui.model.Transaction
import com.example.appui.ui.theme.AppUITheme
import com.example.appui.ui.theme.brightOrange
import com.example.appui.ui.theme.dividerColor
import com.example.appui.ui.theme.liteGreen
import com.example.appui.ui.theme.inviteFrndBg
import com.example.appui.ui.theme.liteTxtColor
import com.example.appui.ui.theme.starBgColor
import com.example.appui.ui.theme.subTxtColor
import com.example.appui.ui.theme.txtGreen
import com.example.appui.ui.theme.txtNameColor
import com.example.appui.ui.theme.txtOrange
import com.example.appui.ui.theme.txtViewAll
import com.example.appui.ui.theme.vpaIdColor
import com.productSansMedium
import com.productSansRegular
import com.robotoRegular
import com.sdp
import com.sfProDisplayBold
import com.sfProDisplayRegular
import com.ssp
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.colorspace.WhitePoint
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cardex.ui.util.common.components.squircle.CornerSmoothing
import com.cardex.ui.util.common.components.squircle.SquircleShape

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val scrollState = rememberScrollState()

            AppUITheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TopAppBar(
                            colors = TopAppBarDefaults.topAppBarColors(
                                containerColor = Color.Transparent,
                                scrolledContainerColor = Color.Blue
                            ),
                            title = {},
                            navigationIcon = {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                ) {
                                    CvIconButton(
                                        R.drawable.ic_back,
                                        modifier = Modifier.scale(1.2f),
                                        iconDescription = "Back"
                                    ) { }
                                    CvIconButton(
                                        R.drawable.ic_setting, modifier = Modifier.scale(1.2f),
                                        iconDescription = "Setting"
                                    ) { }
                                }
                            }
                        )
                    }) { innerPadding ->
                    MainScreenUI(scrollState)
                    MainUiPreview()
                }
            }
        }
    }

    @Composable
    fun MainScreenUI(scrollState: androidx.compose.foundation.ScrollState) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(state = scrollState)
                .background(Color.White)
        ) {
            Column(modifier = Modifier.fillMaxHeight(0.5f)) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .paint(
                            painter = painterResource(id = R.drawable.ic_bg),
                            contentScale = ContentScale.FillBounds
                        )
                        .padding(top = 120.sdp)
                ) {
                    Column {
                        Row(
                            horizontalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(IntrinsicSize.Max)

                        ) {
                            Box(
                                contentAlignment = Alignment.BottomEnd, // Aligns the QR code at the bottom-right
                                modifier = Modifier
                            ) {
                                CircularImageView(
                                    imgRes = R.drawable.ic_profile_pic,
                                    modifier = Modifier.size(50.sdp)
                                )
                                Box(
                                    modifier = Modifier
                                        .size(24.sdp) // Size of the QR code container
                                        .clip(CircleShape),
                                    contentAlignment = Alignment.BottomEnd
                                ) {
                                    CircularImageView(
                                        imgRes = R.drawable.ic_scanner,
                                        modifier = Modifier
                                    )
                                }
                            }

                            Spacer(modifier = Modifier.width(16.dp))

                            Column(
                                modifier = Modifier.fillMaxHeight(),
                                verticalArrangement = Arrangement.spacedBy(3.dp),
                                horizontalAlignment = Alignment.Start
                            ) {
                                Text(
                                    text = "Name Surname",
                                    fontSize = 19.ssp,
                                    color = txtNameColor,
                                    style = sfProDisplayBold,
                                    modifier = Modifier
                                )
                                Row {
                                    Text(
                                        text = "VPA ID:  ",
                                        style = robotoRegular,
                                        fontSize = 13.ssp,
                                        color = txtNameColor
                                    )
                                    Text(
                                        text = "cryptouser@ixfi",
                                        style = robotoRegular,
                                        fontSize = 13.ssp,
                                        color = vpaIdColor
                                    )
                                    Image(
                                        painter = painterResource(R.drawable.ic_copy),
                                        contentDescription = "Copy",
                                        Modifier
                                            .padding(start = 8.sdp)
                                            .size(14.sdp)
                                    )
                                }
                            }
                        }

                        Spacer(Modifier.padding(top = 36.dp))

//                        CurvedLineUI()

                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 18.sdp)
                                .background(
                                    color = Color.White
                                )
                                .paint(
                                    painter = painterResource(id = R.drawable.ic_box_border)
                                )
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.fillMaxHeight()
                            ) {
                                val text by remember { mutableStateOf("") }
                                OutlinedTextField(
                                    value = text,
                                    onValueChange = {},
                                    placeholder = {
                                        Text(
                                            text = "Pay to Contact",
                                            color = Color.Gray
                                        )
                                    },
                                    leadingIcon = {
                                        Image(
                                            painter = painterResource(R.drawable.ic_search), // Replace with your drawable resource
                                            contentDescription = "Search Icon"
                                        )
                                    },
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .weight(2.5f),
                                    colors = OutlinedTextFieldDefaults.colors(
                                        focusedContainerColor = Color.Transparent,
                                        unfocusedContainerColor = Color.Transparent,
                                        disabledContainerColor = Color.Transparent,
                                        errorContainerColor = Color.Transparent,
                                        cursorColor = Color.Black,
                                        selectionColors = LocalTextSelectionColors.current,
                                        focusedBorderColor = Color.Transparent, // Set transparent since we're using a custom border
                                        unfocusedBorderColor = Color.Transparent
                                    ),
                                    shape = RoundedCornerShape(8.dp) // Rounded corners
                                )
                                Image(
                                    painter = painterResource(R.drawable.ic_scan_to_pay),
                                    "Scan to Pay",
                                    modifier = Modifier
                                        .weight(1f)
                                        .padding(end = 8.sdp),
                                )
                            }
                        }

                        Box(modifier = Modifier.fillMaxSize()) {
                            // Background Image
                            Image(
                                painter = painterResource(id = R.drawable.banner_unlock), // Replace with your image resource
                                contentDescription = "Background Image",
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(
                                        top = 14.sdp,
                                        start = 18.sdp,
                                        end = 18.sdp,
                                        bottom = 18.sdp
                                    ),
                            )

                            // Overlay content
                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(start = 48.sdp, top = 30.sdp),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.Start
                            ) {
                                // Main Title
                                CvTextView(
                                    txt = "Unlock",
                                    fontSize = 28.ssp,
                                    style = sfProDisplayBold,
                                    textColor = Color.White,
                                )

                                Spacer(modifier = Modifier.height(4.dp))

                                // Subtext with icons
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Text(
                                        text = "Send",
                                        fontSize = 14.ssp,
                                        fontWeight = FontWeight.Bold,
                                        color = txtOrange
                                    )
                                    Spacer(modifier = Modifier.width(4.dp))
                                    Image(
                                        painter = painterResource(id = R.drawable.ic_arrow_send), // Replace with your send icon resource
                                        contentDescription = "Send Icon",
                                        modifier = Modifier.size(14.dp)
                                    )
                                    Text(
                                        text = ",",
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color.White,
                                        modifier = Modifier.padding(horizontal = 2.sdp)
                                    )

                                    Text(
                                        text = "Receive",
                                        fontSize = 14.ssp,
                                        fontWeight = FontWeight.Bold,
                                        color = txtGreen
                                    )
                                    Spacer(modifier = Modifier.width(2.dp))
                                    Image(
                                        painter = painterResource(id = R.drawable.ic_arrow_receive), // Replace with your receive icon resource
                                        contentDescription = "Receive Icon",
                                        modifier = Modifier.size(14.dp)
                                    )
                                }

                                // Footer Text
                                CvTextView(
                                    txt = "Payments",
                                    fontSize = 26.ssp,
                                    style = sfProDisplayBold,
                                    fontWeight = FontWeight.SemiBold,
                                    textColor = Color.White,
                                    modifier = Modifier.padding(top = 4.sdp),
                                )
                            }
                        }
                    }
                }
            }

            //Xifi pay
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 26.sdp),
                horizontalArrangement = Arrangement.Center
            ) {
                XifiPayView(modifier = Modifier, isVisible = true)

                Box(
                    modifier = Modifier
                        .align(Alignment.Bottom)
                        .padding(start = 3.sdp, bottom = 2.sdp)
                ) {
                    Text(
                        "to",
                        style = sfProDisplayRegular,
                        fontSize = 22.ssp,
                        color = txtNameColor
                    )
                }
                Image(
                    painter = painterResource(R.drawable.ic_down_arrow),
                    "Down Arrow",
                    alignment = Alignment.BottomCenter,
                    modifier = Modifier
                        .padding(start = 3.sdp, top = 12.sdp)
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 18.sdp, start = 16.sdp, end = 16.sdp),
                horizontalArrangement = Arrangement.SpaceEvenly
            )
            {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    CvImageView(
                        resId = R.drawable.ic_contact,
                        "Contact",
                        modifier = Modifier.size(80.sdp)
                    )
                    CvTextView(
                        "Contacts",
                        modifier = Modifier.padding(top = 3.sdp),
                        fontSize = 13.ssp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    CvImageView(
                        resId = R.drawable.ic_vpa,
                        "Vpa",
                        modifier = Modifier.size(80.sdp)
                    )
                    CvTextView(
                        "VPA",
                        modifier = Modifier.padding(top = 3.sdp),
                        fontSize = 13.ssp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    CvImageView(
                        resId = R.drawable.ic_receive,
                        "Receive",
                        modifier = Modifier.size(80.sdp)
                    )
                    CvTextView(
                        "Receive",
                        modifier = Modifier.padding(top = 3.sdp),
                        fontSize = 13.ssp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Spacer(modifier = Modifier.padding(top = 28.sdp))

            //USDC Free Transfer
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.sdp)
                    .offset(x = 18.sdp)
                    .background(
                        color = starBgColor,
                        shape = RoundedCornerShape(
                            topStart = 100.sdp,
                            bottomStart = 100.sdp
                        )
                    )
            ) {
                Row {
                    Image(
                        painter = painterResource(R.drawable.ic_percent_star_bg),
                        "star bg",
                        modifier = Modifier
                            .offset(x = (-10).dp, y = (-2).sdp)
                            .scale(1.1f)
                    )
                    // Content above the image
                    Column(
                        modifier = Modifier
                            .padding(top = 16.sdp, bottom = 16.sdp, end = 18.sdp)
                    ) {
                        // Text Content
                        CvTextView(
                            txt = "\uD83D\uDC4B USDC Free Transfer",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            style = sfProDisplayBold
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        CvTextView(
                            txt = "Now you can transfer FREE Payments in USDC for unlimited times.",
                            fontSize = 14.ssp,
                            style = robotoRegular,
                            textColor = subTxtColor,
                            modifier = Modifier.padding(start = 10.sdp)
                        )
                    }
                }
            }

            Spacer(Modifier.height(34.sdp))

            //Your Contacts
            ProfileTitleWithXifiPay("Your Contact on")

            Spacer(modifier = Modifier.size(3.sdp))

            //Profile for Xifi Pay
            XifiPayHorizontalProfileList(
                listOf(
                    Pair(R.drawable.ic_user_1, "Leesa Monork"),
                    Pair(R.drawable.ic_user_2, "Smith Smith"),
                    Pair(R.drawable.ic_user_3, "Miller Davis"),
                    Pair(R.drawable.ic_user_4, "Manica Jho")
                )
            )

            //Invite your Friend
            Row(
                modifier = Modifier
                    .height(IntrinsicSize.Max)
                    .fillMaxWidth()
                    .padding(22.sdp)
                    .background(inviteFrndBg, shape = RoundedCornerShape(14.sdp)),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 28.sdp)
                ) {
                    CvTextView(
                        txt = "Invite Your friends",
                        style = sfProDisplayBold,
                        fontSize = 19.ssp
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    CvTextView(
                        txt = "Invite your friends to Earn IXFI points ",
                        style = robotoRegular,
                        fontSize = 15.ssp,
                        textColor = liteTxtColor
                    )
                }
                Image(
                    painter = painterResource(R.drawable.ic_invite_frnd),
                    "Invite your friend",
                    modifier = Modifier.size(150.sdp),
                    contentScale = ContentScale.Fit
                )
            }

            Spacer(modifier = Modifier.size(8.sdp))

            ProfileTitleWithXifiPay("Buy more with")
            Spacer(modifier = Modifier.size(3.sdp))

            //Profile for Xifi Pay
            XifiPayHorizontalProfileList(
                listOf(
                    Pair(R.drawable.ic_brand_1, "Puma"),
                    Pair(R.drawable.ic_brand_2, "Starbucks"),
                    Pair(R.drawable.ic_brand_3, "Ferrari"),
                    Pair(R.drawable.ic_brand_4, "Dominoz")
                )
            )

            Spacer(modifier = Modifier.size(12.sdp))

            //Recent Transactions
            ProfileTitleWithXifiPay("Recent Transactions", showXifiPay = false)
            TransactionListUI()

            Image(
                painter = painterResource(R.drawable.ic_design_with_love_care),
                "Bottom Hader",
                alignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 22.sdp)
                    .navigationBarsPadding()
            )
        }
    }

    @Composable
    fun TransactionListUI() {
        val transactions = listOf(
            Transaction(
                "Martine D",
                500,
                "28/05/23 10:11:12",
                TransactionType.DEBIT,
                null
            ),
            Transaction(
                "Leesa M",
                2800,
                "30/05/23 10:11:12",
                TransactionType.CREDIT,
                R.drawable.ic_user_1
            ),
            Transaction(
                "Kareem K",
                500,
                "28/05/23 10:11:12",
                TransactionType.DEBIT,
                R.drawable.ic_user_kareem
            ),
            Transaction(
                "Manica J",
                500,
                "28/05/23 10:11:12",
                TransactionType.CREDIT,
                R.drawable.ic_user_manica
            )
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.sdp) // Light background
        ) {
            transactions.forEach { transaction ->
                TransactionItem(transaction)
            }
        }
    }

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

    @Composable
    fun CustomShape(modifier: Modifier) {
        Canvas(modifier = modifier) {
            val width = size.width
            val height = size.height
            val cornerRadius = 30f
            val curveHeight = 20f

            val path = Path().apply {
                // Start at the top-left corner
                moveTo(cornerRadius, 0f)
                lineTo(width - cornerRadius, 0f)
                cubicTo(
                    width, 0f, // Control point 1
                    width, height / 2 - curveHeight, // Control point 2
                    width - cornerRadius, height / 2 // End of the curve
                )
                lineTo(width - cornerRadius, height - cornerRadius)
                cubicTo(
                    width, height, // Control point 1 for bottom curve
                    width / 2, height, // Control point 2
                    cornerRadius, height - cornerRadius // End point for bottom-left curve
                )
                lineTo(0f, cornerRadius)
                close() // Close the shape
            }

            // Draw the shape with a fill color
            drawPath(
                path = path,
                color = Color.White // Shape fill color
            )

            // Optional: Draw a border for the shape
            drawPath(
                path = path,
                color = Color.LightGray, // Border color
                style = Stroke(width = 2f) // Border thickness
            )
        }
    }

    @Composable
    fun CurvedLineUI() {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 18.sdp)
                .height(56.dp)  // Reduced height further
                .background(
                    Color.White,
                    shape = SquircleShape(28.sdp, cornerSmoothing = CornerSmoothing.High)
                )  // Ensure rounded corners
        ) {
            // Canvas for the curved border
//            Canvas(
//                modifier = Modifier.fillMaxSize()
//            ) {
//                val cornerRadius = 14.dp.toPx()  // Convert Dp to Px for rounded corners
//                val curveHeight = size.height * 0.1f // Controls the curve height, you can adjust this value for a subtle curve
//
//                val path = Path().apply {
//                    // Start at the top-left corner
//                    moveTo(cornerRadius, 0f)
//
//                    // Subtle curve on top line
//                    quadraticBezierTo(
//                        size.width * 0.5f, -curveHeight,  // Slight curve control point above the box
//                        size.width - cornerRadius, 0f     // End at the top-right corner
//                    )
//
//                    // Right side curve
//                    lineTo(size.width, size.height - cornerRadius)
//                    quadraticBezierTo(
//                        size.width, size.height,
//                        size.width - cornerRadius, size.height
//                    )
//
//                    // Bottom-right curve
//                    lineTo(cornerRadius, size.height)
//                    quadraticBezierTo(
//                        0f, size.height,
//                        0f, size.height - cornerRadius
//                    )
//
//                    // Left side curve
//                    lineTo(0f, cornerRadius)
//                    quadraticBezierTo(
//                        0f, 0f,
//                        cornerRadius, 0f
//                    )
//
//                    close() // Complete the path
//                }
//
//                drawPath(
//                    path = path,
//                    color = Color(0xFFD1C4E9),  // Light border color
//                    style = Stroke(width = 2.dp.toPx())  // Border width
//                )
//            }


            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                // Left Section: Search Icon and Text
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 8.dp)
                ) {
                    Icon(
                        painter = painterResource(android.R.drawable.ic_menu_search), // Replace with your search icon
                        contentDescription = "Search Icon",
                        tint = Color.Gray,
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Pay to Contact",
                        fontSize = 16.sp,
                        color = Color.Gray
                    )
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(R.drawable.ic_scan_to_pay), // Replace with your scan icon
                        contentDescription = "Scan Icon",
                    )
                }
            }
        }
    }


    @Composable
    fun TransactionItem(transaction: Transaction) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            // Profile Icon
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(color = brightOrange), // Dynamic color
                contentAlignment = Alignment.Center
            ) {
                if (transaction.profilePic == null) {
                    Text(
                        text = transaction.name[0].toString(),
                        color = Color.White,
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Bold
                    )
                } else {
                    Image(
                        painter = painterResource(id = transaction.profilePic),
                        contentDescription = null,
                        modifier = Modifier.scale(1.2f),
                        contentScale = ContentScale.FillBounds
                    )
                }
            }

            Spacer(modifier = Modifier.width(16.dp))

            // Details Section
            Column(
                modifier = Modifier.weight(1f)
            ) {
                // Name
                CvTextView(
                    txt = transaction.name,
                    style = productSansMedium,
                    fontSize = 15.ssp
                )

                Spacer(modifier = Modifier.height(4.dp))

                // Sent Securely Row
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(top = 4.sdp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(8.dp)
                            .clip(CircleShape)
                            .background(liteGreen) // Green dot
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    CvTextView(
                        txt = setTransactionMessage(transaction.transactionType),
                        textColor = subTxtColor,
                        style = robotoRegular,
                        fontSize = 14.ssp
                    )
                }
            }

            Spacer(modifier = Modifier.width(16.dp))

            // Amount & Date
            Column(
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.padding(top = 4.sdp)
            ) {
                // Amount
                CvTextView(
                    txt = setTranscationType(transaction.amount, transaction.transactionType),
                    textColor = setAmountColor(transaction.transactionType), // Orange color
                    style = productSansRegular,
                    fontSize = 14.ssp
                )

                Spacer(modifier = Modifier.height(4.dp))

                // Date
                CvTextView(
                    txt = transaction.date,
                    textColor = subTxtColor,
                    style = productSansRegular,
                    fontSize = 14.ssp
                )
            }
        }

        // Divider
        HorizontalDivider(
            modifier = Modifier.padding(horizontal = 16.dp),
            thickness = 1.dp,
            color = dividerColor
        )
    }

    private fun setTranscationType(amount: Int, transactionType: TransactionType): String {
        return if (transactionType == TransactionType.CREDIT) {
            "+ €$amount"
        } else {
            "- €$amount"
        }
    }

    private fun setAmountColor(transactionType: TransactionType): Color {
        return if (transactionType == TransactionType.DEBIT) {
            brightOrange
        } else {
            liteGreen
        }
    }

    private fun setTransactionMessage(transactionType: TransactionType): String {
        return if (transactionType == TransactionType.DEBIT) {
            "Sent Securely"
        } else {
            "Received Successfully"
        }
    }

    @Composable
    fun XifiPayHorizontalProfileList(list: List<Pair<Int, String>>) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            list.forEach { profile ->
                ProfileCard(profileImage = profile.first, username = profile.second)
            }
        }
    }

    @Composable
    fun ProfileTitleWithXifiPay(title: String, showXifiPay: Boolean = true) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 12.sdp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row {
                CvTextView(
                    txt = title,
                    style = sfProDisplayBold,
                    fontSize = 19.ssp
                )
                XifiPayView(
                    modifier = Modifier
                        .height(24.sdp)
                        .padding(horizontal = 6.sdp),
                    isVisible = showXifiPay
                )
            }

            Row(
                modifier = Modifier.padding(end = 14.sdp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                CvTextView(
                    txt = "View all",
                    textColor = txtViewAll,
                    fontSize = 16.ssp,
                    style = productSansRegular
                )
                Icon(
                    painter = painterResource(R.drawable.ic_view_all),
                    "", modifier = Modifier
                        .scale(1.2f)
                        .padding(top = 2.sdp, start = 8.sdp)
                )
            }
        }
    }

    @Composable
    fun ProfileCard(profileImage: Int, username: String) {
        Column(
            modifier = Modifier
                .width(80.dp)
                .padding(horizontal = 4.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = profileImage),
                contentDescription = null,
                modifier = Modifier
                    .height(74.sdp)
                    .width(80.sdp)
                    .clip(RoundedCornerShape(16.sdp))
                    .background(Color.Gray),
                contentScale = ContentScale.FillBounds
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = username,
                style = robotoRegular,
                textAlign = TextAlign.Center,
                maxLines = 1,
                overflow = TextOverflow.Clip,
                fontSize = 11.ssp,
                color = txtNameColor,
                modifier = Modifier
            )
        }
    }

    @Preview(showSystemUi = true, device = Devices.PIXEL_7, showBackground = false)
    @Composable
    fun MainUiPreview() {
        /*  Box(
              modifier = Modifier
                  .fillMaxWidth()
                  .padding(horizontal = 18.sdp)
                  .background(
                      color = Color.White
                  )
                  .paint(
                      painter = painterResource(id = R.drawable.ic_box_border)
                  )
          ) {
              Row(
                  verticalAlignment = Alignment.CenterVertically,
                  modifier = Modifier.fillMaxHeight()
              ) {
                  val text by remember { mutableStateOf("") }
                  OutlinedTextField(
                      value = text,
                      onValueChange = {},
                      placeholder = {
                          Text(
                              text = "Pay to Contact",
                              color = Color.Gray
                          )
                      },
                      leadingIcon = {
                          Image(
                              painter = painterResource(R.drawable.ic_search), // Replace with your drawable resource
                              contentDescription = "Search Icon"
                          )
                      },
                      modifier = Modifier
                          .fillMaxSize()
                          .weight(2.5f),
                      colors = OutlinedTextFieldDefaults.colors(
                          focusedContainerColor = Color.Transparent,
                          unfocusedContainerColor = Color.Transparent,
                          disabledContainerColor = Color.Transparent,
                          errorContainerColor = Color.Transparent,
                          cursorColor = Color.Black,
                          selectionColors = LocalTextSelectionColors.current,
                          focusedBorderColor = Color.Transparent, // Set transparent since we're using a custom border
                          unfocusedBorderColor = Color.Transparent
                      ),
                      shape = RoundedCornerShape(8.dp) // Rounded corners
                  )
                  Image(
                      painter = painterResource(R.drawable.ic_scan_to_pay),
                      "Scan to Pay",
                      modifier = Modifier
                          .weight(1f)
                          .padding(end = 8.sdp),
                  )
              }
          }*/
//        Box(modifier = Modifier
//            .fillMaxWidth()
//            .padding(top = 100.dp)
//            .background(Color.LightGray)
//            .paint(painterResource(R.drawable.ic_box_border))
//            .scale(0.92f)) {
        CurvedCard()
//        }
    }
}
